package ch6.lec04

import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.time.LocalDateTime

/**
 * 예제 6.8 감사 시스템 초기 구현
 */
class AuditManagerStep1(
    private val _maxEntriesPerFile: Int,
    private val _directoryName: String
) {
    fun addRecord(visitorName: String, timeOfVisit: LocalDateTime) {
        val files = File(_directoryName).listFiles()
        val sorted = sortByIndex(files)

        val newRecord = "${visitorName};${timeOfVisit}"

        if (sorted.isEmpty()) {
            val newFile = Paths.get(_directoryName, "audit_1.txt")
            Files.writeString(newFile, newRecord)
            return
        }

        val (currentFileIndex, currentFilePath) = sorted.last()
        val lines = Files.readAllLines(currentFilePath).toMutableList()

        if (lines.size < _maxEntriesPerFile) {
            lines.add(newRecord)
            val newContent = lines.joinToString("\r\n")
            Files.writeString(currentFilePath, newContent)
        } else {
            val newIndex = currentFileIndex + 1
            val newName = "audit_${newIndex}.txt"
            val newFile = Paths.get(_directoryName, newName)
            Files.writeString(newFile, newRecord)
        }

    }

    private fun sortByIndex(files: Array<File>): List<Pair<Int, Path>> {
        return files.map { Pair(getIndex(it), it.toPath()) }
            .sortedBy { it.first }
            .toList()
    }

    private fun getIndex(file: File): Int {
        val fileName = file.nameWithoutExtension
        return fileName.split("_")[1].toInt()
    }
}