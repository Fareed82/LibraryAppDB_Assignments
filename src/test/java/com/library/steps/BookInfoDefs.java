package com.library.steps;

import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class BookInfoDefs {

    BookPage bookPage = new BookPage();

    String bookName;

    @When("the user searches for {string} book")
    public void the_user_searches_for_book(String bookName) {
        this.bookName = bookName;
        bookPage.search.sendKeys(bookName);
    }
    @When("the user clicks edit book button")
    public void the_user_clicks_edit_book_button() {
        bookPage.editBook(bookName).click();
    }
    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {
        String query = "select * from books where name = 'Afzals Legacy'";
        DB_Util.runQuery(query);

        Map<String, String> rowMap = DB_Util.getRowMap(1);

        String DB_name = rowMap.get("name");
        String DB_isbn = rowMap.get("isbn");
        String DB_year = rowMap.get("year");
        String DB_author = rowMap.get("author");

        String UI_name = bookPage.getBookInfo("Book Name");
        String UI_isbn = bookPage.getBookInfo("ISBN");
        String UI_year = bookPage.getBookInfo("Year");
        String UI_author = bookPage.getBookInfo("Author");

        Assert.assertEquals(DB_name , UI_name);
        Assert.assertEquals(DB_isbn, UI_isbn);
        Assert.assertEquals(DB_year, UI_year);
        Assert.assertEquals(DB_author, UI_author);



    }


}
