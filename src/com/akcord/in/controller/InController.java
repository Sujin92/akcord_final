package com.akcord.in.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.akcord.in.model.InDto;
import com.akcord.in.service.InService;
import com.akcord.user.model.UserDto;



@Controller

@RequestMapping("/in")
public class InController {
	@Autowired
	private InService inService;
	
	@RequestMapping(value="/answer.akcord", method=RequestMethod.GET)
	public ModelAndView qna(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/in/answer");
		return mav;
	}
	@RequestMapping(value="/qna.akcord", method=RequestMethod.GET)
	public ModelAndView answer(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/in/qna");
		return mav;
	}

	@RequestMapping(value="/question.akcord", method=RequestMethod.GET)
	public ModelAndView question(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/in/question");
		return mav;
	}
	

	@RequestMapping(value="/inmain.akcord", method=RequestMethod.GET)
	public ModelAndView inmain(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/in/inmain");
		return mav;
	}
	@RequestMapping(value="/inmain.akcord", method=RequestMethod.POST)
	public ModelAndView answer(@RequestParam Map<String, String> queryString,
			InDto inDto, HttpSession session){
		System.out.println("여까진 오냐");
		ModelAndView mav = new ModelAndView();
		UserDto userDto = (UserDto) session.getAttribute("userInfo");
		if(userDto != null) {
			
			
			
			int cnt = inService.answerroom(inDto);
			mav.addObject("qs", queryString);
			mav.setViewName("inmain");
	
		}		return mav;
	}
	
}
