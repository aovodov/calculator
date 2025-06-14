pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                dir('/workspace') {
                    echo 'Starting build stage...'
                    sh 'mvn clean package'
                    echo 'Build stage completed'
                }
            }
        }
        
        stage('Test') {
            steps {
                dir('/workspace') {
                    echo 'Starting test stage...'
                    sh 'mvn test'
                    echo 'Test stage completed'
                }
            }
        }
    }
    
    post {
        always {
            dir('/workspace') {
                echo 'Publishing test results...'
                junit '**/target/surefire-reports/*.xml'
                echo 'Pipeline completed'
            }
        }
    }
} 