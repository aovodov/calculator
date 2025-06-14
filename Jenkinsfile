pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Hello') {
            steps {
                sh 'echo "Hello from Jenkins!"'
            }
        }
    }
} 