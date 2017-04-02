package fr.cgi.TestUnoWithBDD.SimpleTestsWithFit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import fit.ColumnFixture;

/**
 *
 * @author cognetj
 */
public class SimpleDecisionTableFixture extends ColumnFixture{

    int firstValue;
    int secondValue;    

    public void setFirstValue(int firstValue) {
        this.firstValue = firstValue;
    }

    public void setSecondValue(int secondValue) {
        this.secondValue = secondValue;
    }

    public int multiplyTwoValues(){
        return this.firstValue*this.secondValue;
    }
    
    
    
}
