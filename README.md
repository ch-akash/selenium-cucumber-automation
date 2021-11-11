# Selenium UI automation with Cucumber 

This package supports allure report 
## Installation

```bash
mvn clean install -DskipTests
```

## Run tests
```
mvn test -Dtest=CucumberRunner -Dcucumber.filter.tags="@browser"
```

## Reporting

intall allure and run:

```
allure serve ./selenium-cucumber-java/allure-results
```
#
### Peace,
