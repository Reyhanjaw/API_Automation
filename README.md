# API Automation Testing Framework

## 1. Project Overview

This project is an API automation testing framework developed to validate API endpoints, response status codes, response data, and authentication behavior.

The framework uses Java, Gradle, JUnit, Rest Assured, and org.json to execute automated API tests and validate API responses.

## 2. Technologies and Libraries

- **Java** — Programming language used to develop automated tests.
- **Gradle** — Build automation and dependency management.
- **JUnit** — Test execution and assertions.
- **Rest Assured** — Sending HTTP requests and validating API responses.
- **org.json** — Parsing and handling JSON data.

## 3. Project Structure

The project follows a standard Gradle project structure.

```text
api-automation/
├── gradle/
│   └── wrapper/
├── src/
│   └── test/
│       └── java/
│           └── [API test classes]
├── .gitignore
├── build.gradle
├── gradlew
├── gradlew.bat
├── settings.gradle
└── README.md
```

The test class names and package structure should match the actual implementation in the repository.

## 4. Test Scenarios

The API automation suite covers the following scenarios:

1. Login with valid credentials.
2. Login with invalid credentials.
3. Logout with valid authentication.
4. Retrieve the current user's information.
5. Retrieve all students with valid authentication.
6. Retrieve all students without an authentication token.
7. Retrieve a student by ID, using an ID obtained from the student list response.

These scenarios cover positive testing, negative testing, authentication validation, and data retrieval.

## 5. Test Execution

### Prerequisites

- A compatible Java Development Kit (JDK).
- Gradle Wrapper included in the repository.
- Network access to the target API.
- Valid test data or credentials where required by the API.

### Run the automated tests

On Windows, open a terminal in the project root and run:

```powershell
.\gradlew.bat clean test
```

On Linux or macOS, run:

```bash
./gradlew clean test
```

The command cleans previous build outputs and executes the Gradle test task.

## 6. Test Reports

Gradle generates an HTML test report at:

`build/reports/tests/test/index.html`

After the test execution finishes, open this file in a browser to review the test results, including passed tests, failed tests, and execution details.

## 7. Test Data and Security

- Use test accounts and test data intended for the target API.
- Do not commit passwords, access tokens, or other sensitive credentials to the repository.
- Use environment variables or an appropriate local configuration for secrets when required.

## 8. Project Status

The framework is designed to automate API authentication and student data retrieval scenarios.

The latest test execution results should be verified through the Gradle test report before reporting the overall test status.