package com.jumawax.jdbc;

import com.jumawax.model.JourneyPlan;
import com.jumawax.model.JourneyPlanStore;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public abstract interface JourneyPlanCC
{
  public abstract List<JourneyPlanStore> createJourneyPlan();
  
  public abstract List<JourneyPlan> getListJourneyPlan(String paramString);
  
  public abstract List<JourneyPlanStore> getListJourneyPlanStore(String paramString1, String paramString2, String paramString3);
}
