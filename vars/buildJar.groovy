#!/usr/bin/env groovy

def call() {
    echo "building JAR file for application..."
    sh "mvn package"
}