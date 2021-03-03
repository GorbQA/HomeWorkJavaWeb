package GitHw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationIndex1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\chromedriver.exe");
        WebDriver webDriver=new ChromeDriver();
        webDriver.get("C:\\Users\\Student\\IdeaProjects\\selenium09022\\src\\main\\resources\\index1.html");
        System.out.println("Start");

        System.out.println("end");



    }
}
