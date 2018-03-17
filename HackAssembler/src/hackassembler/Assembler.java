/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackassembler;

import com.sun.media.sound.InvalidFormatException;
import hackassembler.Parser.instructionType;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
/**
 *
 * @author Maynor
 */
public class Assembler {
    BufferedReader br;
    SymbolTable st;
    FileReader fr;
    FileWriter fw;
    Parser p;
    ArrayList<String> Assembly;
    ArrayList<String> MachineL;
    BufferedWriter bw;
    String filePath;
    String fileName;
    ArrayList<int[]> LineMatch;
    public Assembler(String InputFilePath) throws FileNotFoundException, IOException{
        LineMatch = new ArrayList<int[]>();
        filePath = InputFilePath;
        Assembly = new ArrayList<String>();
        MachineL = new ArrayList<String>();
        st = new SymbolTable();
        p = new Parser(InputFilePath, st);
        Assemble();
        Path fileP = Paths.get(filePath);
        fileName = fileP.getFileName().toString().substring(0, fileP.getFileName().toString().lastIndexOf("."));
    }
    
    void Assemble() throws IOException{
        int ROMCounter = 0;
        int RAMCounter = 16;
        int DocLine = 0;
        fr = new FileReader(filePath);
        br = new BufferedReader(fr);
        String currentLine = br.readLine();
        while(currentLine != null){
            MachineL.add(currentLine);
            currentLine = currentLine.replaceAll("\\s", "");
            if(!LanguageRules.isValid(currentLine)){ 
                throw new InvalidFormatException(currentLine + " is not a valid expression\nLine: " + DocLine);
            }
            if(currentLine.startsWith("(")){
                st.addEntry(currentLine.replace("(", "").replace(")", ""),
                        ROMCounter);
            }else{
                if(!currentLine.equals("") && !currentLine.startsWith("//")){
                    ROMCounter++;
                }
            }
            currentLine = br.readLine();
            int[] newPair = new int[2];

            newPair[0] = DocLine;
            newPair[1] = ROMCounter-1;
            DocLine++;
            
            LineMatch.add(newPair);
        }
        fr.close();
        br.close();
        
        fr = new FileReader(filePath);
        br = new BufferedReader(fr);
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
                        st.addEntry(p.symbol(), RAMCounter++);
                        newLine = "0"+binaryFixedLength(st.GetAddress(p.symbol()), 15);
                    }
                }
            }
            if(!newLine.equals("")){
                Assembly.add(newLine);
            }
        }
        br.close();
        fr.close();
    }
    
    void WriteFile(String OutputFilePath) throws IOException{
        if(OutputFilePath.contains(".") && OutputFilePath.substring(OutputFilePath.lastIndexOf('.')).
                equals(".hack")){
            fw = new FileWriter(OutputFilePath);
        }else{
        fw = new FileWriter(OutputFilePath+".hack");
        }
        bw = new BufferedWriter(fw);
        for(String line:Assembly){
            bw.write(line+"\n");
        }        
        bw.close();
        fw.close(); 
    }
    
    static String fixedLengthString(String string, int length){
            return String.format("%1$" + length+"s",string).replace(' ', '0');
    }
    
    static String binaryFixedLength(int number, int length){
        return fixedLengthString(Integer.toString(number, 2), length);
    }
}
