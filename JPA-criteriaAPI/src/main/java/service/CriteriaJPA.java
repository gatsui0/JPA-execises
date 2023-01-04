package service;

import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class CriteriaJPA {
    public static void main(String[] args){

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = emfactory.createEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
        Root<Employee> from = criteriaQuery.from(Employee.class);

        //select all records
        System.out.println("Select all records");
        CriteriaQuery<Object> select = criteriaQuery.select(from);
        TypedQuery<Object> typedQuery = entityManager.createQuery(select);
        List<Object> resultList = typedQuery.getResultList();

        for (Object o : resultList){
            Employee e = (Employee) o;
            System.out.println("EID : " + e.getEid() + " Ename : " + e.getEname());
        }

        //ordering the records
        System.out.println("ordering the records");
        CriteriaQuery<Object> select1 = criteriaQuery.select(from);
        select1.orderBy(criteriaBuilder.asc(from.get("ename")));
        TypedQuery<Object> typedQuery1 = entityManager.createQuery(select1);
        List<Object> resultList1 = typedQuery1.getResultList();

        for (Object o : resultList1){
            Employee e = (Employee) o;
            System.out.println("EID : " + e.getEid() + " Ename : " + e.getEname());
        }

        entityManager.close( );
        emfactory.close( );

    }
}
