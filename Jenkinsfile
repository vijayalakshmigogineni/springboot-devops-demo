pipeline {
    agent any

    stages {

        stage('Build Jar') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t student-api:latest .'
            }
        }

        stage('List Images') {
            steps {
                sh 'docker images'
            }
        }
    }
}