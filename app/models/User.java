package models;

import play.*;
import play.db.jpa.*;
import play.data.validation.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class User extends Model {
    
    @Required
    public String name;
    
    @Required
    public String password;
    
    public User(String name,String password)
    {
    	
     this.name=name;
     this.password=password;
    }
    
}

