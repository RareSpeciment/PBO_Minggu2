package weeklychain.view;

import java.util.List;
import java.util.Scanner;
import weeklychain.model.*;
import weeklychain.repository.MahasiswaRepository;
import weeklychain.repository.MatakuliahRepository;
import weeklychain.repository.NilaiRepository;
import weeklychain.enums.TipeUser;
import weeklychain.enums.UserStatus;

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
        Mhs[0] = new Mahasiswa("Mahakarya@gmail.com", "123123", "AKTIF", "12345", "qwerty", "12 Januari 2024",
                "12 January 2028");
        Mhs[1] = new Mahasiswa("Ma@gmail.com", "wasd", "AKTIF", "22345", "burpy", "12 Januari 2025", "12 January 2029");

        Pmatkul[0][0] = new PengambilanMatkul(Mhs[0], Matkul[0], 100);
        Pmatkul[0][1] = new PengambilanMatkul(Mhs[0], Matkul[1], 80);
        Pmatkul[1][0] = new PengambilanMatkul(Mhs[1], Matkul[0], 90);

        daftarKaryawan[0] = new DosenTetap("Udin", "DosenT@Gmail.com", "12345", "AKTIF", "DT001", 4500000, 500000);
        daftarKaryawan[1] = new Staff("Rufos", "Staff@gmail.com", "09876", "AKTIF", "ST001", 3500000);
        daftarKaryawan[2] = new DosenHonorer("Skari", "DosenH@gmail.com", "qwerty", "AKTIF", "DH001", 400000);
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
                menuMatakuliah();
                break;

            case 2: // Menu Mahasiswa
                menuMahasiswa();
                break;

            case 3: // Menu Mahasiswa - Matakuliah
                menuMahasiswaDanMatakuliah();
                break;

            case 4: // Menu List berdasarkan Matakuliah
                printBerdasarkanListMatakuliah();
                break;

            case 5: // Menu List berdasarkan Mahasiswa
                printBerdasarkanListMahasiswa();
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

    public void menuMatakuliah() {
        System.out.println("===================");
        System.out.println("1. Tambah Matakuliah");
        System.out.println("2. Edit Matakuliah");
        System.out.println("0. Menu");
        int opsiMatkul = sc.nextInt();
        sc.nextLine();

        switch (opsiMatkul) {
            case 1:
                tambahMatkul();
                break;
            
            case 2:
                editMatkul();
                break;
            
            case 0:
                Menu();
                break;
            default:
                break;
        }
    }

    public void menuMahasiswa() {
        System.out.println("===================");
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Edit Mahasiswa");
        System.out.println("3. Hitung IP");
        System.out.println("0. Menu");
        int opsiMahasigma = sc.nextInt();

        switch (opsiMahasigma) {
            case 1:
                tambahMhs();
                break;

            case 2:
                updateMhs();
                break;

            case 3:
                hitungIPMhs();
                break;

            case 0:
                Menu();
                break;

            default:
                break;
        }
    }

    public void menuMahasiswaDanMatakuliah() {
        System.out.println("===================");
        System.out.println("1. Tambah");
        System.out.println("2. Edit");
        System.out.println("0. Menu");
        System.out.println("Tolong pilih");
        int pilihan = sc.nextInt();

        switch (pilihan) {
            case 1:
                tambahPengambilanMatakuliah();
                break;

            case 2:
                updatePengambilanMatakuliah();
                break;

            case 0:
                Menu();
                break;
        
            default:
                break;
        }
    }

    public void printBerdasarkanListMatakuliah() {
        System.out.println("================");
        System.out.println("Mata kuliah apa yang ingin dilihat ?");
        for (int i = 0; i < 10; i++) {
            if (Matkul[i] != null) { // Tambahkan pengecekan ini
                System.out.println(Matkul[i].getNama());
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
    }

    public void printBerdasarkanListMahasiswa() {
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
    }

    public void tambahMhs() {
        List<Mahasiswa> allMahasiswa = MahasiswaRepository.getAllMahasiswa();
        System.out.println("\n Daftar Mahasiswa:");
        for (Mahasiswa m : allMahasiswa) {
            System.out.println(m.nomor_induk + " - " + m.nama + " (" + m.kode_jurusan + ")");
        }

        System.out.println();
        System.out.print("Masukkan NIM: ");
        String nim = sc.nextLine();

        System.out.print("Masukkan Nama: ");
        String nama = sc.nextLine();

        System.out.print("Masukkan Email: ");
        String email = sc.nextLine();

        System.out.print("Masukkan Password: ");
        String password = sc.nextLine();

        System.out.print("Masukkan Kode Jurusan: ");
        String kodeJurusan = sc.nextLine();

        System.out.print("Masukkan Tanggal Masuk (YYYY-MM-DD): ");
        String tanggalMasuk = sc.nextLine();

        Mahasiswa mhs = new Mahasiswa(
                nim, nama, email, password,
                UserStatus.AKTIF, TipeUser.MAHASISWA,
                tanggalMasuk, null,
                kodeJurusan);
        MahasiswaRepository.addMahasiswa(mhs);

        System.out.println("Mahasiswa Terdaftar");
        Menu();
    }

    public void updateMhs() {
        List<Mahasiswa> allMahasiswa = MahasiswaRepository.getAllMahasiswa();
        System.out.println("\n Daftar Mahasiswa:");
        for (Mahasiswa m : allMahasiswa) {
            System.out.println(m.nomor_induk + " - " + m.nama + " (" + m.kode_jurusan + ")");
        }

        System.out.println("Mau Update Mahasiswa yang mana?");
        System.out.print("Masukkan NIM mahasiswa yang ingin diupdate: ");
        String nim = sc.nextLine().trim();

        Mahasiswa existing = MahasiswaRepository.getMahasiswaByNim(nim);
        if (existing == null) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
            Menu();
            return;
        }

        System.out.println("Biarkan kosong untuk mempertahankan nilai lama.");

        System.out.print("Nama [" + existing.nama + "]: ");
        String nama = sc.nextLine();
        if (nama.isEmpty())
            nama = existing.nama;

        System.out.print("Email [" + existing.email + "]: ");
        String email = sc.nextLine();
        if (email.isEmpty())
            email = existing.email;

        System.out.print("Password [" + existing.password + "]: ");
        String password = sc.nextLine();
        if (password.isEmpty())
            password = existing.password;

        System.out.print("Status (AKTIF/NON_AKTIF/CUTI) [" + existing.status + "]: ");
        String statusStr = sc.nextLine().trim();
        UserStatus status = existing.status;
        if (!statusStr.isEmpty()) {
            try {
                status = UserStatus.valueOf(statusStr);
            } catch (IllegalArgumentException e) {
                System.out.println("Status tidak valid, menggunakan nilai lama.");
            }
        }

        System.out.print("Tanggal Masuk (YYYY-MM-DD) [" + existing.tanggal_masuk + "]: ");
        String tanggalMasuk = sc.nextLine();
        if (tanggalMasuk.isEmpty())
            tanggalMasuk = existing.tanggal_masuk;

        System.out.print("Tanggal Keluar (YYYY-MM-DD) ["
                + (existing.tanggal_keluar == null ? "" : existing.tanggal_keluar) + "]: ");
        String tanggalKeluar = sc.nextLine();
        if (tanggalKeluar.isEmpty())
            tanggalKeluar = existing.tanggal_keluar;

        System.out.print("Kode Jurusan [" + existing.kode_jurusan + "]: ");
        String kodeJurusan = sc.nextLine();
        if (kodeJurusan.isEmpty())
            kodeJurusan = existing.kode_jurusan;

        Mahasiswa mhs = new Mahasiswa(
                nim,
                nama,
                email,
                password,
                status,
                TipeUser.MAHASISWA,
                tanggalMasuk,
                tanggalKeluar,
                kodeJurusan);

        MahasiswaRepository.updateMahasiswa(mhs);
        System.out.println("Mahasiswa berhasil diupdate.");
        Menu();
    }

    public void hitungIPMhs() {
        List<Mahasiswa> allMahasiswa = MahasiswaRepository.getAllMahasiswa();
        System.out.println("\n Daftar Mahasiswa IP:");
        for (Mahasiswa m : allMahasiswa) {
            System.out.println(m.nomor_induk + " - " + m.nama + " (" + m.kode_jurusan + ")");
        }

        System.out.println("Mau Hitung IP dari Mahasiswa yang mana?");
        String nim = sc.nextLine().trim();

        Mahasiswa ada = MahasiswaRepository.getMahasiswaByNim(nim);
        if (ada == null) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
            Menu();
            return;
        }

        List<PengambilanMatkul> nilaiMhs = NilaiRepository.getNilaiByNim(ada);
        if (nilaiMhs == null || nilaiMhs.isEmpty()) {
            System.out.println("Belum ada data nilai untuk mahasiswa ini.");
            Menu();
            return;
        }

        System.out.println("Daftar Nilai:");
        for (PengambilanMatkul pm : nilaiMhs) {
            if (pm.getMatakuliah() != null) {
                System.out.println(pm.getMatakuliah().getKode() + " - " + pm.getMatakuliah().getNama() + " : " + pm.getNilai());
            } else {
                System.out.println("(matakuliah tidak diketahui) : " + pm.getNilai());
            }
        }

        double ip = ada.hitungIPMahasiswa(nilaiMhs);
        System.out.println("IP Mahasiswa " + ada.nama + " : " + ip);
        Menu();
    }





    public void tambahMatkul(){
        List<Matakuliah> allMatkul = MatakuliahRepository.getAllMatakuliah();
        System.out.println("\n Daftar Matakuliah:");
        for (Matakuliah m : allMatkul) {
            System.out.println(m.getKode() + " - " + m.getNama() + m.getSks() + " (" + m.getKode_jurusan() + ")");
        }

        System.out.println();
        System.out.print("Masukkan kode Matakuliah: ");
        String nim = sc.nextLine();

        System.out.print("Masukkan Nama: ");
        String nama = sc.nextLine();

        System.out.print("Masukkan sks: ");
        int sks = sc.nextInt();
        sc.nextLine();

        System.out.print("Masukkan kode Jurusan: ");
        String kode_jurusan = sc.nextLine();

        Matakuliah mk = new Matakuliah(
                nim, nama, sks, kode_jurusan);
        MatakuliahRepository.addMatakuliah(mk);

        System.out.println("Matakuliah Terdaftar");
        Menu();
    }

    public void editMatkul(){
        List<Matakuliah> allMatkul = MatakuliahRepository.getAllMatakuliah();
        System.out.println("\n Daftar Matakuliah:");
        for (Matakuliah m : allMatkul) {
            System.out.println(m.getKode() + " - " + m.getNama() + m.getSks() + " (" + m.getKode_jurusan() + ")");
        }

        System.out.println("Mau Edit Matkul yang mana?");
        System.out.print("Masukkan kode matakuliah yang ingin diupdate: ");
        String pilihkode = sc.nextLine().trim();

        Matakuliah existing = MatakuliahRepository.getMatakuliahByKode(pilihkode);
        if (existing == null) {
            System.out.println("Matakuliah dengan NIM " + pilihkode + " tidak ditemukan.");
            Menu();
            return;
        }

        System.out.print("kode [" + existing.getKode() + "]: ");
        String kode = sc.nextLine().trim();
        if (kode.isEmpty())
            kode = existing.getNama();

        System.out.print("Nama [" + existing.getNama() + "]: ");
        String nama = sc.nextLine().trim();
        if (nama.isEmpty())
            nama = existing.getNama();

        System.out.print("sks [" + existing.getSks() + "]: ");
        String isks = sc.nextLine().trim();
        int sks;
        if (isks.isEmpty()) {
            sks = existing.getSks();
        }else{
            try {
                sks = Integer.parseInt(isks);
            } catch (NumberFormatException e) {
                System.out.println("Input SKS tidak valid, menggunakan nilai sebelumnya.");
                sks = existing.getSks();
            }
        }

        System.out.print("Kode Jurusan [" + existing.getKode_jurusan() + "]: ");
        String kodeJurusan = sc.nextLine().trim();
        if (kodeJurusan.isEmpty())
            kodeJurusan = existing.getKode_jurusan();

        Matakuliah mk = new Matakuliah(
                kode, nama, sks, kodeJurusan);
        MatakuliahRepository.updateMatakuliah(mk);
        System.out.println("Matakuliah berhasil diupdate.");
        Menu();
    }




    public void tambahPengambilanMatakuliah(){
        List<PengambilanMatkul> allPMatkul = NilaiRepository.getAllNilai();
        System.out.println("\n Daftar Mahasiswa & Matakuliah:");
        for (PengambilanMatkul m : allPMatkul) {
            System.out.println(m.getMahasiswa() + " - " + m.getMatakuliah() + m.getNilai());
        }

        System.out.println();
        System.out.print("Masukkan Nomor_induk: ");
        String nik = sc.nextLine().trim();

        System.out.print("Masukkan Kode_matakuliah: ");
        String kodematkul = sc.nextLine().trim();

        System.out.print("Masukkan Nilai: ");
        int nilai  = sc.nextInt();

        Mahasiswa mhs = MahasiswaRepository.getMahasiswaByNim(nik);
        if (mhs == null) { System.out.println("Nomor_induk tidak ada"); Menu(); return;}

        Matakuliah mk = MatakuliahRepository.getMatakuliahByKode(kodematkul);
        if (mk == null) {System.out.println("Kode_Matakuliah Tidak ada"); Menu(); return;}

        PengambilanMatkul pm = new PengambilanMatkul(mhs, mk, nilai);
        NilaiRepository.tambahPengambilanMatakuliah(pm);

        System.out.println("Matakuliah Terdaftar");
        Menu();
    }

    public void updatePengambilanMatakuliah(){
        List<PengambilanMatkul> allPMatkul = NilaiRepository.getAllNilai();
        System.out.println("\n Daftar Mahasiswa & Matakuliah:");
        for (PengambilanMatkul m : allPMatkul) {
            System.out.println(m.getMahasiswa() + " - " + m.getMatakuliah() + m.getNilai());
        }

        System.out.println("Mau Update Nilai Mahasiswa yang mana?");
        System.out.println("Masukan Nomor_induk Mahasiswa :");
        String nik = sc.nextLine().trim();

        System.out.println("Masukan Kode_matakuliah : ");
        String kode_matkul = sc.nextLine().trim();

        PengambilanMatkul existing = NilaiRepository.getNilaiPengambilanByFK(nik, kode_matkul);
        if (existing == null) {
            System.out.println("Matakuliah dengan NIM " + nik + " & " + kode_matkul + " tidak ditemukan.");
            Menu();
            return;
        }

        System.out.println("Menjadi Nilai berapa ? ");
        String upnilai = sc.nextLine().trim();
        int nil;
        if(upnilai.isEmpty()){
            nil = existing.getNilai();
        }else{
            try {
                nil = Integer.parseInt(upnilai);
            } catch (NumberFormatException e) {
                System.out.println("Input nilai tidak valid, menggunakan nilai sebelumnya.");
                nil = existing.getNilai();
            }
        }
        
    }

    public static void main(String[] args) {
        new MainApp().start();
    }
}