package ch6.lec04

import java.io.File
import java.nio.file.Path

interface IFileSystem {
    fun getFiles(_directoryName: String): Array<File>
    fun writeAllText(newFile: Path, newRecord: String)
    fun readAllLines(currentFilePath: Path): List<String>
}