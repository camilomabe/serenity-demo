package co.com.certification.serenitydemo.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuOrganizationPage extends PageObject {

    public static final Target LINK_ORGANIZATION = Target.the("organization").located(By.xpath("//span[contains(text(),'Organización')]"));
    public static final Target LINK_BUSINESS_UNITS = Target.the("business units").located(By.xpath("//span[contains(text(),'Unidades de negocio')]"));

}
