package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;

/**
 * Created by MiF on 20.05.2017.
 */
public class Modal extends HtmlElement{

    //todo : elements of modal window

    @FindBy(className = "ui-regions__item")
    private List<Link> regions;

    public Modal(WebDriver driver){
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public void select(String name){
        regions.stream().filter(item -> (item.getText().equals(name))).findFirst().get().findElement(By.tagName("span")).click();
//        this.findElement(By.xpath("//div[@class='ui-regions__item' and contains(text(), '" + name + "')]")).click();
    }
}
