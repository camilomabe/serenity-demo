package co.com.certification.serenitydemo.stepsdefinitions;

import co.com.certification.serenitydemo.models.MeetingDataModel;
import co.com.certification.serenitydemo.tasks.CreatesBusinessMeeting;
import co.com.certification.serenitydemo.tasks.DeletesSchedules;
import co.com.certification.serenitydemo.utils.SessionVariables;
import co.com.certification.serenitydemo.models.datalists.GetMeetingInfo;
import co.com.certification.serenitydemo.questions.ValidatesBusinessMeeting;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.hamcrest.CoreMatchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ScheduleStepsDefinitions {
    private final GetMeetingInfo meetingInfo = new GetMeetingInfo();

    @And("^he schedules a business meeting$")
    public void scheduleAMeet(DataTable meetInfo) {
        MeetingDataModel dataMeeting = meetingInfo.setData(meetInfo).get(0);
        theActorInTheSpotlight().attemptsTo(CreatesBusinessMeeting.letsGo(dataMeeting));
    }

    @Then("^he should see the business meeting was created$")
    public void shouldSeeTheBusinessMeetingWasCreated() {
        theActorInTheSpotlight().should(seeThat(ValidatesBusinessMeeting.wasCreate(),
                CoreMatchers.equalTo(theActorInTheSpotlight().recall(SessionVariables.MEETING_NAME_VALUE.toString()))));
    }

    @And("^he should delete meeting and unit$")
    public void shouldDeleteMeetingAndUnit() {
        theActorInTheSpotlight().attemptsTo(DeletesSchedules.letsGo());
    }

}
