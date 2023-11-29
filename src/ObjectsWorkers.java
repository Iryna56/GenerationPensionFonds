import java.io.*;
import java.util.List;

public class ObjectsWorkers {


    public static void main(String[] args) throws FileNotFoundException {







        File human = new File("src/People.txt");

        FileReader fileReader = new FileReader(human);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<Worker> workerList =  bufferedReader.lines()
                .map(Worker::new)
                .toList();

        System.out.println(workerList);

    }













    }

