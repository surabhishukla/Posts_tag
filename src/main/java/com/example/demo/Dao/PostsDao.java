package com.example.demo.Dao;

import com.example.demo.Entity.Posts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PostsDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addPosts(Posts posts) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(posts);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public Posts getPostsById(String id, Session session) {
        session = sessionFactory.getCurrentSession();
        Posts posts = session.get(Posts.class, id);
        return posts;
    }

    public List<Posts> getPosts() {
        Session session = sessionFactory.getCurrentSession();
        List<Posts> postsList = session.createQuery("from posts", Posts.class).list();
        return postsList;
    }

    public void deletePosts(String id) {
        Session session = sessionFactory.getCurrentSession();
        Posts posts = getPostsById(id, session);
        try {
            session.delete(posts);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updatePosts(String id, Posts posts) {
        Session session = sessionFactory.getCurrentSession();
        session.update(id, posts);
    }
}
