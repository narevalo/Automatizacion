import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Test1 {
    WebDriver driver;
    String chromePath = System.getProperty("user.dir")+ "\\driver\\chromedriver.exe";


    @Test
    @DisplayName("Caso de prueba para validar el ingreso a la pagina empleos")
    public void test_IngresoEmpleos() {

        String urlApp = "https://www.choucairtesting.com/";
        String actualResultado2 = "";
        String actualResultado3 = "";
        String resultadoExperado2 = "Prepararse para aplicar";
        String resultadoExperado3 = "Ir al portal de empleos";


        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get(urlApp);
        driver.manage().window().maximize();

        //Clic en el enlace

        driver.findElement(By.linkText("Empleos")).click();
        actualResultado2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/section[2]/div/div/div[2]/div/div/div/div/div/div/h3/a")).getText();
        actualResultado3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/section[3]/div/div/div[2]/div/div/div/div/div/a/span/span")).getText();

    Assert.assertEquals("Prueba de ingreso a empleos resultado 1",resultadoExperado2,actualResultado2);
    Assert.assertEquals("Prueba de ingreso a empleos resultado 2",resultadoExperado3,actualResultado3);

        if( (actualResultado2.contentEquals(resultadoExperado2)) && (actualResultado3.contentEquals(resultadoExperado3))){
            System.out.println("Prueba Existosa");
        }else
            System.out.println("Prueba Fallo");


        driver.quit();



    }

    @Test
    @DisplayName("Caso de prueba para validar que la opcion Que es ser choucair testing redirija al contenido")
    public void test_RedirigirContenidoQueEsSerChoucair() {

        String urlApp = "https://www.choucairtesting.com/empleos-testing/";
        String actualResultado2 = "";
        String resultadoExperado2 = "SER CHOUCAIR";


        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get(urlApp);
        driver.manage().window().maximize();

        //Clic en el enlace
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/section[2]/div/div/div[1]/div/div/div/div/div/figure/a/img")).click();
        actualResultado2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/section[4]/div/div/div/div/div/div[2]/div/h2")).getText();

        Assert.assertEquals("Prueba de ir a contenido de que es ser choucair",resultadoExperado2,actualResultado2);

        if (actualResultado2.contentEquals(resultadoExperado2)){
            System.out.println("Prueba Existosa");
        }else
            System.out.println("Prueba Fallo");
        driver.quit();

    }


    @Test
    @DisplayName("Caso de prueba para validar Validar que la opcion Ir al portal de empleos despliegue ventana")
    public void test_ValidarOpcionIrPortalEmpleosDespliegueVentana() {

        String urlApp = "https://www.choucairtesting.com/empleos-testing/";
        String actualResultado2 = "";
        String resultadoExperado2 = "CURSOS GENERALES PARA INGENIEROS";


        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get(urlApp);
        driver.manage().window().maximize();
        //Clic en el enlace
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/section[2]/div/div/div[2]/div/div/div/div/div/div/h3/a")).click();
        actualResultado2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/section[11]/div/div/div[1]/div/div/div/div/div/h3[1]")).getText();

        Assert.assertEquals("Prueba falla",resultadoExperado2,actualResultado2);

        if (actualResultado2.contentEquals(resultadoExperado2)){
            System.out.println("Prueba Existosa");
        }else
            System.out.println("Prueba Fallo");
        driver.quit();

    }


    @Test
    @DisplayName("Caso de prueba para validar Apertura de enlace Modelo de calidad de software")
    public void test_ValidarEnlaceModeloCalidadSoftware() {

        String urlApp = "https://www.choucairtesting.com/empleos-testing/";

        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get(urlApp);


        WebElement validarEnalce = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/section[11]/div/div/div[1]/div/div/div/div/div/ul[1]/li[1]/a"));
        HttpURLConnection http = null;
        int codigorespuesta = 200;
        String src = "";

        src = validarEnalce.getAttribute("href");

        System.out.println("Validar el src"+ src);

        try{
            http = (HttpURLConnection) (new URL(src).openConnection());
            http.setRequestMethod("HEAD");
            http.connect();

            // Asignar codigo de respuesta a variable codigo de respuesta
            codigorespuesta = http.getResponseCode();
            System.out.println(codigorespuesta);

            if (codigorespuesta >= 400){
                System.out.println(src +" Es un link roto");
            }else {
                System.out.println(src +" Es un link estable");
            }


        }catch (Exception e){
            System.out.println("Error Catche"+ e);
        }
        driver.quit();

    }

}
