package ch6.lec04.functional

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * 예제 6.12 리팩터링 후의 AuditManager
 */
class AuditManager(
    private val _maxEntriesPerFile: Int,
) {
    fun addRecord(fileContents: List<FileContent>, visitorName: String, timeOfVisit: LocalDateTime): FileUpdate {
        val sorted = sortByIndex(fileContents)

        val newRecord = "${visitorName};${timeOfVisit.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"))}"

        if (sorted.isEmpty()) {
            return FileUpdate("audit_1.txt", newRecord)
        }

        val (currentFileIndex, currentFileContent) = sorted.last()
        val lines = currentFileContent.lines

        if (lines.size < _maxEntriesPerFile) {
            lines.add(newRecord)
            val newContent = lines.joinToString("\r\n")
            return FileUpdate(currentFileContent.file.name, newContent)
        } else {
            val newIndex = currentFileIndex + 1
            val newName = "audit_${newIndex}.txt"
            return FileUpdate(newName, newRecord)
        }

    }

    private fun sortByIndex(fileContents: List<FileContent>): List<Pair<Int, FileContent>> {
        return fileContents.map { Pair(getIndex(it), it) }
            .sortedBy { it.first }
            .toList()
    }

    private fun getIndex(fileContent: FileContent): Int {
        val fileName = fileContent.file.nameWithoutExtension
        return fileName.split("_")[1].toInt()
    }
}