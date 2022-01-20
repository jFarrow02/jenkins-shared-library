#!/usr/bin/env groovy

import com.example.Docker

def call(String imageName, String repoLocation) {
    return new Docker(this).buildDockerImage(imageName, repoLocation)
}