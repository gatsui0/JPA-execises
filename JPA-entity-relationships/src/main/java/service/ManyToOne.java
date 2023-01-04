package service;

import entity.Department;
import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ManyToOne {
    public static void main(String[] args){
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = emfactory.createEntityManager();
        entityManager.getTransaction().begin();

        //Create Department Entity
        Department department = new Department();
        department.setName("Development");

        //Store Department
        entityManager.persist(department);

        //Create Employee1 Entity
        Employee employee1 = new Employee();
        employee1.setEname("Satish");
        employee1.setSalary(45000.0);
        employee1.setDeg("Technical Writer");
        employee1.setDepartment(department);

        //Create Employee2 Entity
        Employee employee2 = new Employee();
        employee2.setEname("Krishna");
        employee2.setSalary(45000.0);
        employee2.setDeg("Technical Writer");
        employee2.setDepartment(department);

        //Create Employee3 Entity
        Employee employee3 = new Employee();
        employee3.setEname("Masthanvali");
        employee3.setSalary(50000.0);
        employee3.setDeg("Technical Writer");
        employee3.setDepartment(department);

        //Store Employees
        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.persist(employee3);

        entityManager.getTransaction().commit();
        entityManager.close();
        emfactory.close();
    }
}

