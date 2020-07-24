package main.java.net.chrzastek.countryInfoWebApp.controller;

import main.java.net.chrzastek.countryInfoWebApp.config.SpringMvcConfig;
import main.java.net.chrzastek.countryInfoWebApp.dao.CountryInfoDao;
import main.java.net.chrzastek.countryInfoWebApp.database.DbHandler;
import main.java.net.chrzastek.countryInfoWebApp.model.CountryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Connection;
import java.util.List;

@Controller
public class MainController {

  @Autowired
  private CountryInfoDao countryInfoDao;

  @RequestMapping(value = "/")
  public ModelAndView index(ModelAndView model) {
    model.setViewName("index");
    return model;
  }

  @RequestMapping(value = "/report")
  public ModelAndView report(ModelAndView model) {
    List<CountryInfo> countryInfoList = countryInfoDao.showReport();
    model.addObject("countryInfoList", countryInfoList);
    model.setViewName("report");

    return model;
  }

  @RequestMapping(value = "/update")
  public ModelAndView update(ModelAndView model) {
    Connection conn = SpringMvcConfig.dbHandler.connectToNewDatabase(SpringMvcConfig.DB_NAME);
    DbHandler.updateAllRows(conn, SpringMvcConfig.dbHandler);
    model.setViewName("update");
    return model;
  }

  @RequestMapping(value = "/add", method = RequestMethod.GET)
  public ModelAndView add(ModelAndView model) {
    CountryInfo countryInfo = new CountryInfo();
    model.addObject("countryInfo", countryInfo);
    model.setViewName("addip");

    return model;
  }

  @RequestMapping(value = "/addIp", method = RequestMethod.POST)
  public ModelAndView addIp(@ModelAttribute CountryInfo countryInfo) {
    countryInfoDao.addIpNumber(countryInfo);
    return new ModelAndView("redirect:/");
  }

  @RequestMapping(value = "/initial")
  public ModelAndView initial(ModelAndView model) {
    model.addObject("initialIpList", SpringMvcConfig.IP_NUMBERS_LIST);
    model.setViewName("initial");
    return model;
  }

}
