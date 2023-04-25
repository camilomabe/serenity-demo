package co.com.certification.serenitydemo.tasks;

import co.com.certification.serenitydemo.interactions.IfCredentialsAreTrue;
import co.com.certification.serenitydemo.models.CredentialsModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static co.com.certification.serenitydemo.userinterfaces.LoginHomePage.*;
import static co.com.certification.serenitydemo.utils.SessionVariables.USER;

public class LogInMap implements Task {

    private final CredentialsModel credentials;

    public LogInMap(CredentialsModel dataUser) {
        this.credentials = dataUser;
    }

    @Override
    @Step("{0} is going to log in with a user")
    public <T extends Actor> void performAs(T actor) {

        actor.remember(USER.toString(), credentials.getUser());
        actor.attemptsTo(
                Enter.theValue(credentials.getUser()).into(TXT_USER),
                Enter.theValue(credentials.getPassword()).into(TXT_PASSWORD),
                Click.on(BTN_LOGIN),
                IfCredentialsAreTrue.verify()
        );
    }

    public static Performable forLoginIn(CredentialsModel credentials) {
        return Tasks.instrumented(LogInMap.class, credentials);
    }

}
