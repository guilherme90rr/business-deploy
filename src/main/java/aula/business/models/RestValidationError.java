package aula.business.models;

public record RestValidationError(
        Integer code,
        String field,
        String message) {
}
