package ro.ubbcluj.Validator;
import ro.ubbcluj.Exceptions.ValidatorException;
public interface IValidator<E> {
    void validate(E entity) throws ValidatorException;
}