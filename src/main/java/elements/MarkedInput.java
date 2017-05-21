package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

/**
 * Created by MiF on 21.05.2017.
 */
public class MarkedInput extends TextInput {

    @FindBy(tagName = "input")
    private TextInput input;

    @FindBy(className = "ui-input")
    private TextBlock wrapper;

    @FindBy(className = "ui-form-field-error-message")
    private TextBlock errorMessage;


    public MarkedInput(WebElement wrappedElement) {
        super(wrappedElement);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(wrappedElement)), this);
    }

    public TextInput input() {
        return input;
    }

    public TextBlock colorWrapper() {
        return wrapper;
    }

    public TextBlock errorMessage() {
        return errorMessage;
    }

    public void sendKeys(CharSequence... keysToSend) {
        input.sendKeys(keysToSend);
    }

    public MarkedInput type(CharSequence... keysToSend) {
        sendKeys(keysToSend);
        return this;
    }

    public void clear(){
        input.clear();
    }

    public MarkedInput clearIt() {
        clear();
        return this;
    }
}
