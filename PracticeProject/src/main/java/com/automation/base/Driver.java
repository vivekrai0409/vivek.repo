package com.automation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

	private static Driver instance;
	private static WebDriver driver = null;
	public static  Properties prop;
	public FileInputStream inp;

	private Driver() {
		if(prop==null) {
			
		try {
			inp = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\automation\\configuration\\config.properties");
			prop = new Properties();
			prop.load(inp);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}
			if (prop.getProperty("browserName").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//testResources//chromedriver.exe");
				driver = new ChromeDriver();
			}

			if (prop.getProperty("browserName").equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//testResources//geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}

	public static Driver getIntsnace() {
		if (driver == null)
			instance = new Driver();
		return instance;
	}

	public WebDriver getDriver() {
		return driver;
	}
}
