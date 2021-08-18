package siteIterasys;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Site {

    String url;
    WebDriver driver;


    @Before

    public void iniciar() {

        url = "https://iterasys.com.br";
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Bruno\\Java=Selenium\\siteIterasys\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000,TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();


    }


    @After

    public void finalizar() {

        driver.quit();
    }

    @Test

    public void Teste() {

        driver.get(url);
        driver.findElement(By.id("searchtext")).clear();
        driver.findElement(By.id("searchtext")).sendKeys(Keys.chord("Mantis")); //digita letra por letra
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);

        driver.findElement(By.cssSelector("span.comprar")).click();

        //pagina carrinho de compras


        String titulo ="Mantis";
        String preco ="R$ 49,99";

        //assertequals (resultadoesperado, resultado)

        assertEquals(titulo, driver.findElement(By.cssSelector("span.item-title")).getText());
        assertEquals(preco, driver.findElement(By.cssSelector("span.new-price")).getText());


    }
}
