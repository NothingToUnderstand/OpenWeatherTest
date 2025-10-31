package extensions

import java.util.Properties

internal fun Properties.getPropertyOrEnv(name: String): String {
    return getProperty(name) ?: System.getenv()[name].orEmpty()
}
