package GitHw;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;

import java.util.List;

public class HwTestSwisn1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        System.out.println("Started test");
        String url = "https://swisnl.github.io/jQuery-contextMenu/demo.html";
        webDriver.get(url);
        Actions actions = new Actions(webDriver);

        WebElement button = webDriver.findElement(By.cssSelector("body > div > section > div > div > div > p > span"));
        WebElement contexst = webDriver.findElement(By.cssSelector("body > ul"));
        List <WebElement> contexstLi = contexst.findElements(By.tagName("li"));

        System.out.println(button.getText());
        actions.contextClick(button);
        Thread.sleep(2000);
        actions.moveToElement(contexstLi.get(5));
        Thread.sleep(2000);
        webDriver.quit();
        System.out.println("Ended test");
    }
}
