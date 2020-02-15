import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Assert;
import org.junit.Ignore;


public class testecampotreinamento {
	
	@Test
	public void testeTextField() {
		
		//Arrange
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Act
		
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Texto Escrito");
				
		//Assert
		
		Assert.assertEquals("Texto Escrito", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		driver.quit();

	}
	@Test
	
	public void testeTextArea() {
		
		//Arrange
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Act
		
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Linha1\nLinha2\nLinha3");
				
		//Assert
		
		Assert.assertEquals("Linha1\nLinha2\nLinha3", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
		driver.quit();
	}
	
	@Test
	
	public void testeRadioButton() {
		//Arrange
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Act
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		
		//Assert
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		driver.quit();
	}
	@Test
	
	public void testeCheckBox() {
		//Arrange
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Act
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		
		//Assert
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		driver.quit();
	}
	@Test
	
	public void testeComboBox() {
		
		//Arrange
		
		WebDriver driver = new ChromeDriver();
		
		//Act
		
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		combo.selectByIndex(3);
		combo.selectByValue("superior");
		combo.selectByVisibleText("Especializacao");
		combo.selectByVisibleText("Mestrado");
		combo.selectByVisibleText("Doutorado");

		//Assert
		
		Assert.assertEquals("Doutorado", combo.getFirstSelectedOption().getText());
		driver.quit();
	}
	@Test
	
	public void VerificarValoresCombo() {
		
		//Arrange

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Act
		
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		
		//Assert
		
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
		boolean encontrou = false;
		
		for(WebElement option : options) {
			if(option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);	
		driver.quit();
	}
	
	@Test
	
	public void TesteComboMultiplasEscolhas() {
		
		//Arrange

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Act
		
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		
		//Assert
		List<WebElement> list = combo.getAllSelectedOptions();
		assertEquals(3, list.size()); //verifica se a quantidade de W.e selc é 3
		
		
		combo.deselectByVisibleText("O que eh esporte?");
		list = combo.getAllSelectedOptions();
		assertEquals(2, list.size()); //verifica se a quantidade de W.e selc é 2
		
		
		combo.deselectByVisibleText("Corrida");
		list  = combo.getAllSelectedOptions();
		assertEquals(1, list.size()); //verifica se a quantidade de W.e selc é 2
		
		
		combo.deselectByVisibleText("Natacao");
		list = combo.getAllSelectedOptions();
		assertEquals(0, list.size()); //verifica se a quantidade de W.e selc é 2
		
		driver.quit();
	}
	@Test
	
	public void testOnClickButton() {
		
		//Arrange

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Act
		
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		
		//Assert
		
		assertEquals("Obrigado!", botao.getAttribute("value"));
		//assertEquals("Obrigado!", (driver.findElement(By.id("buttonSimple")).getAttribute("value")));
		driver.quit();
	}
	
	@Test
	//@Ignore - notação utilizada para ignorar algum test case
	
	public void InteragirComLinks() {
			
			//Arrange
	
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			//Act
			
			driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
			WebElement linkVoltar = driver.findElement(By.linkText("Voltar"));
			linkVoltar.click();
			WebElement textoVoltar = driver.findElement(By.id("resultado"));
			
			//Assert
			
			assertEquals("Voltou!", textoVoltar.getText());
			driver.quit();
	}
	
	@Test
	
	public void deveBuscarTextoNaTela() {
			
		//Arrange
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Act
		
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		driver.findElement(By.tagName("body"));
		//Assert.assertTrue(driver.findElement(By.tagName("body"))
			//	.getText().contains("Campo de Treinamento"));
		WebElement  titulo = driver.findElement(By.tagName("h3"));
		WebElement carefullClick = driver.findElement(By.className("facilAchar"));
		
		//Assert
		
		Assert.assertEquals("Campo de Treinamento", titulo.getText());
		assertEquals("Cuidado onde clica, muitas armadilhas...", carefullClick.getText());
		
		driver.quit();
			
	}
}
