package ro.ubbcluj;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ro.ubbcluj.Domain.Student;
import ro.ubbcluj.Domain.TemaLab;
import ro.ubbcluj.Exceptions.ValidatorException;
import ro.ubbcluj.Repository.XMLFileRepository.StudentXMLRepo;
import ro.ubbcluj.Validator.StudentValidator;
import ro.ubbcluj.Validator.TemaLabValidator;

import static org.junit.Assert.fail;

public class ServiceTest {
    private static final String EMPTY = "";
    private static final String NULL = null;
    private static final String OK = "OK";
    private static final int GRUPA = 1;

    String filename = "TestStudentiXML.xml";
    StudentValidator studentValidator;
    StudentXMLRepo studentRepo;
    Student student;

    @Before
    public void setUp(){
        studentValidator = new StudentValidator();
        studentRepo = new StudentXMLRepo(studentValidator, filename);
        student = new Student(OK, OK, GRUPA, OK, OK);
    }

    @After
    public void tearDown(){
        studentRepo = null;
        studentValidator = null;
        student = null;
    }

    @Test(expected = ValidatorException.class)
    public void test_addStudentIdEmpty() throws ValidatorException {
        student.setId(EMPTY);
        studentRepo.save(student);
    }

    @Test(expected = ValidatorException.class)
    public void test_addStudentIdNull() throws ValidatorException {
        student.setId(NULL);
        studentRepo.save(student);
    }

    @Test
    public void test_addStudentIdOk(){
        try {
            studentRepo.save(student);
            assert true;
        } catch (ValidatorException e) {
            fail(e.getMessage());
        }
    }

    @Test(expected = ValidatorException.class)
    public void test_addStudentNumeEmpty() throws ValidatorException {
        student.setNume(EMPTY);
        studentRepo.save(student);
    }

    @Test(expected = ValidatorException.class)
    public void test_addStudentNumeNull() throws ValidatorException {
        student.setNume(NULL);
        studentRepo.save(student);
    }

    @Test
    public void test_addStudentNumeOk(){
        try {
            studentRepo.save(student);
            assert true;
        } catch (ValidatorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test_addStudentGrupaInvalid(){
        student.setGrupa(0);
        try {
            studentRepo.save(student);
            fail("Grupa 0 should not be valid!");
        } catch (ValidatorException e) {
            assert true;
        }

        student.setGrupa(Integer.MAX_VALUE + 1);
        try {
            studentRepo.save(student);
            fail("Grupa MAXINT+1 should not be valid!");
        } catch (ValidatorException e) {
            assert true;
        }
    }

    @Test
    public void test_addStudentGrupaValid(){
        try {
            studentRepo.save(student);
            assert true;
        } catch (ValidatorException e) {
            fail(e.getMessage());
        }

        student.setGrupa(2);
        try {
            studentRepo.save(student);
            assert true;
        } catch (ValidatorException e) {
            fail(e.getMessage());
        }

        student.setGrupa(Integer.MAX_VALUE);
        try {
            studentRepo.save(student);
            assert true;
        } catch (ValidatorException e) {
            fail(e.getMessage());
        }

        student.setGrupa(Integer.MAX_VALUE - 1);
        try {
            studentRepo.save(student);
            assert true;
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_addStudentEmailEmpty(){

    }

    @Test
    public void test_addStudentEmailNull(){

    }

    @Test
    public void test_addStudentEmailOk(){

    }

    @Test
    public void test_addStudentIndrumatorEmpty(){

    }

    @Test
    public void test_addStudentIndrumatorNull(){

    }

    @Test
    public void test_addStudentIndrumatorOk(){

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
