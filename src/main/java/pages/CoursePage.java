package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoursePage extends BasePage{

    @FindBy(css="h1.sc-1og4wiw-0.sc-s2pydo-1.bojQOq.diGrSa")
    private WebElement title;

    //.course-header2__subtitle
    // .sc-1og4wiw-0.sc-s2pydo-3.jweyVs.dZDxRw
    @FindBy(css=".sc-1og4wiw-0.sc-s2pydo-3.jweyVs.dZDxRw")
    private WebElement description;

    //#__next > div.sc-1j17uuq-0.klmZDZ.sc-1b3dhyb-0.bzaXwp > main > div > section > div.sc-x072mc-0.sc-3cb1l3-1.hOtCic.galmep > div > div:nth-child(1) > p
    //.sc-x072mc-0.sc-3cb1l3-1.hOtCic.galmep .sc-3cb113-3.jeNzke .sc-3cb1l3-4.KGoYMV:first-child
    @FindBy(css="#__next > div.sc-1j17uuq-0.klmZDZ.sc-1b3dhyb-0.bzaXwp > main > div > section > div.sc-x072mc-0.sc-3cb1l3-1.hOtCic.galmep > div > div:nth-child(1) > p")
    private WebElement startFrom;

    //.sc-x072mc-0.sc-3cb1l3-1.hOtCic.galmep .sc-3cb113-3.jeNzke .sc-3cb1l3-4.KGoYMV:nth-child(2)
    @FindBy(css="#__next > div.sc-1j17uuq-0.klmZDZ.sc-1b3dhyb-0.bzaXwp > main > div > section > div.sc-x072mc-0.sc-3cb1l3-1.hOtCic.galmep > div > div:nth-child(2) > p")
    private WebElement duration;

    public CoursePage(WebDriver driver){super(driver);}

    public String getTitle() {
        return title.getText();
    }

    public String getDescription() {
        return description.getText();
    }

    public String getStartFrom() {
        return startFrom.getText();
    }

    public String getDuration() {
        return duration.getText();
    }
}

