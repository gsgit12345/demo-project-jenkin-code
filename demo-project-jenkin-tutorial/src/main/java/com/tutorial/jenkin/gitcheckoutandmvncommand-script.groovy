pipeline {
    agent any
    environment {
        PATH = "/usr/local/apache-maven/bin:$PATH"
    }
    stages {
        stage('Git-Clone') {
            steps {
                git branch: 'release/0.1', url: 'https://github.com/gsgit12345/demo-springbootandspringcloud-project-3.2.git'
            }
        }
        stage('MANEN-BUILD') {
            steps {
                sh '''
               mvn --version
               mvn clean
               mvn clean install
               '''
            }
        }
    }
}