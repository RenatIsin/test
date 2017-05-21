package pages;

import elements.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

/**
 * Created by MiF on 19.05.2017.
 */
public class PaymentsPage extends BasePage{

    @FindBy(xpath = "//*[@data-reactid=\"231\"]")
    private UIMenuItemsList paymentTypes;

    @FindBy(tagName = "section")
    private Section payments;

    @FindBy(className = "ui-menu-second__items")
    private TabsElement tabs;

    @FindBy(tagName = "form")
    private PayForm payForm;

    @FindBy(xpath = "//form[@class='ui-search-input']/label/div/input")
    private TextInput search;

    @FindBy(className = "ui-search-flat")
    private SearchResultList searchResultList;

    @FindBy(className = "ui-banner")
    private TextBlock banner;

    public PaymentsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public UIMenuItemsList paymentTypes() {
        return paymentTypes;
    }

    public Section payments(){
        return payments;
    }

    public TabsElement tabs(){
        return tabs;
    }

    public PayForm payForm(){
        return payForm;
    }

    public TextInput search(){
        return search;
    }

    public SearchResultList result(){
        return searchResultList;
    }

    public TextBlock banner(){
        return banner;
    }
}
