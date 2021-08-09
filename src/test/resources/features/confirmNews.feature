@NewsValidation @smoke @newsregression
Feature: Confirm the news is valid by Searching in Google


@confirmnews
Scenario Outline: Confirm the news is valid and not fake
Given Launch the application 
Then navigate to "News" home page
And Search for the news and confirm the news is valid
And Search for the news and confirm the <newsToSearch> is valid
Examples: 
|newsToSearch                                                            |
|Swimming Australia boss Alex Baumann quits after three months in the job| 



@Checknews @searchConfirmNews
Scenario Outline: To Confirm the news is valid
Given Launch the application 
Then navigate to "News" home page
And I confirm the news "<splitword>" by searching in google 
|<newsToSearch>|
Examples: 
|newsToSearch                                                      |splitword    |
|Swimming Australia boss Alex Baumann quits after three months in the job|   the     |