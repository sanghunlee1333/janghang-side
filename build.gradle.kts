plugins {
	java
	id("org.springframework.boot") version "3.3.12"
	id("io.spring.dependency-management") version "1.1.7"
	id("war")
}

group = "com.janghang"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
    //implementation("org.springframework.boot:spring-boot-starter-web")
    //implementation("org.apache.tomcat.embed:tomcat-embed-jasper")
    //implementation("javax.servlet:jstl:1.2")
    //implementation 'jakarta.servlet:jakarta.servlet-api:5.0.0' // ✅ Tomcat 10 호환
    
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.apache.tomcat.embed:tomcat-embed-jasper")
    implementation("jakarta.servlet:jakarta.servlet-api:5.0.0")
    implementation("jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:2.0.0")
    implementation("org.glassfish.web:jakarta.servlet.jsp.jstl:2.0.0") // 구현체
   	implementation 'org.jsoup:jsoup:1.17.2'
   	implementation("org.json:json:20240303")
    
    // 기타 필요 의존성
    providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
    
    // For test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.bootJar {
    enabled = false
}
tasks.war {
    enabled = true
    archiveFileName.set("api.war")
}