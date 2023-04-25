package co.com.certification.serenitydemo.interactions;

import co.com.certification.serenitydemo.userinterfaces.MenuOrganizationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class GoesBusinessUnits implements Interaction {

    public static Performable letsGo() {
        return Tasks.instrumented(GoesBusinessUnits.class);
    }

    @Override
    @Step("{0} is going to new business unit")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MenuOrganizationPage.LINK_ORGANIZATION),
                Click.on(MenuOrganizationPage.LINK_BUSINESS_UNITS));
    }
}
