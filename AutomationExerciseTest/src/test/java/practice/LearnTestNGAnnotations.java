package practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import objectRepository.ListenersImp;
@Listeners(ListenersImp.class)
public class LearnTestNGAnnotations {
	@Test(groups = "smoke")
	public void testngAnnotation()
	{
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.flipkart.com/");
		
		Assert.assertEquals(driver.getTitle(),driver.getTitle().contains("Shopping"),"Flipkart Home Page not displayed.");
		
		driver.close();
	}
}
