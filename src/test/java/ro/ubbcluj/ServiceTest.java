package ro.ubbcluj;


import org.junit.Test;
import ro.ubbcluj.Domain.Student;
import ro.ubbcluj.Domain.TemaLab;
import ro.ubbcluj.Exceptions.ValidatorException;
import ro.ubbcluj.Validator.StudentValidator;
import ro.ubbcluj.Validator.TemaLabValidator;

import static org.junit.Assert.fail;

public class ServiceTest {

    @Test
    public void test_addStudent(){
        StudentValidator validator = new StudentValidator();
        Student student = new Student("1", "1", 1, "1", "1");
        try {
            validator.validate(student);
        } catch (ValidatorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test_addLabAssignment(){
        TemaLabValidator validator = new TemaLabValidator();
        TemaLab temaLab = new TemaLab(1, "1", 5, 5);
        try {
            validator.validate(temaLab);
        } catch (ValidatorException e) {
            fail(e.getMessage());
        }
    }

}
