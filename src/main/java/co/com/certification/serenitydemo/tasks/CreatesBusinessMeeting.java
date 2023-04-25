package co.com.certification.serenitydemo.tasks;

import co.com.certification.serenitydemo.models.MeetingDataModel;
import co.com.certification.serenitydemo.utils.Constants;
import co.com.certification.serenitydemo.interactions.GoesMeeting;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.type.Type;
import net.thucydides.core.annotations.Step;

import static co.com.certification.serenitydemo.userinterfaces.CommonTargetsPage.SAVE_AND_CLOSE_BUTTON;
import static co.com.certification.serenitydemo.userinterfaces.CommonTargetsPage.SEARCH_BY_NAME;
import static co.com.certification.serenitydemo.userinterfaces.MeetingPage.*;
import static co.com.certification.serenitydemo.utils.SessionVariables.BUSINESS_UNIT_NAME;
import static co.com.certification.serenitydemo.utils.SessionVariables.MEETING_NAME_VALUE;


public class CreatesBusinessMeeting implements Task {

    private final MeetingDataModel meetingInfo;

    public CreatesBusinessMeeting(MeetingDataModel dataMeeting) {
        this.meetingInfo = dataMeeting;
    }

    public static Performable letsGo(MeetingDataModel dataMeeting) {
        return Tasks.instrumented(CreatesBusinessMeeting.class, dataMeeting);
    }

    @Override
    @Step("{0} creates new business unit")
    public <T extends Actor> void performAs(T actor) {
        String unitName = actor.recall(BUSINESS_UNIT_NAME.toString());
        actor.remember(MEETING_NAME_VALUE.toString(), meetingInfo.getBusinessMeeting());

        actor.attemptsTo(GoesMeeting.letsGo(),
                Click.on(NEW_MEETING),
                Type.theValue(meetingInfo.getBusinessMeeting()).into(TXT_MEETING_NAME),
                Click.on(LIST_MEETING_TYPE),
                Click.on(lblMeetingOptions(Constants.MEETING_TYPE, meetingInfo.getMeetingType())),
                Type.theValue(meetingInfo.getMeetingNumber()).into(TXT_MEETING_NUMBER),
                Click.on(LIST_LOCATION),
                Click.on(lblMeetingOptions(Constants.MEETING_LOCATION, meetingInfo.getLocation())),
                Click.on(LIST_UNIT),
                Click.on(lblMeetingOptions(Constants.MEETING_UNIT, unitName)),
                Click.on(LIST_ORGANIZED_BY),
                Click.on(lblMeetingOptions(Constants.ORGANIZED_BY, meetingInfo.getOrganizedBy())),
                Click.on(LIST_REPORT),
                Click.on(lblMeetingOptions(Constants.REPORTER, meetingInfo.getOrganizedBy())),
                Click.on(LIST_ATTENDEE),
                Click.on(lblMeetingOptions(Constants.ATTENDEE_LIST, meetingInfo.getOrganizedBy())),
                Click.on(SAVE_AND_CLOSE_BUTTON),
                Enter.theValue(meetingInfo.getBusinessMeeting()).into(SEARCH_BY_NAME)
        );
    }
}
