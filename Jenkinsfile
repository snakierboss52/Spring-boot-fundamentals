pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                echo TOKEN_SONAR
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
                sh "docker tag  springfundamentals:latest snakierboss/springfundamental:latest"
                sh "docker push snakierboss/springfundamental:latest "
            }
        }
    }
}