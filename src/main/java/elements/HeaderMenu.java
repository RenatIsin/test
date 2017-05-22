package elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

import java.util.List;

/**
 * Created by MiF on 19.05.2017.
 */
public class HeaderMenu extends HtmlElement {

    //todo : other links
    //todo : 2 same menu blocks, no one way to correct location, and first menu hidden =(
    @FindBy(xpath = "//span[contains(text(), 'Платежи')]/..")
    private List<Link> payments;

    public Link paymentsLink(){
        return payments.stream().filter(item -> (item.isDisplayed())).findFirst().orElseThrow(AssertionError::new);
    }

    public HeaderMenu goToPayments(){
        paymentsLink().click();
        return this;
    }

}
