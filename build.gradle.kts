import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins {
    java
    war
    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.4"
    id("org.openapi.generator") version "7.2.0"
}

group = "aoleg.com.github"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

val globalProps = mapOf(
        "apis" to "",
        "models" to "",
        "skipFormModel" to "",
        "apiDocs" to "false",
        "modelDocs" to "false",
        "apiTests" to "false",
        "modelTest" to "false"
        // If you need to see how variables are filled in the generator, then you need to enable: "debugModels" to "true"
)

val configJavaGenOpts = mapOf(
        "dateLibrary" to "java8",
        "hideGenerationTimestamp" to "true",
        "interFaceOnly" to "true",
        "serializableModel" to "true",
        "skipDefaultInterface" to "true",
        "useTags" to "true",
        "openApiNullable" to "false",
        "additionalModelTypeAnnotations" to "\n" +
                "@lombok.AllArgsConstructor"
)

val openApiGroupName = "openapi tools"
val srcOutputDir = "${layout.buildDirectory.get().asFile}/generated/sources/"
val backModelPackage = "aoleg.com.github.manager"
val openApiDir = "$rootDir/openapi"

fun configureGenTask(task: GenerateTask, openApiSpec: String, apiPackagePostfix: String, generatorName: String = "spring") {
    task.group = openApiGroupName
    task.inputSpec.set(openApiSpec)
    task.generatorName.set(generatorName)
    task.outputDir.set(srcOutputDir)
    task.globalProperties.set(globalProps)
    when (generatorName) {
        "spring" -> {
            task.configOptions.set(configJavaGenOpts)
            task.modelPackage.set("$backModelPackage.model")
            task.modelPackage.set("$backModelPackage.$apiPackagePostfix.api")
            task.templateDir.set("$openApiDir")
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks {
    val requestOpenApiGenerate by registering(GenerateTask::class) {
        configureGenTask(this, "$openApiDir/openapi.yaml", "request")
    }

    compileJava {
        dependsOn(
                requestOpenApiGenerate
        )
    }
}
