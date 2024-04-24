pipeline {
	agent any
	
	environment {
	    build.number = "${env.BUILD_NUMBER}"
	}

   	stages {
    	stage('Environment') {
            steps {
                echo "Using environment:"
                echo "Building branch: ${env.GIT_BRANCH}"
                echo "Build #: ${build.number}"
            }
        }
        stage('Build & Deploy') {
            steps {
                bat 'mvn -B deploy'
            }
        }
    }
}