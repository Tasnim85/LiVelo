package tn.esprit.test;

    import tn.esprit.models.User;
    import tn.esprit.models.role_user;
    import tn.esprit.models.type_vehicule;
    import tn.esprit.services.Authentification;
    import tn.esprit.services.CrudUser;


public class mainUser {
    public static void main(String[] args) {
        User user = new User(
                "Benhassine",
                "Tasnim",
                "tunis",
                "tasnim.benhassine1@esprit.tn",
                "28740885",
                "48455027",
                "123456",
                role_user.delivery_person,
                type_vehicule.e_bike
        );
        CrudUser crudUser = new CrudUser();
        //crudUser.delete(19);
        crudUser.add(user);
        crudUser.getAll();

        /*user.setAdresse("Sousse");
        user.setEmail("tasnim.sousse@esprit.tn");
        crudUser.update(user);
        crudUser.getAll();*/
        //crudUser.getById(1);

        /*Authentification authentification = new Authentification();
        String token = authentification.login("48475027", "123456");*/

        crudUser.search("48475027");
    }
}
