import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;
public class Exem09032021 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        System.out.println("Sterted test");
        String url = "http://shop.demoqa.com/shop/";
        webDriver.get(url);
        String cssdefaultSortingClick = "#noo-site > div.noo-container-shop.noo-shop-wrap > div.noo-container-catalog > div > form > select";
        webDriver.manage().window().maximize();
        String shoes = "Shoes";
        String checktitle = "ROSE GOLD SIMPLE STRAP PLATFORM SANDALS";
        String send = "Sun Glasses";
        String strcount = "₹55.00";

        try {
            WebElement defaultSortingClick = webDriver.findElement(By.cssSelector(cssdefaultSortingClick));
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            System.out.println("Menu \"Default sorting\":\n"+defaultSortingClick.getText());
            defaultSortingClick.click();
            WebElement option1= webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[1]/div/form/select/option[2]"));
            System.out.println("Click on - " + option1.getText());
            option1.click();
            Thread.sleep(1000);
            WebElement linkshoes = webDriver.findElement(By.partialLinkText(shoes));
            System.out.println("Click on category - "+ linkshoes.getText());
            linkshoes.click();
            Thread.sleep(1000);
            WebElement roseShoes = webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[5]/div"));
            roseShoes.click();
            System.out.println("Click on " + shoes +" "+ checktitle);
            Thread.sleep(1000);
            WebElement titleRoseShoes = webDriver.findElement(By.tagName("h1"));
            System.out.println("Title " + shoes +" "+ titleRoseShoes.getText());
            System.out.println("Test title");
            String title = titleRoseShoes.getText();
            Assert.assertEquals(checktitle,title);
            Thread.sleep(1000);
            System.out.println("Go to home page");
            webDriver.navigate().to(url);
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            System.out.println("Test Search");
            WebElement search = webDriver.findElement(By.className("noo-search"));
            search.click();
            WebElement sendKeys=webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[3]/div[2]/form/input[1]"));
            sendKeys.sendKeys(send);
            Thread.sleep(1000);
            sendKeys.submit();
            WebElement glassesElement = webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[4]/div/h3/a"));
            WebElement glassesName = webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[4]/div/h3/a"));
            String glName=glassesName.getText();
            System.out.println("Click on " + glName);
            glassesElement.click();
            Thread.sleep(1000);
            WebElement count = webDriver.findElement(By.cssSelector("#product-1323 > div.single-product-content > div.summary.entry-summary > p > ins > span > bdi"));
            String countEl=count.getText();
            System.out.println("Price " + glName + " is " + countEl);
            System.out.println("Test price ");
            Assert.assertEquals(strcount,countEl);
            Thread.sleep(1000);
        }catch (NoSuchElementException | InterruptedException e){
            System.out.println(e.getMessage());
        }
        webDriver.quit();
        System.out.println("Ended Test");
    }
}
