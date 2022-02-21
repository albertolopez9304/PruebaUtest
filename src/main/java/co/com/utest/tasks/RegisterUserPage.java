package co.com.utest.tasks;

import co.com.utest.model.UserData;
import co.com.utest.userinterface.PageBasicData;
import co.com.utest.userinterface.UtestPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import static net.serenitybdd.screenplay.actions.Click.*;
import static net.serenitybdd.screenplay.actions.Enter.*;
import static net.serenitybdd.screenplay.actions.SelectFromOptions.*;


public class RegisterUserPage implements Task {

    private final UserData userData;

    public RegisterUserPage(UserData userData) {
        this.userData = userData;
    }

    public static RegisterUserPage withData(UserData userData) {
        return Tasks.instrumented(RegisterUserPage.class, userData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                on(UtestPage.JOIN_TODAY),
                theValue(userData.getFirtsName()).into(PageBasicData.FIRST_NAME),
                theValue(userData.getLastName()).into(PageBasicData.LAST_NAME),
                theValue(userData.getEmail()).into(PageBasicData.EMAIL),
                byVisibleText(userData.getMonth()).from(PageBasicData.MONTH),
                byVisibleText(userData.getDay()).from(PageBasicData.DAY),
                byVisibleText(userData.getYear()).from(PageBasicData.YEAR),
                on(PageBasicData.NEXT_LOCATION)
        );
    }
}
