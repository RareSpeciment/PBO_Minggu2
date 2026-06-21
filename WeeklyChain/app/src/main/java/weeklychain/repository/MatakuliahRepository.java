package weeklychain.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import weeklychain.database.Database;
import weeklychain.model.Matakuliah;

public class MatakuliahRepository {
    private static final Connection conn;

    static {
        conn = Database.connect();
    }

    private static Matakuliah mapRow(ResultSet rs) throws SQLException {
        String kode_matkul = rs.getString("kode_matakuliah");
        String nama = rs.getString("nama");
        int sks = rs.getInt("sks");
        String kode_jurusan = rs.getString("kode_jurusan");
        return new Matakuliah(kode_matkul, nama, sks, kode_jurusan);
    }

    //readddd
    public static List<Matakuliah> getAllMatakuliah() {
        List<Matakuliah> list = new ArrayList<>();
        String sql = "SELECT kode_matakuliah, nama, sks, kode_jurusan FROM matakuliah";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) list.add(mapRow(rs));
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    //add
    public static void addMatakuliah(Matakuliah mk){
        String sql ="""
                INSERT INTO "matakuliah" (
                    "kode_matakuliah", "nama", "sks", "kode_jurusan"
                    ) VALUES (?, ?, ?, ?)
                """;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, mk.getKode());
            stmt.setString(2, mk.getNama());
            stmt.setInt(3, mk.getSks());
            stmt.setString(4, mk.getKode_jurusan());
            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void updateMatakuliah(Matakuliah mk) {
        String sql = """
                UPDATE "user"
                SET "kode_matakuliah" = ?, "nama" = ?, "sks" = ?, "kode_jurusan" = ?
                WHERE "kode_matakuliah" = ? AND "type" = 'MAHASISWA'::user_type
                """;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, mk.getKode());
            stmt.setString(2, mk.getNama());
            stmt.setInt(3, mk.getSks());
            stmt.setString(4, mk.getKode_jurusan());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Matakuliah getMatakuliahByKode(String kode){
        String sql = """
                SELECT kode_matakuliah, nama, sks, kode_jurusan FROM matakuliah" 
                FROM "Matakuliah"
                WHERE "kode_matakuliah" = ?
                """;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, kode);
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
