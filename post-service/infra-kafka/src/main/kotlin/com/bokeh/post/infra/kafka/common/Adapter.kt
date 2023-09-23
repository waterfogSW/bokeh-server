package com.bokeh.user.framework.common.annotation

import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Component

/**
 * Annotates a class as a persistence adapter.
 *
 * The persistence adapter is responsible for handling the persistence logic of the application, such as
 * storing and retrieving data from a database or any other persistent storage.
 *
 * By using this annotation, the annotated class will be marked as a Spring component and can be auto-detected
 * by the Spring framework for dependency injection and component scanning.
 *
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Component
annotation class Adapter(

    @get:AliasFor(annotation = Component::class)
    val value: String = ""
)
