# Example projects that use Cucumber to do GUI and API testing

## Technology used:
- Groovy
- Cucumber-JVM
- Geb
- Selenium

## Usage

To run the tests, run the following depending on your platform.

	*nix    - ./gradlew cucumber
	Windows - gradlew.bat cucumber

Note: This will run all scenarios that have not been tagged as `@wip` (work in progress). 

To run a subset of tests, include the `--tags` parameter.
For more details about how to "AND"ing and "OR"ing Tags see https://github.com/cucumber/cucumber/wiki/Tags

	*nix    - ./gradlew cucumber -Dcucumber.options="--tags @wip"
	Windows - gradlew.bat cucumber -Dcucumber.options="--tags @wip"

## Environments

By specifying parameter: "-Denv=local", the base url for the tests is set to http://localhost:8080

    *nix    - ./gradlew cucumber -Denv=local
    Windows - gradlew.bat cucumber -Denv=local

## Reporting

Once a test run has completed the results can be viewed in the following location;

	*nix    - ./build/reports/cucumber/index.html
	Windows - .\build\reports\cucumber\index.html

## Structure of repo

The following tree describes how this project is structured and an indication of what/where files should be stored.

```
└── src
    ├── cucumber
    │   └── resources
    │       ├── env       - Runtime configuration
    │       ├── features
    │       │   └── gui   - scenario to be run against the web application only
    │       └── steps
    │           └── gui   - step definitions to implement the features
    └── test
        ├── groovy
        │   └── steps
        │       └── data
        |            └── setup
        └── resources     - Configuration for tests
```

## Technical debt

This project is on-going however there are issues that have arisen during implementation that whilst they work should be reviewed and refactored at the earliest opportunity.

- **Selectors** - Whilst this is strictly not an issue with this project and more to do with construction of the DM GUI web app. No or very little semantic id's have been used in the HTML markup, which as a result means that the selectors being used are very brittle. Refer to [DMC-56] for details.

[mm-dot]: https://bitbucket.org/metapack/mm-dot "Metapack Manager Delivery Options Thing"
[Gherkin]: https://github.com/cucumber/cucumber/wiki/Gherkin "Gherkin Domain Specific Language"
[Cucumber-JVM]: http://cukes.info/install-cucumber-jvm.html "Cucumber JVM"