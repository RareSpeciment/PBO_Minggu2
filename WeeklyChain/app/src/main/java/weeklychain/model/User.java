package weeklychain.model;

import weeklychain.enums.UserStatus;
import weeklychain.enums.TipeUser;

public class User {
    public String nomor_induk;
    public String nama;
    public String email;
    public String password;
    public UserStatus status;
    public String tanggal_masuk;
    public String tanggal_keluar;
    public TipeUser type;

    public User(String nomor_induk, String nama, String email, String password, UserStatus status, TipeUser type,
            String tanggal_masuk, String tanggal_keluar) {
        this.nomor_induk = nomor_induk;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.status = status;
        this.type = type;
        this.tanggal_masuk = tanggal_masuk;
        this.tanggal_keluar = tanggal_keluar;
    }

    public String getNomor_induk() {
        return nomor_induk;
    }

    public void setNomor_induk(String nomor_induk) {
        this.nomor_induk = nomor_induk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    // Accept status as String for backward compatibility
    public void setStatus(String statusStr) {
        this.status = UserStatus.valueOf(statusStr);
    }

    public String getTanggal_masuk() {
        return tanggal_masuk;
    }

    public void setTanggal_masuk(String tanggal_masuk) {
        this.tanggal_masuk = tanggal_masuk;
    }

    public String getTanggal_keluar() {
        return tanggal_keluar;
    }

    public void setTanggal_keluar(String tanggal_keluar) {
        this.tanggal_keluar = tanggal_keluar;
    }

    public TipeUser getType() {
        return type;
    }

    public void setType(TipeUser type) {
        this.type = type;
    }

    
}
