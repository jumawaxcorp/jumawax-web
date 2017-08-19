package com.jumawax.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.jumawax.helper.DateFormatter;
import com.jumawax.model.Visit;

@Repository
public class VisitImpl implements VisitCC {
	
	Logger log = Logger.getLogger(VisitImpl.class);
	
	@Autowired
	@Qualifier("ds")
	private DataSource ds;
	  
	public void setDs(DataSource ds)
	{
	  this.ds = ds;
	}
	
	@Autowired
	@Qualifier("dateformatter")
	private DateFormatter df;
	
	@Override
	public Visit doVisit(String pjpId, String storeCode, String skuId, String collectDtm, String oosPromo, String oos,String oosPartial) {
		// TODO Auto-generated method stub
		Visit visitForm  = new Visit();
		visitForm.setPjpId(pjpId);
		visitForm.setCollectDtm(collectDtm);
		visitForm.setOos(oos);
		visitForm.setOosPromo(oosPromo);
		visitForm.setSkuId(skuId);
		visitForm.setStoreCode(storeCode);
		collectDtm = collectDtm.replace("T", " ");
		String msg = new String("SUCCESS");
		Connection con = null;
		String sql = "{? = CALL dovisit(?,?,?,?,?,?,?)}";
		log.debug("debug 1");
		log.debug("Input : "+pjpId);
		log.debug("Input : "+storeCode);
		log.debug("Input : "+skuId);
		log.debug("Input : "+collectDtm);
		log.debug("Input : "+oosPromo);
		log.debug("Input : "+oos);
		try {
			con = ds.getConnection();
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(2, Integer.valueOf(pjpId));
			cs.setString(3, storeCode);
			cs.setInt(4, Integer.valueOf(skuId));
			cs.setInt(5, Integer.valueOf(oosPromo));
			cs.setInt(6, Integer.valueOf(oos));
			cs.setTimestamp(7, DateFormatter.date(collectDtm));
			cs.setInt(8, Integer.valueOf(oosPartial));
			cs.executeUpdate();
			log.debug("debug2");
			cs.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			msg = e.getMessage();
			log.debug(msg);
		}
		if(!msg.equals("SUCCESS")) {
			msg = "Failed to insert data";
		}
		else {
			try {
				sql = "{? = CALL doupdatejourneystore(?,?,?,?,?,?,?)}";
				con = ds.getConnection();
				CallableStatement cs = con.prepareCall(sql);
				cs.setInt(2, Integer.valueOf(pjpId));
				cs.setString(3, storeCode);
				cs.setInt(4, Integer.valueOf(skuId));
				cs.setInt(5, Integer.valueOf(oosPromo));
				cs.setInt(6, Integer.valueOf(oos));
				cs.setTimestamp(7, DateFormatter.date(collectDtm));
				cs.setInt(8, Integer.valueOf(oosPartial));
				cs.executeUpdate();
				cs.close();
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		visitForm.setMsg(msg);
		return visitForm;
	}
	
}
