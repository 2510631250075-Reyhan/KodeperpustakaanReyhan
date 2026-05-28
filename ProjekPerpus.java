import java.util.Scanner;
import java.io.*;
class Buku {
        int id;
        String judul;
        String kategori;
        int stok;
        boolean aktif;
        String status;

        Buku(int id, String judul, String kategori, int stok) {
            this.id = id;
            this.judul = judul;
            this.kategori = kategori;
            this.stok = stok;
            this.aktif = true;
            this.status = "tersedia";
        }
    }

    public class ProjekPerpus {
        static Scanner input = new Scanner(System.in);
        static Buku[] dataBuku = new Buku[100];
        static int jumlahData = 0;

        public static void main(String[] args) {
            isiDataAwal(); 

            int pilihan;

            do {
                System.out.println("\n=== SISTEM MANAJEMEN PERPUSTAKAAN DIGITAL ===");
                System.out.println("1. Tambah Data Buku");
                System.out.println("2. Tampilkan Semua Buku");
                System.out.println("3. Edit Data Buku Berdasarkan ID");
                System.out.println("4. Hapus Data Buku Berdasarkan ID");
                System.out.println("5. Cari buku berdasarkan nama (Linear Search)");
                System.out.println("6. Cari buku berdasarkan ID (Binary Search");
                System.out.println("7. Cari buku berdasarkan kategori");
                System.out.println("8. Urutkan buku berdasarkan ID");
                System.out.println("9. urutkan buku berdasarkan judul (Alphabetical)");
                System.out.println("10.Urutkan buku berdasarkan stok ");
                System.out.println("11.Update Status buku (Dipinjam/tersedia)");
                System.out.println("12.Status ketersediaan buku ");
                System.out.println("13 statistik data buku ");
                System.out.println("14. Save Data Buku");
                System.out.println("15. Load Data Buku");
                System.out.println("16. Keluar");

                System.out.print("Pilih menu:");

                pilihan = input.nextInt();
                input.nextLine();

                switch (pilihan) {
                    case 1:
                        tambahBuku();
                        break;
                    case 2:
                        tampilkanBuku();
                        break;
                    case 3:
                        editBuku();
                        break;
                    case 4:
                        hapusBuku();
                        break;
                    case 5:
                        cariBukuLin();
                        break;
                    case 6:
                        cariBukubin();
                        break;
                    case 7:
                        cariKategori();
                        break;
                    case 8:
                        bubbleSortid();
                        break;
                    case 9:
                        selectionSortJudul();
                        break;
                    case 10:
                        bubbleSortStok();
                        break;
                    case 11:
                        updateStatus();
                        break;
                    case 12:
                        counterBuku();
                        break;
                    case 13:
                        statistikData();
                        break;
                    case 14:
                        saveData();
                        break;
                    case 15:
                        loadData();
                        break;
                    case 16:
                        System.out.println("Program selesai, Terima Kasih.");
                        break;

                    default:
                        System.out.println("Pilihan tidak valid.");
                }

            } while (pilihan != 16);
        }

        static void isiDataAwal() {
            dataBuku[jumlahData++] = new Buku( 1, "Algoritma dan Pemrograman", "Teknologi", 10);
            dataBuku[jumlahData++] = new Buku( 2, "Struktur Data", "Teknologi", 8);
            dataBuku[jumlahData++] = new Buku( 3, "Basis Data", "Teknologi", 12);
            dataBuku[jumlahData++] = new Buku( 4, "Jaringan Komputer", "Teknologi", 7);
            dataBuku[jumlahData++] = new Buku( 5, "Sistem Operasi", "Teknologi", 9);
            dataBuku[jumlahData++] = new Buku( 6, "Pemrograman Java", "Teknologi", 15);
            dataBuku[jumlahData++] = new Buku( 7, "Pemrograman Python", "Teknologi", 11);
            dataBuku[jumlahData++] = new Buku( 8, "Machine Learning", "Teknologi", 6);
            dataBuku[jumlahData++] = new Buku( 9, "Artificial Intelligence", "Teknologi", 5);
            dataBuku[jumlahData++] = new Buku(10, "Data Mining", "Teknologi", 8);

            dataBuku[jumlahData++] = new Buku(11, "Laskar Pelangi", "Novel", 20);
            dataBuku[jumlahData++] = new Buku(12, "Bumi Manusia", "Novel", 14);
            dataBuku[jumlahData++] = new Buku(13, "Ayat-Ayat Cinta", "Novel", 18);
            dataBuku[jumlahData++] = new Buku(14, "Dilan 1990", "Novel", 22);
            dataBuku[jumlahData++] = new Buku(15, "Perahu Kertas", "Novel", 16);

            dataBuku[jumlahData++] = new Buku(16, "Sejarah Indonesia", "Sejarah", 13);
            dataBuku[jumlahData++] = new Buku(17, "Sejarah Dunia", "Sejarah", 9);
            dataBuku[jumlahData++] = new Buku(18, "Perang Dunia II", "Sejarah", 7);
            dataBuku[jumlahData++] = new Buku(19, "Kerajaan Majapahit", "Sejarah", 10);
            dataBuku[jumlahData++] = new Buku(20, "Kerajaan Sriwijaya", "Sejarah", 8);

            dataBuku[jumlahData++] = new Buku(21, "Fisika Dasar", "Sains", 11);
            dataBuku[jumlahData++] = new Buku(22, "Kimia Dasar", "Sains", 12);
            dataBuku[jumlahData++] = new Buku(23, "Biologi Dasar", "Sains", 14);
            dataBuku[jumlahData++] = new Buku(24, "Astronomi", "Sains", 6);
            dataBuku[jumlahData++] = new Buku(25, "Geologi", "Sains", 5);

            dataBuku[jumlahData++] = new Buku(26, "Manajemen Bisnis", "Ekonomi", 9);
            dataBuku[jumlahData++] = new Buku(27, "Akuntansi Dasar", "Ekonomi", 10);
            dataBuku[jumlahData++] = new Buku(28, "Ekonomi Mikro", "Ekonomi", 8);
            dataBuku[jumlahData++] = new Buku(29, "Ekonomi Makro", "Ekonomi", 7);
            dataBuku[jumlahData++] = new Buku(30, "Kewirausahaan", "Ekonomi", 12);
        }

static void tampilHeader() {
        System.out.println("=================================================================================================");
        System.out.printf("%-5s %-35s %-15s %-10s %-12s\n",
                "ID", "Judul", "Kategori", "Stok", "Status");
        System.out.println("=================================================================================================");
    }

    static void tampilBaris(Buku b) {
        System.out.printf("%-5d %-35s %-5s %-10d %-12s\n",
                b.id,
                b.judul,
                b.kategori,
                b.stok,
                b.status);
    }

        static void tambahBuku() {
            System.out.println("\n=== TAMBAH DATA BUKU ===");

            System.out.print("Masukan ID Buku: ");
            int id = input.nextInt();
            input.nextLine();

            System.out.print("Masukan Judul Buku: ");
            String judul = input.nextLine();

            System.out.print("Masukan Kategori Buku: ");
            String kategori = input.nextLine();

            System.out.print("Masukan Stok Buku: ");
            int stok = input.nextInt();
            input.nextLine();

            dataBuku[jumlahData++] = new Buku(id, judul, kategori, stok);

            System.out.println("Data buku berhasil ditambahkan.");
        }

     static void tampilkanBuku() {
    System.out.println("\n=== DAFTAR BUKU ===");

    if (jumlahData == 0) {
        System.out.println("Belum ada data buku.");
        return;
    }
        tampilHeader();
    for (int i = 0; i < jumlahData; i++) {
        if (dataBuku[i].aktif == true) {

            System.out.printf("%-5d %-35s %-15s %-10d %-12s\n",
                    dataBuku[i].id,
                    dataBuku[i].judul,
                    dataBuku[i].kategori,
                    dataBuku[i].stok,
                    dataBuku[i].status);
        }
    }

    System.out.println("=====================================================================================================");
}

    static void editBuku() {
        System.out.println("\n=== EDIT DATA BUKU ===");

        System.out.print("Masukkan ID Buku: ");
        int id = input.nextInt();
        input.nextLine();

        for (int i = 0; i < jumlahData; i++) {
            if (dataBuku[i].id == id && dataBuku[i].aktif == true) {
                System.out.print("Judul Baru: ");
                dataBuku[i].judul = input.nextLine();

                System.out.print("Kategori Baru: ");
                dataBuku[i].kategori = input.nextLine();

                System.out.print("Stok Baru: ");
                dataBuku[i].stok = input.nextInt();
                input.nextLine();

                System.out.println("Data berhasil diedit.");
                return;
            }
        }

        System.out.println("Data tidak ditemukan.");
    }

    static void hapusBuku() {
        System.out.println("\n=== HAPUS DATA BUKU ===");

        System.out.print("Masukkan ID Buku: ");
        int id = input.nextInt();
        input.nextLine();

        for (int i = 0; i < jumlahData; i++) {
            if (dataBuku[i].id == id && dataBuku[i].aktif == true) {
                dataBuku[i].aktif = false;
                System.out.println("Data berhasil dihapus.");
                return;
            }
        }

        System.out.println("Data tidak ditemukan.");
    }

   static void cariBukuLin() {

    System.out.println("\n=== MENCARI BUKU ===");
    System.out.println("Masukan nama buku: ");
    String cari = input.nextLine();

    boolean ditemukan = false;

    for (int i = 0; i < jumlahData; i++) {
        if (dataBuku[i].aktif == true && mengandung(dataBuku[i].judul, cari)) {

            System.out.println("\nBuku ditemukan:");
                tampilHeader();
                tampilBaris(dataBuku[i]);
            ditemukan = true;
        }
    }

    if (ditemukan == false) {
        System.out.println("Buku tidak ditemukan.");
    }
}

static boolean mengandung(String teks, String cari) {
   
    char[] arrTeks = new char[teks.length()];
    char[] arrCari = new char[cari.length()];

    for (int i = 0; i < teks.length(); i++) {
        char c = teks.charAt(i);
        if (c >= 'A' && c <= 'Z') {
            arrTeks[i] = (char)(c + 32); 
        } else {
            arrTeks[i] = c;
        }
    }

    for (int i = 0; i < cari.length(); i++) {
        char c = cari.charAt(i);
        if (c >= 'A' && c <= 'Z') {
            arrCari[i] = (char)(c + 32);
        } else {
            arrCari[i] = c;
        }
    }

    for (int i = 0; i <= arrTeks.length - arrCari.length; i++) {
        boolean cocok = true;
        for (int j = 0; j < arrCari.length; j++) {
            if (arrTeks[i + j] != arrCari[j]) {
                cocok = false;
                break;
            }
        }
        if (cocok) return true;
    }

    return false;
}
   static void cariBukubin() {  
        System.out.println("\n=== CARI ID BUKU (BINARY SEARCH) ===");

        System.out.print("Masukan ID Buku: ");
        int cari = input.nextInt();

        int awal = 0;
        int akhir = jumlahData - 1;

        boolean ditemukan = false;

        while (awal <= akhir) {
            int tengah = (awal + akhir) / 2;

            if (dataBuku[tengah].id == cari &&
                dataBuku[tengah].aktif == true) {
                    System.out.println("\nBuku ditemukan");
                    tampilHeader();
                    tampilBaris(dataBuku[tengah]);
                    ditemukan = true;
                    break;
                }else if (cari > dataBuku[tengah].id) {
                    awal = tengah + 1;
                }else {
                    akhir = tengah - 1;
            }
        }

        if (ditemukan == false) {
        System.out.println("Buku tidak ditemukan");
        }
    }

    static void cariKategori() {
        System.out.println("\n=== CARI BUKU BERDASARKAN KATEGORI ===");

        System.out.print("Masukan kategori buku: ");
        String kategori = input.nextLine();
        boolean ditemukan = false;

    for (int i = 0; i < jumlahData; i++) {

        if (dataBuku[i].aktif == true &&
            kategoriSama(dataBuku[i].kategori, kategori)) {
                System.out.println("\nBuku ditemukan");
                tampilHeader();
                tampilBaris(dataBuku[i]);
                ditemukan = true;
            }
        }

    if (ditemukan == false) {
        System.out.println("Kategori buku tidak ditemukan");
    }
}

    static boolean kategoriSama(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            char ca = a.charAt(i);
            char cb = b.charAt(i);
        if (ca >= 'A' && ca <= 'Z') ca = (char)(ca + 32);
        if (cb >= 'A' && cb <= 'Z') cb = (char)(cb + 32);
        if (ca != cb) return false;
    }

    return true;
}
    
    static void bubbleSortid() {
        System.out.println("\n=== SORTING BUKU (ID) ===");

        for (int i = 0; i < jumlahData - 1; i++) {
            for (int j = 0; j < jumlahData - i - 1; j++) {
                if (dataBuku[j].id > dataBuku[j + 1].id) {

                    Buku temp = dataBuku[j];
                    dataBuku[j] = dataBuku[j + 1];
                    dataBuku[j + 1] = temp;
                }
            }
        }

        tampilHeader();
        for (int i = 0; i < jumlahData; i++) {
            if (dataBuku[i].aktif == true) {
                tampilBaris(dataBuku[i]);
            }
        }
       System.out.println("=====================================================================================================");
    }

    static void selectionSortJudul() {
        System.out.println("\n=== SORTING JUDUL BUKU A-Z ===");

        for (int i = 0; i < jumlahData - 1; i++) {
            int min = i;

            for (int j = i + 1; j < jumlahData; j++) {

                String judul1 = dataBuku[j].judul;
                String judul2 = dataBuku[min].judul;
                int panjang;

                if (judul1.length() < judul2.length()) {
                    panjang = judul1.length();
                } else {
                    panjang = judul2.length();
                }

                boolean lebihKecil = false;

                for (int k = 0; k < panjang; k++) {
                    char huruf1 = judul1.charAt(k);
                    char huruf2 = judul2.charAt(k);

                    if (huruf1 < huruf2) {
                        lebihKecil = true;
                        break;
                    } else if (huruf1 > huruf2) {
                        break;
                    }
                }

                if (lebihKecil == true) {
                    min = j;
                }
            }

            Buku temp = dataBuku[i];
            dataBuku[i] = dataBuku[min];
            dataBuku[min] = temp;
        }

        System.out.println("\n=== BUKU SETELAH SORTING ===");
        
        tampilHeader();

        for (int i = 0; i < jumlahData; i++) {
            if (dataBuku[i].aktif == true) {
                tampilBaris(dataBuku[i]);
            }
        }
       System.out.println("=====================================================================================================");
    }

    static void bubbleSortStok() {
        System.out.println("\n=== SORTING STOK BUKU DESCENDING ===");

        for (int i = 0; i < jumlahData - 1; i++) {
            for (int j = 0; j < jumlahData - i - 1; j++) {
                if (dataBuku[j].stok < dataBuku[j + 1].stok) {
                    Buku temp = dataBuku[j];
                    dataBuku[j] = dataBuku[j + 1];
                    dataBuku[j + 1] = temp;
                }
            }
        }

        System.out.println("\n=== BUKU SETELAH SORTING STOK DESC ===");
        
        tampilHeader();
        
        for (int i = 0; i < jumlahData; i++) {
            if (dataBuku[i].aktif == true) {
                tampilBaris(dataBuku[i]);
            }
        }
       System.out.println("=====================================================================================================");
    }
    
    static void updateStatus() {

    System.out.println("\n=== UPDATE STATUS BUKU ===");

    System.out.print("Masukkan ID Buku: ");
    int id = input.nextInt();
    input.nextLine();

    for (int i = 0; i < jumlahData; i++) {

        if (dataBuku[i].id == id && dataBuku[i].aktif == true) {

            System.out.println("Status saat ini : " + dataBuku[i].status);

            System.out.print("Masukkan status buku baru (Tersedia/Dipinjam): ");
            dataBuku[i].status = input.nextLine();

        if (statusSama(dataBuku[i].status, "Dipinjam")) {
                if (dataBuku[i].stok > 0) {
                    dataBuku[i].stok--;
                    System.out.println("Stok berkurang, sisa stok: " + dataBuku[i].stok);
                } else {
                    System.out.println("Stok habis, tidak bisa dipinjam.");
                    dataBuku[i].status = "Tersedia";
                }
            } else if (statusSama(dataBuku[i].status, "Tersedia")) {
                dataBuku[i].stok++;
                System.out.println("Buku dikembalikan, stok bertambah: " + dataBuku[i].stok);
            }

            System.out.println("Status berhasil diupdate.");
            return;
        }
    }

    System.out.println("Buku tidak ditemukan.");
}

    static void counterBuku() {

    int totalAktif = 0;
    int totalStok = 0;
    int totalDipinjam = 0;

    for (int i = 0; i < jumlahData; i++) {

        if (dataBuku[i].aktif == true) {

            totalAktif++;
            totalStok += dataBuku[i].stok;

            if (statusSama(dataBuku[i].status, "Dipinjam")) {
                totalDipinjam++;
            }
        }
    }

    System.out.println("\n=== COUNTER BUKU ===");
    System.out.println("Total Buku Aktif     : " + totalAktif);
    System.out.println("Total Stok Tersedia  : " + totalStok);
    System.out.println("Total Buku Dipinjam  : " + totalDipinjam);
}

    static void statistikData() {

    int totalAktif = 0;
    int totalStok = 0;
    int totalDipinjam = 0;

    for (int i = 0; i < jumlahData; i++) {

        if (dataBuku[i].aktif == true) {

            totalAktif++;
            totalStok += dataBuku[i].stok;

            if (statusSama(dataBuku[i].status, "Dipinjam")) {
                totalDipinjam++;
            }
        }
    }

    double persenTersedia = 0;
    double persenDipinjam = 0;

    if (totalStok > 0) {
        persenTersedia = (double) totalStok / (totalStok + totalDipinjam) * 100;
        persenDipinjam = (double) totalDipinjam / (totalStok + totalDipinjam) * 100;
    }

    System.out.println("\n=== STATISTIK DATA BUKU ===");
    System.out.println("Total Buku Aktif      : " + totalAktif);
    System.out.println("Total Stok Tersedia   : " + totalStok);
    System.out.println("Total Buku Dipinjam   : " + totalDipinjam);

    System.out.printf("Persentase Tersedia   : %.2f%%\n", persenTersedia);
    System.out.printf("Persentase Dipinjam   : %.2f%%\n", persenDipinjam);
}

     static boolean statusSama(String a, String b) { //statusSama untuk counterBuku dan statistik Data

        if (a.length() != b.length()) return false;

        for (int i = 0; i < a.length(); i++) {
            char ca = a.charAt(i);
            char cb = b.charAt(i);
        if (ca >= 'A' && ca <= 'Z') ca = (char)(ca + 32);
        if (cb >= 'A' && cb <= 'Z') cb = (char)(cb + 32);
        if (ca != cb) return false;
    }

    return true;
}
 
    static void saveData() {

     try {

        FileWriter fw = new FileWriter("dataBuku.txt");

        for (int i = 0; i < jumlahData; i++) {

            if (dataBuku[i].aktif == true) {

                fw.write(
                    dataBuku[i].id + ";" +
                    dataBuku[i].judul + ";" +
                    dataBuku[i].kategori + ";" +
                    dataBuku[i].stok + ";" +
                    dataBuku[i].status + "\n"
                );
            }
        }

        fw.close();

        System.out.println("Data berhasil disimpan ke file.");

    } catch (IOException e) {

        System.out.println("Terjadi kesalahan saat menyimpan data.");
    }
}

static void loadData() {

    try {

        File file = new File("dataBuku.txt");

        Scanner bacaFile = new Scanner(file);

        jumlahData = 0;

        while (bacaFile.hasNextLine()) {

            String data = bacaFile.nextLine();

            String[] pecah = data.split(";");

            int id = Integer.parseInt(pecah[0]);
            String judul = pecah[1];
            String kategori = pecah[2];
            int stok = Integer.parseInt(pecah[3]);
            String status = pecah[4];

            dataBuku[jumlahData] = new Buku(id, judul, kategori, stok);
            dataBuku[jumlahData].status = status;

            jumlahData++;
        }

        bacaFile.close();

        System.out.println("Data berhasil di-load dari file.");

    } catch (FileNotFoundException e) {

        System.out.println("File data tidak ditemukan.");
    }
}
}
