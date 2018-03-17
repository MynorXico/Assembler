/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackassembler;

import hackassembler.Parser.instructionType;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Maynor
 */
public class HackAssembler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String line = "This order";
        String code = "M-D";
        String pattern = LanguageRules.comp;
        
        Pattern r = Pattern.compile(pattern);
        
        Matcher m = r.matcher(code);
        System.out.println(m.matches());
    }    
}
