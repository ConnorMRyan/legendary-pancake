package com.revature.DAO;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.utils.HibernateUtil;
import org.hibernate.Session;
import com.google.gson.Gson;


import java.sql.Timestamp;
import java.util.List;

public class ReimbursementDAO {
    //C
    public static void newReimbursement(Reimbursement reimbursement){
        Session ses = HibernateUtil.getSession();
        ses.beginTransaction();
        ses.save(reimbursement);
        ses.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    //R
    public static Reimbursement getReimbursement(int ID){
        Session ses = HibernateUtil.getSession();
        return ses.get(Reimbursement.class,ID);
    }
    public static List<Reimbursement> getReimbursments(){
        Session ses = HibernateUtil.getSession();
        return ses.createQuery("from Reimbursement ",Reimbursement.class).list();
    }

    //U

    public static void resolveReimbursement(Reimbursement reimbursement,int status, int resolverID){
        Session ses = HibernateUtil.getSession();
        ses.beginTransaction();
        int id = reimbursement.getId();
        reimbursement.setStatus(status);
        reimbursement.setResolverID(resolverID);
        ses.createQuery("update Reimbursement ers set ers.resolved = current_timestamp where ers.id = :id", Reimbursement.class).setParameter("id",id);
        ses.getTransaction().commit();
        HibernateUtil.closeSession();

    }

    public static void toJSON(Reimbursement reimbursement){

    }


}
