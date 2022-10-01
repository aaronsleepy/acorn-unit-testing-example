package ch6.lec04.functional

import java.io.File

data class FileContent(
    val file: File,
    val lines: MutableList<String>,
)
