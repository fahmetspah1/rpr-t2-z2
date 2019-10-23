package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    public double prvaTacka, drugaTacka;
    boolean prva, druga;
    Interval( double prvaTacka, double drugaTacka, boolean prva, boolean druga) {
        if (drugaTacka<prvaTacka) throw new IllegalArgumentException("izuzetak");
        this.prvaTacka=prvaTacka;
        this.drugaTacka=drugaTacka;
        this.prva=prva;
        this.druga=druga;

    }

    Interval () {
        this.prvaTacka=0;
        this.drugaTacka=0;
        this.prva=false;
        this.druga=false;
    }

    public boolean isNull () {
        if (prvaTacka==0 && drugaTacka==0 && prva==false && druga==false) return true;
        return false;
    }

    public boolean isIn (double tacka) {
        if (tacka==prvaTacka) {
            if(prva==true) return true;
            return false;
        }
        if(tacka==drugaTacka) {
            if(druga==true) return true;
            return false;
        }

        if(tacka>prvaTacka && tacka<drugaTacka) return true;

        return false;
    }

    public Interval intersect (Interval i) {
        Interval novi = new Interval();
        if(i.prvaTacka > prvaTacka) {
            novi.prvaTacka=i.prvaTacka;
            if (i.prva==true) novi.prva=true;
            else novi.prva=false;
        }
        else {
            novi.prvaTacka=prvaTacka;
            if(prva==true) novi.prva=true;
            else novi.prva=false;
        }
        if(i.drugaTacka < drugaTacka) {
            novi.drugaTacka=i.drugaTacka;
            if(i.druga==true) novi.druga=true;
            else novi.druga=false;
        }
        else {
            novi.drugaTacka = drugaTacka;
            if(druga==true) novi.druga=true;
            else novi.druga=false;
        }
        return novi;
    }

    public static Interval intersect (Interval i1, Interval i2) {
        return i1.intersect(i2);
    }

    public String toString () {
        if (this.isNull()) return "()";
        String interval = new String();
        if(prva==true) interval="[";
        else interval="(";
        interval=interval + prvaTacka + "," + drugaTacka;
        if(druga==true) interval=interval + "]";
        else interval = interval + ")";

        return interval;

    }

    public boolean equals (Interval i) {
        return prvaTacka==i.prvaTacka && drugaTacka==i.drugaTacka && prva==i.prva && druga==i.druga;
    }

}
