package com.jumawax.jdbc;

import org.springframework.stereotype.Component;

import com.jumawax.model.Visit;

@Component
public interface VisitCC {
	
	public abstract Visit doVisit(String pjpId,String storeCode,String skuId,String collectDtm,String oosPromo,String oos,String oosPartial);
	
}
