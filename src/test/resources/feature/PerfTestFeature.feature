Feature: MY Performance Test

@Reg
Scenario Outline: 
Given user direct to the site
When user click on Login button
And validate login page "<Login_Page>"
And user enter a valid ID "<IR_ID>"
And user enter a password "<password>"
Then user click on login button
And validate the landing page "<DB_page _link>"
And user click on shop link
And validate the landing page "<Pro_page _link>"

Examples:
    |IR_ID   | password|
	|MY212760|testpw   |
