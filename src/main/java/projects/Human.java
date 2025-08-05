package projects;

import projects.pet.Pet;

import java.util.Arrays;

public class Human {
    String name;
    String surname;
    int birthDate;
    int iq;
    Pet pet;
    Human mother;
    Human father;
    String[][] nonWorkingActivities;

    public Human() {}

    public Human(String name, String surname, int birthDate, int iq, Pet pet, Human mother, Human father, String[][] nonWorkingActivities) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.nonWorkingActivities = nonWorkingActivities;
    }

    public Human(String name, String surname, int birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public Human(String name, String surname, int birthDate, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.mother = mother;
        this.father = father;
    }

    public void greetPet(){
        System.out.printf("Hello, %s %n" + pet.nickname);
    }
    public void describePet(){
        String slyness = pet.trickLevel > 50 ? "very sly" : "almost not sly";
        System.out.printf("I have an %s is %d years old, it is %s. %n" ,pet.species,pet.age, slyness);
    }


    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + birthDate +
                ", iq=" + iq +
                ", projects.pet=" + pet +
                ", mother=" + mother.name + " " + mother.surname +
                ", father=" + father.name +" "+ father.name+
                ", habits=" + Arrays.toString(nonWorkingActivities) +
                '}';
    }
}
