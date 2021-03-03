package GitHw;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.List;

public class PizzaAdditives {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        System.out.println("Started test");
        String html = "C:\\Java\\Git\\src\\main\\resources\\select.html";
        webDriver.get(html);
        Actions actions = new Actions(webDriver);
        try {
            List<WebElement> option = webDriver.findElements(By.tagName("option"));
            actions
                    .click(option.get(0))
                    .keyDown(Keys.CONTROL)
                    .perform();
            String option1 = webDriver.findElement(By.id("out2")).getText();
            if (option1.equals("Cheese")) {
                System.out.println("Pass");
            } else {
                System.out.println("Error");
            }
            actions.moveToElement(option.get(2))
                    .click().perform();
            String option2 = webDriver.findElement(By.id("out2")).getText();
            if (option2.equals("Cheese\nPepperoni")) {
                System.out.println("Pass");
            } else {
                System.out.println("Error");
            }
            actions
                    .moveToElement(option.get(4))
                    .click().pause(2000).perform();
            String option3 = webDriver.findElement(By.id("out2")).getText();
            if (option3.equals("Cheese\nPepperoni\nMushrooms")) {
                System.out.println("Pass");
            } else {
                System.out.println("Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        webDriver.quit();
        System.out.println("End test");
    }
}

