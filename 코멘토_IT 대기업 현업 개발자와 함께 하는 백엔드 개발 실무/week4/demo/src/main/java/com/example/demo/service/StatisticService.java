package com.example.demo.service;

import com.example.demo.dto.AverageDailyLoginCountDto;
import com.example.demo.dto.DailyVisitorCountDto;
import com.example.demo.dto.MonthlyDepartmentLoginCountDto;
import com.example.demo.dto.MonthlyVisitorCountDto;
import com.example.demo.dto.NonHolidayLoginCountDto;
import java.util.HashMap;

public interface StatisticService {
  public HashMap<String,Object> yearloginNum (String year);
  MonthlyVisitorCountDto monthlyVisitorCount(String year);
  DailyVisitorCountDto dailyVisitorCount(String year, String month);
  AverageDailyLoginCountDto averageDailyLoginCount();
  NonHolidayLoginCountDto nonHolidayLoginCount();
  MonthlyDepartmentLoginCountDto monthlyDepartmentLoginCount(String department, String year);
}