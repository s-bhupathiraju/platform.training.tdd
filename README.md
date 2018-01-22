# Platform Training TDD
This is a training repository for a step wise execution of writing a pure TDD based unit tests. Code coverage is validated at the end of the unit tests to make sure all branches and lines are implicitly covered as a result of TDD process.

All subprojects shall be built from the root folder. Avoid going into the subprojects and running gradle commands in subprojects.

## Generate Jacoco Report

> Generate jacoco report by executing the check task

```gradle clean begin:check```

> Build and bootRun
```gradle clean begin:build begin:bootRun```


> Open the coverage report generated from Jacoco

```google-chrome-app begin/build/reports/jacoco/test/html/index.html```

## Use cases for endpoint
1. return a 404 when the user is not found, send some details in ErrorDetail
2. 