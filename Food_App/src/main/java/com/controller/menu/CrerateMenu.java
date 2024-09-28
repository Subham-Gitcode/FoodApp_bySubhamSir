package com.controller.menu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MenuDao;
import com.dao.UserDao;
import com.dto.Menu;
import com.dto.User;

@WebServlet("/crerateMenu")
public class CrerateMenu extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		User branchmanager = (User)req.getSession().getAttribute("branchmanager");
		
		int branchManagerId=Integer.parseInt(req.getParameter("id"));
		
		UserDao userDao=new UserDao();
		User bm = userDao.findUserById(branchManagerId);//branch Manager Object
		
		if(bm.getMenu()==null)
		{
			Menu menu = new Menu();//menu object
			
		       //mapping
				menu.setUser(bm);
				
				MenuDao menuDao=new MenuDao();
				menuDao.saveMenu(menu);//store in databasess
				
				resp.getWriter().print("<h1>Menu Created Succesfully</h1>");
				req.getRequestDispatcher("menu.jsp").include(req, resp);
		} 
		else
		{
			resp.getWriter().print("<h1>Menu Already Creayed </h1>");
			req.getRequestDispatcher("menu.jsp").include(req, resp);
		}
		
	
	}

}
