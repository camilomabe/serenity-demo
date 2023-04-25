package co.com.certification.serenitydemo.questions;

import co.com.certification.serenitydemo.userinterfaces.CommonTargetsPage;
import co.com.certification.serenitydemo.utils.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

public class ValidatesBusinessMeeting implements Question<String> {

    public static Question<String> wasCreate() {
        return new ValidatesBusinessMeeting();
    }

    @Override
    @Step("{0} searches meeting name")
    public String answeredBy(Actor actor) {
        return CommonTargetsPage.labelSearch(actor.recall(SessionVariables.MEETING_NAME_VALUE.toString())).resolveFor(actor).getText();
    }
}
