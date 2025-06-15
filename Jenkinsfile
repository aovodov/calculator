pipeline {
    agent any
    
    environment {
        ALLURE_SERVER_ID = 'testops'      // ID сервера из настроек Jenkins
        ALLURE_PROJECT_ID = '124'             // ID проекта в Allure TestOps
    }

    stages {
        stage('Тестирование') {
            steps {
                withAllureLaunch(
                    serverId: env.ALLURE_SERVER_ID,
                    projectId: env.ALLURE_PROJECT_ID,
                    name: "Автотесты ${env.BUILD_NUMBER}",
                    tags: "jenkins,pipeline,automated"
                ) {
                    sh './mvnw clean test'

                    withAllureUpload(
                        serverId: env.ALLURE_SERVER_ID,
                        projectId: env.ALLURE_PROJECT_ID,
                        results: [[path: 'target/allure-results']],
                        indexExistingFiles: true
                    ) {
                        echo 'Результаты тестов загружены в Allure TestOps'
                    }
                }
            }
        }           
        stage('Build') {
            steps {
                sh './mvnw clean package'
            }
        }
    }
    post {
        always {
            junit '**/target/surefire-reports/*.xml'
            echo 'Ссылка на отчет в Allure TestOps будет доступна в деталях сборки'
        }
    }
} 