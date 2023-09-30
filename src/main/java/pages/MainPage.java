package pages;

import components.CourseCard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;


public class MainPage extends BasePage {

    @FindBy(css=".sc-gg1znw-0 > div")
    private List<WebElement> courses;
    private List<CourseCard> cards = new ArrayList<>();

    @FindBy(css=".sc-pzx9cw-0")
    private WebElement menu;

    @FindBy(css="#__next > div.sc-1j17uuq-0.klmZDZ > main > section.sc-1hmcglv-0.sc-17j7rzz-0.chEWCa.haXPXW > a:nth-child(1) > div.sc-1rxoy3m-1.iWgyfi")
    //href="https://otus.ru/events"
    //a[href="/events"=]. sc-1rxoy3m-0
    private WebElement calendar;


    public MainPage(WebDriver driver) {
        super(driver);
        for(WebElement element : courses) {
            cards.add( new CourseCard( element ) );
        }
        url = "http://otus.ru";
    }

    public CatalogPage menuClick(int el){
        ++el; //локатор "Программирование" child(2)

        menu.findElement( By.cssSelector(".sc-yfk21i-0:nth-child("+el+")") ).click();

        new WebDriverWait( driver, Duration.ofSeconds( 5 ) ).until( ExpectedConditions.urlContains( "catalog/" ) );

        return new CatalogPage( driver );

    }

    public CalendarPage CalendarPageClick(){
        calendar.click();
        new WebDriverWait( driver, Duration.ofSeconds( 1 ) ).until( ExpectedConditions.urlContains( "events/" ) );
        return new CalendarPage(driver);
    }


    public List<CourseCard> getCards(){
        return cards;
    }


}
