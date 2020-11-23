package com.revature.models;

 enum EMPLOYEE_ROLE {

     EMPLOYEE(1,"Employee"),MANAGER(2,"Manager"),ADMIN(3,"Admin");

     private EMPLOYEE_ROLE(int ID,String roleName){
        this.ID = ID;
        this.ROLE_NAME = roleName;
    }

     private int ID;
     private String ROLE_NAME;

     public int getID() {
         return ID;
     }

     public String getROLE_NAME() {
         return ROLE_NAME;
     }
 }
