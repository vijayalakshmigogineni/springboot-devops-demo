pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                echo 'Downloading code from GitHub'
            }
        }

        stage('Build') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean package -DskipTests'
            }
        }

    }
}