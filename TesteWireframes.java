import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TesteWireframes {

	@Test
	public void DeveInteragirComWireframe() {
		
		//Arrange
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			TargetUrl url = new TargetUrl();
			driver.get(url.getUrl());
			
		//Act
			driver.switchTo().frame("frame1");
			driver.findElement(By.id("frameButton")).click();
			Alert alert = driver.switchTo().alert();
			String msg = alert.getText();
			assertEquals("Frame OK!",msg);
			alert.accept();
			driver.switchTo().defaultContent();//Retornar para o Frame Principal

		//Assert
			driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);
		
		//End
			driver.quit();
	}
}
