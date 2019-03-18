package ro.ubbcluj.Repository.MemoryRepository;
import ro.ubbcluj.Validator.IValidator;
import ro.ubbcluj.Domain.Student;

public class StudentRepo extends AbstractCrudRepo<String, Student> {
    public StudentRepo(IValidator<Student> v){ super(v);
    }
}