package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	// 모든 프로젝트가 main 메서드에서 시작
	// tomcat 웹서버를 내장하고 있음
	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
