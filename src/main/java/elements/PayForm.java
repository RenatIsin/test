package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Form;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;

/**
 * Created by MiF on 21.05.2017.
 */
public class PayForm extends Form {

    @FindBy(className = "ui-form__field")
    private List<MarkedInput> formFields;

    @FindBy(tagName = "button")
    private Button payButton;

    public PayForm(WebElement wrappedElement) {
        super(wrappedElement);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(wrappedElement)), this);
    }

    public MarkedInput payCode() {
        return formFields.get(0);
    }

    public MarkedInput payPeriod() {
        return formFields.get(1);
    }

    public MarkedInput insurance() {
        return formFields.get(2);
    }

    public MarkedInput paySum() {
        return formFields.get(3);
    }

    public PayForm fillCode(String value){
        payCode().sendKeys(value);
        return this;
    }

    public PayForm fillPeriod(String value){
        payPeriod().sendKeys(value);
        return this;
    }

    public PayForm fillInsurance(String value){
        insurance().sendKeys(value);
        return this;
    }

    public PayForm fillSum(String value){
        paySum().sendKeys(value);
        return this;
    }
}
