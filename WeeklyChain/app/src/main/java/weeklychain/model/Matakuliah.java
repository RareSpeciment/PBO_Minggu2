package weeklychain.model;

public class Matakuliah {
    String kode;
    String nama;
    int sks;
    String kode_jurusan;

    public Matakuliah(String kode, String nama, int sks, String kode_jurusan) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
        this.kode_jurusan = kode_jurusan;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public String getKode_jurusan() {
        return kode_jurusan;
    }

    public void setKode_jurusan(String kode_jurusan) {
        this.kode_jurusan = kode_jurusan;
    }
}