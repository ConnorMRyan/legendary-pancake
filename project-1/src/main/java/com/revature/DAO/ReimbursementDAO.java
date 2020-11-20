package com.revature.DAO;

import com.revature.models.Reimbursement;
import com.revature.utils.HibernateUtil;
import org.hibernate.Session;

import java.sql.Timestamp;

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
        return ses.load(Reimbursement.class,ID);
    }

    //U

    public static void resolveReimbursement(Reimbursement reimbursement,int status, int resolverID){
        Session ses = HibernateUtil.getSession();
        ses.beginTransaction();
        int id = reimbursement.getId();
        reimbursement.setStatus(status);
        reimbursement.setResolverID(resolverID);
        ses.createQuery("update Reimbursement ers set ers.resolved = current_timestamp where ers.id = :id").setParameter("id",id);
        ses.getTransaction().commit();
        HibernateUtil.closeSession();

    }


}
