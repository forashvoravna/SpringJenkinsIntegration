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
                echo '8080 portni tekshirish va tozalash...'
                // Agar 8080 portda eski dastur ishlab turgan bo'lsa, uni o'ldiradi.
                // (Birinchi marta ishga tushganda port bo'sh bo'lsa, xato bermasligi uchun catchError ishlatildi)
                catchError(buildResult: 'SUCCESS', stageResult: 'SUCCESS') {
                    bat 'FOR /F "tokens=5" %%T IN (\'netstat -a -n -o ^| findstr :8080\') DO taskkill /F /PID %%T'
                }
            }
        }

        stage('3. Yangi dasturni ishga tushirish (Deploy)') {
            steps {
                echo 'Yangi server ko\'tarilmoqda...'
                bat '''
                    :: Jenkins jarayon tugagach serverni o'chirib yubormasligi uchun maxsus buyruq:
                    set JENKINS_NODE_COOKIE=dontKillMe

                    :: Yangi .jar faylni alohida oynada (orqa fonda) ishga tushirish
                    start "Spring_Server" java -jar target\\*SNAPSHOT.jar
                '''
            }
        }
    }
}