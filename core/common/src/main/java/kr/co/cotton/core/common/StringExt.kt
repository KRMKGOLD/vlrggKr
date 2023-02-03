package kr.co.cotton.core.common

fun String.getUrl(): String = when {
    this.startsWith("//") -> "https:$this"
    this.startsWith("/") -> "https://www.vlr.gg$this"
    else -> this
}