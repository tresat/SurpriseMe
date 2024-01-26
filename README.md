# SurpriseMe

## Building

To build and test the complete project, use:
```shell
    ./gradlew 
```
This will automatically run tests which require internet access if it is available.

## Running

TBD

## Maintenance Tasks

All reports will generate in the `build/reports` directory.

To see a report of dependencies that could be upgraded to newer (stable) versions using the  [gradle-versions-plugin](https://github.com/ben-manes/gradle-versions-plugin):
```shell
    ./gradlew dependencyUpdates --no-configuration-cache
```

To see a report of dependencies that are potentially misconfigured the  [gradle-analysis-plugin](https://github.com/autonomousapps/dependency-analysis-gradle-plugin):
```shell
    ./gradlew buildHealth --no-configuration-cache
```

To run all checks and reports:
```shell
  ./gradlew checkAll --no-configuration-cache
```