# Selenium Automation Framework

This repository contains a Selenium Automation Framework for testing workflows on [Rahul Shetty Academy](https://rahulshettyacademy.com/client/).

## Overview

The framework automates the following workflows:
- Login to the website.
- Add a product to the cart.
- Verify the product is added correctly.
- Proceed to checkout with address and other details.
- Validate error messages for negative test cases.

It is designed for maintainability, scalability, and ease of integration with CI/CD pipelines.

## Features

- Selenium WebDriver with Java for browser automation.
- TestNG for test orchestration and assertions.
- Extent Reports for generating detailed test execution reports with screenshots on failures.
- Jenkins integration for continuous integration and automated execution.
- Page Object Model (POM) structure for organized and reusable code.
- Error validation and negative test handling.

## Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Extent Reports
- Maven
- Jenkins

## Project Structure

- `src/main/java`: Page Objects and utilities.
- `src/test/java`: Test classes.
- `testng.xml`: Test suite configuration.
- `reports/`: Extent Reports output.
- `pom.xml`: Maven dependency management.

## Prerequisites

- Java (JDK 17 or compatible)
- Maven
- Git
- Browser drivers (e.g., ChromeDriver)

## Setup and Execution

1. Clone the repository:
    ```
    git clone https://github.com/Divyadeep25/Selenium-Practice.git
    cd Selenium-Practice
    ```

2. Import the project into IntelliJ IDEA or Eclipse as a Maven project.

3. Configure `testng.xml` to modify or select tests as needed.

4. Execute tests using either:
    - TestNG plugin in your IDE by running `testng.xml`.
    - Maven:
      ```
      mvn clean test
      ```

5. After execution, view Extent Reports:
    - Navigate to `reports/index.html` in your browser for detailed execution reports.

## Jenkins Integration

- Create a Jenkins pipeline or freestyle job pointing to this repository.
- Use the Maven goals:
    ```
    clean test
    ```
- Configure post-build actions to archive the `reports` directory for easy access to Extent Reports after test execution.

## Contribution

Contributions for additional test cases, utilities, and optimizations are welcome. Feel free to fork the repository, create a feature branch, and submit a pull request.

## Contact

Maintained by Divyadeep. For questions or collaboration, please reach out via GitHub.

