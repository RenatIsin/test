package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;

/**
 * Created by MiF on 21.05.2017.
 */

public class TabsElement extends TextBlock {

    @FindBy(className = "ui-menu-second__item")
    public List<Link> tabs;

    @FindBy(xpath = "//li[contains(class, 'ui-menu-second__item_active')]")
    public Link active;


    public TabsElement(WebElement wrappedElement){
        super(wrappedElement);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(wrappedElement)), this);
    }


    public Link active() {
        return active;
    }

    public void select(String name){
        tabs.stream().filter(
                item -> (item.getText().equals(name))).findFirst().get().findElement(By.tagName("a")).click();
    }

    //position stats from 1 ...
    public void select(int position){
        tabs.get(position - 1).findElement(By.tagName("a")).click();
    }
}
