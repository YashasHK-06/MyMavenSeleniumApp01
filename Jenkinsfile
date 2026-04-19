pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/Yashaswiiii8/MyMavenSeleniumApp01.git'
            }
        }

        stage('Run Selenium') {
            steps {
                sh 'mvn clean compile exec:java -Dexec.mainClass="com.example.App"'
            }
        }
    }
}
