package projects.pet.sub_classes;

import projects.pet.Fouls;
import projects.pet.Pet;
import projects.pet.Species;

public class GenericPet extends Pet implements Fouls {

    public GenericPet(){
        super.setSpecies(Species.UNKNOWN);
    }

    public GenericPet(String nickname){
        super(nickname);
        super.setSpecies(Species.UNKNOWN);
    }

    public GenericPet(String nickname,int age,int trickLevel,String [] habits){
        super(nickname,age,trickLevel,habits);
        super.setSpecies(Species.UNKNOWN);
    }

    @Override
    public void respond(){
        System.out.printf("Hello Owner. I am pet %s, making sound! %n", super.getNickname());
    }

    @Override
    public void foul(){
        System.out.println("Pet made a foul");
    }

}
