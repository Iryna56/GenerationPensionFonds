import java.io.FileNotFoundException;

import java.util.List;

public class Main {

        public static void main(String[] args) throws FileNotFoundException {
            ObjectsWorkers objectsWorkers = new ObjectsWorkers();
            List<Worker> list = objectsWorkers.generate();

            ObjectsPensionFonds objectsPensionFonds = new ObjectsPensionFonds();
            List<PensionFund> listPensionFonds = objectsPensionFonds.create();




        }
}
