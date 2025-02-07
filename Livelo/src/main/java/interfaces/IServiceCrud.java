package interfaces;

import java.util.List;

public interface IServiceCrud<T> {
    // Ajouter un élément
    void add(T t);

    // Lire un élément par ID
    T getById(int id);

    // Lire tous les éléments
    List<T> getAll();

    // Mettre à jour un élément
    void update(T t);

    // Supprimer un élément
    void delete(int id);
}
