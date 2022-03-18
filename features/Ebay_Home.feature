Feature: Ebay Home Page Scenarios

  @P1
  Scenario: Advanced Search Link
    Given I am on Ebay Home Page
    When I click on Advanced Search Link
    Then I navigate to Advanced Search Page

  @P2 @setcookies @test
  Scenario: Search items count
    Given I am on Ebay Home Page
    When I search for 'iPhone 11'
    Then I validate atleast 1000 search items present

  @P24 @setcookies @test
  Scenario: Search items count2
    Given I am on Ebay Home Page
    When I search for 'Toy Cars'
    Then I validate atleast 100 search items present

  @P240 @setcookies
  Scenario: Search an item in category
    Given I am on Ebay Home Page
    When I search for 'soap' in 'baby' category

  @P500
  Scenario Outline: Home page links
    Given I am on Ebay Home Page
    When I click on '<links>'
    Then I validate that page navigates to '<url>' and title contains '<title>'

    Examples: 
      | link        | url                                              | title       |
      | Electronics | https://www.ebay.com/b/Electronics/bn_7000259124 | Electronics |
      | Fashion     | https://www.ebay.com/b/Fashion/bn_7000259856     | Fashion     |
