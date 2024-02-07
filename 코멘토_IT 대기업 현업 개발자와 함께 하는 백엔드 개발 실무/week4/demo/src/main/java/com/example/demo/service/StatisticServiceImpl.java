package com.example.demo.service;

import com.example.demo.dto.AverageDailyLoginCountDto;
import com.example.demo.dto.DailyVisitorCountDto;
import com.example.demo.dto.MonthlyDepartmentLoginCountDto;
import com.example.demo.dto.MonthlyVisitorCountDto;
import com.example.demo.dto.NonHolidayLoginCountDto;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.StatisticMapper;
@Service
public class StatisticServiceImpl implements StatisticService {


  @Autowired
  private StatisticMapper uMapper;

  @Override
  public HashMap<String, Object> yearloginNum (String year) {
    // TODO Auto-generated method stub
    HashMap<String, Object> retVal = new HashMap<String,Object>();

    try {
      retVal = uMapper.selectYearLogin(year);
      retVal.put("year", year);
      retVal.put("is_success", true);

    }catch(Exception e) {
      retVal.put("totCnt", -999);
      retVal.put("year", year);
      retVal.put("is_success", false);
    }

    return retVal;
  }

  @Override
  public MonthlyVisitorCountDto monthlyVisitorCount(String year) {
    return uMapper.selectMonthlyVisitorCount(year);
  }

  @Override
  public DailyVisitorCountDto dailyVisitorCount(String year, String month) {
    return uMapper.selectDailyVisitorCount(year, month);
  }

  @Override
  public AverageDailyLoginCountDto averageDailyLoginCount() {
    return uMapper.selectAverageDailyLoginCount();
  }

  @Override
  public NonHolidayLoginCountDto nonHolidayLoginCount() {
    return uMapper.selectNonHolidayLoginCount();
  }

  @Override
  public MonthlyDepartmentLoginCountDto monthlyDepartmentLoginCount(String department, String year) {
    return uMapper.selectMonthlyDepartmentLoginCount(department, year);
  }


}