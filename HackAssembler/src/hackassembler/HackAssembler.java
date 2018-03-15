/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackassembler;

import hackassembler.Parser.instructionType;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author Maynor
 */
public class HackAssembler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String input = "C:\\Users\\Maynor\\Desktop\\Prog.asm";
        
        Parser p = new Parser(input);
        
        while(true){
            p.advance();
            if(p.commandType() == instructionType.C_COMMAND){
                System.out.println("TIPO C");
                System.out.println("Dest: " + p.dest());
                System.out.println("Jump: " + p.jump());
                System.out.println("Comp: " + p.comp());
                System.out.println("111" +binaryFixedLength(Code.comp(p.comp()), 7)+binaryFixedLength(Code.dest(p.dest()), 3)+binaryFixedLength(Code.jump(p.jump()),3));
                System.out.println("---------------------------");            
            }else{
                System.out.println("TIPO A");
                System.out.println(p.currentCommand);
                System.out.println("Symbol: " + p.symbol());
                System.out.println("---------------------------");  
            }
            
        }
        
        
        //Path outputPath = Paths.get("C:\\Users\\Maynor\\Desktop", "Prog.hack");
        //Files.write(outputPath, lines);
    }
    static String fixedLengthString(String string, int length){
            return String.format("%1$" + length+"s",string).replace(' ', '0');
    }
    static String binaryFixedLength(int number, int length){
        return fixedLengthString(Integer.toString(number, 2), length);
    }
    
}
