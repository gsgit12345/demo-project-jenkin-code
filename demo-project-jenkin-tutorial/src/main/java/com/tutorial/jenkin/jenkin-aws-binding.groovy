pipeline {
    agent any
    stages {
        stage("aws-demo") {
            steps {
                withCredentials([[

                                         $class          : 'AmazonWebServicesCredentialsBinding',
                                         credentialsId   : 'aws-credential', //this is the global variable
                                         accessKyVariable: 'AWS_ACCESS_KEY_ID',
                                         secretKyVariable: 'AWS_SECRET_ACCESS_KEY_ID']]) {
                    sh 'aws s3 ls'

                }

            }
        }

    }

}