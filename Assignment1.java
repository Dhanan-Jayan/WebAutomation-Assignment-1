package WebAutomation;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.testng.Assert;

public class Assignment1
{

	public static void main(String[] args) throws InterruptedException 
	{

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DJ\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 										
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		driver.get("http://www.qaclickacademy.com/practice.php"); 							
		
		exerciseone(driver); 												
		exercisetwo(driver);
		exercisethree(driver);
		exercisefour(driver);
		exercisefourpointone(driver);
		exercisefourpointtwo(driver);
		exerciseFive(driver);
		exerciseSeven(driver);
		exerciseEight(driver);
		exerciseNine(driver);
		exerciseSix(driver);

	}

	public static void exerciseone(WebDriver driver) throws InterruptedException 
	{

		driver.findElement(By.xpath("//*[@value='radio1']")).click(); 							
		Assert.assertTrue(driver.findElement(By.xpath("//*[@value='radio1']")).isSelected());				
		Thread.sleep(1000); 												
		driver.findElement(By.xpath("//*[@value='radio2']")).click();							
		Assert.assertTrue(driver.findElement(By.xpath("//*[@value='radio2']")).isSelected());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@value='radio3']")).click();							
		Assert.assertTrue(driver.findElement(By.xpath("//*[@value='radio3']")).isSelected());

	}

	public static void exercisetwo(WebDriver driver) throws InterruptedException 
	{
		driver.findElement(By.id("autocomplete")).sendKeys("United States"); 						
		Thread.sleep(1000);

		List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));

		for (int i=0; i<options.size();i++)										
		{ 
			if (options.get(i).getText().equalsIgnoreCase("United States Minor Outlying Islands")) 
			{
				options.get(i).click();
				break;
			}

		}

	}

	public static void exercisethree(WebDriver driver) throws InterruptedException 
	{
		driver.findElement(By.id("dropdown-class-example")).click(); 							
		driver.findElement(By.xpath("//option[@value='option1']")).click();						
		Thread.sleep(500);
		driver.findElement(By.xpath("//option[@value='option2']")).click();					
		Thread.sleep(500);
		driver.findElement(By.xpath("//option[@value='option3']")).click();						
	}

	public static void exercisefour(WebDriver driver) throws InterruptedException 
	{

		driver.findElement(By.id("checkBoxOption1")).click();								
		Thread.sleep(100);
		driver.findElement(By.id("checkBoxOption1")).click();								
		driver.findElement(By.id("checkBoxOption2")).click();								
		Thread.sleep(100);
		driver.findElement(By.id("checkBoxOption2")).click();								
		driver.findElement(By.id("checkBoxOption3")).click();								
		Thread.sleep(100);
		driver.findElement(By.id("checkBoxOption3")).click();								
		Thread.sleep(1500);

	}
	
	public static void exercisefourpointone(WebDriver driver) throws InterruptedException
	{															
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		driver.findElement(By.id("checkBoxOption2")).click();
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption2")).isSelected());
		
		driver.findElement(By.id("checkBoxOption3")).click();
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption3")).isSelected());
		Thread.sleep(1500);
	}
	
	public static void exercisefourpointtwo(WebDriver driver) throws InterruptedException					
	{
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		Thread.sleep(100);
		driver.findElement(By.id("checkBoxOption2")).click();
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption2")).isSelected());
		Thread.sleep(100);
		driver.findElement(By.id("checkBoxOption3")).click();
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption3")).isSelected());
	}
	
	public static void exerciseFive(WebDriver driver) throws InterruptedException 
	{

		driver.get("http://www.qaclickacademy.com/practice.php");
		driver.findElement(By.id("openwindow")).click();								
		Set<String> newWindow = driver.getWindowHandles();								
		Iterator<String> it = newWindow.iterator();									
		String parentid = it.next();											
		Thread.sleep(1500);
		driver.switchTo().window(parentid);										
		
	}
	
	public static void exerciseSix(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.id("opentab")).click();									
		Set<String> newTab = driver.getWindowHandles();									
		Iterator<String> it = newTab.iterator();
		it.next();
		String child=it.next();
		driver.switchTo().window(child);
		Thread.sleep(1500);
		driver.close();
		Thread.sleep(2000);
		driver.quit();
	}
	
	public static void exerciseSeven(WebDriver driver) throws InterruptedException 
	{
		
		driver.findElement(By.id("name")).sendKeys("Nikhil");								
		Thread.sleep(1500);
		driver.findElement(By.id("alertbtn")).click();									
		Thread.sleep(500);
		driver.switchTo().alert().accept();										
	}
	
	public static void exerciseEight(WebDriver driver) throws InterruptedException 
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;								
		Thread.sleep(500);
		jse.executeScript("window.scrollBy(0,600)");									
		Thread.sleep(1500);
		jse.executeScript("document.querySelector('.tableFixHead').scrollBy(0,6000)");					
		Thread.sleep(1000);
	}
	
	private static void exerciseNine(WebDriver driver) throws InterruptedException 
	{
		Actions a = new Actions(driver);
		Thread.sleep(500);
		WebElement mouseHower = driver.findElement(By.id("mousehover"));						
		a.moveToElement(mouseHower).click().build().perform();								
		Thread.sleep(500);
		WebElement mouseClick = driver.findElement(By.cssSelector("a[href='#top']"));					
		Thread.sleep(2000);
		a.moveToElement(mouseClick).click().build().perform();
		Thread.sleep(500);
	}
}

