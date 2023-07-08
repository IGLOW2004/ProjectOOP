abstract class Transaksi {
    private String ket;
    private double jml;

    public Transaksi (String ket, double jml){
        this.ket = ket;
        this.jml = jml;
    }

    public Transaksi() {

    }

    public String getKet(){
        return ket;
    }
    public void setKet(String ket) {
        this.ket = ket;
    }

    public double getJml() {
        return jml;
    }
    public void setJml(double jml) {
        this.jml = jml;
    }

    public abstract String getJenisTransaksi();
}

class Pemasukan extends Transaksi{
    public Pemasukan (String ket, double jml){
        super(ket,jml);
    }

    public Pemasukan() {
        super();
    }

    @Override
    public String getJenisTransaksi() {
        return "Pemasukan";
    }
}

class Pengluaran extends Transaksi{
    public Pengluaran (String ket, double jml){
        super(ket,jml);
    }
    @Override
    public String getJenisTransaksi()  {
        return "Pengluaran";
    }
}
