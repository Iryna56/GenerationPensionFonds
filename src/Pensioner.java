import java.util.Objects;

public class Pensioner extends Person {
    private int pension;


    public Pensioner(String name, int age, double weight, int height) {
        super(name, age, weight, height);
    }

    @Override
    public void die() {
        int age = getAge();
        int result = (age - 50) * pension;
        System.out.println("Этот пенсионер умер, он заработал: " + result);
    }

    @Override
    public void die(int years) {
        System.out.println("Этот пенсионер умрет через" + years + "лет");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pensioner pensioner = (Pensioner) o;
        return pension == pensioner.pension;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pension);
    }

    @Override
    public String toString() {
        return "Pensioner{" +
                "pension=" + pension +
                '}';
    }
}
