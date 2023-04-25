package co.com.certification.serenitydemo.interactions;

import co.com.certification.serenitydemo.userinterfaces.LoginHomePage;
import co.com.certification.serenitydemo.userinterfaces.MenuBarPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class IfCredentialsAreTrue implements Interaction {

    public static Performable verify() {
        return Tasks.instrumented(IfCredentialsAreTrue.class);
    }

    @Override
    @Step("{0} if credentials are true")
    public <T extends Actor> void performAs(T actor) {
        if(!LoginHomePage.TEXT_WRONG_LOGIN.resolveFor(actor).isVisible()){
            actor.attemptsTo(Click.on(MenuBarPage.AVATARS_USER));
        }
    }
}
