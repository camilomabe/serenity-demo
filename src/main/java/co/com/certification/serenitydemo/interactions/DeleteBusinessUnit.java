package co.com.certification.serenitydemo.interactions;

import co.com.certification.serenitydemo.userinterfaces.CommonTargetsPage;
import co.com.certification.serenitydemo.utils.SessionVariables;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class DeleteBusinessUnit implements Interaction {
    public static Performable letsGo() {
        return Tasks.instrumented(DeleteBusinessUnit.class);
    }

    @SneakyThrows
    @Override
    @Step("{0} delete business unit")
    public <T extends Actor> void performAs(T actor) {
        String unitName = actor.recall(SessionVariables.BUSINESS_UNIT_NAME.toString());
        actor.attemptsTo(
                Enter.theValue(unitName).into(CommonTargetsPage.SEARCH_BY_NAME),
                Click.on(CommonTargetsPage.labelSearch(unitName)),
                RemovesEvents.delete());
    }
}
