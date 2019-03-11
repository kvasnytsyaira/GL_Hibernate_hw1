package DAO;

import model.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.List;

public class DepartmentDAOImpl implements DAO<Department, Integer> {

    private final SessionFactory sessionFactory;

    public DepartmentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Department department) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
//
        session.saveOrUpdate(department);
//
        session.getTransaction().commit();
    }

    @Override
    public Department read(Integer integer) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
//
        Department department = session.get(Department.class, integer);
//
        session.getTransaction().commit();
        return department;
    }

    @Override
    public List readAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
//
        Query readAllDepartments = session.createQuery("from Department");
        java.util.List listDepartments = readAllDepartments.list();
//
        session.getTransaction().commit();
        return listDepartments;
    }

    @Override
    public void updateById(Department department) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
//
        session.saveOrUpdate(department);
//
        session.getTransaction().commit();
    }

    @Override
    public void delete(Integer integer) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
//
        Department department = session.get(Department.class, integer);
        Query findWorkersToDelete = session.createQuery("from Worker where departmentId= " + integer);
        java.util.List workersToDelete = findWorkersToDelete.list();
        for (Object o : workersToDelete) {
            session.delete(o);
        }
        session.delete(department);
//
        session.getTransaction().commit();
    }

    @Override
    public void deleteAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
//
        Query findWorkersToDelete = session.createQuery("from Worker");
        java.util.List workersToDelete = findWorkersToDelete.list();
        for (Object o : workersToDelete) {
            session.delete(o);
        }
        Query deleteDepartments = session.createQuery("from Department ");
        List departmentsToDelete = deleteDepartments.list();
        for (Object o : departmentsToDelete) {
            session.delete(o);
        }
//
        session.getTransaction().commit();
    }
}
