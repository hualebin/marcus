package com.marcus.activeMQ.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.marcus.activeMQ.service.JmsSendService;

@Controller
@RequestMapping("/jms/test")
public class JmsTestAct {
	
	@Autowired
	private JmsSendService jmsSendService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView page(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/test");
		mav.addObject("message", "请发送消息");
		return mav;
	}
	
	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public ModelAndView send(@RequestParam("message") String message){
		jmsSendService.sendMessage(message);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/test");
		mav.addObject("message", message);
		return mav;
	}

}
