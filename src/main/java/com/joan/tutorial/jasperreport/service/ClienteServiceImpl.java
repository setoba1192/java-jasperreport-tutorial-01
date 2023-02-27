package com.joan.tutorial.jasperreport.service;

import com.joan.tutorial.jasperreport.dto.SimpleDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {


    @Override
    public byte[] generarReporte(List<SimpleDTO> lista) {
        JasperPrint empReport =
                null;
        try {
            empReport = JasperFillManager.fillReport
                    (ResourceUtils.getFile("classpath:reports/simple-report.jasper").getAbsolutePath()
                            , null
                            , new JRBeanCollectionDataSource(lista)
                    );
        } catch (JRException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //HttpHeaders headers = new HttpHeaders();
        //set the PDF format
        //headers.setContentType(MediaType.APPLICATION_PDF);
        //headers.setContentDispositionFormData("filename", "employees-details.pdf");
        //create the report in PDF format
        try {
            return JasperExportManager.exportReportToPdf(empReport);
        } catch (JRException e) {
            e.printStackTrace();
        }
        return null;
    }
}
