#!/usr/bin/env groovy
package com.example

class Docker implements Serializable { // supports saving state if pipeline is paused and resumed

    def script // Makes env vars, commands, etc. from pipeline syntax available in class

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "building the docker image..."
        script.sh "docker build -t $imageName ."
    }

    def dockerLogin(String repoLocation) {
        script.withCredentials([script.usernamePassword(credentialsId: 'nexus-my-docker-hostedrepo', passwordVariable: 'PWD', usernameVariable: 'USER')]) {
            script.sh "echo $script.PWD | docker login -u $script.USER --password-stdin  $repoLocation"
        }
    }

    def dockerPush(String imageName) {
        script.sh "docker push $imageName"
    }
}