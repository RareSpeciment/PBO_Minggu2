package weeklychain.model;

import weeklychain.enums.UserStatus;
import java.util.List;
import weeklychain.enums.TipeUser;

public class Mahasiswa extends User {
    public String nim;
    public String kode_jurusan;

    public Mahasiswa(String nim, String nama, String email, String password, UserStatus status, TipeUser type, String tanggal_masuk, String tanggal_keluar, String kode_jurusan) {
        super(nim, nama, email, password, status, type, tanggal_masuk, tanggal_keluar);

        this.nim = nim;
        this.kode_jurusan = kode_jurusan;
    }

    // Compatibility constructor used by MainApp (email, password, status, nim, nama, tanggal_masuk, tanggal_keluar)
    public Mahasiswa(String email, String password, String statusStr, String nim, String nama, String tanggal_masuk, String tanggal_keluar) {
        super(nim, nama, email, password, UserStatus.valueOf(statusStr), TipeUser.MAHASISWA, tanggal_masuk, tanggal_keluar);
        this.nim = nim;
        this.kode_jurusan = "";
    }

    public Mahasiswa(String nim, String nama, String status) {
        this("", "", status, nim, nama, "", "");
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getKode_jurusan() {
        return kode_jurusan;
    }

    public void setKode_jurusan(String kode_jurusan) {
        this.kode_jurusan = kode_jurusan;
    }

    public double hitungIPMahasiswa(List<PengambilanMatkul> daftarNilai) {
        double totalNilaiSks = 0.0;
        int totalSks = 0;

        for (PengambilanMatkul pm : daftarNilai) {
            if (pm == null) continue;
            int nilai = pm.getNilai();
            int sks = pm.getMatakuliah() != null ? pm.getMatakuliah().getSks() : 0;

            double bobot;
            if (nilai >= 80) bobot = 4.0;
            else if (nilai >= 70) bobot = 3.0;
            else if (nilai >= 60) bobot = 2.0;
            else if (nilai >= 50) bobot = 1.0;
            else bobot = 0.0;

            totalNilaiSks += bobot * sks;
            totalSks += sks;
        }

        if (totalSks == 0) return 0.0;
        return totalNilaiSks / totalSks;
    }
}