package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetnaTacka,krajnjaTacka;
    private boolean lVrijednost,dVrijednost;
/*Potrebno je napraviti klasu Interval koja omogućuje izračunavanje presjeka dva intervala, te provjeru
da li se tačka nalazi unutar intervala ili ne. Klasa treba imati:
konstruktor sa četiri parametra: početna tačka, krajnja tačka
 (obje tipa double), boolean Ivrijednost koja označava da li početna tačka
  pripada intervalu ili ne, te isto i za krajnju tačku; u slučaju da je
  početna tačka veća od krajnje treba baciti izuzetak tipa IllegalArgumentException;
*/
public Interval(double pocetnaTacka,double krajnjaTacka,boolean lVrijednost, boolean dVrijednost){
    if(pocetnaTacka>krajnjaTacka) throw new IllegalArgumentException();
    this.pocetnaTacka=pocetnaTacka;
    this.krajnjaTacka=krajnjaTacka;
    this.lVrijednost=lVrijednost;
    this.dVrijednost=dVrijednost;
}
public Interval(){
    pocetnaTacka=0;
    krajnjaTacka=0;
    lVrijednost=false;
    dVrijednost=false;
}

    public boolean isNull(){
    if(pocetnaTacka==0&&krajnjaTacka==0&& !lVrijednost && !dVrijednost) return true;
    return false;
    }
    public boolean isIn(double tacka){
    if(tacka>pocetnaTacka&&tacka<krajnjaTacka) return true;
    if(tacka==pocetnaTacka&& lVrijednost) return true;
    if(tacka==krajnjaTacka&& dVrijednost) return true;
    return false;
    }

    public static Interval intersect(Interval interval1,Interval interval2) {
    double prvaTacka,drugaTacka;
    if(interval1.pocetnaTacka>interval2.pocetnaTacka) prvaTacka=interval1.pocetnaTacka;
    else prvaTacka=interval2.pocetnaTacka;
        if(interval1.krajnjaTacka<interval2.krajnjaTacka) drugaTacka=interval1.krajnjaTacka;
        else drugaTacka=interval2.krajnjaTacka;
        Interval novi=new Interval(prvaTacka,drugaTacka,true,true);
        return novi;
    }

    public Interval intersect(Interval interval) {
    double prvaTacka,drugaTacka;
    if(this.pocetnaTacka>interval.pocetnaTacka) prvaTacka=this.pocetnaTacka;
    else prvaTacka=interval.pocetnaTacka;
    if(this.krajnjaTacka<interval.krajnjaTacka) drugaTacka=this.krajnjaTacka;
    else drugaTacka=interval.krajnjaTacka;
    Interval novi=new Interval(prvaTacka,drugaTacka,true,true);
    return novi;
    }
    public String toString(){
   String prva="",druga="";
   if(lVrijednost) prva="[";
   else prva="(";
   if(dVrijednost) druga="]";
   else druga=")";
   return prva+pocetnaTacka+","+krajnjaTacka+druga;
    }
    public boolean equals(Interval i1,Interval i2){
    if(i1.pocetnaTacka==i2.pocetnaTacka&&i1.krajnjaTacka==i2.krajnjaTacka&&i1.lVrijednost==i2.lVrijednost&&i1.dVrijednost==i2.dVrijednost) return true;
    else return false;
    }
    // public Interval(Interval interval){}
}
