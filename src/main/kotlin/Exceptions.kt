import java.lang.RuntimeException

class Exceptions {

}
class ObjectNotFoundException(message: String): RuntimeException(message)

class ReasonForReportNotExist(message: String = "Причина жалобы не найдена"): RuntimeException(message)
