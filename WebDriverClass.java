import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverClass {
public static WebDriver driver;

	public WebDriver iniciaChromeDriver() {
		
		WebDriver driver = new ChromeDriver();
		return driver;

	}
}
