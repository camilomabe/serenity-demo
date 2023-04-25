package co.com.certification.serenitydemo.tasks;

import co.com.certification.serenitydemo.models.CredentialsModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.certification.serenitydemo.userinterfaces.LoginHomePage.*;
import static co.com.certification.serenitydemo.userinterfaces.MenuBarPage.AVATARS_USER;


public class EnterValueToLogin implements Task {

    private final CredentialsModel credentials;

    public EnterValueToLogin(CredentialsModel credentials) {
        this.credentials = credentials;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(credentials.getUser()).into(TXT_USER),
                Enter.theValue(credentials.getPassword()).into(TXT_PASSWORD),
                Click.on(BTN_LOGIN),
                Click.on(AVATARS_USER)
        );
    }

    public static EnterValueToLogin with(CredentialsModel credentials) {
        return Tasks.instrumented(EnterValueToLogin.class, credentials);
    }
}
