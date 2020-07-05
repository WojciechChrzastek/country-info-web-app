package main.java.net.chrzastek.countryInfoWebApp.controller;

import main.java.net.chrzastek.countryInfoWebApp.dao.CountryInfoDao;
import main.java.net.chrzastek.countryInfoWebApp.model.CountryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

  @Autowired
  private CountryInfoDao countryInfoDao;

  @RequestMapping(value = "/")
  public ModelAndView listContact(ModelAndView model) {
    List<CountryInfo> countryInfoList = countryInfoDao.showReport();
    model.addObject("countryInfoList", countryInfoList);
    model.setViewName("index");

    return model;
  }

  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView addIp(ModelAndView model) {
    CountryInfo countryInfo = new CountryInfo();
    model.addObject("countryInfo", countryInfo);
    model.setViewName("countryInfo_form");

    return model;
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public ModelAndView addIp(@ModelAttribute CountryInfo countryInfo) {
    countryInfoDao.addIpNumber(countryInfo);

    return new ModelAndView("redirect:/");
  }
}
