package pages;

import components.CourseCard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage {

    @FindBy(css=".sc-gg1znw-0 > div")
    private List<WebElement> courses;
    private List<CourseCard> cards = new ArrayList<>();

    @FindBy(css=".sc-pzx9cw-0")
    private WebElement menu;

    public MainPage(WebDriver driver) {
        super(driver);
        for(WebElement element : courses) {
            cards.add( new CourseCard( element ) );
           // System.out.println("Карточка: " +element +"\n");
        }
        url = "http://otus.ru";
    }

    public CatalogPage menuClick(String el){
        menu.findElement( new By.ByLinkText(el) ).click();
        return new CatalogPage( driver );
    }

    public List<CourseCard> getCards(){
        return cards;
    }


}
