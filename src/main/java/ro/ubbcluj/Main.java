package ro.ubbcluj;


import ro.ubbcluj.Exceptions.ValidatorException;
import ro.ubbcluj.Repository.XMLFileRepository.NotaXMLRepo;
import ro.ubbcluj.Repository.XMLFileRepository.StudentXMLRepo;
import ro.ubbcluj.Repository.XMLFileRepository.TemaLabXMLRepo;
import ro.ubbcluj.Service.XMLFileService.NotaXMLService;
import ro.ubbcluj.Service.XMLFileService.StudentXMLService;
import ro.ubbcluj.Service.XMLFileService.TemaLabXMLService;
import ro.ubbcluj.UI.ui;
import ro.ubbcluj.Validator.NotaValidator;
import ro.ubbcluj.Validator.StudentValidator;
import ro.ubbcluj.Validator.TemaLabValidator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ValidatorException {
        //System.out.println("Hello World!");
        StudentValidator vs=new StudentValidator();
        TemaLabValidator vt=new TemaLabValidator();
        NotaValidator vn=new NotaValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);
        NotaXMLService ntsrv=new NotaXMLService(ntrepo);
        ui ui=new ui(stsrv,tmsrv,ntsrv);
        ui.run();
    }
}