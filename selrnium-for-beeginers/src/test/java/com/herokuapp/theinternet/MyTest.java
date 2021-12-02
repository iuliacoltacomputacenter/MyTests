package com.herokuapp.theinternet;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MyTest {
	private WebDriver driver;

	@Parameters({ "browser" })
	@BeforeTest(alwaysRun = true)
	private void setUp(@Optional String browser) {
		// create driver

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		default:
			System.out.println("Starting chrome");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}

		// sleep for 3 seconds
		sleep(3000);

		// maximize browser window
		driver.manage().window().maximize();

		// implicit wait
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterMethod(alwaysRun = true)
	private void tearDown() {
		// close browser
		driver.quit();
	}

	@Test
	public void entryAdd() {

		driver.get("http://the-internet.herokuapp.com/entry_ad");
		System.out.println("page is opened");

		WebElement clickhere = driver.findElement(By.id("restart-ad"));

		clickhere.click();

		sleep(3000);

		String s = driver.findElement(By.className("modal-title")).getText();
		System.out.println(s);

		String s1 = driver.findElement(By.xpath("//div[@class='modal-body']")).getText();
		System.out.println(s1);

	
		// driver.findElement(By.xpath("//div[@class='modal-footer']")).getText();

		driver.findElement(By.xpath("//div[@class='modal-footer']")).click();

		driver.quit();
	}
	
	
	@Test
	
	public void multipleWindows() {
		
		driver.get("http://the-internet.herokuapp.com/windows");
		System.out.println("Before click");
		
		System.out.println("Number of windows opened by selenium : " + driver.getWindowHandles().size());
		 for (String window : driver.getWindowHandles())
		 {
		  System.out.println(window);
		        } 
		 System.out.println("Current window handle : " + driver.getWindowHandle());
		 driver.findElement(By.linkText("Click Here")).click();
		 driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
		 
		 System.out.println("After click");
		 sleep(2000);
		 System.out.println("Number of windows opened by selenium : " + driver.getWindowHandles().size());
		 for (String window : driver.getWindowHandles())
		 {
		  System.out.println(window);
		        }
		 
		 ArrayList <String>newTab = new ArrayList <String>(driver.getWindowHandles());
		 driver.switchTo().window(newTab.get(1));
		 System.out.println(driver.findElement(By.id("draggable")).getText());
		 System.out.println("Current window handle : " + driver.getWindowHandle());
		 
		 System.out.println("After close");
		 driver.close();
		 
		 System.out.println("Number of windows opened by selenium : " + driver.getWindowHandles().size());
		 for (String window : driver.getWindowHandles())
		 {
		  System.out.println(window);
		        }

		 sleep(2000);
	   //  driver.switchTo().Window(driver.WindowHandles[0]);
		 driver.switchTo().window(newTab.get(0));
		 System.out.println("Current window handle : " + driver.getWindowHandle());
		 sleep(2000);
		 driver.quit();
		 
		 
		 
		
	}
	
	@Test
	
	private void keyPress() {
		// this is just a test
		driver.get("http://the-internet.herokuapp.com/key_presses?");
		System.out.println("page is opened");
		
		//driver.findElement(By.id("content")).sendKeys(Keys.SPACE) ;
		Actions action = new Actions(driver) ;
		action.sendKeys(Keys.ENTER).build().perform();
		
		 String text = driver.findElement(By.id("result")).getText();
		 System.out.println(text);
		 
		 Assert.assertEquals(text, "You entered: ENTER");
		 
		 sleep(5000);
		 
		 driver.quit();
		
	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
