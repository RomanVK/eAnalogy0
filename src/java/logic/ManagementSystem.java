package logic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.LinkedHashSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ManagementSystem
{
    private static Connection con;
    private static ManagementSystem instance;
    private static DataSource dataSource;
    private static ArrayList Catalogs;
    
    private static String nameFile;
    private static String pathFile;
    private static String pathDir;

    private ManagementSystem() {
    }

    public static synchronized ManagementSystem getInstance() {
        if (instance == null) {
            try {
                instance = new ManagementSystem();
                Context ctx = new InitialContext();
                instance.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/DS");
                con = dataSource.getConnection();
                Catalogs = getCatalogs();
            } catch (NamingException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
    
    public static ArrayList getCatalogs() throws SQLException{
        ArrayList Catalogs = new ArrayList();
        DatabaseMetaData dbmd = con.getMetaData();
        ResultSet rs = dbmd.getCatalogs();
        System.out.println("All catalogs of DB:");
        
        while (rs.next()) {
            Catalogs.add(rs.getString(1));
            System.out.println(rs.getString(1));
        }
        System.out.println("Quantity catalogs of DB = "+Catalogs.size());//
        System.out.println("Removing system catalogs DB:");//
        for(int i=0; i<=3; i++){
            System.out.println("remove -> "+Catalogs.get(0).toString());
            Catalogs.remove(0);
        }//
        System.out.println("Catalogs after remove:");//
        for(Object o:Catalogs){
          System.out.println(o.toString());
        }//
        return Catalogs;
    }
    
    // ! все геттеры передают набор стрингов. может где то понадобиться перевести в примитивы 17-04-2019
    
    public Set getManufacturerS() throws SQLException{
        
        Set <String> ManufacturerS = new LinkedHashSet<String>();
        ManufacturerS.add("");
        
        Statement stmt = con.createStatement();

        for(Object o:this.Catalogs){
            String sql = "USE " + o.toString();
            ResultSet rs = stmt.executeQuery(sql + " SELECT Manufacturer "
                +"FROM dbo.ElAutomat ");
            while (rs.next()) {
                String st = rs.getString(1);
                ManufacturerS.add(st);
            }
            rs.close();            
        }        
        stmt.close();

        return ManufacturerS;
    }

    public Set getDbPoleCountEnumS() throws SQLException{
        
        Set<String> DbPoleCountEnumS = new LinkedHashSet<String>();
        DbPoleCountEnumS.add("");
        
        Statement stmt = con.createStatement();
        for(Object o:this.Catalogs){
            String sql = "USE " + o.toString();
            ResultSet rs = stmt.executeQuery(sql + " SELECT DbPoleCountEnum "
                +"FROM dbo.ElAutomat ");
            while (rs.next()) {
                String st = rs.getString(1);
                DbPoleCountEnumS.add(st);
            }
            rs.close();            
        }
        stmt.close();
        
        return DbPoleCountEnumS;
    }    

    public Set getAutomatCharReleaseTypeS() throws SQLException{
        
        Set<String> AutomatCharReleaseTypeS = new LinkedHashSet<String>();
        AutomatCharReleaseTypeS.add("");
        
        Statement stmt = con.createStatement();
        for(Object o:this.Catalogs){
            String sql = "USE " + o.toString();
            ResultSet rs = stmt.executeQuery(sql + " SELECT AutomatCharReleaseType "
                +"FROM dbo.ElAutomat ");
            while (rs.next()) {
                String st = rs.getString(1);
                AutomatCharReleaseTypeS.add(st);
            }
            rs.close();            
        }
        stmt.close();
        
        return AutomatCharReleaseTypeS;
    }        

    public Set getMaxCommutationS() throws SQLException{
        
        Set<String> MaxCommutationS = new LinkedHashSet<String>();
        MaxCommutationS.add("");
        
        Statement stmt = con.createStatement();
        for(Object o:this.Catalogs){
            String sql = "USE " + o.toString();
            ResultSet rs = stmt.executeQuery(sql + " SELECT MaxCommutation "
                +"FROM dbo.ElAutomat ");
            while (rs.next()) {
                String st = rs.getString(1);
                MaxCommutationS.add(st);
            }
            rs.close();            
        }
        stmt.close();
        
        return MaxCommutationS;
    }    

    public Set getNominalCurrentS() throws SQLException{
        
        Set<String> NominalCurrentS = new LinkedHashSet<String>();
        NominalCurrentS.add("");
        
        Statement stmt = con.createStatement();
        for(Object o:this.Catalogs){
            String sql = "USE " + o.toString();
            ResultSet rs = stmt.executeQuery(sql + " SELECT NominalCurrent "
                +"FROM dbo.ElAutomat ");
            while (rs.next()) {
                String st = rs.getString(1);
                NominalCurrentS.add(st);
            }
            rs.close();            
        }
        stmt.close();
        
        return NominalCurrentS;
    }
    
    public Set getCurrentScaleUzoS() throws SQLException{
        
        Set<String> CurrentScaleUzoS = new LinkedHashSet<String>();
        CurrentScaleUzoS.add("");
        
        Statement stmt = con.createStatement();
        for(Object o:this.Catalogs){
            String sql = "USE " + o.toString();
            ResultSet rs = stmt.executeQuery(sql + " SELECT CurrentScaleUzo "
                +"FROM dbo.ElAutomat ");
            while (rs.next()) {
                String st = rs.getString(1);
                CurrentScaleUzoS.add(st);
            }
            rs.close();            
        }
        stmt.close();
        return CurrentScaleUzoS;
    } 

    public Set getNameS() throws SQLException{
        
        Set<String> NameS = new LinkedHashSet<String>();
        NameS.add("");
        
        Statement stmt = con.createStatement();
        for(Object o:this.Catalogs){
            String sql = "USE " + o.toString();
            ResultSet rs = stmt.executeQuery(sql + " SELECT Name "
                +"FROM dbo.ElAutomat ");
            while (rs.next()) {
                String st = rs.getString(1);
                NameS.add(st);
            }
            rs.close();            
        }
        stmt.close();
        return NameS;
    }
    
    public Set getCodeS() throws SQLException{
        
        Set<String> CodeS = new LinkedHashSet<String>();
        CodeS.add("");
        
        Statement stmt = con.createStatement();
        for(Object o:this.Catalogs){
            String sql = "USE " + o.toString();
            ResultSet rs = stmt.executeQuery(sql + " SELECT Code "
                +"FROM dbo.ElAutomat ");
            while (rs.next()) {
                String st = rs.getString(1);
                CodeS.add(st);
            }
            rs.close();            
        }
        stmt.close();
        return CodeS;
    }        

    public Collection getItems(String selManufacturer,
            int selDbPoleCountEnum, String selAutomatCharReleaseType, 
            float selMaxCommutation, float selNominalCurrent,
            String selCurrentScaleUzo, String selName, String selCode)throws SQLException{
               
        Collection Items = new ArrayList();
        ArrayList Concat = new ArrayList();
        ArrayList Parameters = new ArrayList();
        
        if(selManufacturer != ""){
            Concat.add("Manufacturer LIKE ? ");
            Parameters.add("Manufacturer");
        }
        if(selDbPoleCountEnum != -1){
            Concat.add("DbPoleCountEnum LIKE ? ");
            Parameters.add("DbPoleCountEnum");
        }
        if(selAutomatCharReleaseType != ""){
            Concat.add("AutomatCharReleaseType LIKE ? ");
            Parameters.add("AutomatCharReleaseType");
        }
        if(selMaxCommutation != -1.0f){
            Concat.add("MaxCommutation LIKE ? ");
            Parameters.add("MaxCommutation");
        }
        if(selNominalCurrent != -1.0f){
            Concat.add("NominalCurrent LIKE ? ");
            Parameters.add("NominalCurrent");
        }
        if(selCurrentScaleUzo != ""){
            Concat.add("CurrentScaleUzo LIKE ? ");
            Parameters.add("CurrentScaleUzo");
        }
        if(selName != ""){
            Concat.add("Name LIKE ?");
            Parameters.add("Name");
        }
        if(selCode != ""){
            Concat.add("Code LIKE ?");
            Parameters.add("Code");           
        }
        
        String sql = " SELECT Manufacturer, "
                +"DbPoleCountEnum, AutomatCharReleaseType, MaxCommutation, NominalCurrent, CurrentScaleUzo, Name, Code "
                +"FROM dbo.ElAutomat ";
        
        if(Concat.size()!=0) sql+=" WHERE ";
        
        for(int i=0;i<Concat.size();i++){
            if(i>=1)sql+=" AND ";
            sql+=Concat.get(i);
        }
        
        for(Object o:this.Catalogs){
            String s = "USE " + o.toString() + sql;  
            PreparedStatement stmt = con.prepareStatement(s);
            for(int i=0;i<Concat.size();i++){
                if(Parameters.get(i).toString()=="Manufacturer") stmt.setNString(i+1, selManufacturer);
                if(Parameters.get(i).toString()=="DbPoleCountEnum") stmt.setInt(i+1, selDbPoleCountEnum);
                if(Parameters.get(i).toString()=="AutomatCharReleaseType") stmt.setNString(i+1, selAutomatCharReleaseType);
                if(Parameters.get(i).toString()=="MaxCommutation") stmt.setFloat(i+1, selMaxCommutation);
                if(Parameters.get(i).toString()=="NominalCurrent") stmt.setFloat(i+1, selNominalCurrent);
                if(Parameters.get(i).toString()=="CurrentScaleUzo") stmt.setNString(i+1, selCurrentScaleUzo);
                if(Parameters.get(i).toString()=="Name") stmt.setNString(i+1, selName);
                if(Parameters.get(i).toString()=="Code") stmt.setNString(i+1, selCode);
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Item it = new Item(rs);
                Items.add(it);
            }
            rs.close();
            stmt.close();
        }
        
        return Items;       
    }
    
    public Collection getAnalogs(String Name)throws SQLException{
        
        Item it = null;
        
        for(Object o:this.Catalogs){
            String s = "USE " + o.toString() + " SELECT Manufacturer, "
                    +"DbPoleCountEnum, AutomatCharReleaseType, MaxCommutation, NominalCurrent, CurrentScaleUzo, Name, Code "
                    +"FROM dbo.ElAutomat "
                    +"WHERE Name LIKE ?";
            PreparedStatement stmt = con.prepareStatement(s);
            stmt.setNString(1, Name);
            ResultSet rs = stmt.executeQuery();    
            while (rs.next()) {
            it  = new Item(rs);
            }
        rs.close();
        stmt.close();
        }
        
        Collection Analogs = new ArrayList();
        for(Object o:this.Catalogs){
            String s = "USE " + o.toString() + " SELECT Manufacturer, "
                +"DbPoleCountEnum, AutomatCharReleaseType, MaxCommutation, NominalCurrent, CurrentScaleUzo, Name, Code "
                +"FROM dbo.ElAutomat "
                +"WHERE DbPoleCountEnum LIKE ? AND AutomatCharReleaseType LIKE ? AND MaxCommutation LIKE ? AND "
                +"NominalCurrent LIKE ? AND "
                +"CurrentScaleUzo LIKE ?";
            
            PreparedStatement stmt = con.prepareStatement(s);        
            stmt.setInt(1, it.getDbPoleCountEnum());
            stmt.setNString(2, it.getAutomatCharReleaseType());
            stmt.setFloat(3, it.getMaxCommutation());
            stmt.setFloat(4, it.getNominalCurrent());
            stmt.setNString(5, it.getCurrentScaleUzo());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Item an = new Item(rs);
                Analogs.add(an);
            }
            rs.close();
            stmt.close();
        }
        return Analogs;       
    }
    
    public Collection getAnalogsDB(Collection Analogs) throws SQLException {
        Collection AnalogsDB = new ArrayList();
        Collection Names = new ArrayList();
        Automat at = null;
        
        for(Object o: Analogs){
            Item it = (Item)o;
            Names.add(it.getName());
        }
         
        for(Object o1:this.Catalogs){
            for (Object o2:Names){
                String s = "USE " + o1.toString() + " SELECT "
                        +"Name, "
                        +"Purpose, "
                        +"Series, "
                        +"Description, "
                        +"UserCategory, "
                        +"NameNcu, "
                        +"SpecDescription, "
                        +"DbDocument, "
                        +"Code, "
                        +"EtmCode, "
                        +"Manufacturer, "
                        +"Url, "
                        +"DbGraphicRef, "
                        +"DbImageRef, "
                        +"NominalCurrent, "
                        +"DbPoleCountEnum, "
                        +"VoltageType, "
                        +"MaxCommutation, "
                        +"DynResistance, "
                        +"MaxCommutation660, "
                        +"DynResistance660, "
                        +"IsHeatR, "
                        +"IsElMagR, "
                        +"IsElectronicR, "
                        +"HasUzo, "
                        +"CurrentScaleUzo, "
                        +"CurrentScale, "
                        +"TimeReleaseIr, "
                        +"TimeOeReleaseIr, "
                        +"CurrentChoice, "
                        +"AutomatCharReleaseType, "
                        +"AutomatReleaseMinCoef, "
                        +"AutomatReleaseMaxCoef, "
                        +"CurrReleaseScale, "
                        +"MinSensivity, "
                        +"MaxSensivity, "
                        +"UnlinkTimeScale, "
                        +"IsMultiplicityOfCurrentForTmTime, "
                        +"MultiplScale, "
                        +"KzInstantCurrentChoice, "
                        +"KzIiScale, "
                        +"UnlinkTimeElectronicScale, "
                        +"KzKiScale, "
                        +"MultiplicityOfCurrentForTmTime, "
                        +"ActiveResistance, "
                        +"InductiveResistance, "
                        +"SafeDegree, "
                        +"IsExplSafe, "
                        +"Climate, "
                        +"ExplodeLevel, "
                        +"ContactType, "
                        +"MaxCordS, "
                        +"Mass, "
                        +"MountType, "
                        +"RailMountTypeFlagged, "
                        +"Height, "
                        +"Width, "
                        +"Depth, "
                        +"DbIsModule, "
                        +"DbModuleCount "
                        +"FROM dbo.ElAutomat "
                        +"WHERE Name LIKE ?";
                PreparedStatement stmt = con.prepareStatement(s);
                stmt.setNString(1, o2.toString());
                ResultSet rs = stmt.executeQuery();    
                while (rs.next()) {
                    at  = new Automat(rs);
                    AnalogsDB.add(at);
                }
                rs.close();
                stmt.close();                
            }
        }        
        return AnalogsDB;
    }
    
    public void generateXls (Collection AnalogsDB, String path)throws IOException, InvalidFormatException{
        
        String [] columns = {
            "Наименование (Тип)", 
            "Назначение", 
            "Серия", 
            "Описание", 
            "Раздел", 
            "Наименование в составе НКУ", 
            "Описание в спецификации", 
            "Нормативный документ", 
            "Код оборудования, изделия, материала", 
            "Код ЭТМ", 
            "Производитель", 
            "Web-ссылка на сайт производителя", 
            "Графика", 
            "Изображение", 
            "Номинальный ток, А", 
            "Количество полюсов", 
            "Номинальное напряжение сети, В", 
            "Предельная коммутационная способность при 380/220В Ics, кА", 
            "Электродинамическая стойкость при 380/220В Icm, кА", 
            "Предельная коммутационная способность при 660/380В Ics, кА", 
            "Электродинамическая стойкость при 660/380В Icm, кА", 
            "Наличие теплового расцепителя", 
            "Наличие электромагнитного расцепителя", 
            "Наличие электронного расцепителя", 
            "Наличие дифференциального расцепителя", 
            "Токи уставок I∆, мА", 
            "Токи уставки расцепителя в зоне перегрузки Ir, А", 
            "Время срабатывания в зоне перегрузки tr, c", 
            "Кратность тока для времени tr, о.е.", 
            "Способ задания уставки расцепителя", 
            "Тип характеристики срабатывания расцепителя Tm", 
            "Кратность нижней границы, о.е.", 
            "Кратность верхней границы, о.е.", 
            "Токи уставок I∆, мА", 
            "Коэффициент гарантированного несрабатывания, о.е.", 
            "Коэффициент гарантированного срабатывания, о.е.", 
            "Время срабатывания расцепителя в зоне КЗ tm, с", 
            "Наличие кратности тока для времени tm (для функции I2t)", 
            "Кратности уставки расцепителя Кm, о.е", 
            "Способ задания уставки мгновенного расцепителя", 
            "Токи уставки мгновенного расцепителя Ii, о.е.", 
            "Время срабатывания мгновенного расцепителя ti, с", 
            "Кратности уставки мгновенного расцепителя Ki, о.е.", 
            "Кратность тока для времени tm (для функции I2t), о.е.", 
            "Активное сопротивление полюса R, мОм", 
            "Реактивное сопротивление полюса X, мОм", 
            "Степень защиты", 
            "Наличие взрывозащиты", 
            "Климатическое исполнение", 
            "Маркировка по взрывозащите", 
            "Конструктивное исполнение", 
            "Макс. сечение проводника, мм^2", 
            "Масса, кг", 
            "Крепление", 
            "Тип монтажной рейки", 
            "Высота, мм", 
            "Ширина, мм", 
            "Глубина, мм", 
            "Модульный", 
            "Количество модулей 18мм, шт"  
        };
        
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("generateXls");

        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }
        
        int rowNum = 1;

        for (Object o : AnalogsDB) {
            Row row = sheet.createRow(rowNum++);
            Automat automat = (Automat)o;
          
            row.createCell(0).setCellValue(automat.getName());
            row.createCell(1).setCellValue(automat.getPurpose());
            row.createCell(2).setCellValue(automat.getSeries());
            row.createCell(3).setCellValue(automat.getDescription());
            row.createCell(4).setCellValue(automat.getUserCategory());
            row.createCell(5).setCellValue(automat.getNameNcu());
            row.createCell(6).setCellValue(automat.getSpecDescription());
            row.createCell(7).setCellValue(automat.getDbDocument());
            row.createCell(8).setCellValue(automat.getCode());
            row.createCell(9).setCellValue(automat.getEtmCode());
            row.createCell(10).setCellValue(automat.getManufacturer());
            row.createCell(11).setCellValue(automat.getUrl());
            row.createCell(12).setCellValue(automat.getDbGraphicRef());
            row.createCell(13).setCellValue(automat.getDbImageRef());
            row.createCell(14).setCellValue(automat.getNominalCurrent());
            row.createCell(15).setCellValue(automat.getDbPoleCountEnum());
            row.createCell(16).setCellValue(automat.getVoltageType());
            row.createCell(17).setCellValue(automat.getMaxCommutation());
            row.createCell(18).setCellValue(automat.getDynResistance());
            row.createCell(19).setCellValue(automat.getMaxCommutation660());
            row.createCell(20).setCellValue(automat.getDynResistance660());
            row.createCell(21).setCellValue(automat.getIsHeatR());
            row.createCell(22).setCellValue(automat.getIsElMagR());
            row.createCell(23).setCellValue(automat.getIsElectronicR());
            row.createCell(24).setCellValue(automat.getHasUzo());
            row.createCell(25).setCellValue(automat.getCurrentScaleUzo());
            row.createCell(26).setCellValue(automat.getCurrentScale());
            row.createCell(27).setCellValue(automat.getTimeReleaseIr());
            row.createCell(28).setCellValue(automat.getTimeOeReleaseIr());
            row.createCell(29).setCellValue(automat.getCurrentChoice());
            row.createCell(30).setCellValue(automat.getAutomatCharReleaseType());
            row.createCell(31).setCellValue(automat.getAutomatReleaseMinCoef());
            row.createCell(32).setCellValue(automat.getAutomatReleaseMaxCoef());
            row.createCell(33).setCellValue(automat.getCurrReleaseScale());
            row.createCell(34).setCellValue(automat.getMinSensivity());
            row.createCell(35).setCellValue(automat.getMaxSensivity());
            row.createCell(36).setCellValue(automat.getUnlinkTimeScale());
            row.createCell(37).setCellValue(automat.getIsMultiplicityOfCurrentForTmTime());
            row.createCell(38).setCellValue(automat.getMultiplScale());
            row.createCell(39).setCellValue(automat.getKzInstantCurrentChoice());
            row.createCell(40).setCellValue(automat.getKzIiScale());
            row.createCell(41).setCellValue(automat.getUnlinkTimeElectronicScale());
            row.createCell(42).setCellValue(automat.getKzKiScale());
            row.createCell(43).setCellValue(automat.getMultiplicityOfCurrentForTmTime());
            row.createCell(44).setCellValue(automat.getActiveResistance());
            row.createCell(45).setCellValue(automat.getInductiveResistance());
            row.createCell(46).setCellValue(automat.getSafeDegree());
            row.createCell(47).setCellValue(automat.getIsExplSafe());
            row.createCell(48).setCellValue(automat.getClimate());
            row.createCell(49).setCellValue(automat.getExplodeLevel());
            row.createCell(50).setCellValue(automat.getContactType());
            row.createCell(51).setCellValue(automat.getMaxCordS());
            row.createCell(52).setCellValue(automat.getMass());
            row.createCell(53).setCellValue(automat.getMountType());
            row.createCell(54).setCellValue(automat.getRailMountTypeFlagged());
            row.createCell(55).setCellValue(automat.getHeight());
            row.createCell(56).setCellValue(automat.getWidth());
            row.createCell(57).setCellValue(automat.getDepth());
            row.createCell(58).setCellValue(automat.getDbIsModule());
            row.createCell(59).setCellValue(automat.getDbModuleCount());
        }
        
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
            
        FileOutputStream fileOut = new FileOutputStream(path);
        workbook.write(fileOut);
        fileOut.close();
        }
    
    public String getPathFile(){
    return this.pathFile;
    }
    
    public void setPathFile(String pathFile){
        this.pathFile=pathFile;
    }
    
    public String getNameFile(){
        return this.nameFile;
    }
    
    public void setNameFile(String nameFile){
        this.nameFile=nameFile;
    }
    
    public String getPathDir(){
    return this.pathDir;
    }
    
    public void setPathDir(String pathDir){
        this.pathDir=pathDir;
    }
    
}
 
