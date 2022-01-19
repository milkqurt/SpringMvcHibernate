package mvc_hibernate.dao;

import mvc_hibernate.entity.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class EmployeeDAOimpl implements EmployeeDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {

        Session session = sessionFactory.getCurrentSession();
        List<Employee> AllEmployee = session.createQuery("from Employee",Employee.class)
                .getResultList();

        return AllEmployee;
    }

    @Override
    public void saveEmployee(Employee employee) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(employee);

    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();

        Employee employee = session.get(Employee.class,id);

        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query =session.createQuery("delete from Employee " +
                "where id=:employeeId");
        query.setParameter("employeeId",id);
        query.executeUpdate();
    }
}
