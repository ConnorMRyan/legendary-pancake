package com.revature;

import com.revature.DAO.ReimbursementDAO;
import com.revature.models.Reimbursement;
import com.revature.utils.ImageConvert;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Driver {

	public static void main(String[] args) throws IOException {
		ReimbursementDAO.resolveReimbursement(ReimbursementDAO.getReimbursement(17),2,4);
		System.out.println("Hopefully je123nki112312323ns now works. ");

	}
}
