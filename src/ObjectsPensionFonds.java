import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectsPensionFonds {


    public List<PensionFund> create() throws FileNotFoundException {



            File pensionFonds = new File("src/FondsGenerated.txt");

            FileReader fileReader = new FileReader(pensionFonds);

            BufferedReader bufferedReader = new BufferedReader(fileReader);


            return bufferedReader.lines()
                    .map(line-> {
                        try {
                            return new PensionFund(line);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .toList();





    }
}

