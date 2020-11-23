package com.revature.DAO;

import com.revature.models.Employee;
import com.revature.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public  class EmployeeDAO {

    static public void newEmployee(Employee emp){
        Session ses = HibernateUtil.getSession();
        ses.beginTransaction();
        ses.save(emp);
        ses.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    static public List<Employee> getEmployees(){
        Session ses = HibernateUtil.getSession();
        return ses.createQuery("from Employee ",Employee.class).list();
    }
    //Returns a specific employee.
    static public Employee getEmployeeFromID(int id){
        Session ses = HibernateUtil.getSession();
        return ses.load(Employee.class,id);
    }

    static public Employee getEmployeeFromUsername(String user){
        Session ses = HibernateUtil.getSession();
        String sqlQuery = "Select ID from "
        criteriaBuilder.like()

    }

    static public void update(Employee emp){
        Session ses = HibernateUtil.getSession();
        Transaction tx = ses.beginTransaction();
        ses.update(emp);
        tx.commit();
    }

    static public void removeEmployee(Employee emp){
        Session ses = HibernateUtil.getSession();
        Transaction tx = ses.beginTransaction();
        ses.remove(emp);
        tx.commit();
    }

}
