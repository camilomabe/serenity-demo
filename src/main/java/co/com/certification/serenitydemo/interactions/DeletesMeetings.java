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

public class DeletesMeetings implements Interaction {

    public static Performable letsGo() {
        return Tasks.instrumented(DeletesMeetings.class);
    }

    @SneakyThrows
    @Override
    @Step("{0} deletes meetings")
    public <T extends Actor> void performAs(T actor) {
        String meetings = actor.recall(SessionVariables.MEETING_NAME_VALUE.toString());
        actor.attemptsTo(
                Enter.theValue(meetings).into(CommonTargetsPage.SEARCH_BY_NAME),
                Click.on(CommonTargetsPage.labelSearch(meetings)),
                RemovesEvents.delete());
    }
}
