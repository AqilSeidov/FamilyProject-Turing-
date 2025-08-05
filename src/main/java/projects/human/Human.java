package projects.human;

import projects.family.Family;
import projects.pet.Pet;

import java.util.Arrays;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private int birthDate;
    private int iq;
    private Family family;
    private String[][] activities;

    public Human() {}

    public Human(String name, String surname, int birthDate, int iq, Family family ,String[][] activities) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
        this.family = family;
        this.activities = activities;
    }

    public Human(String name, String surname, int birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }


    public String getName() { return name;}
    public void setName(String name) { this.name = name;}

    public String getSurname() { return surname;}
    public void setSurname(String surname) { this.surname = surname;}

    public int getBirthDate() { return birthDate;}
    public void setBirthDate(int birthDate) { this.birthDate = birthDate;}

    public int getIq() { return iq;}
    public void setIq(int iq) { this.iq = iq;}

    public String[][] getNonWorkingActivities() {
        return activities != null ? Arrays.copyOf(activities, activities.length) : null;
    }

    public void setNonWorkingActivities(String[][] nonWorkingActivities) {
        this.activities = activities != null ? Arrays.copyOf(activities, activities.length) : null;
    }

    public Family getFamily() { return family;}
    public void setFamily(Family family) { this.family = family;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return birthDate == human.birthDate && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(family, human.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate, family);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + birthDate +
                ", iq=" + iq +
                ", schedule=" + Arrays.toString(activities) +
                '}';
    }

}