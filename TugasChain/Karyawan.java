public class Karyawan extends User {
    private String nik;

    public Karyawan(String nama, String email, String password, String status, TipeUser type, String nik) {
        super(email, nama, password, status, type);
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