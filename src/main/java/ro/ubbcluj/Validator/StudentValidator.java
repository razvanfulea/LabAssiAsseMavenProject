package ro.ubbcluj.Validator;
import ro.ubbcluj.Exceptions.ValidatorException;
import ro.ubbcluj.Domain.Student;

public class StudentValidator implements IValidator<Student> {

    public void validate(Student s) throws ValidatorException {
        String errors="";
        if(s.getId() == null || s.getId().equals("")){
            //throw new ValidatorException("Id invalid\n");
            errors+="Id invalid\n";
        }
        if(s.getNume().equals("") || s.getNume()==null){
            //throw new ValidatorException("Nume invalid\n");
            errors+="Nume invalid\n";
        }
        if(s.getGrupa()<=0){
            //throw new ValidatorException("Grupa invalida\n");
            errors+="Grupa invalid\n";
        }
        if(s.getEmail().equals("") || s.getEmail()==null){
            //throw new ValidatorException("Email invalid\n");
            errors+="Email invalid\n";
        }
        if (errors.length()!=0){
            throw  new ValidatorException(errors);
        }
    }
}