# WrikeTest
Test case scenario:

Open url: wrike.com;
Click "Get started for free" button near "Login" button;
Fill in the email field with random generated value of email with mask “<random_text>+wpt@wriketask.qaa” (e.g. “abcdef+wpt@wriketask.qaa”);
Click on "Create my Wrike account" button + check with assertion that you are moved to the next page;
Fill in the Q&A section at the left part of page (like random generated answers) + check with assertion that your answers are submitted;
Click on "Resend email" + check it with assertion;
Check that section "Follow us" at the site footer contains the "Twitter" button that leads to the correct url and has the correct icon;
Create results report using allure plugin (by maven).

com.wrike package:
HomeWrikePage class describes user's steps at "wrike.com". Randomizer class outputs random number for the email generator.

ru.tests package:
HomeWrikePageTest tests above steps.

The main branch in the Git project is master.
