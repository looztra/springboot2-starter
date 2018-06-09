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
                sh 'mvn -U --batch-mode clean package'
            }
        }
    }
}

