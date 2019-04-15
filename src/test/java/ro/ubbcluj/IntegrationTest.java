package ro.ubbcluj;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ro.ubbcluj.Domain.Nota;
import ro.ubbcluj.Domain.Student;
import ro.ubbcluj.Domain.TemaLab;
import ro.ubbcluj.Exceptions.ValidatorException;
import ro.ubbcluj.Repository.MemoryRepository.NotaRepo;
import ro.ubbcluj.Repository.MemoryRepository.StudentRepo;
import ro.ubbcluj.Repository.MemoryRepository.TemaLabRepo;
import ro.ubbcluj.Validator.NotaValidator;
import ro.ubbcluj.Validator.StudentValidator;
import ro.ubbcluj.Validator.TemaLabValidator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static junit.framework.TestCase.fail;

public class IntegrationTest {
    private StudentValidator studentValidator;
    private StudentRepo studentRepo;
    private Student student;

    private TemaLabValidator temaLabValidator;
    private TemaLabRepo temaLabRepo;
    private TemaLab temaLab;

    private NotaValidator notaValidator;
    private NotaRepo notaRepo;
    private Nota nota;

    @Before
    public void setUp(){
        studentValidator = new StudentValidator();
        studentRepo = new StudentRepo(studentValidator);
        student = new Student("1", "ion", 936, "ion@ion", "gheorghe");

        temaLabValidator = new TemaLabValidator();
        temaLabRepo = new TemaLabRepo(temaLabValidator);
        temaLab = new TemaLab(1, "tema1", 2, 3);

        notaValidator = new NotaValidator();
        notaRepo = new NotaRepo(notaValidator);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime ldt = LocalDateTime.parse("2019-01-01 00:00", formatter);
        nota = new Nota(1, "1", 1, 9.5, ldt);
    }

    @After
    public void tearDown(){
        studentValidator = null;
        studentRepo = null;
        student = null;

        temaLabValidator = null;
        temaLabRepo = null;
        temaLab = null;

        notaValidator = null;
        notaRepo = null;
        nota = null;
    }

    @Test
    public void test_addStudent(){
        try {
            studentRepo.save(student);
        } catch (ValidatorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test_addAssignment(){
        try {
            temaLabRepo.save(temaLab);
        } catch (ValidatorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test_addGrade(){
        try {
            notaRepo.save(nota);
        } catch (ValidatorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test_integrationAddAssignment(){
        try {
            studentRepo.save(student);
            temaLabRepo.save(temaLab);
        } catch (ValidatorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test_integrationAddGrade(){
        try {
            studentRepo.save(student);
            temaLabRepo.save(temaLab);
            notaRepo.save(nota);
        } catch (ValidatorException e) {
            fail(e.getMessage());
        }
    }

}
