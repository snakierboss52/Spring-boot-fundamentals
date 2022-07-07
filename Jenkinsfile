pipeline {
    agent any

    environment {
        //Use Pipeline Utility Steps plugin to read information from pom.xml into env variables
        VERSION = readMavenPom().getVersion()
        }

    stages {
        stage('Deleting local container'){
            steps{
                sh 'docker container prune -f'
                sh 'docker image prune -f'
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