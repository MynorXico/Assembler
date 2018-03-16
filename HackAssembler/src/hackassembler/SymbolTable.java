/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackassembler;

import java.util.Hashtable;

/**
 *
 * @author Maynor
 */

// Keeps a correspndence between symbolic labels and numerica ddresses.
public class SymbolTable {
    Hashtable<String, Integer> ht;

    // Creates a new empty symbol table
    public SymbolTable(){
        ht = new Hashtable<String, Integer>();
        FillPredefinedSymbols();
    }
    // Adds the pair (symbol, address) to the table
    void addEntry(String symbol, int address){
        ht.put(symbol, address);
    }
    
    // Does the symbol table contain the given symbol?
    boolean contains(String symbol){
        return ht.containsKey(symbol);        
    }
    
    // Returns the address associated with the symbol
    int GetAddress(String symbol){
        return ht.get(symbol);
    }
    
    void FillPredefinedSymbols(){
        addEntry("SP", 0);
        addEntry("LCL", 1);
        addEntry("ARG", 2);
        addEntry("THIS", 3);
        addEntry("THAT", 4);
        for(int i = 0; i < 16; i++){
            addEntry("R"+i, i);
        }
        addEntry("SCREEN", 16384);
        addEntry("KBD", 24576);        
    }
    
    
    
    
}
