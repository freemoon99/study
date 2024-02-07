package com.example.demo.dao;

import com.example.demo.dto.AverageDailyLoginCountDto;
import com.example.demo.dto.DailyVisitorCountDto;
import com.example.demo.dto.MonthlyDepartmentLoginCountDto;
import com.example.demo.dto.MonthlyVisitorCountDto;
import com.example.demo.dto.NonHolidayLoginCountDto;
import java.util.HashMap;
import com.example.demo.dto.StatisticDto;
public interface  StatisticMapper {
  public HashMap<String, Object> selectYearLogin(String year);
  MonthlyVisitorCountDto selectMonthlyVisitorCount(String year);
  DailyVisitorCountDto selectDailyVisitorCount(String year, String month);
  AverageDailyLoginCountDto selectAverageDailyLoginCount();
  NonHolidayLoginCountDto selectNonHolidayLoginCount();
  MonthlyDepartmentLoginCountDto selectMonthlyDepartmentLoginCount(String department, String year);
}