#!groovy
pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo 'Hello World'
            }
        }
        stage('Test') {
            agent any
            steps {
                echo 'Hello, JDK'
                sh 'java -version'
            }
        }
        stage('Deployonontest') {
            agent any
            steps {
                sh 'printenv'
            }
        }
        stage('DeployOnProduction') {
            agent any
            steps {
                sh 'printenv'
            }
        }
        stage('CommandExecution') {
            agent any
            steps {
                sh  '''
                ls -a
                pwd
                pwd
                date
                cal 2024
                
                '''
            }
        }


    }
}
