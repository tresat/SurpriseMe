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

To see a report of dependencies that could be upgraded to newer (stable) versions using the  [gradle-versions-plugin](https://github.com/ben-manes/gradle-versions-plugin):
```shell
    ./gradlew dependencyUpdates --no-configuration-cache
```

To run all checks and reports:
```shell
  ./gradlew checkAll --no-configuration-cache
```