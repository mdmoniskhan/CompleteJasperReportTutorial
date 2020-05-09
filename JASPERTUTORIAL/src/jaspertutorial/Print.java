/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaspertutorial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author monis
 */
public class Print {
    public Print(String chid, Connection conn){
        
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("chid", chid);
        
        try {
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResourceAsStream("/jaspertutorial/jasperReport.jasper"));
            
            JasperPrint jp = JasperFillManager.fillReport(jasperReport, parameters, conn);
            
            JasperViewer.viewReport(jp, true);
            
            JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(new File(System.getProperty("user.home")+File.separator+"challanreport.pdf")));
        } catch (JRException ex) {
            Logger.getLogger(Print.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Print.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
