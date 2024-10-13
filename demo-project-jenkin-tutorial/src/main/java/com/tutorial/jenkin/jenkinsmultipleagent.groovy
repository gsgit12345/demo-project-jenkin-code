pipeline {
    agent any
    environment {
        PATH = "/usr/local/apache-maven/bin:$PATH"
    }

    stages {
        stage("git-checkout") {
            agent {
                label 'master-node'
            }

            steps {
                git url: "https://github.com/gsgit12345/demo-project-springboot-kubernetes-jenkin-intdemo.git"
                stash "source"
            }
        }
        stage("build-checkout") {
            agent {
                label 'slave-node'
            }


            steps {
                unstash "source"
                sh "mvn clean package"
            }
        }

    }
}