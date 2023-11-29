import java.io.*;
import java.util.List;
import java.util.Random;

public class PensionFondGenerator {
    public static void main(String[] args) throws IOException {

        Random random = new Random();

        File fonds = new File("src/Fonds.txt");

        File file = new File("src/FondsGenerated.txt");

        FileWriter fileWriter = new FileWriter(file);

        FileReader fileReader = new FileReader(fonds);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        List<String> pensionFondsList = bufferedReader.lines()
                .toList();

        for (int i = 0; i < 100; i++) {

            int pensionFondsRandom = random.nextInt(0, pensionFondsList.size());
            String pensionFonds = pensionFondsList.get(pensionFondsRandom);

            boolean pensionFondsState = random.nextBoolean();



            String generatedString = pensionFonds + " " + pensionFondsState;
            bufferedWriter.append(generatedString);
            bufferedWriter.newLine();
            bufferedWriter.flush();




        }
    }
}
