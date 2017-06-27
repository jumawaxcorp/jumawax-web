package com.jumawax.controller;

import com.jumawax.helper.Distance;
import com.jumawax.jdbc.JourneyPlanCC;
import com.jumawax.model.JourneyPlan;
import com.jumawax.model.JourneyPlanStore;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
  
  @Autowired
  @Qualifier("distance")
  Distance storeDistance;
  
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
	  String planid = request.getParameter("planid");
	  String agentLat = request.getParameter("latitude");
	  String agentLon = request.getParameter("longitude");
	  jps = jPlanCC.getListJourneyPlanStore(planid, agentLat, agentLon);
	  
	  for (JourneyPlanStore journeyPlanStore : jps) {
		  log.debug("agent latitude = "+Double.parseDouble(agentLat));
		  log.debug("agent longitude = "+Double.parseDouble(agentLon));
		  if(journeyPlanStore.getLatitude()!=null && journeyPlanStore.getLongitude()!=null) {
			  String storeLat = journeyPlanStore.getLatitude().replace(",", ".");
			  String storeLon = journeyPlanStore.getLongitude().replace(",", ".");
			  double distance = Distance.distance(Double.parseDouble(storeLat),Double.parseDouble( storeLon),Double.parseDouble(agentLat),Double.parseDouble(agentLon));
			  log.debug("Store Address : "+journeyPlanStore.getAddress()+"| Distance : "+distance);
			  if(distance > 25.0) {
				  journeyPlanStore.setIsReached("false");
			  }
			  else
				  journeyPlanStore.setIsReached("true");
		  }
		
		//@TODO: add logic to defaultly set store position
		
	  }
	  
	  return jps;
  }
}
