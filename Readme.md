# Hotel Booking

I've created below two tests:
- Create a week long hotel booking from the first saturday of the next month 
  I have picked up first Saturday of the next month to ensure the test will not require date changes as time passes by.
- Delete first hotel booking on the booking page
  Since the site is a test site and while development, I noticed records were being created/deleted by others, I have implemented the deletion of the first record it finds to ensure the delete functionality is working.

### Prerequisites
- Language - Java 1.8
- Automation Tool - Selenium Webdriver 3.4.0
- Test Framework - Junit 4.12
- Build Tool - Maven
- IDE - IntelliJ

### Tested on below browsers 

#### Mac
- FF - 65
- Chrome - 72

#### Windows
- FF - 65
- Chrome - 72


At present CommonConstants file contains "chrome" driver so it'll run the tests on chrome. If you want to
run the tests on FF, change the browser value to "firefox".

### Execution Steps

- Clone the repository or download project as a zip file. Navigate to the folder EETest.

Through command line, use maven commands ( mvn site with generate the surefire report EEtest/target/site/surefire-report.html)

```
mvn site

```
OR you could also just use

```
mvn test

```
