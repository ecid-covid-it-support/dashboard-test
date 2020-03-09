package test;

import config.*;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class LoginTest {

	static WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"/home/diego/eclipse-workspace/dashboard-test/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://ocariot-nutes-dashboard.firebaseapp.com/");
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.close();
	}

	@Test
	void valid_login() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div[2]/div/app-login/div[2]/div/div[2]/form/div[1]/input")).sendKeys(Config.username_ED);
		;
		driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div[2]/div/app-login/div[2]/div/div[2]/form/div[2]/div/input")).sendKeys(Config.password_ED);
		;
		driver.findElement(By.xpath("/html/body/app-root/app-layout/div/div[2]/div/app-login/div[2]/div/div[2]/form/div[3]/button")).click();
		;
		Thread.sleep(4000);
		Assert.assertEquals("https://ocariot-nutes-dashboard.firebaseapp.com/userList", driver.getCurrentUrl());
	}

	@Test
	void invalid_login() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("/html/body/app-root/app-layout/div/div[2]/div/app-login/div[2]/div/div[2]/form/div[1]/input"))
				.sendKeys("");
		;
		driver.findElement(By.xpath(
				"/html/body/app-root/app-layout/div/div[2]/div/app-login/div[2]/div/div[2]/form/div[2]/div/input"))
				.sendKeys("");
		;
		driver.findElement(By
				.xpath("/html/body/app-root/app-layout/div/div[2]/div/app-login/div[2]/div/div[2]/form/div[3]/button"))
				.click();
		;

		Thread.sleep(3000);
		Assert.assertTrue(driver
				.findElement(By
						.xpath("/html/body/app-root/app-layout/div/div[2]/div/app-login/div[2]/div/div[2]/form/div[4]"))
				.isDisplayed());
	}

}
