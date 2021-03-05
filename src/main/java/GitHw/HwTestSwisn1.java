package GitHw;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;

import java.util.List;

public class HwTestSwisn1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        System.out.println("Started test");
        String url = "https://swisnl.github.io/jQuery-contextMenu/demo.html";
        String checkText = "clicked: quit";
        webDriver.get(url);
        Thread.sleep(500);
        Actions actions = new Actions(webDriver);
        WebElement button = null;
        int i =0;
        try {
            button = webDriver.findElement(By.cssSelector("body > div > section > div > div > div > p > span"));
            System.out.println("Click on button " + button.getText());
            actions.contextClick(button).perform();
            Thread.sleep(500);
            webDriver.switchTo();
        List <WebElement> contexstLi = webDriver.findElements(By.cssSelector("body > ul > li"));
            System.out.println("LIST contexstmenu");
            for (WebElement webElement : contexstLi) {
                System.out.println(i + " " + webElement.getText());    //список контексного меню
                i++;
            }
            actions.click(contexstLi.get(6)).perform();
            WebDriver.TargetLocator targetLocator = webDriver.switchTo();
            Thread.sleep(500);
            Alert alert = targetLocator.alert();
            if (checkText.equals(alert.getText())){
                System.out.println("Сorresponds to " + checkText);
            }else {
                System.err.println(checkText + " don't corresponds to " + alert.getText());
            }
            alert.accept();
            Thread.sleep(500);
        }catch (Exception e) {

        }
        webDriver.quit();
        System.out.println("Ended test");
    }
}
