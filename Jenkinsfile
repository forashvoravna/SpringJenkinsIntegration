pipeline {
    agent any

    stages {
        stage('1. Loyihani Yig\'ish (Build)') {
            steps {
                echo 'Kompilyatsiya boshlandi...'
                bat 'mvnw.cmd clean package -DskipTests'
            }
        }

        stage('2. Eski dasturni to\'xtatish') {
            steps {
                echo '8078 portni tekshirish va tozalash...'
                catchError(buildResult: 'SUCCESS', stageResult: 'SUCCESS') {
                    // Port 8078 ga o'zgartirildi:
                    bat 'FOR /F "tokens=5" %%T IN (\'netstat -a -n -o ^| findstr :8078\') DO taskkill /F /PID %%T'
                }
            }
        }

        stage('3. Yangi dasturni ishga tushirish (Deploy)') {
            steps {
                echo 'Yangi server ko\'tarilmoqda...'
                bat '''
                    set JENKINS_NODE_COOKIE=dontKillMe

                    :: /k buyrug'i terminal oynasi xatolik bersa ham yopilib ketmasligini ta'minlaydi
                    start "Spring_Server" cmd /k "java -jar target\\*.jar"
                '''
            }
        }
    }
}