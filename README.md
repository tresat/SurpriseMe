# SurpriseMe

## Building

To build and test the complete project, use:
```shell
    ./gradlew 
```
This will automatically run tests which require internet access if it is available.

## Running

TBD

## Testing

To run unit tests for only the modules that changed (and dependent modules) during the last commit using the [affected-module-detector](https://github.com/dropbox/AffectedModuleDetector) plugin:
```shell
    ./gradlew runAffectedUnitTests --no-configuration-cache
```

## Maintenance Tasks

All reports will generate in the `build/reports` directory.

To see a report of dependencies that could be upgraded to newer (stable) versions using the [gradle-versions-plugin](https://github.com/ben-manes/gradle-versions-plugin):
```shell
    ./gradlew dependencyUpdates --no-configuration-cache
```

To see a report of dependencies that are potentially misconfigured using the [gradle-analysis-plugin](https://github.com/autonomousapps/dependency-analysis-gradle-plugin):
```shell
    ./gradlew buildHealth --no-configuration-cache
```

To see a report of module dependencies (that is incomplete due to lacking KMP SourceSets) using the [module-dependency-graph](https://github.com/savvasdalkitsis/module-dependency-graph) plugin:
```shell
    ./gradlew graphModules --no-configuration-cache
```

To run all checks and reports:
```shell
  ./gradlew checkAll --no-configuration-cache
```