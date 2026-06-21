package weeklychain.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import weeklychain.database.Database;
import weeklychain.model.Mahasiswa;
import weeklychain.model.Matakuliah;
import weeklychain.model.PengambilanMatkul;

public class NilaiRepository {
    private static final Connection conn;

    static {
        conn = Database.connect();
    }

    private static PengambilanMatkul mapRow(ResultSet rs) throws SQLException {
        String nomor = rs.getString("nomor_induk");
        Mahasiswa mhs = MahasiswaRepository.getMahasiswaByNim(nomor);

        String kodeMk = rs.getString("kode_matakuliah");
        String namaMk = rs.getString("nama");
        int sks = rs.getInt("sks");
        String kode_Matkul = rs.getString("kode_matkul");
        double nilaiD = rs.getDouble("nilai");
        int nilai = rs.wasNull() ? 0 : (int) Math.round(nilaiD);

        Matakuliah mk = new Matakuliah(kodeMk, namaMk, sks, kode_Matkul);
        return new PengambilanMatkul(mhs, mk, nilai);
    }

    private static PengambilanMatkul mapRow(ResultSet rs, Mahasiswa mhs) throws SQLException {
        String kodeMk = rs.getString("kode_matakuliah");
        String namaMk = rs.getString("nama");
        int sks = rs.getInt("sks");
        String kode_Matkul = rs.getString("kode_matkul");
        double nilaiD = rs.getDouble("nilai");
        int nilai = rs.wasNull() ? 0 : (int) Math.round(nilaiD);

        Matakuliah mk = new Matakuliah(kodeMk, namaMk, sks, kode_Matkul);
        return new PengambilanMatkul(mhs, mk, nilai);
    }

    public static List<PengambilanMatkul> getNilaiByNim(Mahasiswa mhs) {
        List<PengambilanMatkul> result = new ArrayList<>();
        String sql = """
                SELECT mm.nomor_induk, mm.kode_matakuliah, mm.nilai, m.nama, m.sks
                FROM mahasiswa_matakuliah mm
                JOIN matakuliah m ON mm.kode_matakuliah = m.kode_matakuliah
                WHERE mm.nomor_induk = ?
                """;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, mhs.nomor_induk);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(mapRow(rs, mhs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<PengambilanMatkul> getNilaiByNim(String nim) {
        Mahasiswa mhs = MahasiswaRepository.getMahasiswaByNim(nim);
        if (mhs == null)
            return new ArrayList<>();
        return getNilaiByNim(mhs);
    }

    public static void tambahPengambilanMatakuliah(PengambilanMatkul pm){
        String sql ="""
                INSERT INTO "mahasiswa_matakuliah" (
                    "nomor_induk", "kode_matakuliah", "nilai"
                ) VALUES (?, ?, ?)
                """;
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pm.getMahasiswa().getNomor_induk());
            stmt.setString(2, pm.getMatakuliah().getNama());
            stmt.setInt(3, pm.getNilai());
            stmt.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePengambilanMatakuliah(PengambilanMatkul pm){
        String sql ="""
                UPDATE "mahasiswa_matakuliah" (
                    "nomor_induk" = ?, "kode_matakuliah" = ?, "nilai" = ?
                ) WHERE "nomor_induk" = ? AND "kode_matakuliah" = ?
                """;
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pm.getMahasiswa().getNomor_induk());
            stmt.setString(2, pm.getMatakuliah().getNama());
            stmt.setInt(3, pm.getNilai());
            stmt.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static List <PengambilanMatkul> getAllNilai(){
        List <PengambilanMatkul> result = new ArrayList<>();
        String sql = """
                SELECT "nomor_induk", "kode_matakuliah", "nilai"
                FROM "mahasiswa_matakuliah"
                """;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(mapRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static PengambilanMatkul getNilaiPengambilanByFK(String nik, String kode_matkul){
        String sql = """
                SELECT mm.nomor_induk, mm.kode_matakuliah, mm.nilai, m.nama, m.sks
                FROM mahasiswa_matakuliah mm
                JOIN matakuliah m ON mm.kode_matakuliah = m.kode_matakuliah
                WHERE mm.nomor_induk = ?
                """;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nik);
            stmt.setString(2, kode_matkul);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapRow(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}