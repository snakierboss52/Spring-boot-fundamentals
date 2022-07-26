pipeline {
    agent any

    environment {
        //Use Pipeline Utility Steps plugin to read information from pom.xml into env variables
        VERSION = readMavenPom().getVersion()
        REGION = 'us-east-2'
        REPOSITORY_NAME = 'practice-devops-springfundamentals'
        def docker = "docker"
        }

    stages {
        stage('mvn clean package'){
            tools{
                maven 'maven'
            }
            steps{
                  sh "mvn clean package"
            }
        }
        stage('mvn install'){
             tools{
                maven 'maven'
             }
            steps{
                 sh "mvn install -Dskiptest"
            }
        }
        stage('package') {
            steps {
                echo 'Building..'
                script {
                    docker.build + "springfundamentals:${VERSION}"
                }
                sh "docker build -t springfundamentals:${VERSION} ."
                sh "docker.images"
            }
        }
        stage('Pushing image to gcp'){
            steps{
                echo 'Pushing image to docker hub...'
                withDockerRegistry(credentialsId: 'gcr:gcp-test-credentials', url: 'https://gcr.io') {
                    sh "docker tag  springfundamentals:${VERSION} cr.io/civic-matrix-356905/springfundamentals:${VERSION}"
                    sh "docker push cr.io/civic-matrix-356905/springfundamentals:${VERSION}"
                }

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