/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jconsigliclasse;

/**
 *
 * @author Andrea
 * Classe che gestisce il vettore contentente i consigli a cui il docente deve partecipare.
 */
public class JCalendarioDocente {
     
   private JConsiglio [] vettore = new JConsiglio[100];
   private int last = 0;
    public JCalendarioDocente() { 
        last=0;
    }

    public void add(JConsiglio nuovo)
    {
        if(last<100)
        {
                 vettore[last]=nuovo;
        if(last<100)
                last++;
        }

    }
    
    public String print()
    {
        String risultato="";
        
        for (int i = 0; i < last; i++) 
           risultato+= i+") "+ vettore[i].getClasse() +", "+ vettore[i].getG() +", "+ vettore[i].getM() +", "+ vettore[i].getA() +", "+ vettore[i].getOre() +", "+ vettore[i].getMinuti()+"\n";
        
           
        return risultato;
    }
    
    
   public int getLast()
    { 
            return last; 
    }

   public String getClasse(int pos)
    {
            return vettore[pos].getClasse();
    }

   public JConsiglio getConsiglio(int pos)
    {
            return vettore[pos];
    }

    public String getMese(int pos)
    {
            return vettore[pos].getM();
    }
    public String getAnno(int pos)
    {
            return vettore[pos].getA();
    }
    public String getGiorno(int pos)
    {
            return vettore[pos].getG();
    }
    public String getOre(int pos)
    {
            return vettore[pos].getOre();
    }

    public String getMinuti(int pos)
    {
            return vettore[pos].getMinuti();
    }

    
}
