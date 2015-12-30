package com.marcus.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class testCon {
	
	@RequestMapping
	public ModelAndView test(@RequestParam(value="name", required=false, defaultValue="World") String name){
		ModelAndView model = new ModelAndView();
		model.setViewName("/test");
		model.addObject("name", name);
		return model;
	}

}
