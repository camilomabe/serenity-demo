package co.com.certification.serenitydemo.tasks;

import co.com.certification.serenitydemo.interactions.DeleteBusinessUnit;
import co.com.certification.serenitydemo.interactions.DeletesMeetings;
import co.com.certification.serenitydemo.interactions.GoesBusinessUnits;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class DeletesSchedules implements Task {

    public static Performable letsGo() {
        return Tasks.instrumented(DeletesSchedules.class);
    }

    @Override
    @Step("{0} delete schedules")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(DeletesMeetings.letsGo(),
                GoesBusinessUnits.letsGo(),
                DeleteBusinessUnit.letsGo()
        );
    }
}
