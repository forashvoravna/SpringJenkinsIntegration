pipeline {
    agent any

    stages {
        stage('1. Loyihani Yig\'ish (Build)') {
            steps {
                // Agar Jenkins Windows'da ishlayotgan bo'lsa 'bat', Linux'da bo'lsa 'sh' ishlatiladi.
                // Hozir Windows uchun moslab yozamiz:
                bat 'mvnw.cmd clean package'
            }
        }

        stage('2. Natijani Tekshirish (Test)') {
            steps {
                echo 'JAR fayl muvaffaqiyatli yaratildi!'
            }
        }
    }
}