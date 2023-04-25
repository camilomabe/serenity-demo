package co.com.certification.serenitydemo.interactions;

import co.com.certification.serenitydemo.userinterfaces.CommonTargetsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class RemovesEvents implements Interaction {

    public static Performable delete() {
        return Tasks.instrumented(RemovesEvents.class);
    }

    @Override
    @Step("{0} delete schedule")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CommonTargetsPage.ICON_DELETE),
                Click.on(CommonTargetsPage.BTN_YES));
    }
}
