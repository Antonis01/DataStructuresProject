public class oceanEntries{
    private float T_degC, PO4uM, SiO3uM, NO2uM, NO3uM, Salnty , O2ml_L;
    private Date date;

    public oceanEntries(Date date,float t_degC, float PO4uM, float siO3uM, float NO2uM, float NO3uM, float salnty, float o2ml_L) {
        this.date = date;
        this.T_degC = t_degC;
        this.PO4uM = PO4uM;
        this.SiO3uM = siO3uM;
        this.NO2uM = NO2uM;
        this.NO3uM = NO3uM;
        this.Salnty = salnty;
        this.O2ml_L = o2ml_L;
    }

    public float getT_degC() {
        return T_degC;
    }

    public float getPO4uM() {
        return PO4uM;
    }

    public float getSiO3uM() {
        return SiO3uM;
    }

    public float getNO2uM() {
        return NO2uM;
    }

    public float getNO3uM() {
        return NO3uM;
    }

    public float getSalnty() {
        return Salnty;
    }

    public float getO2ml_L() {
        return O2ml_L;
    }

    public Date getDate() {
        return date;
    }
}
