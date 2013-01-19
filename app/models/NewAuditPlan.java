package models;

import play.*;
import play.db.jpa.*;
import play.data.validation.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class NewAuditPlan extends Model {
    
    @Required
    public String audit_target;
    
    @Required
    public String auditor_list;
    
    @Required
    public Date audit_schedule;
    
    @Required
    public String contact_info;
    
    public String report;
    
    public String toString(){
    	return " Audit Target : " + audit_target + " auditor_list : " + auditor_list + " audit_schedule " +  audit_schedule + " contact_info " + contact_info + " report " + report;
    }
}

