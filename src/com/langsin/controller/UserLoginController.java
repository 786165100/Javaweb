package com.langsin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.langsin.pojo.EasyUIDataGridResult;
import com.langsin.pojo.User;
import com.langsin.service.BookinfoService;
import com.langsin.service.UserService;

@Controller
@RequestMapping("/user") // 窄化请求
public class UserLoginController {

	@Autowired
	private UserService userService = null;

	@Autowired
	private BookinfoService bookinfoService = null;

	@RequestMapping(value = { "/login.action" }, consumes = "application/json;charset=utf-8")
	public @ResponseBody User queryUser(@RequestBody User user) {

		User user1 = null;
		try {
			user1 = userService.queryUser(user.getEmail(), user.getPass());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(user.getEmail() + user.getPass());
		System.out.println(user1);

		return user1;

	}

	@RequestMapping(value = { "/signUp.action" }, consumes = "application/json;charset=utf-8")
	public @ResponseBody User insertUser(@RequestBody User user) {

		try {
			userService.insertUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(user.getEmail() + user.getPass());
		System.out.println("注册成功！");
		return user;

	}

	@RequestMapping("/list.action")
	public @ResponseBody EasyUIDataGridResult queryBookinfoList(int page, int rows) throws Exception {
		EasyUIDataGridResult result = bookinfoService.queryBookinfoList(page, rows);
		System.out.println("-------------------------------123");
		return result;
	}

	// @RequestMapping(value={"/login.action"},method={RequestMethod.POST})
	// public ModelAndView queryUser(HttpServletRequest request){
	// String username = request.getParameter("username");
	// String password = request.getParameter("password");
	// User user = null;
	// try {
	// user = userService.queryUser(username, password);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// ModelAndView mav = new ModelAndView();
	// System.out.println(user);
	// mav.addObject("user", user);
	// mav.setViewName("loginok");
	// return mav;
	// }

	@RequestMapping("/userList.action")
	public String queryUserList(HttpServletRequest request) throws Exception {
		List<User> userList = null;
		try {
			userList = userService.queryUserList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("userList", userList);
		// 返回逻辑视图：就是找jsp的路径和url没有关系
		return "user/userList";
	}

}
