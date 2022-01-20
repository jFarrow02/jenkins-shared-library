#!/usr/bin/env groovy

def call() {
    echo "building JAR file for application for branch $BRANCH_NAME..."
    sh 'mvn package'
}