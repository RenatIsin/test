package elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;

/**
 * Created by MiF on 20.05.2017.
 */
public class TitleComponent extends HtmlElement {

//    @FindBy
    private TextBlock title;

    @FindBy(className = "payment-page__title_inner")
    private Link city;

    public Link city() {
        return city;
    }

    public boolean cityIs(String name){
        return city().getText().equals(name);
    }
}
