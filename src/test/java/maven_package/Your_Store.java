package maven_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Your_Store {
      public  static String URL= "http://www.tutorialsninja.com/demo/";
    		  WebDriver driver;
	
       @BeforeTest
        public void bt() {
    	   WebDriverManager.edgedriver().setup();
    	   driver = new EdgeDriver();
    	   driver. get(URL);
    	   driver.manage().window().maximize();
    	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	   
       }
       @Test (enabled = true ,priority = 0)
        public void tc() throws InterruptedException {
    	   driver.findElement(By.xpath("//*[@class='nav pull-right']/ul/li[2]")).click();
    	   driver.findElement(By.linkText("Register")).click();
    	   driver.findElement(By.name("firstname")).sendKeys("suresh");
    	   driver.findElement(By.name("lastname")).sendKeys("ss");
    	   driver.findElement(By.name("email")).sendKeys("sstdd@gmail.com");
    	   driver.findElement(By.name("telephone")).sendKeys("547891323");
    	   driver.findElement(By.name("password")).sendKeys("123456Sure");
    	   driver.findElement(By.name("confirm")).sendKeys("123456Sure");
    	   driver.findElement(By.xpath("//*[@class='form-group']/div/label[1]")).click();
    	   driver.findElement(By.xpath("//*[@type='checkbox']")).click();
    	   driver.findElement(By.xpath("//*[@type='submit']")).click();
    	   Thread.sleep(5000);
    	   driver.findElement(By.linkText("Continue")).click();
       }
       
       
       //links
   	@Test(enabled = true,priority = 2)
   	public void tc1() {
   		java.util.List<WebElement> links =driver.findElements(By.tagName("a"));
   		System.out.println("Total number of the links "+ links.size());
   		
   		for(int i=0;i<links.size();i++) 
   		{
   			System.out.println(links.get(i).getText());
   			System.out.println(links.get(i).getAttribute("href"));
   			
   		}
   	}
       
  
       
       
       @Test(enabled = true , priority = 3)
       public void tc2() {
    	   driver.findElement(By.xpath("//*[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[6]/a")).click();
    	   driver.findElement(By.xpath("//*[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12'][2]/div/div/a")).click();
    	 
    	   driver.findElement(By.xpath("//*[@class='col-sm-8']/ul/li[4]")).click();
    	   driver.findElement(By.xpath("//*[@title='Next (Right arrow key)']")).click();
    	   driver.findElement(By.xpath("//*[@title='Close (Esc)']")).click();
    	   driver.findElement(By.name("quantity")).sendKeys("2");
    	   driver.findElement(By.xpath("//*[@id='button-cart']")).click();
    	   driver.findElement(By.xpath("//*[@class='col-sm-3']/div")).click();
    	  driver.findElement(By.xpath("//body[1]/header[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]/div[1]/p[1]/a[2]/strong[1]")).click();
//    	   driver.findElement(By.xpath("//body[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/h4[1]/a[1]")).click();
//    	   driver.findElement(By.name("country_id")).click();
//    	   Actions act2= new Actions(driver);
//    	   act2.moveToElement(driver.findElement(By.xpath("//*[@value='99']"))).click().build().perform();
//    	   Actions act3= new Actions(driver);
//    	   act3.moveToElement(driver.findElement(By.xpath("//*[@value='1489']"))).click().build().perform();
//    	   driver.findElement(By.name("postcode")).sendKeys("583236");
//    	   driver.findElement(By.xpath("//*[@id='button-quote']")).click();
//    	   driver.findElement(By.name("shipping_method")).click();
//    	   driver.findElement(By.xpath("//*[@id='button-shipping']")).click();
  	       driver.findElement(By.linkText("Checkout")).click();
  	       driver.quit();

    	   
    	   
       }



}


