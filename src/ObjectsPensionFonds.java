import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectsPensionFonds {


    public List<PensionFund> create() throws FileNotFoundException {



            File pensionFonds = new File("src/FondsGenerated.txt");

            FileReader fileReader = new FileReader(pensionFonds);

            BufferedReader bufferedReader = new BufferedReader(fileReader);


            return bufferedReader.lines()
                    .map(PensionFund::new)
                    .toList();





    }
}

