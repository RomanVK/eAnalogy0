package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
                
            } catch (SQLException sql_e) {
            throw new IOException(sql_e.getMessage());
            }
        }
        
        if (answer == 4) {
            //потом
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
