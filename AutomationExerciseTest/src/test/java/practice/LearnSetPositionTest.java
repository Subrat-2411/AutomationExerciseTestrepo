package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
//import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import objectRepository.ProductsPage;

public class LearnSetPositionTest{
	@Test
	public void test() throws IOException, InterruptedException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/DemoWebShopPracticeData.xlsx");
		
//		Properties pro=new Properties();
//		
//		pro.load(fis);
//		
//		String time = LocalDateTime.now().toString().replace(':', '-');
		
		Workbook wg=WorkbookFactory.create(fis);
		
		ChromeOptions opt=new ChromeOptions();
		
		opt.addArguments("--start-fullscreen");
				
		WebDriver driver=new ChromeDriver(opt);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(wg.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue());
		
		WebElement goodRBtn = driver.findElement(By.xpath("//label[text()='Good']/..//input[@type='radio']"));
		
		WebElement searchTF = driver.findElement(By.xpath("//input[@name='q']"));
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].click()",goodRBtn);// To perform click operation.......
		
		js.executeScript("arguments[0].setAttribute('value','mobile')",searchTF);// To send data to the Attribute field
		
		js.executeScript("arguments[0].scrollIntoView(true)",goodRBtn);
		
		System.out.println(js.executeScript("return window.pageYOffset;"));
		Thread.sleep(2000);
		
		ProductsPage pp=new ProductsPage(driver);
		
		pp.getElectronicsLink().click();
		
		Assert.assertEquals("Demo Web Shop. Electronics",driver.getTitle(),"Electronics Page Not Displayed.");
		
		Reporter.log("Electronics Page Displayed.");

		System.out.println("done");
		
		driver.close();
	}
}
