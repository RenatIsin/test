package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by MiF on 19.05.2017.
 */
public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver driver(){
        return driver;
    }

    public void setDriver(WebDriver driver){
        this.driver = driver;
    }

    public void open(String url){
        driver.get(url);
    }
}
