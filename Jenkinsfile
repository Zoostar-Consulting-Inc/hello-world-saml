pipeline {
	agent any
	
   	stages {
    	stage('Environment') {
            steps {
                echo "Using environment:"
                echo "Building branch: ${env.GIT_BRANCH}"
            }
        }
        stage('Build & Deploy') {
            steps {
                bat 'mvn -B deploy -Dbuild.number=${env.BUILD_NUMBER}'
            }
        }
    }
}