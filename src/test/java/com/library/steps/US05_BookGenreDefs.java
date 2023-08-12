package com.library.steps;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US05_BookGenreDefs {

    @When("I execute query to find most popular book genre")
    public void i_execute_query_to_find_most_popular_book_genre() {
        String query = "select name from book_categories\n" +
                "where id = (select book_category_id from books\n" +
                "where id = (select book_id from book_borrow group by book_id order by count(*) desc limit 1))";
        DB_Util.runQuery(query);
    }
    @Then("verify {string} is the most popular book genre.")
    public void verify_is_the_most_popular_book_genre(String expectedBookGenre) {
        String actualBookGenre = DB_Util.getFirstRowFirstColumn();

        Assert.assertEquals(expectedBookGenre , actualBookGenre);

    }

}
