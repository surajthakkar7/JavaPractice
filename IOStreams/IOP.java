import java.util.List;

import Packages.Processor;
import Packages.ZipCode;
import java.util.stream.*;;
public class IOP {
    public static void main(String[] args) {
        Processor processor = new Processor();
        List<ZipCode> list = processor.processInputFile("ZipCode.csv");


        List newList2 = list.stream()
        .filter(line  -> line.state.contains("Delhi"))
        .filter(line  -> line.city.contains("New Delhi"))
        .filter(line  -> (line.distance < 7.0))

            .collect(Collectors.toList());

        for(int i = 0; i < newList2.size() ; i++) {
            System.out.println(newList2.get(i));
        }  


            
    }

}
