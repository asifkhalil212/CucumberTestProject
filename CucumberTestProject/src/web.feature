Feature: web test

Scenario: User can search for a website and click a link

Given a user goes to google
And searches for TYPE
When he clicks on link
Then the pag should appear
