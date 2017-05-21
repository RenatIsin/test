package matchers;

import elements.MarkedInput;
import org.hamcrest.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.matchers.common.HasEnteredTextMatcher;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

/**
 * Created by MiF on 21.05.2017.
 */
public class IncorrectInputMatcher extends TypeSafeMatcher<MarkedInput> {

    private final Matcher<String> errorText;

    public IncorrectInputMatcher(Matcher<String> errorText) {
        this.errorText = errorText;
    }

    @Override
    protected boolean matchesSafely(MarkedInput textInput) {
        assertThat("element not marked as error(red wrapper)", textInput.colorWrapper().getAttribute("class"), containsString("ui-input_error"));
        assertThat(textInput.errorMessage(), hasText(errorText));
        return true;
    }

    @Override
    public void describeTo(Description description) {
//        description.appendText("input item incorrect ").appendDescriptionOf(errorText);
    }

    @Override
    protected void describeMismatchSafely(MarkedInput textInput, Description mismatchDescription) {
//        mismatchDescription.appendText("item should marked as incorrect ");
    }

    public static Matcher<MarkedInput> markedAsErrorWithText(final Matcher<String> errorMessage) {
        return new IncorrectInputMatcher(errorMessage);
    }

    public static Matcher<MarkedInput> markedAsErrorWithText(String errorMessage) {
        return new IncorrectInputMatcher(is(errorMessage));
    }
}

