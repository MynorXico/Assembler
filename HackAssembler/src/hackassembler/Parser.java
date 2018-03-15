/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackassembler;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author Maynor
 */
public class Parser {
    
    // Opens the input file/stream and gets ready to parse it
    public Parser(String inputPath){
        
    }
    
    // Arethere more commands in the input
    boolean hasMoreCommands(){
        return false;
    }
    
    // Reads the next command from the input and makes it the current command.
    // Should be called only if hasMoreCommands. Initially there is no current
    // command    
    void advance(){
    }
    
    // Returns the type of the current command
    /*
        A_COMMAND for @Xxx where Xxx is either a symbol or a decimal number
        C_COMMAND for dest = comp; jump
        L_COMMAND for (Xxx)where Xxx is a symbol
    */
    instructionType commandType(){
        return null;
    }
    
    // Returns the symbol or decimal Xxx of the current command @Xxx or (Xxx(.
    // Should be called only when commandType() is A_COMMAND OR L_COMMAND.
    String symbol(){
        return null;        
    }
    
    // Returns the dest mnemonic in the current C-command (8 posibilities).
    // Should be called only when commandType() is C_COMMAND.
    String dest(){
        return null;        
    }
    
    // Returns the comp mnemonic in the current C-command (28 posibilities). 
    // Should be called only when commandType() is C_COMMAND
    String comp(){
        return null;
    }
    
    // Returns the jump mnemonic in the current C-command (8 posibilities). 
    // Should be called only when commandType() is C_COMMAND.
    String jump(){
        return null;
    }
    
    
    
    // Types of commands found in HackAssembler
    enum instructionType{
        A_COMMAND,
        C_COMMAND,
        L_COMMAND
    }
}
