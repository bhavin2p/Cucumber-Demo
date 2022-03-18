$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:features/Ebay_Home.feature");
formatter.feature({
  "name": "Ebay Home Page Scenarios",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Search items count",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@P2"
    },
    {
      "name": "@setcookies"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on Ebay Home Page",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.EbayHome_steps.i_am_on_Ebay_Home_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search for \u0027iPhone 11\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "steps.EbayHome_steps.i_search_for_iPhone(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate atleast 1000 search items present",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.EbayHome_steps.i_validate_atleast_search_items_present(int)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});