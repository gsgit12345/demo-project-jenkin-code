currentBuild.displayName="online-shopping#"+currentBuild.number
pipeline {
    agent any
    environment {
        PATH = "/usr/local/apache-maven/bin:$PATH"
    }
    stages {
        stage('Git-Clone') {
            steps {
                git branch: 'master', url: 'https://github.com/springhow/spring-boot-war-example.git'
            }
        }
        stage('MANEN-BUILD') {
            steps {
                sh '''
               mvn --version
               mvn clean package
               mv target/*.war  target/myweb.war
               '''
            }
        }
        stage('Test-Deployment') {
            steps {
                sshagent(['up']) {
                    sh '''
     scp -o StrictHostKeyChecking=no -l  target/myweb.war iid@:/opt/tomcat/webapps/ 
    ssh  iid@92.168.146.225 /opt/tomcat/bin/shutdown.sh
     ssh  iid@92.168.146.225 /opt/tomcat/bin/startup.sh
               '''
                }
            }
        }
    }
}