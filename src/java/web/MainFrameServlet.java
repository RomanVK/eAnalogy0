package web;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Set;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import logic.ManagementSystem;
import web.forms.MainFrameForm;

public class MainFrameServlet extends HttpServlet
{   
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Установка кодировки для принятия параметров
        req.setCharacterEncoding("UTF-8");
        int answer = 0;
        try {
            answer = checkAction(req);
            System.out.println("answer = " + answer);
        } catch (SQLException sql_e) {
            throw new IOException(sql_e.getMessage());
        }
              
        MainFrameForm form = new MainFrameForm();
        
        try {
            //Search
            Set ManufacturerS = ManagementSystem.getInstance().getManufacturerS();
            Set DbPoleCountEnumS = ManagementSystem.getInstance().getDbPoleCountEnumS();
            Set AutomatCharReleaseTypeS = ManagementSystem.getInstance().getAutomatCharReleaseTypeS();
            Set MaxCommutationS = ManagementSystem.getInstance().getMaxCommutationS();
            Set NominalCurrentS = ManagementSystem.getInstance().getNominalCurrentS();
            Set CurrentScaleUzoS = ManagementSystem.getInstance().getCurrentScaleUzoS();
            Set NameS = ManagementSystem.getInstance().getNameS();
            Set CodeS = ManagementSystem.getInstance().getCodeS();
                            
            form.setManufacturerS (ManufacturerS);
            form.setDbPoleCountEnumS (DbPoleCountEnumS);
            form.setAutomatCharReleaseTypeS (AutomatCharReleaseTypeS);
            form.setMaxCommutationS (MaxCommutationS);
            form.setNominalCurrentS (NominalCurrentS);
            form.setCurrentScaleUzoS (CurrentScaleUzoS);
            form.setNameS (NameS);
            form.setCodeS (CodeS);
           
        } catch (SQLException sql_e) {
            throw new IOException(sql_e.getMessage());
        }
    
        String selManufacturer = "";
        int selDbPoleCountEnum = -1;
        String selAutomatCharReleaseType = "";
        float selMaxCommutation = -1.0f;
        float selNominalCurrent = -1.0f;
        String selCurrentScaleUzo = "";
        String selName = "";
        String selCode = ""; 
        
        if (answer == 1) {
            form.setSelManufacturer (selManufacturer);
            form.setSelDbPoleCountEnum (selDbPoleCountEnum);
            form.setSelAutomatCharReleaseType (selAutomatCharReleaseType);
            form.setSelMaxCommutation (selMaxCommutation);
            form.setSelNominalCurrent (selNominalCurrent);
            form.setSelCurrentScaleUzo (selCurrentScaleUzo);
            form.setSelName (selName);
            form.setSelCode (selCode);              
        }
        
        if (answer == 2) {
            try{
            selManufacturer = req.getParameter("selManufacturer");
            
            String other = "";
            
            if(other == req.getParameter("selDbPoleCountEnum")){
                selDbPoleCountEnum = -1;
            }
            else{
                selDbPoleCountEnum = Integer.parseInt(req.getParameter("selDbPoleCountEnum"));
            }
            
            selAutomatCharReleaseType = req.getParameter("selAutomatCharReleaseType");
            
            if(other == req.getParameter("selMaxCommutation")){
                selMaxCommutation = -1.0f;
            }
            else{
                selMaxCommutation = Float.parseFloat(req.getParameter("selMaxCommutation"));                
            }
            
            if(other == req.getParameter("selNominalCurrent")){
                selNominalCurrent = -1.0f;    
            }
            else{
                selNominalCurrent = Float.parseFloat(req.getParameter("selNominalCurrent"));            
            }
            
            selCurrentScaleUzo = req.getParameter("selCurrentScaleUzo");
            selName = req.getParameter("selName");
            selCode = req.getParameter("selCode");

            form.setSelManufacturer (selManufacturer);
            form.setSelDbPoleCountEnum (selDbPoleCountEnum);
            form.setSelAutomatCharReleaseType (selAutomatCharReleaseType);
            form.setSelMaxCommutation (selMaxCommutation);
            form.setSelNominalCurrent (selNominalCurrent);
            form.setSelCurrentScaleUzo (selCurrentScaleUzo);
            form.setSelName (selName);
            form.setSelCode (selCode);

            Collection Items = ManagementSystem.getInstance().getItems (selManufacturer,
             selDbPoleCountEnum, selAutomatCharReleaseType, 
             selMaxCommutation, selNominalCurrent,
             selCurrentScaleUzo, selName, selCode);
            
            form.setItems(Items);
            } catch (SQLException sql_e) {
            throw new IOException(sql_e.getMessage());
            }             
        }

