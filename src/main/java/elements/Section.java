package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

/**
 * Created by MiF on 20.05.2017.
 */
public class Section extends TextBlock {

    @FindBy(xpath = "//span/div[1]")
    private TitleComponent title;

    @FindBy(className = "ui-menu")
    private UIMenuItemsList items;

    public Section(WebElement wrappedElement){
        super(wrappedElement);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(wrappedElement)), this);
    }

    public TitleComponent title() {
        return title;
    }

    public UIMenuItemsList items() {
        return items;
    }
}
