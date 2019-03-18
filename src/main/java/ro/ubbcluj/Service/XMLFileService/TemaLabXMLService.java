package ro.ubbcluj.Service.XMLFileService;

import ro.ubbcluj.Domain.TemaLab;
import ro.ubbcluj.Exceptions.ValidatorException;
import ro.ubbcluj.Repository.XMLFileRepository.TemaLabXMLRepo;

public class TemaLabXMLService extends AbstractXMLService<Integer,TemaLab>{
    private TemaLabXMLRepo xmlrepo;

    public TemaLabXMLService(TemaLabXMLRepo xmlrepo)  {
        super(xmlrepo);
    }

    public void prelungireTemaLab(String nr,String descr,String sl,String sp,int sc) throws ValidatorException {
        if(sc<=Integer.parseInt(sp)){
            String sln=Integer.toString(Integer.parseInt(sl)+1) ;
            String[] params={nr,descr,sln,sp};
            update(params);
        }

    }
    @Override
    protected TemaLab extractEntity(String[] params){
        int nr = 0;
        int termenLimita = 0;
        int saptamanaPredarii = 0;
        try{
            nr = Integer.parseInt(params[0]);
            termenLimita = Integer.parseInt(params[2]);
            saptamanaPredarii = Integer.parseInt(params[3]);
        } catch (NumberFormatException e){
            System.out.println(e.toString());
        }

        return new TemaLab(nr,params[1],termenLimita,saptamanaPredarii);
    }

}