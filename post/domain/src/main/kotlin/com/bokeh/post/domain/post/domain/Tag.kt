package com.bokeh.post.domain.post.domain

data class Tag(val value: String) {

    init {
        require(value.isNotBlank()) { "tag must not be blank" }
        require(value.length in 1..20) { "tag length must be between 1 and 20" }
        require(value.matches(validCharactersRegex)) { "태그는 한글,영문,숫자로 이루어 져야 합니다." }
    }

    companion object {
        val validCharactersRegex = Regex("[a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ]*")
    }
}
