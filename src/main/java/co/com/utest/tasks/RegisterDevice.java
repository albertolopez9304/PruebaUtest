package co.com.utest.tasks;

import co.com.utest.model.UserData;
import co.com.utest.userinterface.RegisterDevicePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.Keys;
import static net.serenitybdd.screenplay.actions.Click.*;
import static net.serenitybdd.screenplay.actions.type.Type.*;


public class RegisterDevice implements Task {

    private final UserData userData;

    public RegisterDevice(UserData userData) {
        this.userData = userData;
    }

    public static RegisterDevice withData(UserData userData){
        return Tasks.instrumented(RegisterDevice.class, userData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                on(RegisterDevicePage.COMPUTER),
                theValue(userData.getComputer()).into(RegisterDevicePage.SELECT_COMPUTER).thenHit(Keys.ENTER),
                on(RegisterDevicePage.VERSION),
                theValue(userData.getVersion()).into(RegisterDevicePage.SELECT_VERSION).thenHit(Keys.ENTER),
                on(RegisterDevicePage.LANGUAGE),
                theValue(userData.getLanguage()).into(RegisterDevicePage.SELECT_LANGUAGE).thenHit(Keys.ENTER),
                on(RegisterDevicePage.MOBILE),
                theValue(userData.getMobile()).into(RegisterDevicePage.SELECT_MOBILE).thenHit(Keys.ENTER),
                on(RegisterDevicePage.MODEL),
                theValue(userData.getModelMobile()).into(RegisterDevicePage.SELECT_MODEL).thenHit(Keys.ENTER),
                on(RegisterDevicePage.SYSTEM),
                theValue(userData.getOperatingSystem()).into(RegisterDevicePage.SELECT_SYSTEM).thenHit(Keys.ENTER),
                on(RegisterDevicePage.LAST_STEP)
        );

    }
}
