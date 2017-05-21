package elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

/**
 * Created by MiF on 19.05.2017.
 */
public class HeaderMenu extends HtmlElement {

    //todo : other links
    @FindBy(xpath = "//div/nav/div[3]/a")
    private Link payments;

    public Link paymentsLink(){
        return payments;
    }

}
