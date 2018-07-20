import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItBooksTests {
    WebDriver webDriver;


    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\vasyl.barladyn\\fireFox\\geckodriver.exe");
        webDriver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 30, 500);

        webDriver.get("http://it-ebooks.info/");
        webDriver.findElement(By.id("q")).sendKeys("Automatioin");
        webDriver.findElement(By.cssSelector("input[type='submit']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/div/div/div/div/a[@class=\"gs-title\"]")));
    }


    @Test
    public void testSearchBookUrl(){
        Assert.assertTrue(webDriver.getCurrentUrl().contains("search"));
    }



    @Test
    public void testBooksSearch (){
        Assert.assertTrue(
                webDriver.findElements(
                        By.xpath("//div/div/div/div/div/div/a[@class=\"gs-title\"]"))
                        .size() == 10);
    }

    @After
    public void tearDown() {
        if(webDriver != null) {
            webDriver.close();
        }
    }
}
