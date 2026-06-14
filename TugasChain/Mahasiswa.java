public class Mahasiswa extends User {
    private String nim;
    private String tahunMasuk;
    private String tahunKelulusan;

    public Mahasiswa(String email, String password, String status, String nim,String nama, String tahunMasuk, String tahunKelulusan) {
        super(email, nama, password, status, TipeUser.MAHASISWA);

        this.nim = nim;
        this.tahunMasuk = tahunMasuk;
        this.tahunKelulusan = tahunKelulusan;
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
    
    public String getTahunMasuk() {
        return tahunMasuk;
    }

    public void setTahunMasuk(String tahunMasuk) {
        this.tahunMasuk = tahunMasuk;
    }

    public String getTahunKelulusan() {
        return tahunKelulusan;
    }

    public void setTahunKelulusan(String tahunKelulusan) {
        this.tahunKelulusan = tahunKelulusan;
    }

    public double hitungIp(PengambilanMatkul[][] Pmatkul , int indexMhs){
        double totalNilaiSks = 0.0;
        int totalSks = 0;
        
        for (int i = 0; i < Pmatkul[indexMhs].length; i++) {
            if(Pmatkul[indexMhs][i] != null){
                int nilaiasli = Pmatkul[indexMhs][i].getNilai();
                int sksMatkul = Pmatkul[indexMhs][i].getMatakuliah().getSks();

                double bobot = 0.0;
                if(nilaiasli >= 80){
                    bobot = 4.0;
                }else{
                    if(nilaiasli >= 70){
                        bobot = 3.0;
                    }else{
                        if(nilaiasli >= 60){
                            bobot = 2.0;
                        }else{
                            if(nilaiasli >= 50){
                                bobot = 1.0;
                            }else{
                                bobot = 0.0;
                            }
                        }
                    }
                }

                totalNilaiSks += bobot * sksMatkul;
                totalSks += sksMatkul;
            }
        }

        if (totalSks == 0){
            return 0.0;
        }

        return totalNilaiSks / totalSks;
    }
}