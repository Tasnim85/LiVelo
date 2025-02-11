package test;

    import main.tn.esprit.models.User;
    import models.role_user;
    import models.type_vehicule;
    import services.CrudUser;


    public class mainUser {
        public static void main(String[] args) {
            User user = new User(
                    "Benhassine",
                    "Tasnim",
                    role_user.delivery_person,
                    true,
                    "tunis",
                    type_vehicule.e_bike,
                    "tasnim.benhassine@esprit.tn",
                    "123",
                    "28740885",
                    "17011727"
            );
            CrudUser crudUser = new CrudUser();
            crudUser.delete(18);
            crudUser.add(user);
            crudUser.getAll();

            user.setAdresse("Sousse");
            user.setEmail("tasnim.sousse@esprit.tn");
            crudUser.update(user);
            crudUser.getAll();
        }
    }
