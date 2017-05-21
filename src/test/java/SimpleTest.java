import elements.*;
import org.hamcrest.Matchers;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PaymentsPage;
import pages.StartPage;
import ru.yandex.qatools.htmlelements.element.Link;

import static matchers.IncorrectInputMatcher.markedAsErrorWithText;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

/**
 * Created by MiF on 19.05.2017.
 */
public class SimpleTest extends BaseTest {

    private StartPage startPage;
    private PaymentsPage paymentsPage;

    @BeforeClass
    public void initPages(){
        startPage = new StartPage(driver());
        paymentsPage = new PaymentsPage(driver());
    }

    @AfterClass
    public void stop(){
        driver().close();
    }

    @Test
    public void test(){
        HeaderMenu menu = startPage.open().header().menu();
        menu.paymentsLink().click();
        paymentsPage.paymentTypes().withTitle("Коммунальные платежи").click();

        TitleComponent title = paymentsPage.payments().title();
        if(!title.cityIs("Москве")){
            title.city().click();
            new Modal(driver()).select("г. Москва");
        }
        Link service = paymentsPage.payments().items().onPosition(1);
        assertThat(service, hasText("ЖКУ-Москва"));

        String serviceName = service.getText();
        service.click();
        byte[] page = ((TakesScreenshot)driver()).getScreenshotAs(OutputType.BYTES);
        paymentsPage.tabs().select("ОПЛАТИТЬ ЖКУ В МОСКВЕ");


        PayForm payForm = paymentsPage.payForm();

        payForm.submit();
        String emptyError = "Поле обязательное";
        String incorrectError = "Поле неправильно заполнено";

        assertThat(payForm.payCode(), markedAsErrorWithText(emptyError));
        assertThat(payForm.payPeriod(), markedAsErrorWithText(emptyError));
        assertThat(payForm.paySum(), markedAsErrorWithText(emptyError));

       /*  checkIncorrectInput(payForm.payCode(), "280132100", incorrectError);
        checkIncorrectInput(payForm.payCode(), RandomStringUtils.randomNumeric(300), incorrectError);
        checkIncorrectInput(payForm.payCode(), "28013210011", incorrectError);
        checkIncorrectInput(payForm.payCode(), "-8013210011", incorrectError);
        checkIncorrectInput(payForm.payCode(), "asdaasdd11", incorrectError);
        checkIncorrectInput(payForm.payCode(), "null", incorrectError);
        checkIncorrectInput(payForm.payCode(), "*", incorrectError);
        checkIncorrectInput(payForm.payCode(), "*^&%$&#(*&(", incorrectError);
        checkIncorrectInput(payForm.payCode(), "21 80 1 32  10  0", incorrectError);

        incorrectError = "Поле заполнено некорректно";

        checkIncorrectInput(payForm.payPeriod(), "aassss", emptyError);
        checkIncorrectInput(payForm.payPeriod(), "002017", incorrectError);
        checkIncorrectInput(payForm.payPeriod(), "402017", incorrectError);
        checkIncorrectInput(payForm.payPeriod(), "-12017", incorrectError);
        checkIncorrectInput(payForm.payPeriod(), "01-001", incorrectError);
        checkIncorrectInput(payForm.payPeriod(), "null", emptyError);
        checkIncorrectInput(payForm.payPeriod(), "@№**", emptyError);
        checkIncorrectInput(payForm.payPeriod(), " ", emptyError);
        checkIncorrectInput(payForm.payPeriod(), "21 80 1 3", incorrectError);
        //todo  ? почему нулевой год корректен?
//        checkIncorrectInput(payForm.payCode(), "010000", emptyError);

        checkIncorrectInput(payForm.paySum(), "null", emptyError);
        checkIncorrectInput(payForm.paySum(), " ", emptyError);
        checkIncorrectInput(payForm.paySum(), "*@#$%", emptyError);
        checkIncorrectInput(payForm.paySum(), "100 000 000 000", "Максимальная сумма перевода - 15 000 \u20BD");
        checkIncorrectInput(payForm.paySum(), "0", "Минимальная сумма перевода - 10 \u20BD");
        checkIncorrectInput(payForm.paySum(), "5", "Минимальная сумма перевода - 10 \u20BD");
        checkIncorrectInput(payForm.paySum(), "9", "Минимальная сумма перевода - 10 \u20BD");
*/
        menu.paymentsLink().click();
        paymentsPage.search().sendKeys(serviceName);
        UILink neededService = paymentsPage.result().onPostition(1);
        assertThat(neededService.title().getText(), equalTo(serviceName));
        neededService.click();

        assertThat(new String(page), equalTo(new String(((TakesScreenshot)driver()).getScreenshotAs(OutputType.BYTES))));

        System.out.println(12123);
    }

    private void checkIncorrectInput(MarkedInput field, String input, String errorMessage) {
        field.clearIt().sendKeys(input);
        field.sendKeys(Keys.ENTER);
        assertThat(field, markedAsErrorWithText(errorMessage));
    }

//
//            12. Выполнить шаги (2) и (3).
//
//            13. В списке регионов выбрать “г. Санкт-Петербург”.
//
//            14. Убедится, что в списке поставщиков на странице выбора поставщиков услуг отсутствует
//
//    искомый.


//    Реализовать тест согласно следующему сценарию:
//
//            1. Переходом по адресу https://www.tinkoff.ru/ загрузить стартовую страницу Tinkoff Bank.
//
//            2. Из верхнего меню, нажатием на пункт меню “Платежи“, перейти на страницу “Платежи“.
//
//            3. В списке категорий платежей, нажатием на пункт “Коммунальные платежи“, перейти на
//
//    страницу выбора поставщиков услуг.
//
//            4. Убедиться, что текущий регион – “г. Москва” (в противном случае выбрать регион “г.
//
//            Москва” из списка регионов).
//
//            5. Со страницы выбора поставщиков услуг, выбрать 1-ый из списка (Должен быть “ЖКУ-
//
//            Москва”). Сохранить его наименование (далее “искомый”) и нажатием на
//
//    соответствующий элемент перейти на страницу оплаты “ЖКУ-Москва“.
//
//            6. На странице оплаты, перейти на вкладку “Оплатить ЖКУ в Москве“.
//
//            7. Выполнить проверки на невалидные значения для обязательных полей: проверить все
//
//    текстовые сообщения об ошибке (и их содержимое), которые появляются под
//
//    соответствующим полем ввода в результате ввода некорректных данных.
//
//            8. Повторить шаг (2).
//
//            9. В строке быстрого поиска поставщика услуг ввести наименование искомого (ранее
//
//                                                                                               сохраненного).
//
//            10. Убедиться, что в списке предложенных провайдеров искомый поставщик первый.
//
//            11. Нажатием на элемент, соответствующий искомому, перейти на страницу “Оплатить ЖКУ в
//
//    Москве“. Убедиться, что загруженная страница та же, что и страница, загруженная в
//
//    результате шага (5).
//
//            12. Выполнить шаги (2) и (3).
//
//            13. В списке регионов выбрать “г. Санкт-Петербург”.
//
//            14. Убедится, что в списке поставщиков на странице выбора поставщиков услуг отсутствует
//
//    искомый.
}
