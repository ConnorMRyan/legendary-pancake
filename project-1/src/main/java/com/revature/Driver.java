package com.revature;

import com.revature.DAO.EmployeeDAO;
import com.revature.DAO.ReimbursementDAO;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.utils.ImageConvert;
import com.revature.utils.JsonBuilder;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Driver {

	public static void main(String[] args) throws IOException {
		//Employee employee = new Employee("connor","ryan","cats","admin","catbutt@butts",3);
		Employee connor = EmployeeDAO.getEmployeeFromUsername("testCat");
		Reimbursement rs = ReimbursementDAO.getReimbursement(17);
		System.out.println(JsonBuilder.makeJSON(connor));

	}
}
