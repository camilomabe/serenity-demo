package co.com.certification.serenitydemo.tasks;

import co.com.certification.serenitydemo.interactions.GoesBusinessUnits;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static co.com.certification.serenitydemo.userinterfaces.BusinessUnitsPage.NEW_BUSINESS_UNITS;
import static co.com.certification.serenitydemo.userinterfaces.BusinessUnitsPage.TXT_NEW_BUSINESS_UNITS_NAME;
import static co.com.certification.serenitydemo.userinterfaces.CommonTargetsPage.SAVE_AND_CLOSE_BUTTON;
import static co.com.certification.serenitydemo.userinterfaces.CommonTargetsPage.SEARCH_BY_NAME;
import static co.com.certification.serenitydemo.utils.SessionVariables.BUSINESS_UNIT_NAME;


public class CreatesNewBusinessUnit implements Task {

    private final String nameBusinessUnit;

    public CreatesNewBusinessUnit(String nameBusinessUnit) {
        this.nameBusinessUnit = nameBusinessUnit;
    }

    public static Performable letsGo(String nameBusinessUnit) {
        return Tasks.instrumented(CreatesNewBusinessUnit.class, nameBusinessUnit);
    }

    @Override
    @Step("{0} creates new business unit")
    public <T extends Actor> void performAs(T actor) {
        actor.remember(BUSINESS_UNIT_NAME.toString(), nameBusinessUnit);
        actor.attemptsTo(GoesBusinessUnits.letsGo(),
                Click.on(NEW_BUSINESS_UNITS),
                Enter.theValue(nameBusinessUnit).into(TXT_NEW_BUSINESS_UNITS_NAME),
                Click.on(SAVE_AND_CLOSE_BUTTON),
                Enter.theValue(nameBusinessUnit).into(SEARCH_BY_NAME));
    }
}
