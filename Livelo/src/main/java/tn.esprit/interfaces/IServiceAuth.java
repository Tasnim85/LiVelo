package tn.esprit.interfaces;

import tn.esprit.models.User;

public interface IServiceAuth {
    String login(String cin, String password);
}
