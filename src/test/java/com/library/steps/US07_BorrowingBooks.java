package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.BorrowedBooksPage;
import com.library.utility.BrowserUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US07_BorrowingBooks {

    BookPage bookPage = new BookPage();
    BorrowedBooksPage borrowedBooksPage = new BorrowedBooksPage();

    String bookName = "In The Land Of Mordor Where The Shadows Lie";

    @When("the user clicks Borrow Book")
    public void the_user_clicks_borrow_book() {
        bookPage.borrowBook(bookName);
    }
    @Then("verify that book is shown in {string} page")
    public void verify_that_book_is_shown_in_page(String module) {
        bookPage.navigateModule(module);

        List<String> elementsText = BrowserUtil.getElementsText(borrowedBooksPage.allBorrowedBooksName);

        Assert.assertTrue(elementsText.contains(bookName));


    }
    @Then("verify logged student has same book in database")
    public void verify_logged_student_has_same_book_in_database() {
        String query = "select name from books b\n" +
                "join book_borrow bb on b.id = bb.book_id\n" +
                "join users u on bb.user_id = u.id\n" +
                "where name = '"+bookName+"' and full_name = 'Test Student 5';";
    }

}
