package co.com.certification.serenitydemo.questions;

import co.com.certification.serenitydemo.exeptions.ErrorValidatingBusinessUnitName;
import co.com.certification.serenitydemo.userinterfaces.CommonTargetsPage;
import co.com.certification.serenitydemo.utils.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

public class ValidatesBusinessUnit implements Question<String> {

    public static Question<String> wasCreate() {
        return new ValidatesBusinessUnit();
    }

    @Override
    @Step("{0} searches business unit name")
    public String answeredBy(Actor actor) {
        try {
            return CommonTargetsPage.labelSearch(actor.recall(SessionVariables.BUSINESS_UNIT_NAME.toString())).resolveFor(actor).getText();
        } catch (RuntimeException e) {
            throw new ErrorValidatingBusinessUnitName(ErrorValidatingBusinessUnitName.ERROR_VALIDATING_UNIT);
        }
    }
}
