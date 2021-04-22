package com.project.phonedir.repository;

import com.project.phonedir.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class UserRepository {

    // EntityManagerFactory
    @PersistenceUnit(unitName = "d2qmbrs1nsovi2")
    private EntityManagerFactory entityManagerFactory;

    public boolean registerUser(User newUser) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(newUser);
            transaction.commit();
            return true;

        } catch (Exception e) {

            System.out.println(e.getMessage());
            transaction.rollback();
            return false;
        }
    }
    public User checkCredentials(String username) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            //TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class);
            TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
            query.setParameter("username", username);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
