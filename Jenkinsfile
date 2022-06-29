pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh "docker build -t springfundamentals ."
                waitUntilServicesReady
                sh "docker images"
            }
        }
    }
}