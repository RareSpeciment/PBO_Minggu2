public class DosenHonorer extends Karyawan {
    private int honorPerSks;

    public DosenHonorer(String nama, String email, String password, String status, String nik, int honorPerSks) {
        super(nama, email, password, status, TipeUser.DOSEN_HONORER, nik);
        this.honorPerSks = honorPerSks;
    }

    public int getHonorPerSks() {
        return honorPerSks;
    }

    public void setHonorPerSks(int honorPerSks) {
        this.honorPerSks = honorPerSks;
    }

    public int hitungGaji(int totalSks){
        return (getHonorPerSks() * totalSks);
    }
}
