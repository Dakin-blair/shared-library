#!/usr/bin/env groovy

def call(String buildResult) {
    if (buildResult == "SUCCESS") {
        slackSend(color: "good", message: "SUCCÈS : ${env.JOB_NAME} #${env.BUILD_NUMBER} - ${env.BUILD_URL}")
    } else if (buildResult == "FAILURE") {
        slackSend(color: "danger", message: "ÉCHEC : ${env.JOB_NAME} #${env.BUILD_NUMBER} - ${env.BUILD_URL}")
    } else if (buildResult == "UNSTABLE") {
        slackSend(color: "warning", message: "INSTABLE : ${env.JOB_NAME} #${env.BUILD_NUMBER} - ${env.BUILD_URL}")
    } else {
        slackSend(color: "#439FE0", message: "RÉSULTAT INCONNU (${buildResult}) : ${env.JOB_NAME} #${env.BUILD_NUMBER} - ${env.BUILD_URL}")
    }
}
