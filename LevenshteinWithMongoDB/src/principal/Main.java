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
import util.LevenshteinRelevance;
import util.Medicamentos;
import util.MongoDBConection;

/**
 *
 * @author roliveira
 */
public class Main {
    
    public static void main(String[] args) throws UnknownHostException{
        
        MongoDBConection db = new MongoDBConection("dbmedicamentos");
        
        String pesquisa= "SUPLEMENTO PARA MEIO DE CULTURA, VANCOMICINA, PÓ P/ RECONSTITUIÇÃO, 3 M";
        
        List<BasicDBObject> objects= db.getAllDocs("catmat"); 
        List<LevenshteinRelevance> listaRelevantes = null;
        int menortxLev=15;
        String melhorPalavra="";
        
        
        System.out.println("Buscando: "+pesquisa);
        for (BasicDBObject ob :objects){
//            int idxof = ob.get("TIPL_DESCRICAO").toString().indexOf(',');
//            if(idxof>ob.get("TIPL_DESCRICAO").toString().length())
//                idxof=ob.get("TIPL_DESCRICAO").toString().length()-1;
            String cmpLev = ob.get("TIPL_DESCRICAO").toString().replace(",", "");
           // System.out.println("codigo: "+ob.getString("TIPL_CODIGO").toString()+" "+cmpLev);
           
            int txLev=  StringUtils.getLevenshteinDistance(pesquisa, cmpLev );
            

               
            
            if(txLev<20){
                if (txLev<menortxLev){
                menortxLev = txLev;
                melhorPalavra = ob.get("TIPL_DESCRICAO").toString();
                }
//                System.out.println("Taxa Levenshtein: "+txLev);
//                System.out.println(ob.getString("TIPL_CODIGO").toString()+": "+cmpLev);
                
              //  listaRelevantes.add(new LevenshteinRelevance(txLev, ob));

            } 
            
       
        };
        
        
                System.out.println("Menor valor txlev "+menortxLev+ " Melhor texto: "+melhorPalavra);             
                List<Medicamentos> med = db.doAdvancedSearch(melhorPalavra, "catmat");
            for (Medicamentos m: med){
              System.out.println("FTS search: "+m.getCodigo()+":"+m.getDescricao());
          }
        
        
      
        
     
        
  
    
    
}
}
