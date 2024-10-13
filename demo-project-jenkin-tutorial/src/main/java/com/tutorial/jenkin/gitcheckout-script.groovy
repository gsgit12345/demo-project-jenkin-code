pipeline {
    agent any
    stages {
        stage('Git-Clone') {
            steps {
                git branch: 'release/0.1', url: 'https://github.com/gsgit12345/demo-springbootandspringcloud-project-3.2.git'
            }
        }
    }
}