import org.gradle.api.Project

val Project.isGmsBuild: Boolean
    get() {
        val requests = gradle.startParameter.taskRequests.toString()
        val regex = "assemble(.+)Gms(.+)".toRegex()
        return regex.containsMatchIn(requests)
    }

val Project.isHmsBuild: Boolean
    get() {
        val requests = gradle.startParameter.taskRequests.toString()
        val regex = "assemble(.+)Hms(.+)".toRegex()
        return regex.containsMatchIn(requests)
    }