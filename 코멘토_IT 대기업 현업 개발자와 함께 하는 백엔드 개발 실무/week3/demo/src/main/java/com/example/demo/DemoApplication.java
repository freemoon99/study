package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void afterStartupComplete(final ApplicationReadyEvent event) {
		final Environment env = event.getApplicationContext().getEnvironment();
		final String ip;
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			throw new IllegalStateException(e);
		}
		final String port = env.getProperty("server.port");
		System.out.println("서버가 시작되었습니다! 접속 주소는 다음과 같습니다: http://" + ip + ":" + port);
	}
}
