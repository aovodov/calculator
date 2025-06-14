pipeline {
    agent any
    
    stages {
        stage('Diagnostics') {
            steps {
                sh 'pwd'
                sh 'ls -la'
            }
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