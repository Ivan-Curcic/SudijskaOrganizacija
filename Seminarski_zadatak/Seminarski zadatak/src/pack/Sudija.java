package pack;

public class Sudija {
    private  String ime;
    private String prezime;

    public  Sudija(String i, String p){
        ime=i;
        prezime=p;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    
    public String AvgZuti(int[] a, int n){
        double z;
        int s=0;
        for(int i=0;i<n;i++){
            s+= a[i];
        }
        z=(double) s/n;
        String str = String.valueOf(z);
        return str;
    }
    public String AvgCrv(int[] a, int n){
        double c;
        int s=0;
        for(int i=0;i<n;i++){
            s+= a[i];
        }
        c=(double) s/n;
        String str = String.valueOf(c);
        return str;
    }
    public String AvgKaz(int[] a, int n){
        double k;
        int s=0;
        for(int i=0;i<n;i++){
            s+= a[i];
        }
        k=(double) s/n;
        String str = String.valueOf(k);
        return str;
    }


}