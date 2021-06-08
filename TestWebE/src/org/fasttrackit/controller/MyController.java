package org.fasttrackit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fasttrackit.dao.UserDAO;
import org.fasttrackit.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	static boolean  setLoginSuperAdmin =true;
	
	@RequestMapping(value="new-admin.htm")
	public ModelAndView newUser() throws SQLException {
		
		return new ModelAndView("WEB-INF/Register/newuser.jsp");
		
	}
	
	
	// redirect to adminregister.jsp
		@RequestMapping(value="register-admin.htm")
		public ModelAndView adminRegister() throws SQLException {
			ModelMap model = new ModelMap();
			UserDAO udao = new UserDAO();
			User usr =new User();
			ArrayList<User> listUsr = new ArrayList<User>();
			listUsr = udao.getUser();
			model.put("listUsr", listUsr);
			return new ModelAndView("WEB-INF/Register/adminregister.jsp","model",model);
			
		}
		
		//Insert New User collect and validate data from adminregister.jsp
				@RequestMapping(value="new-user.htm")
				public ModelAndView insertNewUser(@ModelAttribute("newuser") User newUser,
						Model model,BindingResult result, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
					response.setContentType("text/html");
					PrintWriter out=response.getWriter();
					request.getRequestDispatcher("index.html").include(request, response);
					
					UserDAO udao = new UserDAO();
				///	ArrayList<User> userList = new ArrayList<User>();
					//PasswordUtils utilPassword = new PasswordUtils();
					 String generatePassword = "adbcas";
					 String saltWord = "FDGsdg";
					// userList=udao.getUser();
					
					 String fullName 
						= request.getParameter("fullName");
		
						 newUser.setFullName(fullName);
						 newUser.setEmail("fwgfsa@gfhs");
						 newUser.setPhoneNumber("df34624");
					     newUser.setSalt(saltWord);
					     newUser.setPassword(generatePassword);
					     newUser.setRole("USER");
					     newUser.setStatute("FORBIDDEN");
					
					udao.insertUser(newUser);	
					
					 return new ModelAndView("redirect:/register-admin.htm");
					   
					 
					
					          }
				
				
	
}
