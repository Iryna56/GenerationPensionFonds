import java.io.*;
import java.util.List;
import java.util.Random;

public class HumanGenerator {



        public void generate () throws IOException {

            Random random = new Random();

            File names = new File("src/Names.txt");

            File file = new File("src/People.txt");

            FileWriter fileWriter = new FileWriter(file);

            FileReader fileReader = new FileReader(names);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            List<String> nameList = bufferedReader.lines()
                    .toList();


            for (int i = 0; i < 10000; i++) {

                int nameRandomNumber = random.nextInt(0, nameList.size());
                String name = nameList.get(nameRandomNumber);

                Gender[] genders = Gender.values();
                Gender randomGender = genders[random.nextInt(genders.length)];


                int minSalaryRandomNumber = random.nextInt(0, 5000);

                int maxSalaryRandomNumber = random.nextInt(5000, 10000);


                String generatedString = name + " " + randomGender + " " + minSalaryRandomNumber + " " + maxSalaryRandomNumber;
                bufferedWriter.append(generatedString);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }

    }

