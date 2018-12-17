val archivesBaseName: String by extra { "interceptor-tests" }
val artefactName: String by extra { "Logging Interceptor Tests" }
val artefactDescription: String by extra { "Logging Interceptor tests package" }

dependencies {
    testImplementation(project(":interceptor-core"))
    testImplementation(project(":apache-interceptor"))
    testImplementation(project(":okhttp-interceptor"))
    testImplementation(project(":okhttp3-interceptor"))
    testImplementation("org.apache.httpcomponents:httpclient:4.5.1")
    testImplementation("org.apache.httpcomponents:httpasyncclient:4.1.4")
    testImplementation("org.apache.httpcomponents:httpmime:4.5.6")
    testImplementation("com.squareup.okhttp3:logging-interceptor:3.9.1")
    testImplementation("com.squareup.okhttp:mockwebserver:2.7.5")
    testImplementation("org.apache.logging.log4j:log4j-core:2.11.0")
    testImplementation("pl.pragmatists:JUnitParams:1.1.1")
    testImplementation("org.assertj:assertj-core:3.11.1")
    testImplementation("junit:junit:4.12")
    testImplementation("com.dkorobtsov.logging:interceptor-core:5.0-SNAPSHOT") {
        setChanging(true)
    }
}

tasks.named<Jar>("jar") {
    manifest {
        attributes(mapOf(
                "Implementation-Title" to artefactName,
                "Implementation-Description" to artefactDescription,
                "Automatic-Module-Name" to "com.dkorobtsov.logging$archivesBaseName"
        ))
    }
}