package co.com.certification.serenitydemo.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuBarPage extends PageObject {

    public static final Target AVATARS_USER = Target.the("avatar's user").located(By.xpath("//i[@class='s-sidebar-band-icon fa fa-user']"));
    public static final Target LABEL_USER = Target.the("user").located(By.xpath("(//p[@class='s-user-info fs-6 mb-1'])[1]"));

}