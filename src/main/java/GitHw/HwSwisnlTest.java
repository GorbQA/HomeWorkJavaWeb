package GitHw;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HwSwisnlTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        String url = "https://swisnl.github.io/jQuery-contextMenu/demo.html";
        System.out.println("Start test1");
        webDriver.get(url);

        Actions action = new Actions(webDriver).contextClick(webDriver.findElement(By.cssSelector("body > div.wy-grid-for-nav > section > div > div > div > p > span")));
        action.build().perform();
        WebElement button = null;

        try {
            button = webDriver.findElement(By.cssSelector(" body > ul > li.context-menu-item.context-menu-icon.context-menu-icon-quit "));
            button.click();
            Thread.sleep(2000);
            WebDriver.TargetLocator targetLocator = webDriver.switchTo();
            Alert alert = targetLocator.alert();
            String expectedText = "clicked: quit ";
            String actualText = alert.getText();
            Thread.sleep(2000);
            if (expectedText.equals(actualText)) {
                System.out.println("Passed");
            } else {
                System.out.println("Модальное окно содержит текст " + actualText);
            }
            alert.accept();
            Thread.sleep(2000);
            System.out.println("Все прошло хорошо");
        } catch (NoSuchElementException e) {
            System.out.println("Элемент не найден");
        }

        System.out.println("End test2");
        Thread.sleep(2000);

    }
}
