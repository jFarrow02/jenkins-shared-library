#!/usr/bin/env groovy

import com.example.Docker

def call(String repoLocation) {
    return new Docker(this).dockerLogin(repoLocation)
}