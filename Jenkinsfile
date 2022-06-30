pipeline {
    agent any
     environment {
        TOKEN_SONAR='sqp_54c57a70f24a0903e34d06266be153036351bf20'
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
                     -Dsonar.login=sqp_54c57a70f24a0903e34d06266be153036351bf20"
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