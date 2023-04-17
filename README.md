## Kamil-demo.alpinizm.uz (Automation Test)

### What was done:

I prepared test automation for "Filters Form" and "All Listings Page"
In this repository, you will find test reports generated with Java, TestNg,
Selenium, Allure. These reports include detailed information about tests,
such as test names, description, test statuses(pass/fail) and execution time.

```bash
$ mvn clean test site
```

To open the report you can use the following command:

```bash
$ mvn io.qameta.allure:allure-maven:serve
```

### Test flow

* Main Page:https://kamil-demo.alpinizm.uz/
* User click "Search Button"
    * "Filter Button" clicked with appropriate date selected
    * "Filter Button" clicked without selecting date and warning message received
        * In filter form minimum and maximum value for bed, bedroom and bathrooms tested
        * In filter form "Clear all Button" clicked and verified the functionalities
* "All Listings button clicked and number of the items verified with "all label's number"
* Maximum guest number test commented out (Manually stopped after reaching 4000+)



### More

Enjoy...