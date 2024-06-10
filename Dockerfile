# Используем официальный образ OpenJDK в качестве базового образа
FROM openjdk:17-jdk-alpine

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем файл сборки (JAR файл) из текущей директории в рабочую директорию контейнера
COPY build/libs/FoodDiaryAppServer-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

# Определяем точку входа для нашего приложения
ENTRYPOINT ["java","-jar","/app/app.jar"]
