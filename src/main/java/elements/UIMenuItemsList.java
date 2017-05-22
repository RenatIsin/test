package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by MiF on 20.05.2017.
 */
public class UIMenuItemsList extends HtmlElement {

    @FindBy(xpath = "//li[contains(@class, 'ui-menu__item')]")
    private List<Link> items;


    public Link withTitle(String name){
        return items.stream().filter(item -> (item.getText().equals(name))).findFirst().orElse(null);
    }

    //number start from 1 ...
    public Link onPosition(int number){
        return items.get(number - 1);
    }

}
