import java.io.*;
import java.util.List;

public class ObjectsWorkers {










    public List<Worker> generate() throws FileNotFoundException {
        File human = new File("src/People.txt");

        FileReader fileReader = new FileReader(human);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        return bufferedReader.lines()
                .map(Worker::new)
                .toList();
    }



    }



