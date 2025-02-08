package models;

public class User {
    private int id;
    private String nom,prenom,adresse,email,num_tel,cin,password;
    private boolean verified;
    role_user role;
    private type_vehicule type_vehicule;

    public User(){}

    public User(int id, String nom, String prenom,role_user role,boolean verified,  String adresse,  models.type_vehicule type_vehicule,String email, String password,String num_tel, String cin) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.num_tel = num_tel;
        this.cin = cin;
        this.password = password;
        this.verified = verified;
        this.role = role;
        this.type_vehicule = type_vehicule;
    }

    public User(String nom, String prenom, role_user role,boolean verified,String adresse,models.type_vehicule type_vehicule, String email, String password,String num_tel, String cin ) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.num_tel = num_tel;
        this.cin = cin;
        this.password = password;
        this.verified = verified;
        this.role = role;
        this.type_vehicule = type_vehicule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public role_user getRole() {
        return role;
    }

    public void setRole(role_user role) {
        this.role = role;
    }

    public models.type_vehicule getType_vehicule() {
        return type_vehicule;
    }

    public void setType_vehicule(models.type_vehicule type_vehicule) {
        this.type_vehicule = type_vehicule;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                ", num_tel='" + num_tel + '\'' +
                ", cin='" + cin + '\'' +
                ", password='" + password + '\'' +
                ", verified=" + verified +
                ", role=" + role +
                ", type_vehicule=" + type_vehicule +
                "}";
    }
}
