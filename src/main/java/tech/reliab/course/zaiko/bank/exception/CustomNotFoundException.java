package tech.reliab.course.zaiko.bank.exception;


public class CustomNotFoundException extends GlobalAppException {

    public CustomNotFoundException(Class<?> notFoundEntityClass, Long id) {
        super(404, "Объект " + notFoundEntityClass.getSimpleName() + " с идентификатором " + id + " не найден");
    }
}