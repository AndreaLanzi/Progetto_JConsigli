/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jconsigliclasse;

/**
 *
 * @author Andrea
 * Classe che gestisce il file riguardante il calendario generale
 */
public class JCalendarioGenerale {
    
   private JConsiglio [] vettore = new JConsiglio[100];
   private int last = 0;
   
   
    public JCalendarioGenerale() { 
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

}
