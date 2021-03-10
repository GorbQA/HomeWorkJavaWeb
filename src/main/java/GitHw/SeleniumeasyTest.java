package GitHw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumeasyTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");
        WebElement element;
        WebElement element1;
        try {
            System.out.println("Started test");
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            element = webDriver.findElement(By.cssSelector("#save"));
            element1 = webDriver.findElement(By.cssSelector("#loading"));
            element.click();
            if(element1.isDisplayed()) {
                System.out.println("isDisplayed");
            }else{
                System.err.println("Error");
            }
            Thread.sleep(2000);
            System.out.println(element1.getText());
            WebElement img = webDriver.findElement(By.cssSelector("#loading > img"));
            String src = img.getAttribute("src");
            System.out.println(src);
            System.out.println("Ended test");
        } catch (Exception e){ e.getMessage();}
        finally {
            assert webDriver != null;
            webDriver.quit();
        }
    }
}
