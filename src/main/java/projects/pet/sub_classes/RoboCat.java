package projects.pet.sub_classes;

import projects.pet.Fouls;
import projects.pet.Pet;
import projects.pet.Species;

public class RoboCat extends Pet implements Fouls {
    public RoboCat(){
        super.setSpecies(Species.ROBOCAT);
    }

    public RoboCat(String nickname){
        super(nickname);
        super.setSpecies(Species.ROBOCAT);
    }

    public RoboCat(String nickname,int age,int trickLevel,String [] habits){
        super(nickname,age,trickLevel,habits);
        super.setSpecies(Species.ROBOCAT);
    }

    @Override
    public void respond(){
        System.out.printf("Hello owner. I am robocat %s. RoboMeow, roboMeow! %n", super.getNickname());
    }

    @Override
    public void foul(){
        System.out.println("Robocat made so much voice!");
    }
}