        String Name = "other";
        
        if (answer == 3) {
            try {
                Name = req.getParameter("name");
                Collection Analogs = ManagementSystem.getInstance().getAnalogs(Name);
                form.setAnalogs(Analogs);
                Collection AnalogsDB = ManagementSystem.getInstance().getAnalogsDB(Analogs);
                Cookie[] cookies = req.getCookies();
                String jsid = null;
                System.out.println("All cookies received:");
                for(int i = 0; i < cookies.length; i++){
                    System.out.println(i + " ." + cookies[i].getName()+" = " + cookies[i].getValue());
                    if("JSESSIONID".equals(cookies[i].getName())){
                        jsid = cookies[i].getValue();
                        System.out.println("JSESSIONID " + jsid + " saved");
                        break;
                    }
                }
            
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            Date date = new Date();
            ManagementSystem.getInstance().setNameFile("eAnalogy0_"+dateFormat.format(date)+".xlsx");
            
            ManagementSystem.getInstance().setPathFile(req.getServletContext().getAttribute("FILES_DIR")
                +File.separator+jsid+File.separator
                +ManagementSystem.getInstance().getNameFile());
            System.out.println("Path to generated xlsx file : "
                    + req.getServletContext().getAttribute("FILES_DIR")
                    +File.separator+jsid+File.separator
                    +ManagementSystem.getInstance().getNameFile());
            
            ManagementSystem.getInstance().setPathDir(req.getServletContext().getAttribute("FILES_DIR")+File.separator+jsid);
            File file = new File( ManagementSystem.getInstance().getPathDir());
            if(!file.exists()) file.mkdirs();
            System.out.println("File Directory for SESSION = "
                    +jsid+" ("+ManagementSystem.getInstance().getPathDir()
                    +") created to be used for storing files");
            
            ManagementSystem.getInstance().generateXls(AnalogsDB, ManagementSystem.getInstance().getPathFile());
                      
            } catch (SQLException sql_e) {
            throw new IOException(sql_e.getMessage());
            } catch (InvalidFormatException io_e){
            throw new IOException(io_e.getMessage());
            }
        }
        
        if (answer == 4) {
            try{
            File file = new File(ManagementSystem.getInstance().getPathFile());
            if(!file.exists()){
                throw new ServletException("File doesn't exists on server.");
            }
            System.out.println("File location on server::"+file.getAbsolutePath());
            ServletContext ctx = getServletContext();
            InputStream fis = new FileInputStream(file);
            String mimeType = ctx.getMimeType(file.getAbsolutePath());
            resp.setContentType(mimeType != null? mimeType:"application/octet-stream");
            resp.setContentLength((int) file.length());
            resp.setHeader("Content-Disposition", "attachment; filename=\"" +ManagementSystem.getInstance().getNameFile() + "\"");

            ServletOutputStream os = resp.getOutputStream();
            byte[] bufferData = new byte[1024];
            int read=0;
            while((read = fis.read(bufferData))!= -1){
                os.write(bufferData, 0, read);
            }
            os.flush();
            os.close();
            fis.close();
            System.out.println("File downloaded at client successfully");
            } catch (ServletException se_e){
            throw new IOException(se_e.getMessage());    
            }
        }

        req.setAttribute("form", form);
        getServletContext().getRequestDispatcher("/MainFrame.jsp").forward(req, resp);
    }

    private int checkAction(HttpServletRequest req) throws SQLException {
        if (req.getParameter("clear") != null) {
            return 1;
        }
        if (req.getParameter("getItems") != null) {
            return 2;
        }
        if (req.getParameter("getAnalogs") != null) {
            return 3;
        }
        if (req.getParameter("SaveToExcel") != null) {
            return 4;
        }
                
        return 0;
    }
     
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

}
