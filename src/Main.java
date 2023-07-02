import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        KeuanganPribadi privateMoney = new KeuanganPribadi();
        Scanner scanner = new Scanner(System.in);

        int pilih = 0;
        do{
            System.out.println("================================");
            System.out.println("    Aplikasi Pengelola Uang");
            System.out.println("================================");
            System.out.println("1. Tambah Pemasukan");
            System.out.println("2. Tambah Pengeluaran");
            System.out.println("3. Tampilkan Riwayat Transaksi");
            System.out.println("4. Hapus Transaksi");
            System.out.println("5. Hitung Saldo");
            System.out.println("6. Exit");
            System.out.println("================================");
            System.out.println("Masukkan Pilihan Anda!!");
            pilih = scanner.nextInt();

            switch (pilih){
                case 1 :
                    System.out.print("Keterangan Pemasukan : ");
                    scanner.nextLine();
                    String ketMasuk = scanner.nextLine();
                    System.out.print("Jumlah Pemasukan : Rp.");
                    double jmlMasuk = getValidateAmount(scanner);
                    Transaksi pemasukan = new Pemasukan(ketMasuk,jmlMasuk);
                    privateMoney.tambahTransaksi(pemasukan);
                    break;
                case 2:
                    System.out.print("keterangan Pengluaran : ");
                    scanner.nextLine();
                    String ketKeluar = scanner.nextLine();
                    System.out.print("Jumlah Pengluaran : Rp.");
                    double jmlKeluar = getValidateAmount(scanner);
                    privateMoney.tambahTransaksi(ketKeluar, jmlKeluar, false);
                    break;
                case 3:
                    privateMoney.tampilkan();
                    break;
                case 4:
                    privateMoney.tampilkan();
                    boolean validIndex = false;
                    if (!privateMoney. getTransaksiList().isEmpty()) {
                        while (!validIndex){
                        System.out.print("Masukkan nomor transaksi yang ingin dihapus:     ");
                        int index = scanner.nextInt();
                            if (index >= 1 && index <= privateMoney.getTransaksiList().size()) {
                                privateMoney.hapusTransaksi(index - 1);
                                validIndex = true;
                            } else {
                                System.out.println("Indeks transaksi tidak valid.");
                                System.out.println("========================================================================================");
                            }
                        }
                    } else {
                        System.out.println("Tidak ada transaksi yang dapat dihapus.");
                    }
                    break;
                case 5:
                    double saldo = privateMoney.hitungSaldo();
                    System.out.println("Saldo Anda : Rp."+saldo);
                    System.out.println("=================================");
                    break;
                case 6:
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
                    break;
                default:
                    System.out.println("Pilihan Menu tidak ada");
                    break;
            }
            System.out.println();
        }while (pilih != 6);
        scanner.close();
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
