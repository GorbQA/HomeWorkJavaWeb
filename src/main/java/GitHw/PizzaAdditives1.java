package GitHw;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.List;
//        1. Открыть веб-браузер и загрузить страницу select.html.
//        2. В первом выпадающем списке "Multiple select" необходиом выбрать "Cheese"
//        3. Проверить наличие выбранного элемента "Cheese" в select элементе с id = out2
//        4. Далее выбрать "Pepperoni"
//        5. Проверить наличие выбранного элемента "Cheese" и "Pepperoni" в select элементе с id = out2
//        6. Далее выбрать "Mushrooms"
//        7. Проверить наличие выбранного элемента "Cheese" и "Pepperoni" и "Mushrooms" в select элементе с id = out2
public class PizzaAdditives1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        System.out.println("Started test");
        String html = "C:\\Java\\Git\\src\\main\\resources\\select.html";
        webDriver.get(html);
        String testOptions1 = "Cheese";
        String testOptions2 = "Cheese\nPepperoni";
        String testOptions3 = "Cheese\nPepperoni\nMushrooms";
        Actions actions = new Actions(webDriver);
        try {
            System.out.println("Testcase1. " + testOptions1);
            List<WebElement> option = webDriver.findElements(By.tagName("option"));
            actions
                    .click(option.get(0))
                    .keyDown(Keys.CONTROL)
                    .perform();
            String realOptions = webDriver.findElement(By.id("out2")).getText();
            PizzaAdditives1.Test(realOptions,testOptions1);
            System.out.println("Testcase2\n" + testOptions2);
            actions.keyDown(Keys.CONTROL).moveToElement(option.get(2)).click().perform();
            realOptions = webDriver.findElement(By.id("out2")).getText();
            PizzaAdditives1.Test(realOptions,testOptions2);
            System.out.println("Testcase3\n" + testOptions3);
            actions.keyDown(Keys.CONTROL).moveToElement(option.get(4)).click().perform();
            realOptions = webDriver.findElement(By.id("out2")).getText();
            PizzaAdditives1.Test(realOptions,testOptions3);
    }catch (Exception e){
            System.out.println(e);
        }
}
    private static void Test(String realOption, String testOptions) {
        if (realOption.equals(testOptions)) {
            System.out.println("Pass test\n" + realOption + "=" + testOptions);
        } else {
            System.err.println("Error \n" + realOption + "=" + testOptions);
        }
    }
    }
