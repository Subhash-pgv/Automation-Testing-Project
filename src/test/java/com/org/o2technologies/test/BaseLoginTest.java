package com.org.o2technologies.test;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.org.o2technologies.pages.LoginPage;
import com.org.o2technologies.utility.InputValues;
import com.org.o2technologies.utility.WebDriverManager;

public class BaseLoginTest {

	protected WebDriver driver;
	protected LoginPage login;
	protected InputValues inputValuesLogin;

	@Parameters({ "Browser", "headless" })
	@BeforeTest
	public void setUpSuite(@Optional("chrome") String br, @Optional("false") String headless)
			throws InterruptedException {
		boolean isHeadless = Boolean.parseBoolean(headless);

		driver = WebDriverManager.getDriver(br, isHeadless);

		driver.manage().window().maximize();
		login = new LoginPage(driver);
		inputValuesLogin = new InputValues("LoginCredentials.json");

		Map<String, String> loginCredentials = inputValuesLogin.getInputValuesList().get(0);
		login.login(loginCredentials.get("username"), loginCredentials.get("password"));
		System.out.println("Login performed once before all tests");
		
		
	}

	@AfterTest
	public void tearDownSuite() {

		WebDriverManager.quitDriver();

	}
}
