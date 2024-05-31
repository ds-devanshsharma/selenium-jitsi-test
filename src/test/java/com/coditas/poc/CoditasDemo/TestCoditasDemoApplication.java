package com.coditas.poc.CoditasDemo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.LocalDateTime;

public class TestCoditasDemoApplication {
	static Logger log = LoggerFactory.getLogger(TestCoditasDemoApplication.class);

	public static void main(String[] args) throws InterruptedException {
//		SpringApplication.from(CoditasDemoApplication::main).with(TestCoditasDemoApplication.class).run(args);

		/**
		 *    args[0] -> count
		 *    args[1] -> URL
		 */

//		String URL = "https://11057-lap-0813:8443/room-I";
		String URL = args[1];
		int count = Integer.parseInt(args[0]);
		WebDriver driver = null ;
		ChromeOptions options = new ChromeOptions();
		options.addArguments(
				"--ignore-certificate-errors",
				"--ignore-ssl-errors=yes",
				"--use-fake-ui-for-media-stream",
				"--disable-infobars",
				"--headless=new"
				);

		LocalDateTime startTime = LocalDateTime.now();
		for (int i = 0; i < count; i++) {
			log.info("Joining meet with id : {} at time {} : " , 1000+i, LocalDateTime.now());

			driver = new ChromeDriver(options);
			driver.get(URL);

			Thread.sleep(5000);
			WebElement joinMeetingBtn = driver.findElement(By.className("css-1hbmoh1-actionButton"));
			joinMeetingBtn.click();
		}

		// Time Taken in This Process
		LocalDateTime endTime = LocalDateTime.now();

		System.out.println("\n\n\n**************************Time Taken in this process *********************\n");
		System.out.println("Start Time : " +  startTime +"\n" +
				"End Time :" + endTime +"\n" +
				"Time Taken : " + Duration.between(endTime,startTime)+"\n"+
		        "Total joiner : " + count);

		System.out.println("\n************************** Process Completed *********************\n");
		Thread.sleep(2000);
		log.info("closing all browser connection in 30 sec ");
		Thread.sleep(30000);
		log.info(" all {} connection closed !" , count);
		driver.close();
	}


}
