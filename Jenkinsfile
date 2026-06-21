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
        stage('Run Container') {
            steps {
                sh 'docker rm -f student-api-container || true'
                sh 'docker run -d --name student-api-container -p 8082:8080 student-api:latest'
            }
        }
    }
}