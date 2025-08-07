package projects.human;


import projects.family.Family;

public final class Man extends Human {

    public Man(String name, String surname, int birthDate, int iq, Family family, String[][] activities) {
        super(name, surname, birthDate, iq, family, activities);

    }
    public Man(String name, String surname, int birthDate) {
        super(name, surname, birthDate);

    }
    public Man(String name, String surname, int birthDate, int iq, Family family ) {
       super(name , surname, birthDate, iq, family);
    }


    public Man() {}


    public void greetPet(){
        if(this.getFamily() == null || this.getFamily().getPet() == null){
            System.out.println("Couldn't find a pet to meet");
            return;
        }else{
            System.out.println("Hello, " + getFamily().getPet().getNickname());
        }
    }
    public void repairCar() {
        System.out.println("I am repairing the car");
    }
}

