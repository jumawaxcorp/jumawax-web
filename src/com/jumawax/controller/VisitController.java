package com.jumawax.controller;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.jumawax.jdbc.VisitCC;
import com.jumawax.model.Visit;

@Controller
@RequestMapping({"visit"})
public class VisitController {

	Logger log = Logger.getLogger(VisitController.class);
	
	@Autowired
	VisitCC visitControl;
	
	@RequestMapping(value={"plan/oos"}, produces={"application/json"})
	@ResponseBody
	public Visit skuVisit(WebRequest request) {
		Visit visit = new Visit();
		visit = visitControl.doVisit(request.getParameter("pjpId"), request.getParameter("storeCode"), request.getParameter("skuId"), request.getParameter("collectDtm"), request.getParameter("oosPromo"), request.getParameter("oos"),request.getParameter("oosPartial"));
		return visit;
	}
	
}
