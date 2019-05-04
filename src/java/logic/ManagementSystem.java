package logic;

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

public class ManagementSystem
{
    private static Connection con;
    private static ManagementSystem instance;
    private static DataSource dataSource;
    private static ArrayList Catalogs;

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
        System.out.println("getCatalogs");
        
        while (rs.next()) {
            Catalogs.add(rs.getString(1));
            System.out.println(rs.getString(1));
        }
        System.out.println("Catalogs.size");//
        System.out.println(Catalogs.size());//
        System.out.println("Catalogs remove");//
        for(int i=0; i<=3; i++){
            System.out.println("remove ->"+Catalogs.get(0).toString());
            Catalogs.remove(0);
        }//
        System.out.println("Catalogs after remove");//

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
            System.out.println(s);
    
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
            System.out.println("Analogs SQL Query");//
            System.out.println(s);//

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
 }
