package com.jumawax.jdbc;

import com.jumawax.model.JourneyPlan;
import com.jumawax.model.JourneyPlanStore;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class JourneyPlanImpl
  implements JourneyPlanCC
{
  @Autowired
  @Qualifier("ds")
  private DataSource ds;
  
  public void setDs(DataSource ds)
  {
    this.ds = ds;
  }
  
  public List<JourneyPlanStore> createJourneyPlan()
  {
    return null;
  }
  
  public List<JourneyPlan> getListJourneyPlan(String username)
  {
    List<JourneyPlan> listOfJourneyPlan = new ArrayList<JourneyPlan>();
    Connection con = null;
    String query = "SELECT * FROM journeyplan WHERE user_agent = '" + username + "' AND status in('SUBMITTED','ONPROGRESS') ORDER BY submit_date ASC";
    try
    {
      con = this.ds.getConnection();
      Statement statement = con.createStatement();
      ResultSet rs = statement.executeQuery(query);
      while (rs.next())
      {
        JourneyPlan jp = new JourneyPlan();
        jp.setPlanId(rs.getString("pjp_id"));
        jp.setSubmitDate(rs.getString("submit_date"));
        jp.setAgent(rs.getString("user_agent"));
        jp.setOwner(rs.getString("pjp_owner"));
        jp.setStatus(rs.getString("status"));
        listOfJourneyPlan.add(jp);
      }
      rs.close();
      con.close();
    }
    catch (Exception localException) {}
    return listOfJourneyPlan;
  }
  
  public List<JourneyPlanStore> getListJourneyPlanStore(String planId, String latitude, String longitude)
  {
	  List<JourneyPlanStore> listPlanStore = new ArrayList<>();
	  Connection con = null;
	  String query = "SELECT * FROM pvpjpstore WHERE id = '"+planId+"'";
	  try {
		con = ds.getConnection();
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(query);
		while(rs.next()) {
			JourneyPlanStore jps = new JourneyPlanStore();
			jps.setStoreCode(rs.getString("storecode"));
			jps.setStoreName(rs.getString("storename"));
			jps.setName(rs.getString("name"));
			jps.setPhonenumber(rs.getString("phonenumber"));
			jps.setEmail(rs.getString("email"));
			jps.setAddress(rs.getString("address"));
			jps.setLatitude(rs.getString("latitude"));
			jps.setLongitude(rs.getString("longitude"));
			jps.setPlanId(planId);
			listPlanStore.add(jps);
		}
		rs.close();
		con.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
	  return listPlanStore;
  }
}
