import java.util.InputMismatchException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
        static KeuanganPribadi privateMoney = new KeuanganPribadi();
        static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int pilih = 0;
        initLibraryData();
        do{
            showmenu();
            pilih = chosemenu();

            switch (pilih){
                case 1 :
                    pemasukan();
                    break;
                case 2:
                    pengluaran();
                    break;
                case 3:
                    privateMoney.tampilkan();
                    break;
                case 4:
                    privateMoney.tampilkan();
                    update();
                    break;
                case 5:
                    privateMoney.tampilkan();
                    hapus();
                    break;
                case 6:
                    jmlSaldo();
                    break;
                case 7:
                    selesai();
                    break;
                default:
                    System.out.println("Pilihan Menu tidak ada");
                    break;
            }
            System.out.println();
        }while (pilih != 7);
        scanner.close();
    }
    public static void showmenu(){
        System.out.println("================================");
        System.out.println("    Aplikasi Pengelola Uang");
        System.out.println("================================");
        System.out.println("1. Tambah Pemasukan");
        System.out.println("2. Tambah Pengeluaran");
        System.out.println("3. Tampilkan Riwayat Transaksi");
        System.out.println("4. Update Transaksi");
        System.out.println("5. Hapus Transaksi");
        System.out.println("6. Hitung Saldo");
        System.out.println("7. Exit");
        System.out.println("================================");
    }
   public static int chosemenu(){
        int pilih = 0;
        try {
        System.out.println("Masukkan Pilihan Anda!!");
        pilih = scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Salah Input, Silakan Masukkan Angka");
            scanner.next();
        }
        return pilih;
   }
    public static void initLibraryData() {
        Transaksi transaksi1 = new Pemasukan();
        transaksi1.setKet("Tabungan");
        transaksi1.setJml(500000);

        privateMoney.getTransaksiList().add(transaksi1);
    }
    public static void pemasukan(){
            System.out.print("Keterangan Pemasukan : ");
            scanner.nextLine();
            String ketMasuk = scanner.nextLine();
            System.out.print("Jumlah Pemasukan : Rp.");
            double jmlMasuk = getValidateAmount(scanner);
            Transaksi pemasukan = new Pemasukan(ketMasuk, jmlMasuk);
            privateMoney.tambahTransaksi(pemasukan);
    }
    public static void pengluaran(){
        System.out.print("keterangan Pengluaran : ");
        scanner.nextLine();
        String ketKeluar = scanner.nextLine();
        System.out.print("Jumlah Pengluaran : Rp.");
        double jmlKeluar = getValidateAmount(scanner);
        privateMoney.tambahTransaksi(ketKeluar, jmlKeluar, false);
    }
    public static void update(){
        boolean validindex = false;
        int index = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                if (!privateMoney.getTransaksiList().isEmpty()) {
                    while (!validindex) {
                        System.out.print("Masukkan nomor transaksi yang ingin di update :");
                        index = scanner.nextInt();

                        if (index >= 1 && index <= privateMoney.getTransaksiList().size()) {
                            validindex = true;
                        } else {
                            System.out.println("Index Transaksi tidak ada/tidak valid");
                            System.out.println("========================================================================================");
                        }
                    }
                    Transaksi transaksi = privateMoney.getTransaksiList().get(index - 1);
                    System.out.println("Transaksi yang akan di update : ");
                    System.out.println("Keterangan : " + transaksi.getKet());
                    System.out.println("Jumlah : Rp." + transaksi.getJml());

                    System.out.println("Masukkan informasi yang baru :");
                    System.out.print("Keterangan : ");
                    scanner.nextLine();
                    String newKet = scanner.nextLine();
                    System.out.print("Jumlah : Rp.");
                    double newJml = getValidateAmount(scanner);

                    privateMoney.updateTransaksi(index - 1, newKet, newJml);
                }
            } catch (InputMismatchException e) {
                System.out.println("Silakan Masukkan Angka!");
                System.out.println("========================================================================================");
                validInput = false;
                scanner.nextLine();
            }
        }
    }
    public static void hapus(){
        boolean validIndex = false;
        boolean validInput = false;
        while (!validInput) {
            try {
                if (!privateMoney.getTransaksiList().isEmpty()) {
                    while (!validIndex) {
                        System.out.print("Masukkan nomor transaksi yang ingin dihapus:     ");
                        int index = scanner.nextInt();
                        if (index >= 1 && index <= privateMoney.getTransaksiList().size()) {
                            privateMoney.hapusTransaksi(index - 1);
                            validIndex = true;
                        } else {
                            System.out.println("Indeks transaksi tidak ada/tidak valid.");
                            System.out.println("========================================================================================");
                        }
                    }
                } else {
                    System.out.println("Tidak ada transaksi yang dapat dihapus.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error. Silakan masukkan angka");
                System.out.println("========================================================================================");
                validInput = false;
                scanner.nextLine();
            }
        }
    }
    public static void jmlSaldo(){
        double saldo = privateMoney.hitungSaldo();
        System.out.println("Saldo Anda : Rp."+saldo);
        System.out.println("=================================");
    }
    public static void selesai(){
        System.out.println();
        System.out.println(
                "****************************************************************************************");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("-############-##-------------------------##------------###--------###-------------------");
        System.out.println("------##------##-------------------------##--------------##------##---------------------");
        System.out.println("------##------######-----######-######---##----##---------##----##----######--##----##--");
        System.out.println("------##------##----##-##----##-##----##-##--##------------##--##----##----##-##----##--");
        System.out.println("------##------##----##-##----##-##----##-####----------------##------##----##-##----##--");
        System.out.println("------##------##----##-##---###-##----##-##--##--------------##------##----##-##----##--");
        System.out.println("------##------##----##-####--##-##----##-##----##------------##-------######----####----");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println(
                "****************************************************************************************");
        System.out.println();
    }

    private static double getValidateAmount(Scanner scanner){
    double amount = 0;
    boolean validInput = false;
    while (!validInput){
        String input = scanner.next();
        try{
            amount = Double.parseDouble(input);
            if (amount >0){
                validInput = true;
            } else {
                System.out.println("Jumlah Harus Lebih Dari 0");
            }
        } catch (NumberFormatException e){
            System.out.println("Input Tidak valid");
        }
    }
    return amount;
}
}
