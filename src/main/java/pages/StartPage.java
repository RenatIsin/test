package pages;

import elements.Header;
import elements.HeaderMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

/**
 * Created by MiF on 19.05.2017.
 */
public class StartPage extends BasePage {

    private String url = "https://www.tinkoff.ru";
    Header header;

    public StartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
        header = new Header(driver);
    }

    public StartPage open(){
        open(url);
        return this;
    }

    public Header header(){
        return header;
    }


}
