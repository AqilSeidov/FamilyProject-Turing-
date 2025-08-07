package projects.pet.sub_classes;

import projects.pet.Fouls;
import projects.pet.Pet;
import projects.pet.Species;

public class DomesticCat extends Pet implements Fouls {
    public DomesticCat() {
        super.setSpecies(Species.CAT);
    }

    public DomesticCat(String nickname) {
        super(nickname);
        super.setSpecies(Species.CAT);
    }

    public DomesticCat(String nickname,int age,int trickLevel,String [] habits) {
        super(nickname, age, trickLevel, habits);
        super.setSpecies(Species.CAT);
    }

    @Override
    public void respond(){
        System.out.printf("Hello, owner. I am cat %s. Meow, meow! %n", super.getNickname());
    }

    @Override
    public void foul(){
        System.out.println("DomesticCat scratched the wallpaper!");
    }

}
