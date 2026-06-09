import java.util.Scanner;

class Mahasiswa {
    String nim;
    String nama;
    String status;

    public Mahasiswa(String nim, String nama, String status) {
        this.nim = nim;
        this.nama = nama;
        this.status = status;
    }
}

class Matakuliah {
    String kode;
    String nama;
    String status;

    public Matakuliah(String kode, String nama, String status) {
        this.kode = kode;
        this.nama = nama;
        this.status = status;
    }
}

class PengambilanMatkul {
    Mahasiswa mahasiswa;
    Matakuliah matakuliah;
    int nilai;

    public PengambilanMatkul(Mahasiswa mahasiswa, Matakuliah matakuliah, int nilai) {
        this.mahasiswa = mahasiswa;
        this.matakuliah = matakuliah;
        this.nilai = nilai;
    }
}



public class MainApp {
    Scanner sc = new Scanner(System.in);

    Mahasiswa[] Mhs = new Mahasiswa[10];
    Matakuliah[] Matkul = new Matakuliah[10];
    PengambilanMatkul[][] Pmatkul = new PengambilanMatkul[10][10];

    public void start() {
        inisialisasi();
        Menu();
    }

    public void inisialisasi() {
        Mhs[0] = new Mahasiswa("123123", "qwerty", "Aktif");
        Mhs[1] = new Mahasiswa("7890", "asdfghj", "Aktif");
        
        Matkul[0] = new Matakuliah("MTK001", "Matematika", "Aktif");
        Matkul[1] = new Matakuliah("PBO002", "Pemrograman Berbasis Object", "Aktif");
        Matkul[2] = new Matakuliah("MTVK003", "Matematika Vektor", "Aktif");

        Pmatkul[0][0] = new PengambilanMatkul(Mhs[0], Matkul[0], 100);
        Pmatkul[0][1] = new PengambilanMatkul(Mhs[0], Matkul[1], 80);
        Pmatkul[1][0] = new PengambilanMatkul(Mhs[1], Matkul[0], 90);
    }

