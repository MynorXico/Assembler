/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackassembler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

/**
 *
 * @author Maynor
 */
public class Parser {
    BufferedReader br;
    
    String currentCommand;
    String currentLine;
    // Opens the input file/stream and gets ready to parse it
    public Parser(String inputPath) throws FileNotFoundException{
        currentCommand = null;
        currentLine = null;
        br = new BufferedReader(new FileReader(inputPath));
    }
    
    // Arethere more commands in the input
    boolean hasMoreCommands() throws IOException{
        currentLine = br.readLine();
        if(currentLine == null){
            br.close();
            return false;
        }else{
            return true;
        }
    }
    
    // Reads the next command from the input and makes it the current command.
    // Should be called only if hasMoreCommands. Initially there is no current
    // command    
    void advance() throws IOException{
        if(hasMoreCommands()){
            if(!currentLine.equals("") && !currentLine.startsWith("//")){
                currentCommand = currentLine.trim();
            }else{
                advance();
            }
        }
    }
    
    // Returns the type of the current command
    /*
        A_COMMAND for @Xxx where Xxx is either a symbol or a decimal number
        C_COMMAND for dest = comp; jump
        L_COMMAND for (Xxx)where Xxx is a symbol
    */
    instructionType commandType(){
        if(currentCommand.substring(0, 1).equals("@")){
            return instructionType.A_COMMAND;
        }else if(currentCommand.substring(0, 1).equals("(")){
            return instructionType.L_COMMAND;
        }else{
            return instructionType.C_COMMAND;
        }
    }
    
    // Returns the symbol or decimal Xxx of the current command @Xxx or (Xxx)
    // Should be called only when commandType() is A_COMMAND OR L_COMMAND.
    String symbol(){
        switch(commandType()){
            case A_COMMAND:
                return currentCommand.substring(1);
            case L_COMMAND:
                return currentCommand.replace('(', ' ').replace(')', ' ').trim();
            default:
                return null;
        }
    }
    
    // Returns the dest mnemonic in the current C-command (8 posibilities).
    // Should be called only when commandType() is C_COMMAND.
    String dest(){
        if(commandType() == instructionType.C_COMMAND){
            if(currentCommand.contains("=")){
                return currentCommand.substring(0,1);
            }else{
                return "null";
            }
        }
        return null;
    }
    
    // Returns the comp mnemonic in the current C-command (28 posibilities). 
    // Should be called only when commandType() is C_COMMAND
    String comp(){
        if(commandType() == instructionType.C_COMMAND){
            if(!currentCommand.contains(";")){
                return currentCommand.substring(2);
            }else{
                return currentCommand.substring(0, 1);
            }            
        }
        return "null";
    }
    
    // Returns the jump mnemonic in the current C-command (8 posibilities). 
    // Should be called only when commandType() is C_COMMAND.
    String jump(){
        if(currentCommand.contains(";")){
            return currentCommand.substring(2);
        }
        return "null";
    }
    
    
    
    // Types of commands found in HackAssembler
    enum instructionType{
        A_COMMAND,
        C_COMMAND,
        L_COMMAND
    }
}
