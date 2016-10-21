/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import com.mongodb.BasicDBObject;
import java.net.UnknownHostException;
import java.util.List;
import util.MongoDBConection;

/**
 *
 * @author roliveira
 */
public class Main {
    
    public static void main(String[] args) throws UnknownHostException{
        
        MongoDBConection db = new MongoDBConection("mydb");
        
        List<BasicDBObject> objects= db.getAllDocs("medicamentos"); 
        
        System.out.println("principal.Main.main()");
        
        objects.stream().forEach((ob) -> {
            System.out.println(ob.getString("Descrição do Item").toString());
        });
        
  
    
    
}
}
