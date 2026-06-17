package weeklychain.model;

import weeklychain.enums.TipeUser;
import weeklychain.enums.UserStatus;

public class Karyawan extends User {
    private String nik;

    public Karyawan(String nama, String email, String password, String status, TipeUser type, String nik) {
        // nomor_induk for Karyawan is the NIK
        super(nik, nama, email, password, UserStatus.valueOf(status), type, "", "");
        this.nik = nik;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public int hitungGaji(int jumlahSks) {
        return 0;
    }
}