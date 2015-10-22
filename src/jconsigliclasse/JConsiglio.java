/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jconsigliclasse;

/**
 *
 * @author Andrea
 * Classe che gestisce un singolo consiglio (questa viene solamente richiamata quando viene costruito un consiglio 
 * o quando lo si deve comparare ad un altro consiglio.
 */
public class JConsiglio {
   private String classe, g, m, a, ore, minuti;

    public JConsiglio() {}
    
    public JConsiglio(String a,String m,String g,    String ore, String minuti, String classe) {
        this.classe = classe;
        this.g = g;
        this.m = m;
        this.a = a;
        this.ore = ore;
        this.minuti = minuti;
    }

    public String getClasse() {
        return classe;
    }

    public String getG() {
        return g;
    }

    public String getM() {
        return m;
    }

    public String getA() {
        return a;
    }

    public String getOre() {
        return ore;
    }

    public String getMinuti() {
        return minuti;
    }
    
    

    
    
    
}
