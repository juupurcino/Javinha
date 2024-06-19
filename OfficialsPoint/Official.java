public class Official {

    private String name;
    private Long cpf;
    private int date_of_birth;
    private int password;
    private boolean admin;
    
    public Official(String name, Long cpf, int date_of_birth, int password, boolean admin) {
        
        this.name = name;
        this.cpf = cpf;
        this.date_of_birth = date_of_birth;
        this.password = password;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Long getCpf() {
        return cpf;
    }
    
    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
    
    public int getDate_of_birth() {
        return date_of_birth;
    }
    
    public void setDate_of_birth(int date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
    
    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
