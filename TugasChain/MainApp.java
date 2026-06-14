import java.util.Scanner;

public class MainApp {
    Scanner sc = new Scanner(System.in);

    Mahasiswa[] Mhs = new Mahasiswa[10];
    Matakuliah[] Matkul = new Matakuliah[10];
    Karyawan[] daftarKaryawan = new Karyawan[15];
    PengambilanMatkul[][] Pmatkul = new PengambilanMatkul[10][10];

    public void start() {
        inisialisasi();
        Menu();
    }

    public void inisialisasi() {
        Mhs[0] = new Mahasiswa("Mahakarya@gmail.com","123123", "AKTIF" ,"12345", "qwerty" , "12 Januari 2024" , "12 January 2028");
        Mhs[1] = new Mahasiswa("Ma@gmail.com","wasd", "AKTIF" ,"22345", "burpy" , "12 Januari 2025" , "12 January 2029");

        Matkul[0] = new Matakuliah("MTK001", "Matematika", "Aktif", 2);
        Matkul[1] = new Matakuliah("PBO002", "Pemrograman Berbasis Object", "Aktif", 4);
        Matkul[2] = new Matakuliah("MTVK003", "Matematika Vektor", "Aktif", 3);

        Pmatkul[0][0] = new PengambilanMatkul(Mhs[0], Matkul[0], 100);
        Pmatkul[0][1] = new PengambilanMatkul(Mhs[0], Matkul[1], 80);
        Pmatkul[1][0] = new PengambilanMatkul(Mhs[1], Matkul[0], 90);

        daftarKaryawan[0] = new DosenTetap("Udin","DosenT@Gmail.com", "12345", "AKTIF", "DT001", 4500000, 500000);
        daftarKaryawan[1] = new Staff("Rufos","Staff@gmail.com", "09876", "AKTIF", "ST001", 3500000);
        daftarKaryawan[2] = new DosenHonorer("Skari","DosenH@gmail.com", "qwerty", "AKTIF", "DH001", 400000);
    }

