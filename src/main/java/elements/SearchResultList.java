package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;

/**
 * Created by MiF on 21.05.2017.
 */
public class SearchResultList extends TextBlock {

    @FindBy(className = "ui-search-flat__item")
    private List<UILink> items;

    public SearchResultList(WebElement wrappedElement){
        super(wrappedElement);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(wrappedElement)), this);
    }

//    public List<UILink> items(){
//        return items;
//    }

    public SearchResultList hasItemWithTitle(String title){
        items.stream().filter(item -> (item.title().getText().equals(title))).findFirst().orElseThrow(AssertionError::new);
        return this;
    }

    //start form 1 ...
    public UILink onPostition(int position){
        return items.get(position - 1);
    }


}
