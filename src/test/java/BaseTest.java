import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

/**
 * Created by MiF on 19.05.2017.
 */
public class BaseTest {

    private WebDriver driver;

    public WebDriver driver(){
        return driver;
    }

    //do initialization of driver for all tests
    public void initDriver(){
        System.getProperties().setProperty("webdriver.chrome.driver", "D:\\Testing\\chromedriver.exe");
        driver = new ChromeDriver();
        driver().manage().window().maximize();
    }

    @BeforeClass
    public void prepare(){
        initDriver();
    }

}
