package com.controller.foodproduct;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FoodDao;
import com.dto.FoodProduct;
import com.dto.Menu;
import com.dto.User;

@WebServlet("/createFoodProduct")
public class CreateFoodProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User branchmanager = (User) req.getSession().getAttribute("branchmanager");
//		int menuId=branchmanager.getMenu().getId();//fetch menu Id
		Menu menu = branchmanager.getMenu();// object of Menu type

		FoodProduct fp = new FoodProduct();// create the food Product object
		// createFoodProduct?name=CHICKEN+TANDooRI&type=non_veg&about=FULL+CHICKEN+ROAST&price=599
		fp.setName(req.getParameter("name"));
		fp.setType(req.getParameter("type"));
		fp.setAbout(req.getParameter("about"));
		fp.setPrice(Double.parseDouble(req.getParameter("price")));
		fp.setAvailability(false);//

		fp.setMenus(Arrays.asList(menu));
		// store the data in database
		FoodDao foodDao = new FoodDao();
		foodDao.createFoodProduct(fp);

		resp.getWriter().print("<h1>FooD PRoduct Created Successfully</h1>");
		req.getRequestDispatcher("menu.jsp").include(req, resp);

	}

}
