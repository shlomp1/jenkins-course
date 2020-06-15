job('NodeJS Docker example') {
    scm {
        git('git://github.com/shlomp1/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('shlomp1')
            node / gitConfigEmail('shlomip1@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('NodeJS') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('shlomp1/docker-nodejs-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}