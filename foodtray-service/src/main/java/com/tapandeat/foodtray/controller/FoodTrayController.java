package com.tapandeat.foodtray.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tapandeat.foodtray.model.Account;
import com.tapandeat.foodtray.model.Items;
import com.tapandeat.foodtray.model.Login;
import com.tapandeat.foodtray.service.AccountService;
import com.tapandeat.foodtray.service.CustomerService;
import com.tapandeat.foodtray.service.RestaurantService;
import com.tapandeat.foodtray.service.StoreService;

/**
 * Main controller used for accessing the application
 * 
 * @author vipin sahu
 *
 */
@RestController
public class FoodTrayController {

	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private StoreService storeService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping(value = "/account")
	public Items getStoreById() {
		return restaurantService.findItemById(Long.valueOf(1000));
	}
	
	@GetMapping(value="/signin")
	public ModelAndView signUp(HttpServletRequest request) {
		ModelAndView model= new ModelAndView();
		model.setViewName("signin");
		return model;
	}
	
	@PostMapping(value = "/login")
	public ModelAndView loginUser(@ModelAttribute("loginModel") Login login,HttpServletRequest request) {
		ModelAndView model=new ModelAndView();
		Account account;
		if(login.getUserName().contains(".com") &&  login.getUserName().contains("@")) {
			account=accountService.getAccountByEmail(login.getUserName());
		}
		else {
			account=accountService.getAccountByUserName(login.getUserName());
		}
		if(account != null && accountService.validateUser(login)) {
			request.getSession().setAttribute("username", account.getUserName());
		}
		else {
			model.setViewName("signin");
			return model;
		}
		model.setViewName("index");
		List<Items> itemsRepo=restaurantService.findAllItems();
		List<Items> items=new ArrayList<Items>();
		int lastIndex=itemsRepo.size() < 6?itemsRepo.size():6;
		items.addAll(itemsRepo.subList(0, lastIndex));
		model.addObject("stores",storeService.findAll());
		model.addObject("customers", customerService.findAll());
		model.addObject("items", items);
		return model;
	}
	
	@GetMapping(value="/signout")
	public ModelAndView signOut(HttpServletRequest request) {
		request.getSession().setAttribute("username", "");
		ModelAndView model=new ModelAndView("index");
		List<Items> itemsRepo=restaurantService.findAllItems();
		List<Items> items=new ArrayList<Items>();
		int lastIndex=itemsRepo.size() < 6?itemsRepo.size():6;
		items.addAll(itemsRepo.subList(0, lastIndex));
		model.addObject("stores",storeService.findAll());
		model.addObject("customers", customerService.findAll());
		model.addObject("items", items);
		return model;
	}
	
	@GetMapping(value = "/index")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView model= new ModelAndView();
		HttpSession session = request.getSession();
		if(session.getAttribute("username")!= null && session.getAttribute("username").toString().length()<=0)
			session.setAttribute("username", "");
		List<Items> itemsRepo=restaurantService.findAllItems();
		List<Items> items=new ArrayList<Items>();
		int lastIndex=itemsRepo.size() < 6?itemsRepo.size():6;
		items.addAll(itemsRepo.subList(0, lastIndex));
		model.addObject("stores",storeService.findAll());
		model.addObject("customers", customerService.findAll());
		model.addObject("items", items);
		model.setViewName("index");
		return model;
	}
	
	@GetMapping(value = "/menu")
	public ModelAndView menu(HttpServletRequest request) {
		ModelAndView model= new ModelAndView();
		model.addObject("stores",storeService.findAll());
		model.addObject("customers", customerService.findAll());
		model.addObject("items", restaurantService.findAllItems());
		model.addObject("cuisines", restaurantService.findAllCuisine());
		model.setViewName("Menu");
		return model;
	}
}
