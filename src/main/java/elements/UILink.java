package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

/**
 * Created by MiF on 21.05.2017.
 */
public class UILink extends Link {

    @FindBy(className = "ui-search-flat__title-box")
    private TextBlock title;

    @FindBy(className = "ui-search-flat__description")
    private TextBlock description;

    public UILink(WebElement wrappedElement) {
        super(wrappedElement);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(wrappedElement)), this);
    }

    public TextBlock title() {
        return title;
    }

    public TextBlock description() {
        return description;
    }
}
