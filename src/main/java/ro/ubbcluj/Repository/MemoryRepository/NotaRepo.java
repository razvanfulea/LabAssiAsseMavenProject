package ro.ubbcluj.Repository.MemoryRepository;
import ro.ubbcluj.Validator.IValidator;
import ro.ubbcluj.Domain.Nota;

public class NotaRepo extends AbstractCrudRepo<Integer,Nota > {
    public NotaRepo(IValidator<Nota> v){ super(v);
    }
}