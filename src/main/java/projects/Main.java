package projects;


import projects.family.Family;
import projects.human.Human;
import projects.pet.Pet;
import projects.pet.Species;

public class Main {
    public static void main(String[] args) throws Throwable {

        Human mom = new Human("Alex","Johnson",1970);
        Human dad = new Human("Lilly","Johnson",1973);

        for(int i =0; i<1000000; i++){
            new Human("Aqil","Saidov",2006);
            new Pet(Species.DOG, "Bright");
            new Family(dad,mom);
        }
    }
}