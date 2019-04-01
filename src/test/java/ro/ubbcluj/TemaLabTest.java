package ro.ubbcluj;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ro.ubbcluj.Domain.TemaLab;
import ro.ubbcluj.Exceptions.ValidatorException;
import ro.ubbcluj.Repository.XMLFileRepository.TemaLabXMLRepo;
import ro.ubbcluj.Validator.TemaLabValidator;

import static org.junit.Assert.fail;

public class TemaLabTest {
    private static final int NR_OK = 1;
    private static final String OK = "OK";

    private String temaLabFilename = "TemaLabXML.xml";
    private TemaLabValidator temaLabValidator;
    private TemaLabXMLRepo temaLabRepo;
    private TemaLab temaLab;

    @Before
    public void setUp(){
        temaLabValidator = new TemaLabValidator();
        temaLabRepo = new TemaLabXMLRepo(temaLabValidator, temaLabFilename);
        temaLab = new TemaLab(NR_OK, OK, NR_OK, NR_OK);
    }

    @After
    public void tearDown(){
        temaLabRepo = null;
        temaLabValidator = null;
        temaLab = null;
    }

    @Test
    public void test_temaLabValidatorInvalid(){
        temaLab.setId(null);
        try {
            temaLabValidator.validate(temaLab);
            fail("ID -1 should throw exception");
        } catch (ValidatorException e) {
            assert true;
        }

        temaLab.setId(NR_OK);
        temaLab.setDescriere(null);

        try {
            temaLabValidator.validate(temaLab);
            fail("Null Descriere should throw exception");
        } catch (ValidatorException e) {
            assert true;
        }
        
        temaLab.setDescriere(OK);
        temaLab.setSaptammanaPredarii(-1);

        try {
            temaLabValidator.validate(temaLab);
            fail("Saptamana predarii -1 should throw exception");
        } catch (ValidatorException e) {
            assert true;
        }
        
        temaLab.setSaptammanaPredarii(NR_OK);
        temaLab.setTermenLimita(16);

        try {
            temaLabValidator.validate(temaLab);
            fail("Termen limita 16 should throw exception");
        } catch (ValidatorException e) {
            assert true;
        }
    }

    @Test
    public void test_temaLabValidatorValid(){
        try{
            temaLabValidator.validate(temaLab);
            assert true;
        } catch (ValidatorException e){
            fail(e.getMessage());
        }
    }

}
