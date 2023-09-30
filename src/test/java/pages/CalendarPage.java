package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarPage extends BasePage {

    @FindBy(css = "body > div.body-wrapper > div > div.js-dod-new-events-root > div > section > div.dod_new-events__list.js-dod_new_events > a:nth-child(1) > div > div.dod_new-event__type > div > div.dod_new-type__text")
    private WebElement title;

    @FindBy(css = "body > div.body-wrapper > div > div.js-dod-new-events-root > div > section > div.dod_new-events__list.js-dod_new_events > a:nth-child(1) > div > div.dod_new-event__bottom > div.dod_new-event__time > span:nth-child(1) > span.dod_new-event__date-text")
    private WebElement startFrom;

    public CalendarPage(WebDriver driver){super(driver);}

    public String getTitle() {
        return title.getText();
    }

    public String getStartFrom() {
        return startFrom.getText();
    }
}
