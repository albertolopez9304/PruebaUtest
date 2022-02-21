package co.com.utest.tasks;

import co.com.utest.model.UserData;
import co.com.utest.userinterface.CreatePasswordPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.*;
import static net.serenitybdd.screenplay.actions.Click.*;
import static net.serenitybdd.screenplay.actions.Enter.*;

public class CreatePassword implements Task {

    private final UserData userData;

    public CreatePassword(UserData userData) {
        this.userData = userData;
    }

    public static CreatePassword withData(UserData userData) {
        return instrumented(CreatePassword.class, userData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                theValue(userData.getPassword()).into(CreatePasswordPage.CREATEPASSWORD),
                theValue(userData.getPassword()).into(CreatePasswordPage.CONFIRMPASSWORD),
                on(CreatePasswordPage.TERMS_OF_USE_UTEST),
                on(CreatePasswordPage.TERMS_OF_PRIVACY),
                on(CreatePasswordPage.COMPLETE_SETUP)
        );

    }
}
