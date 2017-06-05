Feature: WP Performance Test

@Reg
Scenario Outline: 
Given user direct to the site
When user click on Login button
And user enter a valid ID "<IR_ID>"
And user enter a password "<password>"
Then user click on login button
And user click on shop link
And set Database "<round>"
Examples:
    | round|IR_ID   | password|
	|1|HZ846273|testpw   |
	|2|HZ846273|testpw   |
	|3|HZ846273|testpw   |