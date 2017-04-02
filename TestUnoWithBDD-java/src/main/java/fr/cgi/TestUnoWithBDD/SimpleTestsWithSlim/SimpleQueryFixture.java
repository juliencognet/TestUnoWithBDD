/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cgi.TestUnoWithBDD.SimpleTestsWithSlim;

import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.List;

/**
 *
 * @author cognetj
 */
public class SimpleQueryFixture{


    String artist;
    public SimpleQueryFixture(String artist){
        this.artist=artist;
    }
    

    public List<List<List<String>>> query(){
        List<List<List<String>>> resultat = new ArrayList();
        
        if (this.artist.equals("Led Zeppelin")){
            ArrayList oneResult = new ArrayList();
            oneResult.add(asList("title","Stairway to Heaven"));
            oneResult.add(asList("artist","Led Zeppelin"));
            oneResult.add(asList("duration","8:36"));
            resultat.add(oneResult);
            oneResult = new ArrayList();
            oneResult.add(asList("title","Immigrant Song"));
            oneResult.add(asList("artist","Led Zeppelin"));
            oneResult.add(asList("duration","2:25"));
            resultat.add(oneResult);        
        } else {
            ArrayList oneResult = new ArrayList();
            oneResult.add(asList("title","Another song"));
            oneResult.add(asList("artist","Unknow"));
            oneResult.add(asList("duration","0:01"));
            resultat.add(oneResult);
        }
        
        return resultat;
    }        

}
