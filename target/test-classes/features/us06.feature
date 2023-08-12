@us06 @db @ui @wip
Feature: Books module
  As a librarian, I should be able to add new book into library

  Scenario Outline: Verify added book is matching with DB
    Given the "librarian" on the home page
    And the user navigates to "Books" page
    When the librarian click to add book
    And the librarian enter book name "<Book Name>"
    When the librarian enter ISBN "<ISBN>"
    And the librarian enter year "<Year>"
    When the librarian enter author "<Author>"
    And the librarian choose the book category "<Book Category>"
    And the librarian click to save changes
    Then verify "The book has been created" message is displayed
    And verify "<Book Name>" information must match with DB

    Examples:
      | Book Name                                   | ISBN     | Year    | Author           | Book Category |
      | In The Land Of Mordor Where The Shadows Lie | 12345678 | 1st Age | J. R. R. Tolkien | Fantasy       |
      | One Ring To Rule Them All                   | 12345677 | 2nd Age | J. R. R. Tolkien | Fantasy       |
#      | One Ring To Find Them                       | 12345676 | 2nd Age | J. R. R. Tolkien | Action and Adventure |
#      | One Ring To Bring Them All                  | 12345675 | 3rd Age | J. R. R. Tolkien | Fantasy              |
#      | And In The Darkness Bind Them               | 12345674 | 3rd Age | J. R. R. Tolkien | Fantasy              |
#      | In The Land Of Mordor Where The Shadows Lie | 12345673 | 3rd Age | J. R. R. Tolkien | Fantasy              |