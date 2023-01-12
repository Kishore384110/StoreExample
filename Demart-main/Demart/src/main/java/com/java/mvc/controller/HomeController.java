package com.java.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.mvc.dao.StoreDaoImpl;
import com.java.mvc.model.Store;

@Controller
public class HomeController {
	
	@Autowired
	StoreDaoImpl dao;
	
	@RequestMapping(value = "/addStore")
	public ModelAndView addStore(HttpServletRequest req) {
		Store store = new Store();
		store.setProductName(req.getParameter("productName"));
		store.setQuantity(Integer.parseInt(req.getParameter("quantity")));
		store.setPrice(Integer.parseInt(req.getParameter("price")));
		dao.addStore(store);
		return new ModelAndView("redirect:/");
	}
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		List<Store> storelist = dao.showStore();
		return new ModelAndView("home","storelist",storelist);
	}
	
	@RequestMapping(value="/newStore")
	public ModelAndView addStore() {
		return new ModelAndView("addStore");
	}
	
	@RequestMapping(value="/deleteStore")
	public ModelAndView deleteDemart(HttpServletRequest req) {
		int storeId=Integer.parseInt(req.getParameter("storeId"));
		dao.deleteStore(storeId);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/editStore")
	public ModelAndView search(HttpServletRequest req) {
		int storeId = Integer.parseInt(req.getParameter("storeId"));
		Store store = dao.searchStore(storeId);
		return new ModelAndView("storesearchform","store",store);
	}
	
	@RequestMapping(value="/updateStore")
	public ModelAndView updateDemart(HttpServletRequest req) {
		Store store = new Store();
		store.setStoreId(Integer.parseInt(req.getParameter("storeId")));
		store.setProductName(req.getParameter("productName"));
		store.setQuantity(Integer.parseInt(req.getParameter("quantity")));
		store.setPrice(Integer.parseInt(req.getParameter("price")));
		dao.updateStore(store);
		return new ModelAndView("redirect:/");
	}
	
}
