import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class PensionFund {
    private String name;

    private boolean isState;

    private String dateOfCreation;

    private List<Worker> persons;

    private Map<DayOfWeek, Boolean> workDays;


    public PensionFund(String name, boolean isState,String dateOfCreation, List<Worker> persons) {
        this.name = name;
        this.isState = isState;
        this.dateOfCreation = dateOfCreation;
        this.persons = persons;
        this.workDays = new HashMap<>();
    }

    public PensionFund(String s) throws IOException {
        String[] array = s.split(" ");
        this.setName(array[0]);
        this.setState(Boolean.parseBoolean(array[1]));
        this.persons = addWorkersToFund();

    }

    public static List<Worker> addWorkersToFund() throws IOException {
        Random random = new Random();
        List<Worker> workers = ObjectsWorkers.generate();
        List<Worker> members = new ArrayList<>();
        int quantityOfMembers = random.nextInt(500, 6000);
        for (int i = 0; i < quantityOfMembers; i++) {
            Worker worker = workers.get(random.nextInt(workers.size()));
            if (!members.contains(worker)) {
                members.add(worker);
            }
        }
        return members;
    }




    public Map<DayOfWeek, Boolean> getWorkDays() {
        return workDays;
    }

    public void setWorkDays(Map<DayOfWeek, Boolean> workDays) {
        this.workDays = workDays;
    }



    public void setPersons(List<Worker> persons) {
        this.persons = persons;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isState() {
        return isState;
    }

    public void setState(boolean state) {
        isState = state;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PensionFund that = (PensionFund) o;
        return isState == that.isState && Objects.equals(name, that.name) && Objects.equals(dateOfCreation, that.dateOfCreation) && Objects.equals(persons, that.persons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isState, dateOfCreation, persons);
    }

    @Override
    public String toString() {
        return "PensionFund{" +
                "name='" + name + '\'' +
                ", isState=" + isState +
                ", persons=" + persons +
                '}';
    }

    public void info() {
        System.out.println("Имя фонда " + name);

        int count = (persons != null) ? persons.size() : 0;

        if (isState) {
            System.out.println("В фонд вложились человек: " + count / 1000 + " тыс.");
        } else {
            System.out.println("В фонд вложились человек: " + count);
        }
    }

    public double calculatePensionFor(AbleToCalculatePension object) {
        if (isState && isWorkDayToday()) {
            return object.calculatePension();
        } else {
            return 0.0;
        }
    }

    private boolean isWorkDayToday() {
        LocalDate localDate = LocalDate.now();
        DayOfWeek dayOfWeekNow = localDate.getDayOfWeek();

        if (workDays == null) {
            return false;
        }

        boolean isWorkDay = workDays.get(dayOfWeekNow);
        return isWorkDay;
    }

    public double calculateMedianPension() {
        if (persons == null || persons.size() == 0) {
            return 0.0;
        }

        double sum = 0.0;

        for (Worker worker : persons) {
            sum += calculatePensionFor(worker);
        }

        return sum / persons.size();
    }

    public PensionFund(String name, boolean isState) {
        this.name = name;
        this.isState = isState;
    }
}
