#!/usr/bin/env groovy

def call(string imageName, string repoLocation) {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'nexus-my-docker-hostedrepo', passwordVariable: 'PWD', usernameVariable: 'USER')]) {
        sh "docker build -t $imageName ."
        sh "echo $PWD | docker login -u $USER --password-stdin $repoLocation"
        sh 'docker push $IMAGE'
    }
}