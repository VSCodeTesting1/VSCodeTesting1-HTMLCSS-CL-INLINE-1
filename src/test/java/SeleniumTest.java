import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions; //take away the screen flickering during each test when it trys to run each chrome session


public class SeleniumTest {

    private WebDriver driver;

   @Before 
   public void setUp() {
    System.setProperty("webdriver.chrome.driver", "driver/chromedriver");

    ChromeOptions options = new ChromeOptions();
    options.addArguments("headless");

    driver = new ChromeDriver(options);

    File file = new File("src/main/StyledElements.html");
    driver.get(file.toURI().toString());
    }


    @Test
    public void testItalicText() {
        WebElement p = driver.findElement(By.id("italic"));
        assertEquals("italic", p.getCssValue("font-style"));
    }

    @Test
    public void testSmallText() {
        WebElement p = driver.findElement(By.id("small"));
        String fontSize = p.getCssValue("font-size"); // e.g. "14px"

        fontSize = fontSize.substring(0, fontSize.length() - 2);
        int fontSizeNum = Integer.valueOf(fontSize);

        assertTrue(fontSizeNum < 16);
    }

    @Test
    public void testCenterContent() {
        WebElement p = driver.findElement(By.id("center"));
        assertEquals("center", p.getCssValue("text-align"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}





