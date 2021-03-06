package com.akcord.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.akcord.admin.model.NoticeDto;
import com.akcord.admin.model.UserManageDto;
import com.akcord.admin.service.NoticeService;
import com.akcord.admin.service.UserManagerService;
import com.akcord.alarm.service.AlarmService;
import com.akcord.group.service.CommonService;
import com.akcord.user.model.UserDto;
import com.akcord.util.PageNavigation;

@Controller
@RequestMapping("/notice")
public class NoticeController {
   @Autowired
   private NoticeService noticeService;

   @Autowired
   private AlarmService alarmService;
   
   @Autowired
   private CommonService commonService;
   
   @RequestMapping("/mvnoticelist.akcord")
   public ModelAndView mvnoticelist(HttpSession session,@RequestParam Map<String,String> query){
      ModelAndView mav = new ModelAndView();
      List<NoticeDto> list = noticeService.getNoticeList(query);
      UserDto userDto = (UserDto) session.getAttribute("user");
      query.put("type", "notice");
      PageNavigation pageNavigation = commonService.makePageNavigation(query);
      pageNavigation.setRoot("/akcord_project");
      pageNavigation.setNavigator();
      mav.addObject("navigator", pageNavigation);
      mav.addObject("user",userDto);
      mav.addObject("noticeList",list);
      mav.addObject("query", query);
      mav.setViewName("/admin/notice");
      return mav;
   }
   
   @RequestMapping("/userNoticelist.akcord")
   public ModelAndView userNoticelist(HttpSession session,@RequestParam Map<String,String> query){
      ModelAndView mav = new ModelAndView();
      List<NoticeDto> list = noticeService.userNoticeList(query);
      UserDto userDto = (UserDto) session.getAttribute("user");
      query.put("type", "usernotice");
      PageNavigation pageNavigation = commonService.makePageNavigation(query);
      pageNavigation.setRoot("/akcord_project");
      pageNavigation.setNavigator();
      mav.addObject("navigator", pageNavigation);
      mav.addObject("user",userDto);
      mav.addObject("noticeList",list);
      mav.addObject("query", query);
      mav.setViewName("/admin/usernotice");
      return mav;
   }
   @RequestMapping(value="/noticewrite.akcord",method=RequestMethod.GET)
   public String noticeWrite(){                                                               
      return "/admin/noticewrite";
   }
   @RequestMapping(value="/noticedelete.akcord",method=RequestMethod.GET)
   public String noticedelete(@RequestParam("str") String str){
   String checkStr[] = str.split(",");
      for (int i = 0; i < checkStr.length; i++) {
         noticeService.delete(checkStr[i]);
      }
      return "redirect:/notice/mvnoticelist.akcord?word=&pg=1";
   }
   @RequestMapping(value="/noticepublic.akcord",method=RequestMethod.GET)
   public String noticepublic(@RequestParam("str") String str){
      String checkStr[] = str.split(",");
      for (int i = 0; i < checkStr.length; i++) {
         noticeService.noticePublic(checkStr[i]);
      }
      return "redirect:/notice/mvnoticelist.akcord?word=&pg=1";
   }

   @RequestMapping(value="/noticewrite.akcord",method=RequestMethod.POST)
   public String noticeWrite(NoticeDto noticeDto){
      int cnt = noticeService.noticeWrite(noticeDto);
      int is_notice= noticeDto.getIs_notice();
      if(is_notice==1){
         int target_id=0;
         alarmService.alarminsertNotice(target_id);
      }
      return "redirect:/notice/mvnoticelist.akcord?word=&pg=1";
   }
   
   @RequestMapping(value="/noticemodify.akcord",method=RequestMethod.GET)
   public ModelAndView noticemodify(@RequestParam("nid") String nid,HttpSession session){
      ModelAndView mav = new ModelAndView();
      UserDto user=(UserDto) session.getAttribute("user");
      int user_id=user.getUser_id();
      NoticeDto noticeDto = noticeService.getNotice(nid);
      mav.addObject("notice",noticeDto);
      if(user_id==0){
         mav.setViewName("/admin/noticemodify");
         }
      else{
         noticeService.updateHit(nid);
         mav.setViewName("/admin/getnotice");
      }
      return mav;
   }
   @RequestMapping(value="/noticemodify.akcord",method=RequestMethod.POST)
   public String noticemodify(NoticeDto noticeDto){
      int cnt = noticeService.modify(noticeDto);
      return "redirect:/notice/mvnoticelist.akcord?word=&pg=1";
   }
      
}