import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PensionFond {
    private String name;

    private boolean isState;



    private List<Worker> persons;

    private Map<DayOfWeek, Boolean> workDays;

    public PensionFond(String name, boolean isState, List<Worker> persons) {
        this.name = name;
        this.isState = isState;

        this.persons = persons;
        this.workDays = new HashMap<>();
    }

    public PensionFond(String name, boolean isState) {
        this.name = name;
        this.isState = isState;
    }

    public Map<DayOfWeek, Boolean> getWorkDays() {
        return workDays;
    }

    public void setWorkDays(Map<DayOfWeek, Boolean> workDays) {
        this.workDays = workDays;
    }

    public List<Worker> getPersons() {
        return persons;
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




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PensionFond that = (PensionFond) o;
        return isState == that.isState && Objects.equals(name, that.name) && Objects.equals(persons, that.persons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isState, persons);
    }

    @Override
    public String toString() {
        return "PensionFund{" +
                "name='" + name + '\'' +
                ", isState=" + isState +
                ", dateOfCreation='"  +
                ", persons=" + persons +
                '}';
    }

    public void info() {
        System.out.println("Имя фонда " + name);

        int count = (persons != null) ? persons.size() : 0;

        if (isState) {
            System.out.println("В фонд вложились человек: " + count / 1000 + " тыс.");
        }
        else {
            System.out.println("В фонд вложились человек: " + count);
        }
    }

    public double calculatePensionFor(AbleToCalculatePension object) {
        if (isState && isWorkDayToday()) {
            return object.calculatePension();
        }
        else {
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

}
