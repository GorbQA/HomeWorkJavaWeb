//package GitHw;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;
//import org.openqa.selenium.support.PageFactory;
//
//import java.util.concurrent.TimeUnit;
//
//public class SeleniumeasyImgTest extends WebPage {
//
//    @FindBy(how = How.CSS, using = "#save")
//    WebElement button;
//    @FindBy(how = How.CSS, using = "#loading > img")
//    WebElement img;
//    @FindBy (how = How.XPATH, using = "//*[@id=\"loading\"]/text()[1]")
//    WebElement fName;
//    @FindBy (how = How.XPATH, using = "//*[@id=\"loading\"]/text()[2]")
//    WebElement lName;
//
//
//    private String url;
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public SeleniumeasyImgTest(WebDriver webDriver) {
//        super(webDriver);
//    }
//    public <button> void Displaed (button){
//    button.click();
//    webDriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//    if(img.isDisplayed()) {
//        System.out.println("Pass");
//    }else{
//        System.out.println("Error");
//    }}
//
//    public static void main(String[] args) {
//        System.out.println("Started test");
//        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
//        WebDriver webDriver = new ChromeDriver();
//        SeleniumeasyImgTest seleniumeasyImgTest = PageFactory.initElements(webDriver,SeleniumeasyImgTest.class);
//        seleniumeasyImgTest.setUrl("http://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");
//        seleniumeasyImgTest.Displaed(seleniumeasyImgTest.img);
//        webDriver.quit();
//        System.out.println("End test");
//    }
//
//}
