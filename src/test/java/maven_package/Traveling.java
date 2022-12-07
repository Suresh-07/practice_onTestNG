package maven_package;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.http.HttpConnection;
import org.checkerframework.dataflow.qual.Pure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.Timeout;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Traveling {
	public String Url="https://demo.guru99.com/test/newtours/";
	WebDriver driver;
	@BeforeTest
	private void pubi() {
		
	WebDriverManager.edgedriver().setup();
	driver= new EdgeDriver();
	driver.get(Url);
	driver.manage().window().maximize();
	driver.getCurrentUrl();
	driver.navigate().refresh();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	@Test(enabled = true , priority = 0)
	public void tc1() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.name("userName")).sendKeys("user");
		driver.findElement(By.name("password")).sendKeys("user");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		System.out.println("User login sucessfully");
	     driver.getCurrentUrl();
		
	}
	@Test (enabled = true , priority = 1)
	public void link() throws IOException {
		List<WebElement> links =driver.findElements(By.tagName("a"));
		System.out.println("Total number of the links "+ links.size());
		
		for(int i=0;i<links.size();i++) 
		{
			WebElement element =links.get(i);
			String url1 = element.getAttribute("href");
			
			URL link = new URL (url1);
			HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
			httpconn.connect();
			int rescode= httpconn.getResponseCode();
		
			if(rescode>=400)
		
			{
				System.out.println(Url+" - "+ "is broken link");
		}
		else
		{
			System.out.println(Url + " - "+ "is valid linl");


	}
			System.out.println(links.get(i).getText());
			System.out.println(links.get(i).getAttribute("href"));
			
		
		}}

		
	
	@Test(enabled = true , priority = 2)
	public void regsiter() throws InterruptedException {
		driver.findElement(By.linkText("REGISTER")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("firstName")).sendKeys("Ramesh");
		driver.findElement(By.name("lastName")).sendKeys("Talakal");
		driver.findElement(By.name("phone")).sendKeys("660011223345");
		driver.findElement(By.xpath("//*[@id='userName']")).sendKeys("Ramesh@gmail.com");
		Thread.sleep(5000);
		driver.findElement(By.name("address1")).sendKeys("Home koppal");
		driver.findElement(By.name("city")).sendKeys("Koppal");
		driver.findElement(By.name("state")).sendKeys("KARNATAKA");
		driver.findElement(By.name("postalCode")).sendKeys("583231");
		Thread.sleep(3000);
		driver.findElement(By.name("country")).click();
		driver.findElement(By.xpath("//*[@value='ANGOLA']")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.name("email")).sendKeys("suresh123");
		driver.findElement(By.name("password")).sendKeys("suresh08");
		driver.findElement(By.name("confirmPassword")).sendKeys("suresh08");
		Thread.sleep(5000);
		driver.findElement(By.name("submit")).click();
		driver.quit();
		
		
	}

}
