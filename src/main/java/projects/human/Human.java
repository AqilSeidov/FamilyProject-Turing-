package projects.human;

import projects.family.Family;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

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
        family.addChild(this);
    }
    public Human(String name, String surname, int birthDate, int iq, Family family ) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
        this.family = family;
        family.addChild(this);
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

    public String[][] getActivities() {
        return activities != null ? Arrays.copyOf(activities, activities.length) : null;
    }

    public void setActivities(String[][] nonWorkingActivities) {
        if (nonWorkingActivities ==null){
            this.activities = null;
            return;
        }

        this.activities = new String[nonWorkingActivities.length][];

        for (int i = 0; i < nonWorkingActivities.length; i++) {
            if (nonWorkingActivities[i] != null) {
                this.activities[i] = Arrays.copyOf(nonWorkingActivities[i],
                        nonWorkingActivities[i].length);
            }
        }
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


    //Helper Method
    public String printActivities() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < activities.length; i++) {
            builder.append(activities[i][0] + "->");
            builder.append(activities[i][1] + ", ");
        }
        builder.delete(builder.lastIndexOf(","), builder.length());
        builder.append("]");
        return builder.toString();
    }


    public void greetPet(){
        if(this.family == null || this.family.getPet() == null){
            System.out.println("Couldn't find a pet to meet");
            return;
        }else{
            System.out.println("Hello, " + family.getPet().getNickname());
        }
    }


    public void describePet(){
        if(this.family == null || this.family.getPet() == null){
            System.out.println("Couldn't find a pet to describe");
            return;
        }
        else{
            String isSly = family.getPet().getTrickLevel() > 50 ? "very sly" : "almost not sly";
            System.out.printf("I have an %s is %d years old, it is %s. %n",family.getPet().getSpecies(),family.getPet().getAge(),isSly);
        }
    }


    public boolean feedPet(boolean isItTimeToFeed){
        if(isItTimeToFeed && this.family != null && this.family.getPet() != null){
            System.out.println("Hmm... I will feed " + family.getPet().getNickname());
            return true;

        }else if(this.family != null && this.family.getPet() != null){
            Random rand = new Random();
            int randResult = rand.nextInt(0,100);

            if(randResult < family.getPet().getTrickLevel()){
                System.out.println("Hmm... I will feed " + family.getPet().getNickname());
                return true;

            }else{
                System.out.printf("I think %s isn't hungry.%n",family.getPet().getNickname());
                return false;
            }
        }else{
            System.out.println("Couldn't find a pet to feed");
            return false;
        }
    }


    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                "| surname='" + surname + '\'' +
                "| birthDate=" + birthDate +
                "| iq=" + iq +
                "| family=" + family +
                "| activities=" + printActivities() +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("[GC] -> Human object with name: %s %s is being deleted.%n",name,surname);
        super.finalize();
    }


}