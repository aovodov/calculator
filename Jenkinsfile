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
        
        stage('Allure Report') {
            steps {
                echo 'Generating Allure report...'
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'target/allure-results']]
                ])
            }
        }
        
        stage('Allure TestOps') {
            steps {
                echo 'Publishing to Allure TestOps...'
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'target/allure-results']],
                    testops: [
                        endpoint: 'https://localhost:8080',
                        projectId: 'your-project-id',
                        launchName: 'Calculator Tests',
                        launchTags: ['jenkins', 'calculator']
                    ]
                ])
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