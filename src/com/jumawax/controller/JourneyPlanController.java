package com.jumawax.controller;

import com.jumawax.jdbc.JourneyPlanCC;
import com.jumawax.model.JourneyPlan;
import com.jumawax.model.JourneyPlanStore;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping({"journeyplan"})
public class JourneyPlanController
{
  Logger log = Logger.getLogger(JourneyPlanController.class);
  @Autowired
  JourneyPlanCC jPlanCC;
  
  @RequestMapping(value={"list/plan"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public List<JourneyPlan> getJourneyPlan(WebRequest request)
  {
    List<JourneyPlan> jp = new ArrayList<JourneyPlan>();
    jp = this.jPlanCC.getListJourneyPlan(request.getParameter("username"));
    return jp;
  }
  
  @RequestMapping(value={"list/jsonp/plan"}, produces={"application/json"})
  @ResponseBody
  public List<JourneyPlan> getJourneyPlanJsonp(WebRequest request)
  {
    List<JourneyPlan> jp = new ArrayList<JourneyPlan>();
    jp = this.jPlanCC.getListJourneyPlan(request.getParameter("username"));
    return jp;
  }
  
  @RequestMapping(value={"list/jsonp/plan/store"}, produces={"application/json"})
  @ResponseBody
  public List<JourneyPlanStore> getJourneyPlanStore(WebRequest request) {
	  List<JourneyPlanStore> jps = new ArrayList<>();
	  jps = jPlanCC.getListJourneyPlanStore(request.getParameter("planid"), null, null);
	  return jps;
  }
}
