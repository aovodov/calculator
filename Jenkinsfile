node {
    stage('Diagnostics') {
        echo 'Current directory:'
        sh 'pwd'
        echo 'Directory contents:'
        sh 'ls -la'
        echo 'Maven wrapper exists?'
        sh 'ls -la mvnw || echo "Maven wrapper not found"'
        echo 'Git status:'
        sh 'git status'
    }
    
    stage('Build') {
        echo 'Starting build stage...'
        sh './mvnw clean package'
        echo 'Build stage completed'
    }
    
    stage('Test') {
        echo 'Starting test stage...'
        sh './mvnw test'
        echo 'Test stage completed'
    }
}

post {
    always {
        echo 'Publishing test results...'
        junit '**/target/surefire-reports/*.xml'
        echo 'Pipeline completed'
    }
} 