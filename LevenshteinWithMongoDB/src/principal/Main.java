/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import com.mongodb.BasicDBObject;
import java.net.UnknownHostException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import util.Medicamentos;
import util.MongoDBConection;

/**
 *
 * @author roliveira
 */
public class Main {
    
    public static void main(String[] args) throws UnknownHostException{
        
        MongoDBConection db = new MongoDBConection("dbmedicamentos");
        
        List<BasicDBObject> objects= db.getAllDocs("catmat"); 
        
        String pesquisa= "ZIDOVUDINAA";
        
        System.out.println("Buscando: "+pesquisa);
        objects.stream().forEach((ob) -> {
            String cmpLev = ob.get("TIPL_DESCRICAO").toString().replace(",", "");
            int txLev=  StringUtils.getLevenshteinDistance(pesquisa, cmpLev );
             
            if(txLev<10){
                System.out.println("Taxa Levenshtein: "+txLev);
                System.out.println(ob.getString("TIPL_CODIGO").toString()+": "+cmpLev);
            
            } 
        });
        
        List<Medicamentos> med = db.doAdvancedSearch(pesquisa, "catmat");
        
          for (Medicamentos m: med){
              System.out.println("FTS search: "+m.getCodigo()+":"+m.getDescricao());
          }
        
  
    
    
}
}
