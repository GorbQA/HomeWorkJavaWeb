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
        Actions action = new Actions(webDriver);
        WebElement additives = webDriver.findElement(By.cssSelector("#additives"));//найден элемент список ингридиентов
        System.out.println("ok");
        Select selectElement = new Select(additives); //запущен класс по работе с селекторами
        List <WebElement> additive = selectElement.getOptions(); //создан лист из вебэлементов
        for (WebElement add : additive) {
            System.out.println(add.getText());                    // проверила видно ли эти элементы
        }
        Thread.sleep(2000);
        System.out.println("ok");
        action.click(additive.get(0))                             // кликаю по первому элементу
                .keyDown(Keys.CONTROL)
                .moveToElement(additive.get(2));                  // кликаю по третьему элементу
        WebElement elementRez = webDriver.findElement(By.cssSelector("#out2")); //проделываю тоже со вторым окном
        Select selRez = new Select(elementRez);
        List <WebElement> listRez = selRez.getOptions();
        for (WebElement webElement : listRez) {
            System.out.println(webElement.getText());
        }
        System.out.println("ok");

        Thread.sleep(2000);
        webDriver.quit();
        System.out.println("Ended test");
    }
}
