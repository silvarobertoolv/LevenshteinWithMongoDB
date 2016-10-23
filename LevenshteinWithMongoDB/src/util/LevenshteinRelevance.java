/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.mongodb.BasicDBObject;

/**
 *
 * @author Roberto
 */
public class LevenshteinRelevance {

    public LevenshteinRelevance(int taxaLevenshtein, BasicDBObject objeto) {
        this.taxaLevenshtein = taxaLevenshtein;
        this.objeto = objeto;
    }
    
    
    
    private int taxaLevenshtein;
    private BasicDBObject  objeto;

    public int getTaxaLevenshtein() {
        return taxaLevenshtein;
    }

    public void setTaxaLevenshtein(int taxaLevenshtein) {
        this.taxaLevenshtein = taxaLevenshtein;
    }

    public BasicDBObject getObjeto() {
        return objeto;
    }

    public void setObjeto(BasicDBObject objeto) {
        this.objeto = objeto;
    }
    
    
    
}
