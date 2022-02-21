package co.com.utest.tasks;

import co.com.utest.model.UserData;
import co.com.utest.userinterface.RegisterAddressPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.type.Type;
import org.openqa.selenium.Keys;
import static net.serenitybdd.screenplay.actions.Click.*;
import static net.serenitybdd.screenplay.actions.Enter.*;
import static net.serenitybdd.screenplay.actions.Hit.*;


public class RegisterAddress implements Task {

    private final UserData userData;

    public RegisterAddress(UserData userData) {
        this.userData = userData;
    }

    public static RegisterAddress withData(UserData userData) {
        return Tasks.instrumented(RegisterAddress.class, userData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                theValue(userData.getCity()).into(RegisterAddressPage.CITY),
                the(Keys.ARROW_DOWN, Keys.ENTER).into(RegisterAddressPage.CITY),
                theValue(userData.getPostalCode()).into(RegisterAddressPage.POSTAL_CODE),
                on(RegisterAddressPage.COUNTRY),
                Type.theValue(userData.getCountry()).into(RegisterAddressPage.ENTER_COUNTRY).thenHit(Keys.ENTER),
                on(RegisterAddressPage.NEXT_DEVICES)
        );


    }
}
