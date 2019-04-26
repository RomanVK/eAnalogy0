package logic;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Item implements Comparable{
    
    private String Name; //Наименование (Тип)
    private String Code; //Код оборудования, изделия, материала
    private String Manufacturer; //Производитель
    private float NominalCurrent; //Номинальный ток, А
    private int DbPoleCountEnum; //Количество полюсов
    private float MaxCommutation; //Предельная коммутационная способность при 380/220В Ics, кА
    private String CurrentScaleUzo; //Токи уставок I∆, мА
    private String AutomatCharReleaseType; //Тип характеристики срабатывания расцепителя Tm

    public Item (ResultSet rs) throws SQLException {
        setName(rs.getString(7));
        setCode(rs.getString(8));
        setManufacturer(rs.getString(1));
        setNominalCurrent(rs.getFloat(5));
        setDbPoleCountEnum(rs.getInt(2));
        setMaxCommutation(rs.getFloat(4));
        setCurrentScaleUzo(rs.getString(6));
        setAutomatCharReleaseType(rs.getString(3));
    }

    public Item() {
    }
    
    public String getName() {
            return Name;
    }

    public void setName(String Name) {
            this.Name = Name;
    }
    public String getCode() {
            return Code;
    }

    public void setCode(String Code) {
            this.Code = Code;
    }    
    public String getManufacturer() {
            return Manufacturer;
    }

    public void setManufacturer(String Manufacturer) {
            this.Manufacturer = Manufacturer;
    }    
    public float getNominalCurrent() {
            return NominalCurrent;
    }

    public void setNominalCurrent(float NominalCurrent) {
            this.NominalCurrent = NominalCurrent;
    }    
    
    public int getDbPoleCountEnum() {
            return DbPoleCountEnum;
    }

    public void setDbPoleCountEnum(int DbPoleCountEnum) {
            this.DbPoleCountEnum = DbPoleCountEnum;
    }    
    public float getMaxCommutation() {
            return MaxCommutation;
    }

    public void setMaxCommutation(float MaxCommutation) {
            this.MaxCommutation = MaxCommutation;
    }    
    public String getCurrentScaleUzo() {
            return CurrentScaleUzo;
    }

    public void setCurrentScaleUzo(String CurrentScaleUzo) {
            this.CurrentScaleUzo = CurrentScaleUzo;
    }    
     public String getAutomatCharReleaseType() {
            return AutomatCharReleaseType;
    }

    public void setAutomatCharReleaseType(String AutomatCharReleaseType) {
            this.AutomatCharReleaseType = AutomatCharReleaseType;
    }   
   
    public String toString() {
        return
   Name + 	"	"
 + Code + 	"	"
 + Manufacturer + 	"	"
 + NominalCurrent + 	"	"
 + DbPoleCountEnum + 	"	"
 + MaxCommutation + 	"	"
 + CurrentScaleUzo + 	"	"
 + AutomatCharReleaseType + 	"	"; 		
    }

    public int compareTo(Object obj) {
        return this.toString().compareTo(obj.toString());
    }
    
}
