package com.example.magnit;

import com.example.magnit.Service.TestService;
import com.example.magnit.XmlManager.XmlManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class MagnitApplication {

	private static TestService testService;
	private static XmlManager xmlManager;

	@Autowired
	public void setTestService(TestService testService, XmlManager xmlManager) {
		this.testService = testService;
		this.xmlManager = xmlManager;
	}

	public static void main(String[] args){
		SpringApplication.run(MagnitApplication.class, args);
		xmlChanger();
	}

	private static void xmlChanger() {
		System.out.println("Введите количество fields");
		Scanner scanner = new Scanner(System.in);
		long startTime = System.nanoTime();
		if(scanner.hasNextInt()){
			testService.addAll(scanner.nextInt());
		}
		xmlManager.createXml();
		xmlManager.transformByXsl();
		xmlManager.sumField();
		System.out.println("Время вычисления: " + (System.nanoTime() - startTime) / 1000000000 + " секунд");
	}
}