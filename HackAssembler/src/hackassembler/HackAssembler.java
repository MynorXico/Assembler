/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackassembler;

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
        Path inputPath = Paths.get("C:\\Users\\Maynor\\Desktop", "Prog.asm");
        
        List<String> lines;
        lines = Files.readAllLines(inputPath);
        
        for(String line : lines){
            System.out.println(line);
        }
        
        
        
        Path outputPath = Paths.get("C:\\Users\\Maynor\\Desktop", "Prog.hack");
        Files.write(outputPath, lines);
    }
    
}
