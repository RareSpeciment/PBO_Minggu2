package weeklychain.model;

import weeklychain.enums.TipeUser;

public class Staff extends Karyawan {
    private int gajiPokok;

    public Staff(String nama, String email, String password, String status, String nik, int gajiPokok) {
        super(nama, email, password, status, TipeUser.STAFF, nik);

        this.gajiPokok = gajiPokok;
    }

    public int getGajiPokok() {
        return gajiPokok;
    }

    public void setGajiPokok(int gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    //kurang tau mau ngitung pake apa ini, tapi katnya pakai gaji pokok sxaja jadi yasudah lah
    public int hitungGaji() {
        return getGajiPokok();
    }
}
