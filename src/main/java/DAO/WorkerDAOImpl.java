package DAO;

import model.Worker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class WorkerDAOImpl implements DAO<Worker, Integer> {

    private final SessionFactory sessionFactory;

    public WorkerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Worker worker) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
//
        session.saveOrUpdate(worker);
//
        session.getTransaction().commit();
    }

    @Override
    public Worker read(Integer integer) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
//
        Worker worker = session.get(Worker.class, integer);
//
        session.getTransaction().commit();
        return worker;
    }

    @Override
    public List readAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
//
        Query readAll = session.createQuery("from Worker");
        java.util.List listWorkers = readAll.list();
//
        session.getTransaction().commit();
        return listWorkers;
    }

    @Override
    public void updateById(Worker worker) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
//
        session.saveOrUpdate(worker);
//
        session.getTransaction().commit();
    }

    @Override
    public void delete(Integer integer) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
//
        Worker worker = session.get(Worker.class, integer);
        session.delete(worker);
//
        session.getTransaction().commit();
    }

    @Override
    public void deleteAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
//
        Query deleteWorkers = session.createQuery("FROM Worker");
        List workersToDelete = deleteWorkers.list();
        for (Object o : workersToDelete) {
            session.delete(o);
        }
//
        session.getTransaction().commit();
    }
}
