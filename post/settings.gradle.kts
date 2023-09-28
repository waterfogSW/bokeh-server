rootProject.name = "post"

include("post-common")
include("post-domain")
include("post-application")

// api
include(":post-api-rest")
project(":post-api-rest").projectDir = file("post-api/rest")

// adapter
include(":post-adapter-mongo")
project(":post-adapter-mongo").projectDir = file("post-adapter/mongo")

include(":post-adapter-kafka")
project(":post-adapter-kafka").projectDir = file("post-adapter/kafka")
