package pack;

public class Utakmica {
	private String  DomEkipa;
    private String  GostEkipa;
    private int DomGol;
    private int GostGol;
    private int brZuti;
    private int brCrveni;
    private int brKazneni;
    private String imeSudije;

    public Utakmica(String domEkipa, String gostEkipa, int domGol, int gostGol, int brZuti, int brCrveni, int brKazneni, String imeSudije) {
        this.DomEkipa = domEkipa;
        this.GostEkipa = gostEkipa;
        this.DomGol = domGol;
        this.GostGol = gostGol;
        this.brZuti = brZuti;
        this.brCrveni = brCrveni;
        this.brKazneni = brKazneni;
        this.imeSudije = imeSudije;
    }

    public String getDomEkipa() {
        return DomEkipa;
    }

    public void setDomEkipa(String domEkipa) {
        DomEkipa = domEkipa;
    }

    public String getGostEkipa() {
        return GostEkipa;
    }

    public void setGostEkipa(String gostEkipa) {
        GostEkipa = gostEkipa;
    }

    public int getDomGol() {
        return DomGol;
    }

    public void setDomGol(int domGol) {
        DomGol = domGol;
    }

    public int getGostGol() {
        return GostGol;
    }

    public void setGostGol(int gostGol) {
        GostGol = gostGol;
    }

    public int getBrZuti() {
        return brZuti;
    }

    public void setBrZuti(int brZuti) {
        this.brZuti = brZuti;
    }

    public int getBrCrveni() {
        return brCrveni;
    }

    public void setBrCrveni(int brCrveni) {
        this.brCrveni = brCrveni;
    }

    public int getBrKazneni() {
        return brKazneni;
    }

    public void setBrKazneni(int brKazneni) {
        this.brKazneni = brKazneni;
    }
   
    public String getImeSudije() {
        return imeSudije;
    }

    public void setImeSudije(String imeSudije) {
        this.imeSudije = imeSudije;
    }
    
    @Override
    public String toString(){
        return DomEkipa+"-"+GostEkipa+"\n"+DomGol+":"+GostGol+"\nBroj zutih:"+brZuti+"\nBroj crvenih:"+brCrveni+"\nBroj kaznenih:"+brKazneni+"\nSudija:"+imeSudije+"\n\n";
    }
}
