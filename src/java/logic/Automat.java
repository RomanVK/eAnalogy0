package logic;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Automat implements Comparable
{
    private String Name; //Наименование (Тип)
    private String Purpose; //Назначение
    private String Series; //Серия
    private String Description; //Описание
    private String UserCategory; //Раздел
    private String NameNcu; //Наименование в составе НКУ
    private String SpecDescription; //Описание в спецификации
    private String DbDocument; //Нормативный документ
    private String Code; //Код оборудования, изделия, материала
    private String EtmCode; //Код ЭТМ
    private String Manufacturer; //Производитель
    private String Url; //Web-ссылка на сайт производителя
    private int DbGraphicRef; //Графика
    private int DbImageRef; //Изображение
    private float NominalCurrent; //Номинальный ток, А
    private int DbPoleCountEnum; //Количество полюсов
    private int VoltageType; //Номинальное напряжение сети, В
    private float MaxCommutation; //Предельная коммутационная способность при 380/220В Ics, кА
    private float DynResistance; //Электродинамическая стойкость при 380/220В Icm, кА
    private float MaxCommutation660; //Предельная коммутационная способность при 660/380В Ics, кА
    private float DynResistance660; //Электродинамическая стойкость при 660/380В Icm, кА
    private boolean IsHeatR; //Наличие теплового расцепителя
    private boolean IsElMagR; //Наличие электромагнитного расцепителя
    private boolean IsElectronicR; //Наличие электронного расцепителя
    private boolean HasUzo; //Наличие дифференциального расцепителя
    private String CurrentScaleUzo; //Токи уставок I∆, мА
    private String CurrentScale; //Токи уставки расцепителя в зоне перегрузки Ir, А
    private String TimeReleaseIr; //Время срабатывания в зоне перегрузки tr, c
    private float TimeOeReleaseIr; //Кратность тока для времени tr, о.е.
    private int CurrentChoice; //Способ задания уставки расцепителя
    private String AutomatCharReleaseType; //Тип характеристики срабатывания расцепителя Tm
    private float AutomatReleaseMinCoef; //Кратность нижней границы, о.е.
    private float AutomatReleaseMaxCoef; //Кратность верхней границы, о.е.
    private String CurrReleaseScale; //Токи уставок I∆, мА
    private float MinSensivity; //Коэффициент гарантированного несрабатывания, о.е.
    private float MaxSensivity; //Коэффициент гарантированного срабатывания, о.е.
    private String UnlinkTimeScale; //Время срабатывания расцепителя в зоне КЗ tm, с
    private boolean IsMultiplicityOfCurrentForTmTime; //Наличие кратности тока для времени tm (для функции I2t)
    private String MultiplScale; //Кратности уставки расцепителя Кm, о.е
    private int KzInstantCurrentChoice; //Способ задания уставки мгновенного расцепителя
    private String KzIiScale; //Токи уставки мгновенного расцепителя Ii, о.е.
    private String UnlinkTimeElectronicScale; //Время срабатывания мгновенного расцепителя ti, с
    private String KzKiScale; //Кратности уставки мгновенного расцепителя Ki, о.е.
    private float MultiplicityOfCurrentForTmTime; //Кратность тока для времени tm (для функции I2t), о.е.
    private float ActiveResistance; //Активное сопротивление полюса R, мОм
    private float InductiveResistance; //Реактивное сопротивление полюса X, мОм
    private int SafeDegree; //Степень защиты
    private int IsExplSafe; //Наличие взрывозащиты
    private int Climate; //Климатическое исполнение
    private int ExplodeLevel; //Маркировка по взрывозащите
    private int ContactType; //Конструктивное исполнение
    private float MaxCordS; //Макс. сечение проводника, мм^2
    private String Mass; //Масса, кг
    private int MountType; //Крепление
    private int RailMountTypeFlagged; //Тип монтажной рейки
    private float Height; //Высота, мм
    private float Width; //Ширина, мм
    private float Depth; //Глубина, мм
    private boolean DbIsModule; //Модульный
    private float DbModuleCount; //Количество модулей 18мм, шт

    public Automat(ResultSet rs) throws SQLException {
        setName(rs.getString(1));
        setPurpose(rs.getString(2));
        setSeries(rs.getString(3));
        setDescription(rs.getString(4));
        setUserCategory(rs.getString(5));
        setNameNcu(rs.getString(6));
        setSpecDescription(rs.getString(7));
        setDbDocument(rs.getString(8));
        setCode(rs.getString(9));
        setEtmCode(rs.getString(10));
        setManufacturer(rs.getString(11));
        setUrl(rs.getString(12));
        setDbGraphicRef(rs.getInt(13));
        setDbImageRef(rs.getInt(14));
        setNominalCurrent(rs.getFloat(15));
        setDbPoleCountEnum(rs.getInt(16));
        setVoltageType(rs.getInt(17));
        setMaxCommutation(rs.getFloat(18));
        setDynResistance(rs.getFloat(19));
        setMaxCommutation660(rs.getFloat(20));
        setDynResistance660(rs.getFloat(21));
        setIsHeatR(rs.getBoolean(22));
        setIsElMagR(rs.getBoolean(23));
        setIsElectronicR(rs.getBoolean(24));
        setHasUzo(rs.getBoolean(25));
        setCurrentScaleUzo(rs.getString(26));
        setCurrentScale(rs.getString(27));
        setTimeReleaseIr(rs.getString(28));
        setTimeOeReleaseIr(rs.getFloat(29));
        setCurrentChoice(rs.getInt(30));
        setAutomatCharReleaseType(rs.getString(31));
        setAutomatReleaseMinCoef(rs.getFloat(32));
        setAutomatReleaseMaxCoef(rs.getFloat(33));
        setCurrReleaseScale(rs.getString(34));
        setMinSensivity(rs.getFloat(35));
        setMaxSensivity(rs.getFloat(36));
        setUnlinkTimeScale(rs.getString(37));
        setIsMultiplicityOfCurrentForTmTime(rs.getBoolean(38));
        setMultiplScale(rs.getString(39));
        setKzInstantCurrentChoice(rs.getInt(40));
        setKzIiScale(rs.getString(41));
        setUnlinkTimeElectronicScale(rs.getString(42));
        setKzKiScale(rs.getString(43));
        setMultiplicityOfCurrentForTmTime(rs.getFloat(44));
        setActiveResistance(rs.getFloat(45));
        setInductiveResistance(rs.getFloat(46));
        setSafeDegree(rs.getInt(47));
        setIsExplSafe(rs.getInt(48));
        setClimate(rs.getInt(49));
        setExplodeLevel(rs.getInt(50));
        setContactType(rs.getInt(51));
        setMaxCordS(rs.getFloat(52));
        setMass(rs.getString(53));
        setMountType(rs.getInt(54));
        setRailMountTypeFlagged(rs.getInt(55));
        setHeight(rs.getFloat(56));
        setWidth(rs.getFloat(57));
        setDepth(rs.getFloat(58));
        setDbIsModule(rs.getBoolean(59));
        setDbModuleCount(rs.getFloat(60));
    }

    public Automat() {
    }
    
    public String getName() {
            return Name;
    }

    public void setName(String Name) {
            this.Name = Name;
    }
    public String getPurpose() {
            return Purpose;
    }

    public void setPurpose(String Purpose) {
            this.Purpose = Purpose;
    }
    public String getSeries() {
            return Series;
    }

    public void setSeries(String Series) {
            this.Series = Series;
    }
    public String getDescription() {
            return Description;
    }

    public void setDescription(String Description) {
            this.Description = Description;
    }
    public String getUserCategory() {
            return UserCategory;
    }

    public void setUserCategory(String UserCategory) {
            this.UserCategory = UserCategory;
    }
    public String getNameNcu() {
            return NameNcu;
    }

    public void setNameNcu(String NameNcu) {
            this.NameNcu = NameNcu;
    }
    public String getSpecDescription() {
            return SpecDescription;
    }

    public void setSpecDescription(String SpecDescription) {
            this.SpecDescription = SpecDescription;
    }
    public String getDbDocument() {
            return DbDocument;
    }

    public void setDbDocument(String DbDocument) {
            this.DbDocument = DbDocument;
    }
    public String getCode() {
            return Code;
    }

    public void setCode(String Code) {
            this.Code = Code;
    }
    public String getEtmCode() {
            return EtmCode;
    }

    public void setEtmCode(String EtmCode) {
            this.EtmCode = EtmCode;
    }
    public String getManufacturer() {
            return Manufacturer;
    }

    public void setManufacturer(String Manufacturer) {
            this.Manufacturer = Manufacturer;
    }
    public String getUrl() {
            return Url;
    }

    public void setUrl(String Url) {
            this.Url = Url;
    }
    public int getDbGraphicRef() {
            return DbGraphicRef;
    }

    public void setDbGraphicRef(int DbGraphicRef) {
            this.DbGraphicRef = DbGraphicRef;
    }
    public int getDbImageRef() {
            return DbImageRef;
    }

    public void setDbImageRef(int DbImageRef) {
            this.DbImageRef = DbImageRef;
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
    public int getVoltageType() {
            return VoltageType;
    }

    public void setVoltageType(int VoltageType) {
            this.VoltageType = VoltageType;
    }
    public float getMaxCommutation() {
            return MaxCommutation;
    }

    public void setMaxCommutation(float MaxCommutation) {
            this.MaxCommutation = MaxCommutation;
    }
    public float getDynResistance() {
            return DynResistance;
    }

    public void setDynResistance(float DynResistance) {
            this.DynResistance = DynResistance;
    }
    public float getMaxCommutation660() {
            return MaxCommutation660;
    }

    public void setMaxCommutation660(float MaxCommutation660) {
            this.MaxCommutation660 = MaxCommutation660;
    }
    public float getDynResistance660() {
            return DynResistance660;
    }

    public void setDynResistance660(float DynResistance660) {
            this.DynResistance660 = DynResistance660;
    }
    public boolean getIsHeatR() {
            return IsHeatR;
    }

    public void setIsHeatR(boolean IsHeatR) {
            this.IsHeatR = IsHeatR;
    }
    public boolean getIsElMagR() {
            return IsElMagR;
    }

    public void setIsElMagR(boolean IsElMagR) {
            this.IsElMagR = IsElMagR;
    }
    public boolean getIsElectronicR() {
            return IsElectronicR;
    }

    public void setIsElectronicR(boolean IsElectronicR) {
            this.IsElectronicR = IsElectronicR;
    }
    public boolean getHasUzo() {
            return HasUzo;
    }

    public void setHasUzo(boolean HasUzo) {
            this.HasUzo = HasUzo;
    }
    public String getCurrentScaleUzo() {
            return CurrentScaleUzo;
    }

    public void setCurrentScaleUzo(String CurrentScaleUzo) {
            this.CurrentScaleUzo = CurrentScaleUzo;
    }
    public String getCurrentScale() {
            return CurrentScale;
    }

    public void setCurrentScale(String CurrentScale) {
            this.CurrentScale = CurrentScale;
    }
    public String getTimeReleaseIr() {
            return TimeReleaseIr;
    }

    public void setTimeReleaseIr(String TimeReleaseIr) {
            this.TimeReleaseIr = TimeReleaseIr;
    }
    public float getTimeOeReleaseIr() {
            return TimeOeReleaseIr;
    }

    public void setTimeOeReleaseIr(float TimeOeReleaseIr) {
            this.TimeOeReleaseIr = TimeOeReleaseIr;
    }
    public int getCurrentChoice() {
            return CurrentChoice;
    }

    public void setCurrentChoice(int CurrentChoice) {
            this.CurrentChoice = CurrentChoice;
    }
    public String getAutomatCharReleaseType() {
            return AutomatCharReleaseType;
    }

    public void setAutomatCharReleaseType(String AutomatCharReleaseType) {
            this.AutomatCharReleaseType = AutomatCharReleaseType;
    }
    public float getAutomatReleaseMinCoef() {
            return AutomatReleaseMinCoef;
    }

    public void setAutomatReleaseMinCoef(float AutomatReleaseMinCoef) {
            this.AutomatReleaseMinCoef = AutomatReleaseMinCoef;
    }
    public float getAutomatReleaseMaxCoef() {
            return AutomatReleaseMaxCoef;
    }

    public void setAutomatReleaseMaxCoef(float AutomatReleaseMaxCoef) {
            this.AutomatReleaseMaxCoef = AutomatReleaseMaxCoef;
    }
    public String getCurrReleaseScale() {
            return CurrReleaseScale;
    }

    public void setCurrReleaseScale(String CurrReleaseScale) {
            this.CurrReleaseScale = CurrReleaseScale;
    }
    public float getMinSensivity() {
            return MinSensivity;
    }

    public void setMinSensivity(float MinSensivity) {
            this.MinSensivity = MinSensivity;
    }
    public float getMaxSensivity() {
            return MaxSensivity;
    }

    public void setMaxSensivity(float MaxSensivity) {
            this.MaxSensivity = MaxSensivity;
    }
    public String getUnlinkTimeScale() {
            return UnlinkTimeScale;
    }

    public void setUnlinkTimeScale(String UnlinkTimeScale) {
            this.UnlinkTimeScale = UnlinkTimeScale;
    }
    public boolean getIsMultiplicityOfCurrentForTmTime() {
            return IsMultiplicityOfCurrentForTmTime;
    }

    public void setIsMultiplicityOfCurrentForTmTime(boolean IsMultiplicityOfCurrentForTmTime) {
            this.IsMultiplicityOfCurrentForTmTime = IsMultiplicityOfCurrentForTmTime;
    }
    public String getMultiplScale() {
            return MultiplScale;
    }

    public void setMultiplScale(String MultiplScale) {
            this.MultiplScale = MultiplScale;
    }
    public int getKzInstantCurrentChoice() {
            return KzInstantCurrentChoice;
    }

    public void setKzInstantCurrentChoice(int KzInstantCurrentChoice) {
            this.KzInstantCurrentChoice = KzInstantCurrentChoice;
    }
    public String getKzIiScale() {
            return KzIiScale;
    }

    public void setKzIiScale(String KzIiScale) {
            this.KzIiScale = KzIiScale;
    }
    public String getUnlinkTimeElectronicScale() {
            return UnlinkTimeElectronicScale;
    }

    public void setUnlinkTimeElectronicScale(String UnlinkTimeElectronicScale) {
            this.UnlinkTimeElectronicScale = UnlinkTimeElectronicScale;
    }
    public String getKzKiScale() {
            return KzKiScale;
    }

    public void setKzKiScale(String KzKiScale) {
            this.KzKiScale = KzKiScale;
    }
    public float getMultiplicityOfCurrentForTmTime() {
            return MultiplicityOfCurrentForTmTime;
    }

    public void setMultiplicityOfCurrentForTmTime(float MultiplicityOfCurrentForTmTime) {
            this.MultiplicityOfCurrentForTmTime = MultiplicityOfCurrentForTmTime;
    }
    public float getActiveResistance() {
            return ActiveResistance;
    }

    public void setActiveResistance(float ActiveResistance) {
            this.ActiveResistance = ActiveResistance;
    }
    public float getInductiveResistance() {
            return InductiveResistance;
    }

    public void setInductiveResistance(float InductiveResistance) {
            this.InductiveResistance = InductiveResistance;
    }
    public int getSafeDegree() {
            return SafeDegree;
    }

    public void setSafeDegree(int SafeDegree) {
            this.SafeDegree = SafeDegree;
    }
    public int getIsExplSafe() {
            return IsExplSafe;
    }

    public void setIsExplSafe(int IsExplSafe) {
            this.IsExplSafe = IsExplSafe;
    }
    public int getClimate() {
            return Climate;
    }

    public void setClimate(int Climate) {
            this.Climate = Climate;
    }
    public int getExplodeLevel() {
            return ExplodeLevel;
    }

    public void setExplodeLevel(int ExplodeLevel) {
            this.ExplodeLevel = ExplodeLevel;
    }
    public int getContactType() {
            return ContactType;
    }

    public void setContactType(int ContactType) {
            this.ContactType = ContactType;
    }
    public float getMaxCordS() {
            return MaxCordS;
    }

    public void setMaxCordS(float MaxCordS) {
            this.MaxCordS = MaxCordS;
    }
    public String getMass() {
            return Mass;
    }

    public void setMass(String Mass) {
            this.Mass = Mass;
    }
    public int getMountType() {
            return MountType;
    }

    public void setMountType(int MountType) {
            this.MountType = MountType;
    }
    public int getRailMountTypeFlagged() {
            return RailMountTypeFlagged;
    }

    public void setRailMountTypeFlagged(int RailMountTypeFlagged) {
            this.RailMountTypeFlagged = RailMountTypeFlagged;
    }
    public float getHeight() {
            return Height;
    }

    public void setHeight(float Height) {
            this.Height = Height;
    }
    public float getWidth() {
            return Width;
    }

    public void setWidth(float Width) {
            this.Width = Width;
    }
    public float getDepth() {
            return Depth;
    }

    public void setDepth(float Depth) {
            this.Depth = Depth;
    }
    public boolean getDbIsModule() {
            return DbIsModule;
    }

    public void setDbIsModule(boolean DbIsModule) {
            this.DbIsModule = DbIsModule;
    }
    public float getDbModuleCount() {
            return DbModuleCount;
    }

    public void setDbModuleCount(float DbModuleCount) {
            this.DbModuleCount = DbModuleCount;
    }

    public String toString() {
        return
   Name + 	"	"
 + Purpose + 	"	"
 + Series + 	"	"
 + Description + 	"	"
 + UserCategory + 	"	"
 + NameNcu + 	"	"
 + SpecDescription + 	"	"
 + DbDocument + 	"	"
 + Code + 	"	"
 + EtmCode + 	"	"
 + Manufacturer + 	"	"
 + Url + 	"	"
 + DbGraphicRef + 	"	"
 + DbImageRef + 	"	"
 + NominalCurrent + 	"	"
 + DbPoleCountEnum + 	"	"
 + VoltageType + 	"	"
 + MaxCommutation + 	"	"
 + DynResistance + 	"	"
 + MaxCommutation660 + 	"	"
 + DynResistance660 + 	"	"
 + IsHeatR + 	"	"
 + IsElMagR + 	"	"
 + IsElectronicR + 	"	"
 + HasUzo + 	"	"
 + CurrentScaleUzo + 	"	"
 + CurrentScale + 	"	"
 + TimeReleaseIr + 	"	"
 + TimeOeReleaseIr + 	"	"
 + CurrentChoice + 	"	"
 + AutomatCharReleaseType + 	"	"
 + AutomatReleaseMinCoef + 	"	"
 + AutomatReleaseMaxCoef + 	"	"
 + CurrReleaseScale + 	"	"
 + MinSensivity + 	"	"
 + MaxSensivity + 	"	"
 + UnlinkTimeScale + 	"	"
 + IsMultiplicityOfCurrentForTmTime + 	"	"
 + MultiplScale + 	"	"
 + KzInstantCurrentChoice + 	"	"
 + KzIiScale + 	"	"
 + UnlinkTimeElectronicScale + 	"	"
 + KzKiScale + 	"	"
 + MultiplicityOfCurrentForTmTime + 	"	"
 + ActiveResistance + 	"	"
 + InductiveResistance + 	"	"
 + SafeDegree + 	"	"
 + IsExplSafe + 	"	"
 + Climate + 	"	"
 + ExplodeLevel + 	"	"
 + ContactType + 	"	"
 + MaxCordS + 	"	"
 + Mass + 	"	"
 + MountType + 	"	"
 + RailMountTypeFlagged + 	"	"
 + Height + 	"	"
 + Width + 	"	"
 + Depth + 	"	"
 + DbIsModule + 	"	"
 + DbModuleCount; 		
    }

    public int compareTo(Object obj) {
        return this.toString().compareTo(obj.toString());
    }

}
