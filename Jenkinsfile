pipeline {
    agent any
     environment {
        USER_DOCKER='snakierboss'
        PASS_DOCKER='loslinces'
     }

    stages {
        stage('Build') {
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
                     -Dsonar.login=sqp_b332c5a04abe7736ac2a5a8f352c01338c292bea"
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