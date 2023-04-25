package co.com.certification.serenitydemo.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuMeetingPage extends PageObject {

    public static final Target LINK_MEETING = Target.the("meeting").located(By.xpath("//span[contains(text(),'Reunión')]"));
    public static final Target LINK_MEETINGS = Target.the("meetings").located(By.xpath("//span[contains(text(),'Reuniones')]"));

}
