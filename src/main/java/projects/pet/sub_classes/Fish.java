package projects.pet.sub_classes;


import projects.pet.Pet;
import projects.pet.Species;

public class Fish extends Pet {

    public Fish() {
        super.setSpecies(Species.FISH);
    }

    public Fish(String nickname) {
        super(nickname);
        super.setSpecies(Species.FISH);
    }

    public Fish(String nickname,int age,int trickLevel,String [] habits){
        super(nickname,age,trickLevel,habits);
        super.setSpecies(Species.FISH);
    }

    @Override
    public void respond(){
        System.out.printf("Hello, owner. I am fish %s. Blub, blub! %n", super.getNickname());
    }
}
