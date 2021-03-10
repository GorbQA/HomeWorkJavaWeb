import net.bytebuddy.agent.builder.AgentBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class ApplicationTest {
    private WebDriver webDriver;


    @Before
    public void setUp() {
        System.out.println("Before test");
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("C:\\Java\\Git\\src\\main\\resources\\waits.html");
    }

    @Test
    public void testAlertWebDriwerWait (){
        System.out.println("Check alert");
        WebDriverWait webDriverWaitAlert = new WebDriverWait(webDriver, 120);
        Alert alert=webDriverWaitAlert.until(new WaitAlert());
        Assert.assertEquals("Test it", alert.getText());
        System.out.println("Text alert = " + alert.getText());
        alert.accept();
    }

    //    @Test
//    public void testAlertWebDriwerWait (){
//        System.out.println("Check ");
//        WebDriverWait webDriverWaitAlert = new WebDriverWait(webDriver, 120);
//        System.out.println("ok");
//        Alert alert=webDriverWaitAlert.until(new Function<WebDriver, Alert>() {
//            @Override
//            public Alert apply(WebDriver webDriver) {
//                return webDriver.switchTo().alert();
//            }
//        });
//        System.out.println(alert.getText());
//        Assert.assertEquals("Test it", alert.getText());
//        alert.accept();
//    }

    @Test
    public void testBackgroundWebDriverWait (){
        System.out.println("Check background");
        WebDriverWait webDriverWaitBackground = new WebDriverWait(webDriver, 200);
        WebElement background = webDriverWaitBackground.until(new WaitBackground());
        if (background.isDisplayed()){
        System.out.println("Background " + background.isDisplayed());}else {
            System.err.println("Background " + background.isDisplayed());
        }
    }

//    @Test
//    public void testBackgroundWebDriverWait (){
//        System.out.println("Check background");
//        WebDriverWait webDriverWaitBackground = new WebDriverWait(webDriver, 200);
//        WebElement background = webDriverWaitBackground.until(new Function<WebDriver, WebElement>(){
//            @Override
//            public WebElement apply(WebDriver webDriver) {
//                return webDriver.findElement(By.xpath("//*[@id=\"main\"]/ul/li[3]"));
//            }
//        });
//        if (background.isDisplayed()){
//        System.out.println("Background " + background.isDisplayed());}
//        else {
//            System.err.println("Background " + background.isDisplayed());
//        }
//    }

    @After
    public void close(){
        webDriver.quit();
        System.out.println("Test ended");
    }
}
class WaitAlert implements Function<WebDriver, Alert>{
    @Override
    public Alert apply(WebDriver webDriver) {
        return webDriver.switchTo().alert();
    }
}
class WaitBackground implements Function<WebDriver, WebElement>{
    @Override
    public WebElement apply(WebDriver webDriver) {
        return webDriver.findElement(By.xpath("//*[@id=\"main\"]/ul/li[3]"));
}}
