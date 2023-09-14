package pages;

import components.CourseCard;
import components.NewCourseCard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class CatalogPage extends BasePage {

    @FindBy(css = ".sc-mrx253-0")
    WebElement buttonMore;

    ArrayList<NewCourseCard> cards;
    @FindBy(css = ".sc-18q05a6-1 .sc-zzdkm7-0")
    ArrayList<WebElement> courses;

    public CatalogPage(WebDriver driver) {
        super( driver );

        for (WebElement element : courses) {
            cards.add( new NewCourseCard( element ) );
        }
    }
    public ArrayList<NewCourseCard> GetCard(){
            return cards;
    }


}//CatalogPage
