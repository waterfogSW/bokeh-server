apply(plugin = "kotlin-kapt")

dependencies {
    implementation(project(":bokeh-post-domain"))
    implementation(project(":bokeh-post-application"))
    implementation(project(":bokeh-post-framework"))
}
