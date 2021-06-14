package Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Browserfactory {
	static WebDriver driver;
	static String browser ;
	static String url;
			
	public static void readConfig() {
		Properties prop = new Properties();// for java to understand the file system
		// for read the file we need to use (try catch) formula
		try {
			InputStream input = new FileInputStream("src\\main\\java\\ConFig\\config.properties");
			prop.load(input);// whatever file we will read need to load here
			browser = prop.getProperty("browser");// for read the file(browser) is the key of properties file
			System.out.println("browser used:" + browser);
			url = prop.getProperty("url");
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	
	public static WebDriver init() {
		readConfig();
		
		if (browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	    } else if(browser.equalsIgnoreCase("firefox")){
		System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}
	
//	public static void tearDown() {
//		driver.close();
//		driver.quit();
//	}
	}
