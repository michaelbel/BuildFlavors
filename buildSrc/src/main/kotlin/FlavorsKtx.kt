import org.gradle.api.Project

val Project.isGmsBuild: Boolean
    get() {
        val requests = gradle.startParameter.taskRequests.joinToString(" ") { it.args.joinToString(" ") }
        val regex = Regex("(assemble|bundle|install|package|publish|test|connected|device|lint|generate).+Gms", RegexOption.IGNORE_CASE)
        return regex.containsMatchIn(requests)
    }

val Project.isHmsBuild: Boolean
    get() {
        val requests = gradle.startParameter.taskRequests.joinToString(" ") { it.args.joinToString(" ") }
        val regex = Regex("(assemble|bundle|install|package|publish|test|connected|device|lint|generate).+Hms", RegexOption.IGNORE_CASE)
        return regex.containsMatchIn(requests)
    }