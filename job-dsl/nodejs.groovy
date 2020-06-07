job('NodeJS example') {
    scm {
        git('git://github.com/shlomp1/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('shlomi')
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
        shell("npm install")
    }
}
