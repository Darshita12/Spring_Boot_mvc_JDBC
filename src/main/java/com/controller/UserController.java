package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class UserController {

	@Autowired
	UserDao userDao;
	
	@RequestMapping("/")
	public String email(Model model)
	{
		model.addAttribute("userBean",new UserBean());
		return "Reg";
	}

	@RequestMapping("/p")
	public String home(Model model) {
		model.addAttribute("userBean", new UserBean());
		return "addUser";
	}

	@PostMapping("/insertuser")
	public String addUser(UserBean userBean) {
		int res = userDao.addUser(userBean);
		return "redirect:viewuser";
	}

	@GetMapping("/viewuser")
	public String getData(Model model) {
		List<UserBean> listOfUser = userDao.getData();
		model.addAttribute("users", listOfUser);
		return "ViewUser";
	}

	@GetMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable int id) {
		int res = userDao.deleteUser(id);
		return "redirect:/viewuser";
	}

	@RequestMapping("/ediuser/{id}")
	public String editUser(@PathVariable int id, Model model) {
		model.addAttribute("userBean", new UserBean());
		return "UpdateUser";
	}

	@PostMapping("/updateuser/{id}")
	public String updateUser(@PathVariable int id, UserBean userBean) {
		userDao.updateUser(userBean);
		return "redirect:/viewuser";
	}
	
	/*
	 * @RequestMapping("/") public String email(Model model) {
	 * model.addAttribute("userBean",new UserBean()); return "Reg"; }
	 * 
	 * @PostMapping("/sendm") public String sendMail(UserBean
	 * userBean,HttpServletRequest request) { String
	 * email=request.getParameter("email"); userBean.setEmail(email);
	 * 
	 * userBean=userDao.frgtpwd(userBean); return null; }
	 */

}
