Feature: WP Performance Test

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
    |IR_ID   | password|Login_Page                                                              |DB_page _link                                                       |Pro_page _link                                                           |
	|HZ846273|testpw   |https://portal.qnet.net/VirtualOffice4/onlineestore/Online_Login_VO.aspx|https://portal.qnet.net/VirtualOffice4/OnlineEStore/PopupsLoad.aspx |https://portal.qnet.net/eStore4/products.aspx?Category=5011000&type=HIGH#|
