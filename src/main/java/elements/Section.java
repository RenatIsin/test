package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;
import ru.yandex.qatools.htmlelements.matchers.WrapsElementMatchers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;

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

    public boolean cityIs(String name){
        return title().city().getText().equals(name);
    }

    public boolean cityIsNot(String name){
        return !cityIs(name);
    }

    public Section hasItem(String name){
        assertThat(items().withTitle(name), WrapsElementMatchers.exists());
        return this;
    }

    public Section noItem(String name){
        assertThat(items().withTitle(name), nullValue());
        return this;
    }


}
