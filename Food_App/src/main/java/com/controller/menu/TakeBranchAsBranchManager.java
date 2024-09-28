package com.controller.menu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BrachDao;
import com.dto.Branch;
import com.dto.User;

@WebServlet("/takeBranchAsBranchManager")
public class TakeBranchAsBranchManager extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int branchId = Integer.parseInt(req.getParameter("id"));
		//map with branch manager
		User branchmanager = (User)req.getSession().getAttribute("branchmanager");//branchManager
		
		//find Branch
		
		BrachDao brachDao=new BrachDao();
		Branch branch = brachDao.findBranchById(branchId);//branch
		//set Status to true
		branch.setStatus(true);
		List<User> listOfUser = branch.getUsers();
		
		listOfUser.add(branchmanager);//mapping
		//
		brachDao.createBranch(branch);//store into database
		
	
		
		resp.getWriter().print("<h1>"+branchId  +"</h1>");
	
	}

}
