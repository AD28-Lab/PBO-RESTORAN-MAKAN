

public class Login {
    private String username_customer, password_customer, username_admin, password_admin; //variabel login

    public Login(){ //memberikan nilai variable
        username_customer = "iuser";
        password_customer = "uuser";
        username_admin = "iadmin";
        password_admin = "uadmin";
    }

    public String getUsername_user() {
        return username_customer;
    }

    public void setUsername_user(String username_user) {
        this.username_customer = username_user;
    }

    public String getPassword_user() {
        return password_customer;
    }

    public void setPassword_user(String password_user) {
        this.password_customer = password_user;
    }

    public String getUsername_admin() {
        return username_admin;
    }

    public void setUsername_admin(String username_admin) {
        this.username_admin = username_admin;
    }

    public String getPassword_admin() {
        return password_admin;
    }

    public void setPassword_admin(String password_admin) {
        this.password_admin = password_admin;
    }

    public boolean login(String username, String password) {
        return false;
    }

    public boolean isAdmin(String username) {
        return false;
    }
}
