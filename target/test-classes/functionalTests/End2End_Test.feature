Feature: Checking the functionality of ordering the 
products from http://shop.demoqa.com

Scenario: Customer place an oder by purchasing an item from search
 Given User is on the home page 
 When he search for dress by clicking the search button
 And choose the first item among the displayed results
 And moves to checkout from mini cart icon at top right corner
 And enter the personal details on checkout page
 And place the order