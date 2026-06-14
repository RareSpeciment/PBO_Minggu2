public class DosenTetap extends Karyawan {
    private int gajiPokok;
    private int honorPerSks;

    public DosenTetap (String nama, String email, String password, String status, String nik, int gajiPokok, int honorPerSks){
        super(nama, email, password, status, TipeUser.DOSEN_TETAP, nik);

        this.gajiPokok = gajiPokok;
        this.honorPerSks = honorPerSks;
    }

    public int getGajiPokok() {
        return gajiPokok;
    }

    public void setGajiPokok(int gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    public int getHonorPerSks() {
        return honorPerSks;
    }

    public void setHonorPerSks(int honorPerSks) {
        this.honorPerSks = honorPerSks;
    }

    public int hitungGaji(int totalSks){
        return getGajiPokok() + (getHonorPerSks() * totalSks);
    }
}