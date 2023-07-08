import java.util.ArrayList;
import java.util.List;

class KeuanganPribadi {
    private static ArrayList<Transaksi> transaksiList;
    public KeuanganPribadi(){
        transaksiList = new ArrayList<>();
    }
    public void tambahTransaksi(Transaksi transaksi){
        transaksiList.add(transaksi);
        System.out.println("SUCSESS!!, Transaksi Berhasil Ditambahkan");
    }
//    Overloading
    public void tambahTransaksi(String ket,double jml, boolean isPemasukan){
        Transaksi transaksi;
        if (isPemasukan){
            transaksi = new Pemasukan(ket, jml);
            System.out.println("SUCSESS!!, Transaksi Berhasil Dimasukkan");
        } else {
            transaksi = new Pengluaran(ket, jml);
            System.out.println("SUCSESS!!, Transaksi Berhasil Dimasukkan");
            if (totalPengeluaran() + jml > totalPemasukan()) {
                System.out.println("PERINGATAN: Jumlah pengeluaran melebihi jumlah pemasukan.");
                System.out.println("Saldo Anda Negatif!!");
            }
        }
        transaksiList.add(transaksi);
    }

    private double totalPengeluaran() {
        double total = 0;
        for (Transaksi transaksi : transaksiList){
            if (transaksi instanceof  Pengluaran){
                total += transaksi.getJml();
            }
        }
        return total;
    }
    private double totalPemasukan() {
        double total = 0;
        for (Transaksi transaksi : transaksiList){
            if (transaksi instanceof  Pemasukan){
                total += transaksi.getJml();
            }
        }
        return total;
    }

    public void tampilkan(){
        if(transaksiList.isEmpty()){
            System.out.println("Belum Ada Transaksi!!");
        } else {
            System.out.println("========================================================================================");
            System.out.println("                               Daftar Riwayat Transaksi :");
            System.out.println("========================================================================================");
            for (int i = 0; i < transaksiList.size(); i++){
                Transaksi transaksi = transaksiList.get(i);
                System.out.println("Transaksi "+(i+1)+": "+transaksi.getJenisTransaksi()+", Keterangan: "+transaksi.getKet()+",Jumlah: Rp. "+transaksi.getJml());
            }
            System.out.println("========================================================================================");
        }
    }
    public double RataPemasukan(){
        double totalMasuk = 0;
        double jmlMasuk = 0;
        for (Transaksi transaksi : transaksiList){
            if(transaksi instanceof Pemasukan){
                totalMasuk += transaksi.getJml();
                jmlMasuk++;
            }
        }
        if (jmlMasuk >0){
            return totalMasuk / jmlMasuk;
        } else {
            return 0;
        }
    }
    public double RataPengeluaran(){
        double totalKeluar = 0;
        double jmlKeluar = 0;
        for (Transaksi transaksi : transaksiList){
            if(transaksi instanceof Pengluaran){
                totalKeluar += transaksi.getJml();
                jmlKeluar++;
            }
        }
        if (jmlKeluar >0){
            return totalKeluar / jmlKeluar;
        } else {
            return 0;
        }
    }
    public double hitungSaldo(){
        double saldoMasuk = 0;
        double saldoKeluar = 0;
        for(Transaksi transaksi : transaksiList){
            if(transaksi instanceof Pemasukan){
                saldoMasuk += transaksi.getJml();
            } else if (transaksi instanceof  Pengluaran) {
                saldoKeluar += transaksi.getJml();
            }
        }
        System.out.println("Total Pemasukan : Rp."+saldoMasuk);
        System.out.println("Total Pengeluaran : Rp."+saldoKeluar);
        System.out.println("Rata-Rata Pemasukan : Rp."+RataPemasukan());
        System.out.println("Rata-Rata Pengeluaran : Rp."+RataPengeluaran());
        System.out.println("=================================");
        return saldoMasuk-saldoKeluar;
    }
    public void hapusTransaksi(int index){
        if (index >= 0 && index < transaksiList.size()){
            transaksiList.remove(index);
            System.out.println("Transaksi Berhasil Dihapus");
        } else {
            System.out.println("indeks transaksi tidak sesuai");
        }
    }
    public List<Transaksi> getTransaksiList()   {
        return transaksiList;
    }
}

