pipeline{
   agent any
    environment{
        DOCKERHUB_CREDENTIALS = credentials('dh_cred')
        IMAGE_TAG = sh(script: 'git describe --tags --abbrev=0', returnStdout: true).trim()
    }
    stages{
        stage("init"){
            steps{
                sh '''
                echo DOCKERHUB_CREDENTIALS_PSW | docker login -u DOCKERHUB_CREDENTIALS_USR --password-stdin
                '''
            }
        }
        stage("build"){
            steps{
                sh "docker build -t ${DOCKERHUB_CREDENTIALS_USR}/maven:${IMAGE_TAG} ."
            }
        }
        stage("Deploy"){
            steps{
                sh "docker push ${DOCKERHUB_CREDENTIALS_USR}/maven:${IMAGE_TAG}"
            }
        }
        stage("clean"){
            steps{
                sh "docker rmi ${DOCKERHUB_CREDENTIALS_USR}/maven:${IMAGE_TAG}"
            }
        }
    }
   
}