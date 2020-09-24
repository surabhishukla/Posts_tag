package com.example.demo.Dao;

import com.example.demo.Entity.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TagDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addTag(Tag tag) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(tag);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public Tag getTagById(String id) {
        Session session = sessionFactory.getCurrentSession();
        Tag tag = session.get(Tag.class, id);
        return tag;
    }

    public void deleteTag(String id) {
        Session session = sessionFactory.getCurrentSession();
        Tag tag = getTagById(id);
        try {
            session.delete(tag);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateTag(Tag tag) {
        Session session = sessionFactory.getCurrentSession();
        session.update(tag);
    }

    public List<Tag> getTags() {
        Session session = sessionFactory.getCurrentSession();
        List<Tag> TagList = session.createQuery("from tag", Tag.class).list();
        return TagList;
    }
}