    public void Menu() {
        System.out.println("===========");
        System.out.println("1. Matakuliah");
        System.out.println("2. Mahasiswa");
        System.out.println("3. mahasiswa - matakuliah");
        System.out.println("4. list berdasarkan mata kuliah");
        System.out.println("5. list berdasarkan mahasiswa");
        int option = sc.nextInt();

        switch (option) {
            case 1: // Menu matakuliah
                System.out.println("===================");
                System.out.println("1. Tambah Matakuliah");
                System.out.println("2. Edit Matakuliah");
                System.out.println("0. Menu");
                int opsiMatkul = sc.nextInt();
                sc.nextLine();
                if (opsiMatkul == 0) {
                    Menu();
                } else {
                    if (opsiMatkul == 1) {
                        System.out.println("Ini list matkul yang sudah ada : ");
                        int i = 0;
                        boolean pengakalan = true;
                        while (pengakalan == true) {
                            if (Matkul[i] == null) {
                                pengakalan = false;
                            } else {
                                System.out.println("Matkul " + (1 + i) + " : " + Matkul[i].nama);
                                i++;
                            }
                        }

                        System.out.println();
                        System.out.println("Mau tambah matkul apa ? : Nama : ");
                        String namaMatkul = sc.nextLine();
                        System.out.println("Mau tambah matkul apa ? : kode : ");
                        String kodeMatkul = sc.nextLine();
                        System.out.println("Mau tambah matkul apa ? : status : ");
                        String statusMatkul = sc.nextLine();

                        Matkul[i] = new Matakuliah(kodeMatkul, namaMatkul, statusMatkul);
                        Menu();
                    } else {
                        if (opsiMatkul == 2) {
                            System.out.println();
                            System.out.println("Mau edit matkul apa ?");
                            int i = 0;
                            boolean pengakalan = true;
                            while (pengakalan == true) {
                                if (Matkul[i] == null) {
                                    pengakalan = false;
                                } else {
                                    System.out.println("Matkul " + (1 + i) + " : " + Matkul[i].nama);
                                    i++;
                                }
                            }

                            System.out.println();
                            System.out.println("Mau edit matkul yang mana ? ");
                            int editMatkul = sc.nextInt();

                            if(editMatkul == 0){
                                System.out.println("Pilihan tidak ada....");
                                Menu();
                            }

                            System.out.println("Nama : ");
                            String namaMatkul = sc.nextLine();
                            System.out.println("kode : ");
                            String kodeMatkul = sc.nextLine();
                            System.out.println("status : ");
                            String statusMatkul = sc.nextLine();

                            Matkul[editMatkul - 1].nama = namaMatkul;
                            Matkul[editMatkul - 1].kode = kodeMatkul;
                            Matkul[editMatkul -1 ].status = statusMatkul;
                            Menu();
                        } else {
                            System.out.println("Salah input tolong coba lagi");
                            Menu();
                        }
                    }
                }
                break;

            case 2: // Menu Mahasiswa
                System.out.println("===================");
                System.out.println("1. Tambah Mahasiswa");
                System.out.println("2. Edit Mahasiswa");
                System.out.println("0. Menu");
                int opsiMahasigma = sc.nextInt();

                if (opsiMahasigma == 0) {
                    Menu();
                } else {
                    if (opsiMahasigma == 1) {
                        System.out.println("Ini list Mahasiswa yang sudah ada : ");
                        int i = 0;
                        boolean pengakalan = true;
                        while (pengakalan == true) {
                            if (Mhs[i] == null) {
                                pengakalan = false;
                            } else {
                                System.out.println("Mahasiswa " + (1 + i) + " : " + Mhs[i].nama);
                                i++;
                            }
                        }

                        System.out.println();
                        System.out.println("Mau tambah matkul apa ? : Nama : ");
                        String namaMaha = sc.nextLine();
                        System.out.println("Mau tambah matkul apa ? : kode : ");
                        String kodeMaha = sc.nextLine();
                        System.out.println("Mau tambah matkul apa ? : status : ");
                        String statusMaha = sc.nextLine();

                        Mhs[i + 1] = new Mahasiswa(kodeMaha, namaMaha, statusMaha);
                        Menu();
                    } else {
                        if (opsiMahasigma == 2) {
                            System.out.println();
                            System.out.println("Mau edit data Mahasiswa yang mana ?");
                            int i = 0;
                            boolean pengakalan = true;
                            while (pengakalan == true) {
                                if (Mhs[i] == null) {
                                    pengakalan = false;
                                } else {
                                    System.out.println("Mahasiswa " + (1 + i) + " : " + Mhs[i].nama);
                                    i++;
                                }
                            }

                            System.out.println();
                            System.out.println("Mau edit matkul yang mana ? ");
                            int editMatkul = sc.nextInt();
                            sc.nextLine();

                            if(editMatkul == 0){
                                System.out.println("Pilihan tidak ada....");
                                Menu();
                            }

                            System.out.println("Nama : ");
                            String namaMhs = sc.nextLine();
                            System.out.println("kode : ");
                            String kodeMhs = sc.nextLine();
                            System.out.println("status : ");
                            String statusMhs = sc.nextLine();

                            Mhs[editMatkul - 1].nama = namaMhs;
                            Mhs[editMatkul - 1].nim = kodeMhs;
                            Mhs[editMatkul - 1].status = statusMhs;
                            Menu();
                        } else {
                            System.out.println("Salah input tolong coba lagi");
                            Menu();
                        }
                    }
                }
                break;

            case 3: // Menu Mahasiswa - Matakuliah
                System.out.println("===================");
                System.out.println("1. Tambah");
                System.out.println("2. Edit");
                System.out.println("0. Menu");
                int pilihan = sc.nextInt();

                System.out.println("Tolong pilih");
                if (pilihan == 0) {
                    Menu();
                } else {
                    if (pilihan == 1) {
                        System.out.println("List yang saat ini sudah ada");

                        for (int i = 0; i < 10; i++) {
                            System.out.println("Mahasiswa ke : " + (i + 1));
                            for (int j = 0; j < 10; j++) {
                                if (Pmatkul[i][j] != null) {
                                    System.out.println(Pmatkul[i][j].matakuliah.nama + " Nilai : " + Pmatkul[i][j].nilai);
                                }
                            }
                        }

                        System.out.println("============");
                        System.out.println("Mau Masukin Mahasiswa mana?");
                        for (int i = 0; i < 10; i++) {
                            if (Mhs[i] != null) {
                                System.out.println((1 + i) + ". " + Mhs[i].nama);
                            }
                        }
                        int pilihMhs = sc.nextInt();

                        System.out.println("============");
                        System.out.println("Mau Nilai Matkul apa?");
                        for (int i = 0; i < 10; i++) {
                            if (Mhs[i] != null) {
                                System.out.println((1 + i) + ". " + Matkul[i].nama);
                            }
                        }
                        int pilihMatkul = sc.nextInt();

                        System.out.println("Masukan Nilai Matkul mahasiswa ");
                        int nilai = sc.nextInt();

                        if (Pmatkul[pilihMhs][pilihMatkul] == null) {
                            Pmatkul[pilihMhs][pilihMatkul] = new PengambilanMatkul(Mhs[pilihMhs], Matkul[pilihMatkul], nilai);
                            System.out.println("Data tersimpan :D");
                        } else {
                            System.out.println("Maaf data sudah ada");
                            Menu();
                        }
                    } else {
                        if (pilihan == 2) {
                            System.out.println("Mau Edit Nial mahasiswa mana?");
                            for (int i = 0; i < 10; i++) {
                                if (Mhs[i] != null) {
                                    System.out.println((1 + i) + ". " + Mhs[i].nama);
                                }
                            }
                            int pilihMhs = sc.nextInt();

                            System.out.println("Mau matakuliah apa?");
                            System.out.println("Mau Nilai Matkul apa?");
                            for (int i = 0; i < 10; i++) {
                                if (Mhs[i] != null) {
                                    System.out.println((1 + i) + ". " + Matkul[i].nama);
                                }
                            }
                            int pilihMatkul = sc.nextInt();

                            System.out.println("Jadi berapa nilainya?");
                            int nilai = sc.nextInt();

                            if(Pmatkul[pilihMhs][pilihMatkul].nilai == 0){
                                System.out.println("Nilai Masih null jadi tidak bisa di update");
                            }else{
                                Pmatkul[pilihMhs][pilihMatkul].nilai = nilai;
                                System.out.println("Nilai Berhasil di Edit :D");
                            }
                        } else {
                            System.out.println("Salah input tolong coba lagi");
                            Menu();
                        }
                    }
                }
                break;

            case 4: // Menu List berdasarkan Matakuliah
                System.out.println("================");
                System.out.println("Mata kuliah apa yang ingin dilihat ?");
                for (int i = 0; i < 10; i++) {
                    if (Matkul[i] != null) { // Tambahkan pengecekan ini
                        System.out.println(Matkul[i].nama);
                    }
                }
                System.out.println("================");
                int mtkl = sc.nextInt();

                for (int i = 0; i < 10; i++) {
                    System.out.println("Mahasiswa yang mengambil Matakuliah Ini adalah : ");
                    if(Pmatkul[i][mtkl].nilai != 0){
                        System.out.println(Mhs[i].nama);
                    }
                }
            break;

            case 5: // Menu List berdasarkan Mahasiswa
                System.out.println("================");
                System.out.println("Mahasiswa Mana yang ingin dilihat ?");
                for (int i = 0; i < 10; i++) {
                    System.out.println(Mhs[i].nama);
                }
                System.out.println("================");
                int Mahasiswa = sc.nextInt();

                for (int i = 0; i < 10; i++) {
                    System.out.println("Mahasiswa yang mengambil Matakuliah Ini adalah : ");
                    if(Pmatkul[Mahasiswa][i].nilai != 0){
                        System.out.println(Mhs[i].nama + " Nilai : " + (1+i) + Pmatkul[Mahasiswa][i].nilai);
                    }
                }
            break;

            default:
                break;
        }
    }

    public static void main(String[] args) {
        new MainApp().start();
    }
}