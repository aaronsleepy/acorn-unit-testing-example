package ch6.lec04.functional

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

/**
 * 에제 6.13 AuditManager의 결정에 영향을 받는 가변 셀
 */
class Persister {
    fun readDirectory(directoryName: String): List<FileContent> {
        return File(directoryName).listFiles()
            .map { FileContent(it, Files.readAllLines(it.toPath()).toMutableList()) }
            .toList()
    }

    fun applyUpdate(directoryName: String, update: FileUpdate) {
        val newFile = Paths.get(directoryName, update.fileName)
        Files.writeString(newFile, update.newContent)
    }
}