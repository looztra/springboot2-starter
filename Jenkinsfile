pipeline {
    agent any
    stages {
        stage("Info") {
            steps {
                sh 'docker version'
            }
        }
        stage("Build") {
            agent {
                docker {
                reuseNode true
                image 'maven:3.5.0-jdk-8'
                }
            }
            steps {
                sh 'mvn --version'
            }
            steps {
                sh 'mvn -U -b clean package'
            }
        }
    }
}

