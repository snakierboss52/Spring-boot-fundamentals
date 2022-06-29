pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh "docker build -t springfundamentals ."
                sh "docker images"
            }
        }
        stage('Building docker container'){
            steps{
                echo 'Building container...'
                sh "docker-compose up"
                sh "docker ps"
            }
        }
    }
}