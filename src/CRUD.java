public interface CRUD {
void tambahTransaksi(Transaksi transaksi);
void tampilkan();
void updateTransaksi(int index, String newKet,double newJml  );
void hapusTransaksi(int index);
}
