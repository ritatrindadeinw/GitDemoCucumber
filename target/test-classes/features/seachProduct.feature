Feature: Search and Place the order for Products

@OffersPlace
Scenario Outline: Search Experience for product search in both Home and Offers page
Given User is on GreenCart Landing Page
When User searched with Shortname <Name> and extracted actual name of the product
Then User search for the <Name> Shortname in Offers page 
And Validate product name matches with Landing Page

Examples: 
  | Name |
  | Tom |
  | Beet |		
	
		
		
		