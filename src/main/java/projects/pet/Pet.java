package projects.pet;

import java.util.Arrays;

public abstract class Pet {

    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String [] habits;

    public Pet() {}

    public Pet(String nickname){
        this.nickname=nickname;
    }
    public Pet(String nickname,int age,int trickLevel,String [] habits){
        this.nickname=nickname;
        this.age=age;
        this.trickLevel=trickLevel;
        this.habits=habits;

    }

    public Species getSpecies() {return species;}

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public String[] getHabits() {return habits;}

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    public void eat(){
        System.out.println("Pet is eating");
    }

    public abstract void respond();

    @Override
    public String toString() {
        return "Pet{" +
                "species='" + species + '\'' +
                "| nickname='" + nickname + '\'' +
                "| age=" + age +
                "| trickLevel=" + trickLevel +
                "| habits=" + Arrays.toString(habits) +
                '}';
    }

    @Override
    public void finalize() throws Throwable {
        System.out.printf("[GC] -> Pet object with nickname: %s is being deleted.%n",nickname);
        super.finalize();
    }
}
