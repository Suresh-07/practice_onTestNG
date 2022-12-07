package maven_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Maven_class {
	public static String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	WebDriver driver;
	
	@BeforeTest 
	public void suri() {
		
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		

}
	@Test(priority = 0)
	public void tc1() {
		System.out.println("Suresh hi");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
		System.out.println("successful  HRM login");
		
	}
	
	//actions admin
	@Test(enabled =true , priority = 1)
	public void tc4() throws InterruptedException {
		driver.findElement(By.xpath("//*[@class='oxd-main-menu']/li[1]")).click();
		driver.findElement(By.xpath("//*[@class='oxd-topbar-body-nav']/ul/li[1]/span/i")).click();
		driver.findElement(By.linkText("Users")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='oxd-form-row']/div/div[1]/div/div[2]/input")).sendKeys("David.Morris");
		
		Actions act = new Actions(driver);
		WebElement suri = driver.findElement(By.xpath("//*[@class='oxd-select-text--after']/i"));
		act.click(suri).build().perform();
		act.sendKeys(suri,Keys.ARROW_DOWN).click().build().perform();
	    act.sendKeys(suri,Keys.ARROW_DOWN).click().build().perform();
	    
//	    Actions act1 = new Actions(driver);
//		WebElement suri1 = driver.findElement(By.xpath("//*[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']"));
//		act.click(suri1).build().perform();
//		act.sendKeys(suri1,Keys.ARROW_DOWN).click().build().perform();
//	    act.sendKeys(suri1,Keys.ARROW_DOWN).click().build().perform();
	    Thread.sleep(8000);
	    driver.findElement(By.xpath("//*[@class='oxd-form-actions']/button[2]")).click();	
	}
	//Job Titles
	@Test (enabled = false)
	public void JobTitles() throws InterruptedException {
		Thread.sleep(5000);
//		driver.findElement(By.xpath("//*[@class='oxd-main-menu']/li[1]")).click();
		driver.findElements(By.xpath("//*[@class='oxd-main-menu-item-wrapper']")).get(1).click();
		driver.findElement(By.xpath("//*[@class='oxd-topbar-body-nav']/ul/li[2]")).click();
		
		driver.findElement(By.linkText("Job Titles")).click();
		driver.findElements(By.xpath("//*[@class='oxd-table-card']")).get(5).click();
		driver.findElements(By.xpath("//*[@class='oxd-table-cell-actions']/button[1]")).get(5).click();
		driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
		
		driver.quit();
	}
	
	//links
	@Test(enabled = true,priority = 2)
	public void tc6() {
		java.util.List<WebElement> links =driver.findElements(By.tagName("a"));
		System.out.println("Total number of the links "+ links.size());
		
		for(int i=0;i<links.size();i++) 
		{
			System.out.println(links.get(i).getText());
			System.out.println(links.get(i).getAttribute("href"));
			
		}
	}
		//list and delect
		@Test (enabled = true, priority = 3)
		public void tc5() throws InterruptedException {
			driver.findElement(By.xpath("//*[@class='oxd-main-menu']/li[1]/a")).click();
			driver.findElement(By.xpath("//*[@class='oxd-topbar-body-nav']/ul/li[1]/span/i")).click();
			driver.findElement(By.linkText("Users")).click();
			Thread.sleep(5000);
			driver.findElements(By.xpath("//*[@class='oxd-table-card']")).get(5).click();
			driver.findElements(By.xpath("//*[@class='oxd-icon bi-trash']")).get(5).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
			Thread.sleep(5000);
			System.out.println("Delecte the 5th username");
	}
	
		
	@Test(enabled = true, priority = 4)
	public void tc11() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='oxd-userdropdown']")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("About")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@class='oxd-dialog-close-button oxd-dialog-close-button-position']")).click();
		driver.findElement(By.xpath("//*[@class='oxd-userdropdown']")).click();
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("successfully Logout ");
		driver.quit();
				
}
}

