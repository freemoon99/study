package com.example.demo.controller;

import com.example.demo.dto.AverageDailyLoginCountDto;
import com.example.demo.dto.DailyVisitorCountDto;
import com.example.demo.dto.MonthlyDepartmentLoginCountDto;
import com.example.demo.dto.MonthlyVisitorCountDto;
import com.example.demo.dto.NonHolidayLoginCountDto;
import com.example.demo.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StatisticController {
  @Autowired
  private StatisticService service;

  @ResponseBody
  @RequestMapping("/")
  public String main() {
    return "서버 연결에 성공하였습니다 !";
  }

  @ResponseBody
  @RequestMapping("/monthly-visitor-count")
  public MonthlyVisitorCountDto monthlyVisitorCount(String year) throws Exception {
    return service.monthlyVisitorCount(year);
  }

  @ResponseBody
  @RequestMapping("/daily-visitor-count")
  public DailyVisitorCountDto dailyVisitorCount(String year, String month) throws Exception {
    return service.dailyVisitorCount(year, month);
  }

  @ResponseBody
  @RequestMapping("/average-daily-login-count")
  public AverageDailyLoginCountDto averageDailyLoginCount() throws Exception {
    return service.averageDailyLoginCount();
  }

  @ResponseBody
  @RequestMapping("/non-holiday-login-count")
  public NonHolidayLoginCountDto nonHolidayLoginCount() throws Exception {
    return service.nonHolidayLoginCount();
  }

  @ResponseBody
  @RequestMapping("/monthly-department-login-count")
  public MonthlyDepartmentLoginCountDto monthlyDepartmentLoginCount(String department, String year) throws Exception {
    return service.monthlyDepartmentLoginCount(department, year);
  }

}
