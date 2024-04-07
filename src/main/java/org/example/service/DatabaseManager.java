package org.example.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import lombok.NoArgsConstructor;
import org.example.model.Chat;

import java.util.List;

@NoArgsConstructor
public class DatabaseManager {
    public Chat getChatByName(String name){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("roomChat");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Chat findChat = entityManager.find(Chat.class, name);

        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();

        return findChat;
    }
    public void addRoom(String name, Integer maxMembers){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("roomChat");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Chat chat = new Chat();

        chat.setName(name);
        chat.setMaxMembers(maxMembers);

        entityManager.persist(chat);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
    }

    public void removeRoom(String name){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("roomChat");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Chat findChat = entityManager.find(Chat.class, name);

        System.out.println(findChat.getName());

        entityManager.remove(findChat);

        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }

    public void changeName(String oldName, String newName){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("roomChat");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Chat> criteriaUpdate = cb.createCriteriaUpdate(Chat.class);
        Root<Chat> root = criteriaUpdate.from(Chat.class);
        criteriaUpdate.set("oldName", newName);
        criteriaUpdate.where(cb.equal(root.get("oldName"), oldName));

        entityManager.createQuery(criteriaUpdate).executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }

    public boolean alreadyExists(String name){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("roomChat");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Chat findChat = entityManager.find(Chat.class, name);

        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();

        if(findChat == null){
            return false;
        } else {
            return true;
        }
    }

    public List getChatList(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("roomChat");
        EntityManager entityManager = factory.createEntityManager();

        Query query = entityManager.createQuery("from chat c");

        List chat = query.getResultList();

        return chat;
    }
}