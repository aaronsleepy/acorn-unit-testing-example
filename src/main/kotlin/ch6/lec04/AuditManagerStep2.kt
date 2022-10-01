package ch6.lec04

import java.io.File
import java.nio.file.Path
import java.nio.file.Paths
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * 예제 6.9 생성자를 통한 파일 시스템의 명시적 주입
 * 예제 6.10 새로운 IFileSystem 인터페이스 사용
 */
class AuditManagerStep2(
    private val _maxEntriesPerFile: Int,
    private val _directoryName: String,
    private val _fileSystem: IFileSystem,
) {
    fun addRecord(visitorName: String, timeOfVisit: LocalDateTime) {
        val files = _fileSystem.getFiles(_directoryName)
        val sorted = sortByIndex(files)

        val newRecord = "${visitorName};${timeOfVisit.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"))}"

        if (sorted.isEmpty()) {
            val newFile = Paths.get(_directoryName, "audit_1.txt")
            _fileSystem.writeAllText(newFile, newRecord)
            return
        }

        val (currentFileIndex, currentFilePath) = sorted.last()
        val lines = _fileSystem.readAllLines(currentFilePath).toMutableList()

        if (lines.size < _maxEntriesPerFile) {
            lines.add(newRecord)
            val newContent = lines.joinToString("\r\n")
            _fileSystem.writeAllText(currentFilePath, newContent)
        } else {
            val newIndex = currentFileIndex + 1
            val newName = "audit_${newIndex}.txt"
            val newFile = Paths.get(_directoryName, newName)
            _fileSystem.writeAllText(newFile, newRecord)
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