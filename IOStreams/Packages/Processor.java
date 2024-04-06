package Packages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Arrays;

public class Processor {

    public List<ZipCode> processInputFile(String inputFilePath) {
        List<ZipCode> inputList = new ArrayList<>();
        try {
            File inputF = new File(inputFilePath);
            InputStream inputFS = new FileInputStream(inputF);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));

          //  System.out.println(inputF.toString( ) + " opened successfully!");

            inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return inputList;

    }

public Function<String,ZipCode> mapToItem = (line) -> {
     String[] p = line.split(","); 

     System.out.println("Array p: " + Arrays.toString(p));

     ZipCode zipCode = new ZipCode();


     zipCode.zip = p[0];
     zipCode.distance = Double.parseDouble(p[1]);
     zipCode.city = p[2];
     zipCode.state = p[3];

    // System.out.println(zipCode);

     return zipCode;
};
    
    }
