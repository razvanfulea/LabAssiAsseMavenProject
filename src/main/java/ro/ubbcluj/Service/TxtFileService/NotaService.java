package ro.ubbcluj.Service.TxtFileService;
import ro.ubbcluj.Domain.*;
import ro.ubbcluj.Repository.TxtFileRepository.NotaFileRepo;

public class NotaService extends AbstractService<Integer,Nota> {
    public NotaService(NotaFileRepo notaRepo){
        super(notaRepo);
    }
}
