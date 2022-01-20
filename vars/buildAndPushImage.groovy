#!/usr/bin/env groovy

def call() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'nexus-my-docker-hostedrepo', passwordVariable: 'PWD', usernameVariable: 'USER')]) {
        sh "docker build -t $IMAGE ."
        sh "echo $PWD | docker login -u $USER --password-stdin $NEXUS"
        sh 'docker push $IMAGE'
    }
}