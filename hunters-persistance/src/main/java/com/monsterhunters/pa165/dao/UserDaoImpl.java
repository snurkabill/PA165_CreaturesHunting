package com.monsterhunters.pa165.dao;

import com.monsterhunters.pa165.entity.Comment;
import com.monsterhunters.pa165.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Created by Snurka on 10/30/2016.
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findById(UUID id) {
        if(id == null) {
            throw new IllegalArgumentException("Id can't ne null");
        }
        return entityManager.find(User.class, id);
    }

    @Override
    public User findByNickname(String nickname) {
        if(nickname == null) {
            throw new IllegalArgumentException("Nickname can't ne null");
        }
        try {
            return entityManager.createQuery("select c from User c where c.nickname = :nickname", User.class)
                    .setParameter("nickname", nickname)
                    .getSingleResult();
        } catch (NoResultException nrf) {
            return null;
        }
    }

    @Override
    public User findByEmail(String email) {
        if(email == null) {
            throw new IllegalArgumentException("Email can't ne null");
        }
        try {
            return entityManager
                    .createQuery("select u from User u where u.email = :email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select l from User l", User.class)
                .getResultList();
    }

    @Override
    public void create(User user) {
        if(user == null) {
            throw new IllegalArgumentException("User can't ne null");
        }
        entityManager.persist(user);
    }

    @Override
    public void delete(User user) throws IllegalArgumentException {
        if(user == null) {
            throw new IllegalArgumentException("User can't ne null");
        }
        List<Comment> commentList = getCommentsByUser(user);
        for(Comment comment: commentList) {
            entityManager.remove(comment);
        }
        entityManager.remove(user);
    }

    private List<Comment> getCommentsByUser(User user) {
        if(user == null) {
            throw new IllegalArgumentException("User can't ne null");
        }
        try {
            return entityManager.createQuery("Select c from Comment c where c.user= :user", Comment.class)
                    .setParameter("user", user)
                    .getResultList();
        } catch (NoResultException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void update(User user) {
        if(user == null) {
            throw new IllegalArgumentException("User can't ne null");
        }
        entityManager.merge(user);
    }
}
