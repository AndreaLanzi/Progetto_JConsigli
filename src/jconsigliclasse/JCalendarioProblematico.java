/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jconsigliclasse;

/**
 *
 * @author Andrea
 */
public class JCalendarioProblematico {
    
    private JConsiglio [] vettore = new JConsiglio[100];
   private int last = 0;
    public JCalendarioProblematico() { 
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
    
    
}
