package com.ncstudy.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

		@RequestMapping({"/","/a"})
		public String test1() {
			return "index";
		}
		
		
		@RequestMapping("/mv")
	    public ModelAndView test2() {
	        ModelAndView mv=new ModelAndView();
	        mv.addObject("msg","Hello , SpringBoot!!!");
	        mv.setViewName("index");
	        return mv;
	    }
	 
	    @RequestMapping("/model")
	    public String test3(Model model) {
	        model.addAttribute("msg","Hello , World!!!");
	        return "index";
	    }
}