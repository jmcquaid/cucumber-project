import static cucumber.api.groovy.Hooks.*

import steps.data.setup.TestContext

World() {
    testContext = new TestContext()
}

Before() { scenario ->
}

After() { scenario ->
}