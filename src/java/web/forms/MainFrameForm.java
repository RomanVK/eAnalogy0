package web.forms;

import java.util.Collection;
import java.util.Set;


public class MainFrameForm
{
    private Set ManufacturerS;//24-04-2019
    private Set DbPoleCountEnumS;
    private Set AutomatCharReleaseTypeS;
    private Set MaxCommutationS;
    private Set NominalCurrentS;
    private Set CurrentScaleUzoS;
    private Set NameS;
    private Set CodeS;
    private Collection Items;
    private Collection Analogs;
    
    private String selManufacturer;
    private int selDbPoleCountEnum;
    private String selAutomatCharReleaseType;
    private float selMaxCommutation;
    private float selNominalCurrent;
    private String selCurrentScaleUzo;
    private String selName;
    private String selCode;

    public String getSelManufacturer() {
        return selManufacturer;
    }

    public void setSelManufacturer(String selManufacturer) {
        this.selManufacturer = selManufacturer;
    }

    public int getSelDbPoleCountEnum() {
        return selDbPoleCountEnum;
    }

    public void setSelDbPoleCountEnum(int selDbPoleCountEnum) {
        this.selDbPoleCountEnum = selDbPoleCountEnum;
    }

    public String getSelAutomatCharReleaseType() {
        return selAutomatCharReleaseType;
    }

    public void setSelAutomatCharReleaseType(String selAutomatCharReleaseType) {
        this.selAutomatCharReleaseType = selAutomatCharReleaseType;
    }

    public float getSelMaxCommutation() {
        return selMaxCommutation;
    }

    public void setSelMaxCommutation(float selMaxCommutation) {
        this.selMaxCommutation = selMaxCommutation;
    }

    public float getSelNominalCurrent() {
        return selNominalCurrent;
    }

    public void setSelNominalCurrent(float selNominalCurrent) {
        this.selNominalCurrent = selNominalCurrent;
    }

    public String getSelCurrentScaleUzo() {
        return selCurrentScaleUzo;
    }

    public void setSelCurrentScaleUzo(String selCurrentScaleUzo) {
        this.selCurrentScaleUzo = selCurrentScaleUzo;
    }

    public String getSelName() {
        return selName;
    }

    public void setSelName(String selName) {
        this.selName = selName;
    }

    public String getSelCode() {
        return selCode;
    }

    public void setSelCode(String selCode) {
        this.selCode = selCode;
    }

    
    public Set getManufacturerS() {
            return ManufacturerS;
    }
    public void setManufacturerS(Set ManufacturerS) {
            this.ManufacturerS = ManufacturerS;
    }
    public Set getDbPoleCountEnumS() {
            return DbPoleCountEnumS;
    }

    public void setDbPoleCountEnumS(Set DbPoleCountEnumS) {
            this.DbPoleCountEnumS = DbPoleCountEnumS;
    }
    public Set getAutomatCharReleaseTypeS() {
            return AutomatCharReleaseTypeS;
    }

    public void setAutomatCharReleaseTypeS(Set AutomatCharReleaseTypeS) {
            this.AutomatCharReleaseTypeS = AutomatCharReleaseTypeS;
    }
    public Set getMaxCommutationS() {
            return MaxCommutationS;
    }

    public void setMaxCommutationS(Set MaxCommutationS) {
            this.MaxCommutationS = MaxCommutationS;
    }
    public Set getNominalCurrentS() {
            return NominalCurrentS;
    }

    public void setNominalCurrentS(Set NominalCurrentS) {
            this.NominalCurrentS = NominalCurrentS;
    }
    public Set getCurrentScaleUzoS() {
            return CurrentScaleUzoS;
    }

    public void setCurrentScaleUzoS(Set CurrentScaleUzoS) {
            this.CurrentScaleUzoS = CurrentScaleUzoS;
    }
    public Set getNameS() {
            return NameS;
    }

    public void setNameS(Set NameS) {
            this.NameS = NameS;
    }
    public Set getCodeS() {
            return CodeS;
    }

    public void setCodeS(Set CodeS) {
            this.CodeS = CodeS;
    }
   
    public Collection getItems() {
            return Items;
    }
    
    public void setItems(Collection Items) {
            this.Items = Items;
    }
    
    public Collection getAnalogs() {
            return Analogs;
    }
    
    public void setAnalogs(Collection Analogs) {
            this.Analogs = Analogs;
    }

}
