## Upload file images to backend from React App fails when file is somewhat larger than 1MB.

### This project is composed of three IntelliJ projects:
- core: Multiplatform project
- backend: Ktor (JVM) project
- frontend: A Kotlin react app

### To run those apps
- Start by the core project and deploy the backend and node publications to your local maven repository
- Run the backend by using ./gradlew run
- Run the frontend by doing ./gradlew yarn, then ./gradlew build and finally ./gradlew webpackDevServer
