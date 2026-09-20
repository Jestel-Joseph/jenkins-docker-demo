pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Jestel-Joseph/jenkins-docker-demo.git'
            }
        }

        stage('Maven Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Unit Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t jenkins-docker-demo .'
            }
        }

        stage('Docker Run') {
            steps {
                bat 'docker stop jenkins-demo 2>NUL || exit 0'
                bat 'docker rm jenkins-demo 2>NUL || exit 0'
                bat 'docker run -d --name jenkins-demo -p 8081:8080 jenkins-docker-demo'
            }
        }

    }
}