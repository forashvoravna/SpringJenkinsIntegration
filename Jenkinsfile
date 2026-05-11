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
                    bat 'FOR /F "tokens=5" %%T IN (\'netstat -a -n -o ^| findstr :8078\') DO taskkill /F /PID %%T'
                }
            }
        }

        stage('3. Yangi dasturni ishga tushirish (Deploy)') {
            steps {
                echo 'Yangi server ko\'tarilmoqda...'
                bat '''
                    set JENKINS_NODE_COOKIE=dontKillMe

                    :: Windows uchun maxsus: Papkadagi jar faylni o'zi topib ishga tushiradi
                    FOR %%i IN (target\\*.jar) DO start "Spring_Server" cmd /k "java -jar %%i"
                '''
            }
        }
    }
}