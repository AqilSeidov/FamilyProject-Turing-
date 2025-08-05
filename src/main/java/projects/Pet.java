package projects;

import java.util.Arrays;

public class Pet {

     String species;
     String nickname;
     int age;
     int tricklevel;
     String [] habits;

    public Pet() {}
    public Pet(String species,String nickname){
        this.species=species;
        this.nickname=nickname;
    }
    public Pet(String species,String nickname,int age,int tricklevel,String [] habits){
        this.species=species;
        this.nickname=nickname;
        this.age=age;
        this.tricklevel=tricklevel;
        this.habits=habits;

    }
    public void eat(){
        System.out.println("Pet eating");
    }
    public void respond(){
        System.out.printf("Hello owner.I am- %s.I miss you", nickname);
    }
    public void foul(){
        System.out.println("I need to cover it up");
    }

    @Override
    public String toString() {
        return "Pet{" +
                "species='" + species + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", tricklevel=" + tricklevel +
                ", habits=" + Arrays.toString(habits) +
                '}';
    }
}
