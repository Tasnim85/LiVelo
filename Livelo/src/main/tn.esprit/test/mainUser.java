package test;

    import models.User;
    import models.role_user;
    import models.type_vehicule;
    import services.CrudUser;


    public class mainUser {
        public static void main(String[] args) {
            User user = new User(
                    "bahloul",
                    "malak",
                    role_user.client,
                    true,
                    "tunis",
                    type_vehicule.e_bike,
                    "malak.bahloul@esprit.tn",
                    "5555",
                    "28740885",
                    "0000000"
            );
            CrudUser crudUser = new CrudUser();
            crudUser.delete(22);
            crudUser.add(user);
            crudUser.getAll();

            user.setAdresse("ariana");
            user.setEmail("bhl.55@esprit.tn");
            crudUser.update(user);
            crudUser.getAll();
        }
    }
