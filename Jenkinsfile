pipeline {
    agent any
    stages {
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
                sh "docker build -t springfundamentals ."
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
                sh "docker tag  springfundamentals:latest snakierboss/springfundamentals:latest"
                sh "docker push snakierboss/springfundamentals:latest "
            }
        }
        stage('Deleting local images'){
            steps{
                echo 'deleting local image'
                sh 'docker image rm springfundamentals snakierboss/springfundamentals'
                sh "docker images"
            }
        }
    }
}