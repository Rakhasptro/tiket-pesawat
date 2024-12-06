import java.util.*;

class TiketPesawat {
    private static final int HARGA_AMERIKA = 5000000; 
    private static final int HARGA_BANGKOK = 2500000;  
    private static final int HARGA_CHINA = 3500000;    
    private static final double PAJAK = 0.1; 
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Masukkan jumlah jenis tiket yang akan dipesan: ");
            int jumlahJenis = input.nextInt();
            
            String[] tujuan = new String[jumlahJenis];
            int[] hargaTiket = new int[jumlahJenis];
            int[] jumlahTiket = new int[jumlahJenis];
            int[] totalHarga = new int[jumlahJenis];

            tampilkanMenu();
            
            for (int i = 0; i < jumlahJenis; i++) {
                System.out.println("\nPemesanan ke-" + (i + 1));
                System.out.print("Masukkan kode tujuan [A/B/C]: ");
                String kode = input.next().toUpperCase();
                
                if("A".equals(kode)) {
                    tujuan[i] = "Jakarta-Amerika";
                    hargaTiket[i] = HARGA_AMERIKA;
                } else if ("B".equals(kode)){
                    tujuan[i] = "Jakarta-Bangkok";
                    hargaTiket[i] = HARGA_BANGKOK;
                } else if ("C".equals(kode)){

                    tujuan[i] = "Jakarta-China";
                    hargaTiket[i] = HARGA_CHINA;
                } else {
                    System.out.println("Kode tidak valid! Menggunakan Jakarta-Bangkok sebagai default.");
                    tujuan[i] = "Jakarta-Bangkok";
                    hargaTiket[i] = HARGA_BANGKOK;
                }
                
                System.out.print("Jumlah tiket yang dipesan: ");
                jumlahTiket[i] = input.nextInt();
                totalHarga[i] = hargaTiket[i] * jumlahTiket[i];
            }

            // Tampilkan ringkasan pesanan
            tampilkanRingkasanPesanan(jumlahJenis, tujuan, hargaTiket, jumlahTiket, totalHarga);
            
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    private static void tampilkanMenu() {
        System.out.println("\nPESANAN TIKET PESAWAT");
        System.out.println("---------------------------------------------");
        System.out.println("Kode    Tujuan              Harga");
        System.out.println("---------------------------------------------");
        System.out.printf("A       Jakarta-Amerika    Rp.%,d%n", HARGA_AMERIKA);
        System.out.printf("B       Jakarta-Bangkok    Rp.%,d%n", HARGA_BANGKOK);
        System.out.printf("C       Jakarta-China      Rp.%,d%n", HARGA_CHINA);
        System.out.println("---------------------------------------------");
    }

    private static void tampilkanRingkasanPesanan(int jumlahJenis, String[] tujuan, 
            int[] hargaTiket, int[] jumlahTiket, int[] totalHarga) {
        System.out.println("\n\tRINGKASAN PEMESANAN TIKET");
        System.out.println("---------------------------------------------");
        System.out.println("No.\tTujuan\t\t\tHarga\t\tJumlah\tTotal");
        System.out.println("\t\t\t\tTiket\t\tTiket\tHarga");
        System.out.println("---------------------------------------------");

        double jumlahBayar = 0;
        for (int i = 0; i < jumlahJenis; i++) {
            System.out.printf("%d\t%-20s\tRp.%,d\t%d\tRp.%,d%n", 
                (i + 1), tujuan[i], hargaTiket[i], jumlahTiket[i], totalHarga[i]);
            jumlahBayar += totalHarga[i];
        }

        System.out.println("---------------------------------------------");
        double pajak = jumlahBayar * PAJAK;
        double totalBayar = jumlahBayar + pajak;

        System.out.printf("\tSubtotal\t\t\t\tRp.%,d%n", (int)jumlahBayar);
        System.out.printf("\tPajak 10%%\t\t\t\tRp.%,d%n", (int)pajak);
        System.out.printf("\tTotal Bayar\t\t\t\tRp.%,d%n", (int)totalBayar);
    }
}
