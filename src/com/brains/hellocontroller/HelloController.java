package com.brains.hellocontroller;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController{

	@RequestMapping("/welcome/{user}")
	protected ModelAndView helloworld(@PathVariable("user") String name) throws Exception {
		ModelAndView modelandview = new ModelAndView("HelloPage");
		modelandview.addObject("welcomeMessage","Hi " + name);
		return modelandview;
	}

	@RequestMapping("/welcome/{sur}/{name}")
	protected ModelAndView hello(@PathVariable Map<String,String> pathVars) throws Exception {
		String surname = pathVars.get("sur");
		String lastname = pathVars.get("name");
		
		ModelAndView modelandview = new ModelAndView("HelloPage");
		modelandview.addObject("welcomeMessage","Hi "+ surname + " "+ lastname);
		return modelandview;
	}
	
	@RequestMapping("/book")
	public ModelAndView add() throws Exception {
		ModelAndView m = new ModelAndView("AddForm");
		return m;
	}
	
//	@RequestMapping(value="/add_book", method=RequestMethod.POST)
//	public ModelAndView add_book(@RequestParam("bookName") String bookName, @RequestParam("bookYear") int bookYear) throws Exception {
//		ModelAndView m = new ModelAndView("BookDisplay");
//		m.addObject("bookName", bookName);
//		m.addObject("bookYear", bookYear);
//		return m;
//	}
	
//	@RequestMapping(value="/add_book", method=RequestMethod.POST)
//	public ModelAndView add_book(@RequestParam("bookName") String bookName, @RequestParam("bookYear") int bookYear) throws Exception {
//		ModelAndView m = new ModelAndView("BookDisplay");
//		Book x = new Book();
//		x.setBookName(bookName);
//		x.setBookYear(bookYear);
//		m.addObject("book", x);
//		return m;
//	}
	
	@ModelAttribute
	public void addCommonObjects(Model model1) {
		model1.addAttribute("general", "This is the page footer");
	}
	
	@RequestMapping(value="/add_book", method=RequestMethod.POST)
	public ModelAndView add_book(@ModelAttribute("book") Book book) throws Exception {
		ModelAndView m = new ModelAndView("BookDisplay");
		return m;
	}
}
