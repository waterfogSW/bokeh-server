rootProject.name = "post"

include("post-common")
include("post-domain")
include("post-application")

// api
include(":post-api-rest")
project(":post-api-rest").projectDir = file("post-api/rest")

include(":post-api-websocket")
project(":post-api-websocket").projectDir = file("post-api/websocket")

include(":post-worker")
project(":post-worker").projectDir = file("post-api/worker")

// adapter
include(":post-adapter-mongo")
project(":post-adapter-mongo").projectDir = file("post-adapter/mongo")

include(":post-adapter-kafka")
project(":post-adapter-kafka").projectDir = file("post-adapter/kafka")

include(":post-adapter-websocket")
project(":post-adapter-websocket").projectDir = file("post-adapter/websocket")
