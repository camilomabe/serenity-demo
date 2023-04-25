package co.com.certification.serenitydemo.interactions;

import co.com.certification.serenitydemo.userinterfaces.MenuMeetingPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class GoesMeeting implements Interaction {

    public static Performable letsGo() {
        return Tasks.instrumented(GoesMeeting.class);
    }

    @Override
    @Step("{0} is going to meeting")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MenuMeetingPage.LINK_MEETING),
                Click.on(MenuMeetingPage.LINK_MEETINGS));
    }
}
