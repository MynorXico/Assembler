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
        
        SymbolTable st = new SymbolTable();
        Parser p = new Parser(input, st);
        FileWriter fw = new FileWriter("C:\\Users\\Maynor\\Desktop\\Prog.hack");
       
        FileReader fr = new FileReader("C:\\Users\\Maynor\\Desktop\\Prog.asm");
        BufferedReader br = new BufferedReader(fr);
        
        int ROMCounter = 0;
        int RAMAvailable = 16;
        String lineaActual = br.readLine();
        while(lineaActual != null){
            lineaActual = lineaActual.replaceAll("\\s", "");
                       
            if(lineaActual.startsWith("(")){
                String symbol = lineaActual.replace("(", "").replace(")", "");
                st.addEntry(symbol, ROMCounter);
            }else{
                if(!lineaActual.equals("") && !lineaActual.startsWith("//"))
                ROMCounter++;
            }
            lineaActual = br.readLine();
        }       
        fr.close();
        br.close();
        // Finaliza Primera Pasada
        // Comienza Segunda Pasada
        
        
        
        BufferedWriter bw = new BufferedWriter(fw);
        while(p.currentLine != null){
            String newLine = "";
            p.advance();
            if(p.currentLine == null)
                break;
            if(p.commandType() == instructionType.C_COMMAND){
                newLine = "111" +binaryFixedLength(Code.comp(p.comp()), 7)+binaryFixedLength(Code.dest(p.dest()), 3)+binaryFixedLength(Code.jump(p.jump()),3); 
            }else if(p.commandType() == instructionType.A_COMMAND){
                try{
                    newLine = "0"+binaryFixedLength(Integer.parseInt(p.symbol()), 15);
                } catch(Exception e){
                    if(st.contains(p.symbol())){
                        newLine = "0"+binaryFixedLength(st.GetAddress(p.symbol()), 15);
                    }else{
                        st.addEntry(p.symbol(), RAMAvailable++);
                        newLine = "0"+binaryFixedLength(st.GetAddress(p.symbol()), 15);
                    }
                }

            }
            // Primera corrida
                     
            
            {
                //System.out.println("TIPO A o L");
                //System.out.println(p.currentCommand);
                //System.out.println("Symbol: " + p.symbol());
                if(p.currentLine != null){
//                    newLine = "0"+binaryFixedLength(Integer.parseInt(p.symbol()), 15);
                }
                
                
//                System.out.println("0"+binaryFixedLength(Integer.parseInt(p.symbol()), 15));
                //System.out.println("---------------------------");  
            }
            if(!newLine.equals(""))
            bw.write(newLine+'\n');
        }
        bw.close();        
        fw.close();
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
