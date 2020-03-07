import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Assert;


public class testgoogle {
	@Test
	public void teste() {
		
		//Arrange
		
		//WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new InternetExplorerDriver();
		WebDriver driver = new ChromeDriver();
		
		//Act
		//driver.manage().window().setPosition(new Point(100, 100));
		driver.manage().window().setSize(new Dimension(1366, 768));
		//driver.manage().window().maximize();
		
		//Assert
		driver.get("https://www.google.com/");
		Assert.assertEquals("Google", driver.getTitle());
		//driver.quit();
				
	}

}
