pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/YashasHK-06/MyMavenSeleniumApp01.git'
            }
        }

        stage('Run Selenium') {
            steps {
                sh 'mvn clean compile exec:java -Dexec.mainClass="com.example.App"'
            }
        }
    }
}
