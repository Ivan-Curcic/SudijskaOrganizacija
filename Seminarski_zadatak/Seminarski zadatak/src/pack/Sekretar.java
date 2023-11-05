package pack;

public class Sekretar {
    private String Ime;
    private String Prezime;

    public Sekretar(String ime, String prezime) {
        Ime = ime;
        Prezime = prezime;
    }

    public String getIme() {
        return Ime;
    }

    public void setIme(String ime) {
        Ime = ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public void setPrezime(String prezime) {
        Prezime = prezime;
    }
}