package org.fasttrackit.helper;

import java.sql.SQLException;
import java.util.ArrayList;

import org.fasttrackit.dao.UserDAO;
import org.fasttrackit.pojo.User;

public class TestMain {

	public static void main(String[] args) {
		UserDAO udao = new UserDAO();
		System.out.println("Nr");
		try {
			udao.createTableUser();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Test");
		User usr =new User("Patcas Florentina","+40743556569", "patcasf12@gmail.com","salt","generatePassword","ADMIN","ACTIVE");
		try {
			udao.insertUser(usr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<User> listUsr = new ArrayList<User>();
		try {
			listUsr = udao.getUser();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(User usr1:listUsr) {
System.out.println("Nr "+usr1.getId()+" Nume "+usr1.getFullName());
		}
	}
	
}

