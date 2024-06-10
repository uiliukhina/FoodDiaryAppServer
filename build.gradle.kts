
plugins {
	java
	id("org.springframework.boot") version "3.3.0"
	id("io.spring.dependency-management") version "1.1.5"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	compileOnly ("org.projectlombok:lombok")
	annotationProcessor ("org.projectlombok:lombok")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-security")
	//implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity5")

}

tasks.withType<Test> {
	useJUnitPlatform()
}



tasks.withType<Jar> {

	enabled = false  // Disable the standard Jar task
}

tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
	duplicatesStrategy = DuplicatesStrategy.EXCLUDE
	enabled = true

}

