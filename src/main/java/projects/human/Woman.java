package projects.human;

import projects.family.Family;

public final class Woman extends Human  {

    public Woman(String name, String surname, int birthDate, int iq, Family family, String[][] activities) {
        super(name, surname, birthDate, iq, family, activities);

    }

    public void greetPet(){
        if(this.getFamily() == null || this.getFamily().getPet() == null){
            System.out.println("Couldn't find a pet to meet");
            return;
        }else{
            System.out.println("Hello, " + getFamily().getPet().getNickname());
        }
    }
    public void makeup() {
        System.out.println("I'm doing makeup");
    }


}
