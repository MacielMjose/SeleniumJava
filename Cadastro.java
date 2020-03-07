import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Cadastro {
	
	@Test
	
	public void DeveCadastrarComSucesso() {
		//Arrange
	
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		//Act
				
			driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
			driver.findElement(By.id("elementosForm:nome")).sendKeys("José Luiz");
			driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Marques Maciel");
			driver.findElement(By.id("elementosForm:sexo:0")).click();
			driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
			
			WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
			Select combo = new Select(element);
			combo.selectByVisibleText("Superior");
			element = driver.findElement(By.id("elementosForm:esportes"));
			combo = new Select(element);
			combo.selectByVisibleText("Karate");
			
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			String nome = driver.findElement(By.id("descNome")).getText();
			String sobrenome = driver.findElement(By.id("descSobrenome")).getText();
			String sexo = driver.findElement(By.id("descSexo")).getText();
			String comida = driver.findElement(By.id("descComida")).getText();
			String escolaridade = driver.findElement(By.id("descEscolaridade")).getText();
			String esportes = driver.findElement(By.id("descEsportes")).getText();
			String sugestoes = driver.findElement(By.id("descSugestoes")).getText();
			WebElement result = driver.findElement(By.id("resultado"));

			
	
		//Assert
			
			Assert.assertTrue(result.getText().startsWith("Cadastrado!"));
			Assert.assertEquals("Nome: José Luiz", nome);
			Assert.assertEquals("Sobrenome: Marques Maciel", sobrenome);
			Assert.assertEquals("Sexo: Masculino", sexo);
			Assert.assertEquals("Comida: Pizza", comida);
			Assert.assertEquals("Escolaridade: superior", escolaridade);
			Assert.assertEquals("Esportes: Karate", esportes);
			Assert.assertEquals("Sugestoes:", sugestoes);
		
		//End
			driver.quit();
	}
}
