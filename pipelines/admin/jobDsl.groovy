node ('master') {
    
    stage ('Checkout'){
        deleteDir()
        checkout([$class: 'GitSCM', branches: [[name: gitBranch]], extensions: [], userRemoteConfigs: [[url: gitUrl]]])
    }
    
    stage ('Job DSL'){
        jobDsl target: dslScripts
    }
}
