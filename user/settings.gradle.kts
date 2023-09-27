rootProject.name = "user"

include("user-common")
include("user-domain")
include("user-application")

// api
include(":user-api-rest")
project(":user-api-rest").projectDir = file("user-api/rest")


// adapter
include(":user-adapter-persistence")
include(":user-adapter-redis")

project(":user-adapter-persistence").projectDir = file("user-adapter/persistence")
project(":user-adapter-redis").projectDir = file("user-adapter/redis")
