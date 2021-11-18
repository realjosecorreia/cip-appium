// 1 - Pacote
package calculadora;

// 2 - Imports / Bibliotecas
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;

// Script lendo uma massa de teste

// 3 - Classe 
@RunWith(Parameterized.class) // Essa é uma classe parametrizada: usa massa de teste
public class CalcDataDriven {
  // 3.1 - Atributos
  private AndroidDriver<MobileElement> driver;
  
  // 3.2 - Métodos e Funções
  // 3.2.1 - Apoio
  // Leitura da Massa
  
  // A - Atributos / Campos da massa de teste
  
  public String id;
  public String num1;
  public String operador;
  public String num2;
  public String resultadoEsperado;
  
  // B - Constructor
  
  public CalcDataDriven(String id, String num1, String operador, String num2, String resultadoEsperado) {
	this.id = id;
	this.num1 = num1;
	this.operador = operador;
	this.num2 = num2;
	this.resultadoEsperado = resultadoEsperado;
}
  
  // C - Chamada - Chama a função de leitura passando o caminho e o nome do arquivo
  @Parameterized.Parameters
  public static Collection<String[]> lerArquivo() throws IOException{
	return lerCSV("src/test/resources/db/massaCalcDataDriven.csv");  
  }

  // D - Leitura do CSV
  public static Collection<String[]> lerCSV(String nomeMassa) throws IOException{
	List<String[]> dados = new ArrayList<String[]>(); // criou uma lista vazia
	String linha; // criou uma string para guardar um registro (conj de campos)
	// Ler o arquivo e colocar na memória
	BufferedReader arquivo = new BufferedReader(new FileReader(nomeMassa));
	// Ler um registro de cada vez
	while((linha = arquivo.readLine()) != null) {
		//Ler os campos de cada registro
		String campos[] = linha.split(";");
		// devolver os dados prontos para uso
		dados.add(campos);	
	}
	arquivo.close();
	
	return dados; 
  }

  
  // 3.2.2 - Teste em si
  @Before
  public void setUp() throws MalformedURLException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("platformName", "Android");
    desiredCapabilities.setCapability("platformVersion", "9.0");
    desiredCapabilities.setCapability("browserName", "");
    // desiredCapabilities.setCapability("appiumVersion", "1.22.0"); // execução local
    desiredCapabilities.setCapability("deviceName", "Samsung Galaxy S9 FHD GoogleAPI Emulator");
    desiredCapabilities.setCapability("deviceOrientation", "portrait");
    desiredCapabilities.setCapability("app", "storage:filename=Calculator_v8.1 (403424005)_apkpure.com.apk");
    desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
    desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
    desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
    desiredCapabilities.setCapability("nativeWebScreenshot", true);
    desiredCapabilities.setCapability("newCommandTimeout", 0);
    desiredCapabilities.setCapability("connectHardwareKeyboard", true);

    URL remoteUrl = new URL("https://dh05jose:29904e23-877d-45d2-a36b-09bfc5de8709@ondemand.us-west-1.saucelabs.com:443/wd/hub");

    driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
  }
 
  @Test
  public void somarDoisNumeros() {
	  
    MobileElement btn9 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_" + num1);
    btn9.click();
    MobileElement btnSomar = (MobileElement) driver.findElementByAccessibilityId("plus");
    btnSomar.click();
    MobileElement btn4 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_" + num2);
    btn4.click();
    MobileElement btnIgual = (MobileElement) driver.findElementByAccessibilityId("equals");
    btnIgual.click();
   
	  
    MobileElement lblResultado = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
 
	 assertEquals(resultadoEsperado,lblResultado.getText()); // Agora sim é um teste!!!
    // lblResultado.click();
    

  }

  @After
  public void tearDown() {
    driver.quit();
  }
}

