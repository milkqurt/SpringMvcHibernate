package mvc_hibernate.service;

import mvc_hibernate.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployee();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);
    //если метод ничего не возвращает,ставить надо void
    public void deleteEmployee(int id);

}
