package net.partsList.dao;

import net.partsList.model.Parts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PartsDaoImpl implements PartsDao  {
    private static final Logger logger = LoggerFactory.getLogger(PartsDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Transactional
    public void addParts(Parts parts) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(parts);
        logger.info("Parts successfully saved. Parts details: " + parts);
    }

    @Transactional
    public void updateParts(Parts parts) {
    Session session = this.sessionFactory.getCurrentSession();
    session.update(parts);
    logger.info("Parts successfully update. Parts details: " + parts);
    }


    @Transactional
    public void removeParts(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Parts parts = (Parts) session.load(Parts.class, new Integer(id));
        if(parts!=null){
            session.delete(parts);
        }
        logger.info("Parts successfully remove. Parts details: " + parts);

    }


    @Transactional
    public Parts getPartsById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Parts parts = (Parts) session.get(Parts.class,new Integer(id));
        logger.info("Parts successfully loaded. Parts details: " + parts);
        return parts;
    }


    @Transactional
    public List<Parts> listParts() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Parts> partsList = session.createQuery("from Parts").list();
        for(Parts parts : partsList)
        {
            logger.info("Parts list: " + parts);
        }return partsList;
    }
}
