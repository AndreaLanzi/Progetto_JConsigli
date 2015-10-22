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
public class JClassi {
    private String [] vettore = new String[100];
    int last=0;

    public JClassi() { 
        last=0;
    }

    public void add(String nuovo)
    {
            if(last<18)
            {
                     vettore[last]=nuovo;
                     last++;
            }
    }


    public int getLast()
    {
            return last;
    }

    public String getClasse(int pos)
    {
            return vettore[pos];
    }
}
