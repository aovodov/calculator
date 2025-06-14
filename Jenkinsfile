pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                dir('/workspace') {
                    sh 'mvn clean package'
                }
            }
        }
        
        stage('Test') {
            steps {
                dir('/workspace') {
                    sh 'mvn test'
                }
            }
        }
    }
    
    post {
        always {
            dir('/workspace') {
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }
} 