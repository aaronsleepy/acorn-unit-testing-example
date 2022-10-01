package ch6.lec04.functional

import java.time.LocalDateTime

/**
 * 예제 6.14 함수형 코어와 가변 셀 붙이기
 */
class ApplicationService(
    private val _directoryName: String,
    private val _auditManager: AuditManager,
    private val _persister: Persister,
) {
    fun addRecord(visitorName: String, timeOfVisit: LocalDateTime) {
        val fileContents = _persister.readDirectory(_directoryName)
        val update = _auditManager.addRecord(fileContents, visitorName, timeOfVisit)

        _persister.applyUpdate(_directoryName, update)
    }
}