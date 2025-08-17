package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	@FindBy(xpath="(//a[contains(text(),'Electronics')])[1]")
	private WebElement electronicsLink;
	
	public ProductsPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getElectronicsLink()
	{
		return electronicsLink;
	}
}
