package controllers;

import play.mvc.*;
import play.test.Fixtures;
import play.data.validation.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        //Date now = new Date();
        render();
    }
    
    public static void list() {
        List<NewAuditPlan> contacts = NewAuditPlan.find("order by audit_target").fetch();
        render(contacts);
    }

    public static void search(Date audit_schedule) {
    	//System.out.println(audit_schedule);
    	List<NewAuditPlan> contacts = NewAuditPlan.find("audit_schedule", audit_schedule).fetch();
    	render(contacts);
    }
    
    public static void report(Long id) {
    	//System.out.println(audit_schedule);
    	List<NewAuditPlan> contacts = NewAuditPlan.find("id", id).fetch();
    	  try {
    	    	FileWriter fstream = new FileWriter("out.txt");
    	    	BufferedWriter out = new BufferedWriter(fstream);
    	    	out.write(contacts.toString());
    	   
    	    	System.out.println(contacts.toString());
    	    	out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	list();
    }
        
    
    
    public static void form(Long id) {
        if(id == null) {
            render();
        }
        NewAuditPlan contact = NewAuditPlan.findById(id);
        render(contact);
    }
    
    public static void newauditplan(@Valid NewAuditPlan contact) {
        if(validation.hasErrors()) {
            if(request.isAjax()) error("Invalid value");
            render("@newauditplan", contact);
        }
        contact.save();
        list();
    }
    
    public static void save(@Valid NewAuditPlan contact) {
        if(validation.hasErrors()) {
            if(request.isAjax()) error("Invalid value");
            render("@newauditplan", contact);
        }
        contact.save();
        list();
    }

    public static void login(String name, String password) {
    	User bob = new User("arda", "222").save();
    	User bob1 = new User("arman", "111").save();
    	User bob2 = new User("tolga", "333").save();
        
    	System.out.println(name + password);
    	
    	if(name.equals("arda") && password.equals("222"))
    	{

        	list();
        	
    	}
    	else if(name.equals("tolga") && password.equals("333"))
    	{

        	list();
    	}
    	else if(name.equals("arman") && password.equals("111"))
    	{

    		 redirect("http://127.0.0.1:9000/newauditplan");
    	}
    	else
    	{
    		redirect("http://127.0.0.1:9000");
    	}
    }

}