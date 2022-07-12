pipeline {
    agent any

    environment {
        //Use Pipeline Utility Steps plugin to read information from pom.xml into env variables
        VERSION = readMavenPom().getVersion()
        REGION = 'us-east-2'
        REPOSITORY_NAME = 'practice-devops-springfundamentals'
        }

    stages {
        stage('Deleting local container'){
            steps{
                sh 'docker container prune -f'
                sh 'docker image prune -f'
            }
        }
        stage('mvn clean package'){
            tools{
                maven 'mvn-3.8.6'
            }
            steps{
                  sh "mvn clean package"
            }
        }
        stage('send artifact to bucket s3'){
            steps{
                    sh """
                         aws s3 cp $HOMEDIR/target/ s3://s3-artifact-springfundamentals/ --recursive --exclude '*' --include '*.jar'
                    """
                    echo "artifact upload"
            }
        }
        stage('mvn install'){
             tools{
                maven 'mvn-3.8.6'
             }
            steps{
                 sh "mvn install -Dskiptest"
            }
        }
        stage('package') {
            steps {
                echo 'Building..'
                sh "docker build -t springfundamentals:${VERSION} ."
                sh "docker images"
            }
        }
        stage("Sonar"){
            steps{
                sh "mvn clean verify sonar:sonar -Dsonar.projectKey=spring-test\
                     -Dsonar.host.url=http://localhost:9000 \
                     -Dsonar.login=${TOKEN_SONAR}"
            }
        }
        stage('Pushing image dockerhub'){
            steps{
                echo 'Pushing image to docker hub...'
                sh "docker tag  springfundamentals:${VERSION} snakierboss/springfundamentals:${VERSION}"
                sh "docker push snakierboss/springfundamentals:${VERSION}"
            }
        }
        stage('Deleting local images'){
            steps{
                echo 'deleting local image'
                sh 'docker image rm springfundamentals:${VERSION} snakierboss/springfundamentals:${VERSION}'
                sh "docker container prune -f"
            }
        }
    }
}