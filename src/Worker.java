import java.util.Objects;
import java.util.Set;

public class Worker extends Person implements AbleToCalculatePension {
    private final static double PENSION_COEFFICIENT = 0.25;
    private final static double ADDITIONAL_COEFFICIENT = 0.05;

    private final static int COUNT_OF_PROFS = 3;

    private int minSalary;

    private int maxSalary;

    private Set<Profession> proffessions;




    public Worker(Gender gender, String name, int minSalary, int maxSalary) {
        super(name, gender);
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public Worker(String s) {
        super("", 0);
        String[] array =  s.split(" ");
        this.setName(array[0]);
        this.setGender(Gender.valueOf(array[1]));
        this.setMinSalary(Integer.parseInt(array[2]));
        this.setMaxSalary(Integer.parseInt(array[3]));




    }


    @Override
    public void die() {
        System.out.println("Этот человек не дожил до пенсии");
    }

    public Worker(String name, Gender gender, int minSalary, int maxSalary) {
        super(name, gender);
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    @Override
    public void die(int years) {
        System.out.println("Этот человек не доживет до пенсии и умрет через " + years + "лет");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return minSalary == worker.minSalary && maxSalary == worker.maxSalary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minSalary, maxSalary);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                '}';
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public Set<Profession> getProffessions() {
        return proffessions;
    }

    public void setProffessions(Set<Profession> proffessions) {
        this.proffessions = proffessions;
    }

    @Override
    public double calculatePension() {
        Gender gender = getGender();

        if (gender == null) {
            return 0.0;
        }

        double averageSalary;

        if (gender.equals(Gender.MALE)) {
            averageSalary = CalculatorUtils.calculateAverage(minSalary, maxSalary);
        }
        else {
            averageSalary = CalculatorUtils.calculateAverage(minSalary / 2, maxSalary * 2);
        }

        double additionalMoney = 0.0;

        if (proffessions != null) {
            double countProffessions = proffessions.size();
            additionalMoney = countProffessions / COUNT_OF_PROFS * ADDITIONAL_COEFFICIENT;
        }

        //0.05


        //return averageSalary * PENSION_COEFFICIENT + (averageSalary * PENSION_COEFFICIENT * additionalMoney);
        return averageSalary * PENSION_COEFFICIENT * (1 + additionalMoney);
    }
}