    public void Menu() {
        System.out.println("===========");
        System.out.println("1. Matakuliah");
        System.out.println("2. Mahasiswa");
        System.out.println("3. mahasiswa - matakuliah");
        System.out.println("4. list berdasarkan mata kuliah");
        System.out.println("5. list berdasarkan mahasiswa");
        System.out.println("6. KARYAWAN");
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
                        int indexKosong = -1;
                        for (int i = 0; i < Matkul.length; i++) {
                            if (Matkul[i] == null) {
                                indexKosong = i;
                                break;
                            }
                        }

                        if (indexKosong != -1) {
                            System.out.println();
                            System.out.println("Mau tambah matkul apa ? : Nama : ");
                            String namaMatkul = sc.nextLine();
                            System.out.println("Mau tambah matkul apa ? : kode : ");
                            String kodeMatkul = sc.nextLine();
                            System.out.println("Mau tambah matkul apa ? : status : ");
                            String statusMatkul = sc.nextLine();
                            System.out.println("SKS : ");
                            int sksMatkul = sc.nextInt();

                            Matkul[indexKosong] = new Matakuliah(kodeMatkul, namaMatkul, statusMatkul, sksMatkul);
                            Menu();
                        } else {
                            System.out.println("Array Penuh!");
                            Menu();
                        }
                    } else {
                        if (opsiMatkul == 2) {
                            System.out.println();
                            System.out.println("Mau edit matkul apa ?");
                            for (int j = 0; j < Matkul.length; j++) {
                                if (Matkul[j] != null) {
                                    System.out.println("Matkul " + (1 + j) + " : " + Matkul[j].nama);
                                }
                            }

                            System.out.println();
                            System.out.println("Mau edit matkul yang mana ? ");
                            int editMatkul = sc.nextInt();

                            if (editMatkul == 0) {
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
                            Matkul[editMatkul - 1].status = statusMatkul;
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
                System.out.println("3. Hitung IP");
                System.out.println("0. Menu");
                int opsiMahasigma = sc.nextInt();

                if (opsiMahasigma == 0) {
                    Menu();
                } else {
                    if (opsiMahasigma == 1) {
                        System.out.println("Ini list Mahasiswa yang sudah ada : ");
                        int indexKosong = -1;
                        for (int i = 0; i < Mhs.length; i++) {
                            if (Mhs[i] == null) {
                                indexKosong = i;
                                break;
                            }
                        }

                        if (indexKosong != -1) {
                            System.out.println();
                            System.out.println("Mau tambah Mahasiswa baru - Nama : ");
                            String namaMaha = sc.nextLine();
                            System.out.println("NIM : ");
                            String kodeMaha = sc.nextLine();
                            System.out.println("Status : ");
                            String statusMaha = sc.nextLine();

                            Mhs[indexKosong] = new Mahasiswa(kodeMaha, namaMaha, statusMaha);
                            Menu();
                        } else {
                            System.out.println("Array Penuh!");
                            Menu();
                        }
                    } else {
                        if (opsiMahasigma == 2) {
                            System.out.println();
                            System.out.println("Mau edit data Mahasiswa yang mana ?");
                            for (int k = 0; k < Mhs.length; k++) {
                                if (Mhs[k] != null) {
                                    System.out.println((k) + ". " + Mhs[k].getNama());
                                }
                            }

                            System.out.println();
                            System.out.println("Mau edit matkul yang mana ? ");
                            int editMatkul = sc.nextInt();
                            sc.nextLine();

                            if (editMatkul == 0) {
                                System.out.println("Pilihan tidak ada....");
                                Menu();
                            }

                            System.out.println("Nama : ");
                            String namaMhs = sc.nextLine();
                            System.out.println("kode : ");
                            String kodeMhs = sc.nextLine();
                            System.out.println("status : ");
                            String statusMhs = sc.nextLine();

                            Mhs[editMatkul - 1].setNama(namaMhs);
                            Mhs[editMatkul - 1].setNim(kodeMhs);
                            Mhs[editMatkul - 1].setStatus(statusMhs);
                            Menu();
                        } else {
                            if (opsiMahasigma == 3) {
                                System.out.println("Ini list Mahasiswa yang sudah ada : ");
                                for (int k = 0; k < Mhs.length; k++) {
                                    if (Mhs[k] != null) {
                                        System.out.println((k) + ". " + Mhs[k].getNama());
                                    }
                                }

                                System.out.println("Mau hitung ip mahasiswa yang mana?");
                                int pilihHitungip = sc.nextInt();

                                pilihHitungip--;
                                if (pilihHitungip >= 0) {
                                    if (Mhs[pilihHitungip] != null) {
                                        double toip = Mhs[pilihHitungip].hitungIp(Pmatkul, pilihHitungip);

                                        System.out.println("IP Keseluruhan dari : " + Mhs[pilihHitungip].getNama()
                                                + " IP : " + toip);
                                    }
                                }
                            } else {
                                System.out.println("Salah input tolong coba lagi");
                                Menu();
                            }
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
                                    System.out.println(Pmatkul[i][j].getMatakuliah().getNama() + " Nilai : "
                                            + Pmatkul[i][j].getNilai());
                                }
                            }
                        }

                        System.out.println("============");
                        System.out.println("Mau Masukin Mahasiswa mana?");
                        for (int i = 0; i < 10; i++) {
                            if (Mhs[i] != null) {
                                System.out.println((1 + i) + ". " + Mhs[i].getNama());
                            }
                        }
                        int pilihMhs = sc.nextInt();

                        System.out.println("============");
                        System.out.println("Mau Nilai Matkul apa?");
                        for (int i = 0; i < 10; i++) {
                            if (Matkul[i] != null) {
                                System.out.println((1 + i) + ". " + Matkul[i].nama);
                            }
                        }
                        int pilihMatkul = sc.nextInt();

                        System.out.println("Masukan Nilai Matkul mahasiswa ");
                        int nilai = sc.nextInt();

                        if (Pmatkul[pilihMhs][pilihMatkul] == null) {
                            Pmatkul[pilihMhs][pilihMatkul] = new PengambilanMatkul(Mhs[pilihMhs], Matkul[pilihMatkul],
                                    nilai);
                            System.out.println("Data tersimpan :D");
                        } else {
                            System.out.println("Maaf data sudah ada");
                            Menu();
                        }
                    } else {
                        if (pilihan == 2) {
                            System.out.println("Mau Edit Nilai mahasiswa mana?");
                            for (int i = 0; i < 10; i++) {
                                if (Mhs[i] != null) {
                                    System.out.println((1 + i) + ". " + Mhs[i].getNama());
                                }
                            }
                            int pilihMhs = sc.nextInt();

                            System.out.println("Mau matakuliah apa?");
                            System.out.println("Mau Nilai Matkul apa?");
                            for (int i = 0; i < 10; i++) {
                                if (Matkul[i] != null) {
                                    System.out.println((1 + i) + ". " + Matkul[i].nama);
                                }
                            }
                            int pilihMatkul = sc.nextInt();

                            System.out.println("Jadi berapa nilainya?");
                            int nilai = sc.nextInt();

                            if (Pmatkul[pilihMhs][pilihMatkul].getNilai() == 0) {
                                System.out.println("Nilai Masih null jadi tidak bisa di update");
                            } else {
                                Pmatkul[pilihMhs][pilihMatkul].setNilai(nilai);
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
                    if (Pmatkul[i][mtkl].getNilai() != 0) {
                        System.out.println(Mhs[i].getNama());
                    }
                }
                break;

            case 5: // Menu List berdasarkan Mahasiswa
                System.out.println("================");
                System.out.println("Mahasiswa Mana yang ingin dilihat ?");
                for (int i = 0; i < 10; i++) {
                    System.out.println(Mhs[i].getNama());
                }
                System.out.println("================");
                int Mahasiswa = sc.nextInt();

                for (int i = 0; i < 10; i++) {
                    System.out.println("Mahasiswa yang mengambil Matakuliah Ini adalah : ");
                    if (Pmatkul[Mahasiswa][i].getNilai() != 0) {
                        System.out.println(Mhs[i].getNama() + " Nilai : " + (1 + i) + Pmatkul[Mahasiswa][i].getNilai());
                    }
                }
                break;

            case 6:
                System.out.println("======= Menu Karyawan =======");
                System.out.println("1. Tampilkan");
                System.out.println("2. Tambah");
                System.out.println("3. Edit");
                System.out.println("4. Delete");
                System.out.println("5. Hitung Gaji");
                System.out.println("0. Back");
                System.out.println("=============================");

                System.out.println();
                System.out.println("Pilih yang mana? ");
                int pilihK = sc.nextInt();

                if (pilihK == 0) {
                    Menu();
                } else {
                    if (pilihK == 1) {// Menampilkan
                        System.out.println("ini adalah Karyawan - karyawan yang laggi ada");
                        for (int i = 0; i < daftarKaryawan.length; i++) {
                            if (daftarKaryawan[i] != null) {
                                System.out.println((1 + i) + " ." + daftarKaryawan[i].getNama() + " , Role : "
                                        + daftarKaryawan[i].getNik());
                            }
                        }
                        Menu();
                    } else {
                        if (pilihK == 2) {// Nambah
                            System.out.println("Nambah Karyawan apa?");
                            System.out.println("1. Dosen Tetap");
                            System.out.println("2. Staff");
                            System.out.println("3. Dosen Honnorer");
                            System.out.println("====================");

                            System.out.print("Pilih : ");
                            int buatK = sc.nextInt();
                            sc.nextLine();

                            int indi = -1;
                            for (int i = 0; i < daftarKaryawan.length; i++) {
                                if (daftarKaryawan[i] == null) {
                                    indi = i;
                                    break;
                                }
                            }

                            if (indi == -1) {
                                System.out.println("Karyawan is full");
                            } else {
                                System.out.print("Nama : ");
                                String nama = sc.nextLine();
                                System.out.print("Email : ");
                                String email = sc.nextLine();
                                System.out.print("Password : ");
                                String pass = sc.nextLine();
                                System.out.print("Status :");
                                String stat = sc.nextLine();
                                System.out.println("Nik : ");
                                String NIKI = sc.nextLine();

                                if (buatK == 1) {
                                    System.out.print("Gaji Pokok : ");
                                    int gjpk = sc.nextInt();

                                    System.out.print("Gaji Honorer : ");
                                    int gjh = sc.nextInt();

                                    daftarKaryawan[indi] = new DosenTetap(nama, email, pass, stat, NIKI, gjpk, gjh);
                                    System.out.println("Berhasil dibuat seharusnya!");
                                    Menu();
                                } else {
                                    if (buatK == 2) {
                                        System.out.print("Gaji pokok : ");
                                        int gjpk = sc.nextInt();

                                        daftarKaryawan[indi] = new Staff(nama, email, pass, stat, NIKI, gjpk);
                                        System.out.println("Berhasil dibuat seharusnya!");
                                        Menu();
                                    } else {
                                        if (buatK == 3) {
                                            System.out.print("Gaji honorer : ");
                                            int gjh = sc.nextInt();

                                            daftarKaryawan[indi] = new DosenHonorer(nama, email, pass, stat, NIKI, gjh);
                                            System.out.println("Berhasil dibuat seharusnya!");
                                            Menu();
                                        } else {
                                            System.out.println("pilihan tidak ada tolong ulang dari awal :D");
                                            Menu();
                                        }
                                    }
                                }
                            }
                        } else {
                            if (pilihK == 3) {// Edit
                                System.out.println("ini adalah Karyawan - karyawan yang laggi ada");
                                for (int i = 0; i < daftarKaryawan.length; i++) {
                                    if (daftarKaryawan[i] != null) {
                                        System.out.println((1 + i) + " ." + daftarKaryawan[i].getNama() + " , Role : "
                                                + daftarKaryawan[i].getNik());
                                    }
                                }

                                System.out.println("Mau Edit Yang mana ?");
                                int pilihKar = sc.nextInt();
                                sc.nextLine();

                                if (daftarKaryawan[pilihKar] != null) {
                                    System.out.print("Email : ");
                                    String email = sc.nextLine();
                                    System.out.print("Password : ");
                                    String pass = sc.nextLine();
                                    System.out.print("Status :");
                                    String stat = sc.nextLine();
                                    System.out.println("Nik : ");
                                    String NIKI = sc.nextLine();

                                    if (daftarKaryawan[pilihKar].getType() == TipeUser.DOSEN_TETAP) {
                                        System.out.print("Gaji Pokok : ");
                                        int gjpk = sc.nextInt();

                                        System.out.print("Gaji Honorer : ");
                                        int gjh = sc.nextInt();

                                        daftarKaryawan[pilihKar].setEmail(email);
                                        daftarKaryawan[pilihKar].setPassword(pass);
                                        daftarKaryawan[pilihKar].setStatus(stat);
                                        daftarKaryawan[pilihKar].setNik(NIKI);
                                        ((DosenTetap) daftarKaryawan[pilihKar]).setGajiPokok(gjpk);
                                        ((DosenTetap) daftarKaryawan[pilihKar]).setHonorPerSks(gjh);
                                    } else {
                                        if (daftarKaryawan[pilihKar].getType() == TipeUser.STAFF) {
                                            System.out.print("Gaji Pokok : ");
                                            int gjpk = sc.nextInt();

                                            daftarKaryawan[pilihKar].setEmail(email);
                                            daftarKaryawan[pilihKar].setPassword(pass);
                                            daftarKaryawan[pilihKar].setStatus(stat);
                                            daftarKaryawan[pilihKar].setNik(NIKI);
                                            ((Staff) daftarKaryawan[pilihKar]).setGajiPokok(gjpk);
                                        } else {
                                            if (daftarKaryawan[pilihKar].getType() == TipeUser.DOSEN_HONORER) {
                                                System.out.print("Gaji Honorer : ");
                                                int gjh = sc.nextInt();

                                                daftarKaryawan[pilihKar].setEmail(email);
                                                daftarKaryawan[pilihKar].setPassword(pass);
                                                daftarKaryawan[pilihKar].setStatus(stat);
                                                daftarKaryawan[pilihKar].setNik(NIKI);
                                                ((DosenHonorer) daftarKaryawan[pilihKar]).setHonorPerSks(gjh);
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (pilihK == 4) {// Delete
                                    System.out.println("ini adalah Karyawan - karyawan yang laggi ada");
                                    for (int i = 0; i < daftarKaryawan.length; i++) {
                                        if (daftarKaryawan[i] != null) {
                                            System.out
                                                    .println((1 + i) + " ." + daftarKaryawan[i].getNama() + " , Role : "
                                                            + daftarKaryawan[i].getNik());
                                        }
                                    }

                                    System.out.println("Siapa yang mau di delete?");
                                    int delete = sc.nextInt();

                                    delete--;
                                    for (int i = delete; i < daftarKaryawan.length - 1; i++) {
                                        daftarKaryawan[i] = daftarKaryawan[i + 1];
                                    }

                                    daftarKaryawan[daftarKaryawan.length - 1] = null;
                                    System.out.println("Berhasil Di Delete");
                                    Menu();
                                } else {
                                    if (pilihK == 5) {// Hitung Gaji ahihihihihi
                                        System.out.println("ini adalah Karyawan - karyawan yang laggi ada");
                                        for (int i = 0; i < daftarKaryawan.length; i++) {
                                            if (daftarKaryawan[i] != null) {
                                                System.out
                                                        .println((1 + i) + " ." + daftarKaryawan[i].getNama()
                                                                + " , Role : "
                                                                + daftarKaryawan[i].getNik());
                                            }
                                        }

                                        System.out.println("Pilih karyawan yang ingin dihitung gajinya ");
                                        int pilihhitunggaji = sc.nextInt();

                                        pilihhitunggaji--;
                                        if (daftarKaryawan[pilihhitunggaji].getType() == TipeUser.DOSEN_TETAP) {
                                            System.out.println("Tolong Masukan Total Sks dari dosen ini ");
                                            int totsks = sc.nextInt();

                                            int totalGaji = daftarKaryawan[pilihhitunggaji].hitungGaji(totsks);
                                            System.out.println("Gaji dosen ini adalah : " + totalGaji);

                                        } else if (daftarKaryawan[pilihhitunggaji].getType() == TipeUser.STAFF) {
                                            int totalGaji = daftarKaryawan[pilihhitunggaji].hitungGaji(0);
                                            System.out.println("Gaji dosen ini adalah : " + totalGaji);

                                        } else if (daftarKaryawan[pilihhitunggaji]
                                                .getType() == TipeUser.DOSEN_HONORER) {
                                            System.out.println("Tolong Masukan Total Sks dari dosen ini ");
                                            int totsks = sc.nextInt();

                                            int totalGaji = daftarKaryawan[pilihhitunggaji].hitungGaji(totsks);
                                            System.out.println("Gaji dosen ini adalah : " + totalGaji);
                                        }
                                    } else {
                                        System.out.println("Pilihan tidak ada!");
                                        Menu();
                                    }
                                }
                            }
                        }
                    }
                } // boborok kayaknya aku bikin file baru buat menu dari pada gini
                break;

            default:
                break;
        }
    }

    public static void main(String[] args) {
        new MainApp().start();
    }
}