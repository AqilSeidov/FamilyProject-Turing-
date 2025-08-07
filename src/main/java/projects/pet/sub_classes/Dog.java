package projects.pet.sub_classes;

import projects.pet.Fouls;
import projects.pet.Pet;
import projects.pet.Species;

public class Dog extends Pet implements Fouls {

    public Dog() {
        super.setSpecies(Species.DOG);
    }

    public Dog(String nickname){
        super(nickname);
        super.setSpecies(Species.DOG);
    }

    public Dog(String nickname,int age,int trickLevel,String [] habits){
        super(nickname,age,trickLevel,habits);
        super.setSpecies(Species.DOG);
    }

    @Override
    public void respond(){
        System.out.printf("Hello, owner. I am dog %s. Whof, whof! %n", super.getNickname());
    }

    @Override
    public void foul(){
        System.out.println("Dog chewed the sofa!");
    }
}
