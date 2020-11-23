package com.revature.DAO;

import com.revature.models.Employee;
import com.revature.utils.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.xml.transform.Result;
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
        return ses.get(Employee.class,id);
    }

    static public Employee getEmployeeFromUsername(String user){
        Session ses = HibernateUtil.getSession();
        String sql = String.format("From Employee e where e.username = %s",user);
        Query query = ses.createSQLQuery(sql);
        return (Employee) query.getResultList().get(0);
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
