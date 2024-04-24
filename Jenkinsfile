pipeline {
	agent any
	
   	stages {
    	stage('Environment') {
            steps {
                echo "Using environment:"
                echo "Building branch: ${env.GIT_BRANCH}"
                echo "Build #: ${env.BUILD_NUMBER}"
            }
        }
        stage('Install') {
            steps {
                echo 'mvn -B install -build.number=${env.BUILD_NUMBER}'
            }
        }
        stage('Deploy') {
            steps {
                bat 'mvn -B deploy -build.number=${env.BUILD_NUMBER}'
            }
        }
    }
}