package com.org.o2technologies.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class initializeDriver {

	private WebDriver initializeDriver(String browser, boolean isHeadless) {
		switch (browser) {
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setAcceptInsecureCerts(true);
			if (isHeadless) {
				chromeOptions.addArguments("--headless");
				chromeOptions.addArguments("--disable-gpu");
				chromeOptions.addArguments("--window-size=1920,1080");
			}
			return new ChromeDriver(chromeOptions);
		case "edge":
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.setAcceptInsecureCerts(true);
			if (isHeadless) {
				edgeOptions.addArguments("--headless");
				edgeOptions.addArguments("--disable-gpu");
				edgeOptions.addArguments("--window-size=1920,1080");
			}
			return new EdgeDriver(edgeOptions);
		default:
			throw new IllegalArgumentException("Invalid browser: " + browser);
		}
	}

}
