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
                sh "docker run --name spring_container -d -t springfundamentals"
                sh "docker ps"
            }
        }
    }
}