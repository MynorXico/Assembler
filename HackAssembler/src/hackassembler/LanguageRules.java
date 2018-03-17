/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackassembler;

import java.util.regex.Pattern;

/**
 *
 * @author Maynor
 */
public class LanguageRules {
    // Instrucción tipo A    
    // De la forma @Xxx Xxx es número
    static String AInstruction1 = "@[0-9]+";
    // De la forma @Xxx Xxx es identificador
    static String AInstruction2 = "@[[a-zA-Z]|_|\\.|$|:][[a-zA-Z]|_|\\.|$|:|[0-9]]*";
    // Generalizando la instrucción A
    static String AInstruction = "("+AInstruction1 + "|" + AInstruction2+")";
    // Instrucción tipo L
    static String LInstruction = "\\(.+\\)";
    
    
    // Instrucción tipo C
    static String dest = "(M|D|MD|A|AM|AD|AMD)";
    
    static String jump = "J(EQ|NE|MP|[GL][TE])";
    
    
    static String comp = "(0|1|D|A|M|-([1DAM])|D([-\\+][1AM]|[&|][AM])|[AM](\\+1|-[1D])|![DAM])";
    
    // Instruccion Jump
    static String jumpInstruction = "([D0];("+jump+"))";
    
    // Instruction C
    static String CInstruction = dest + "=" + comp;
    
    
    // Commend
    static String Comment = "//.*";
            
            
            
    static String ValidInstruction = AInstruction+"|"+jumpInstruction+"|"+CInstruction+"|"+LInstruction+ "|" + Comment + "|";
     
    static boolean isValid(String currentLine){
        return Pattern.compile(LanguageRules.ValidInstruction).matcher(currentLine).matches();
    } 

}
