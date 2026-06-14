public class User {
    private String email;
    private String nama;
    private String password;
    private String status;
    private TipeUser type;

    public User(String email, String nama, String password, String status, TipeUser type){
        this.email = email;
        this.nama = nama;
        this.password = password;
        this.status = status;
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TipeUser getType() {
        return type;
    }

    public void setType(TipeUser type) {
        this.type = type;
    }

    public int hitungGaji(int totalSks){
        return 0;
    }
}
