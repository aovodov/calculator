pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                echo 'Starting build stage...'
                sh './mvnw clean package'
                echo 'Build stage completed'
            }
        }
        
        stage('Test') {
            steps {
                echo 'Starting test stage...'
                sh './mvnw test'
                echo 'Test stage completed'
            }
        }
    }
    
    post {
        always {
            echo 'Publishing test results...'
            junit '**/target/surefire-reports/*.xml'
            echo 'Pipeline completed'
        }
    }
} 