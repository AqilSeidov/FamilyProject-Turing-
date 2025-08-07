package projects.family;


import projects.human.Human;
import projects.human.HumanCreator;
import projects.human.Man;
import projects.human.Woman;
import projects.pet.Pet;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Family implements HumanCreator {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;
    private int childCount;
    private static final String[] boyNames = {"Aqil", "Saleh", "Orxan", "Tural"};
    private static final String[] girlNames = {"Aysel", "Nigar", "Zeyneb", "Zehra"};
    private static final Random random = new Random();


    public Family(Human mother, Human father) {
        checkArguments(mother, father);
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];
        this.childCount = 0;
    }


    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }


    public void bornChild(){
        boolean isBoy = random.nextBoolean();

        String name = isBoy ? boyNames[random.nextInt(boyNames.length)] : girlNames[random.nextInt(girlNames.length)];
        Human child;

         String surname=this.father.getSurname();
         int birthDate = LocalDate.now().getYear();
         int iq=(mother.getIq()+father.getIq())/2;

        if (isBoy) {
            child = new Man(name,surname, birthDate, iq, this);
        } else {
            child = new Woman(name,surname , birthDate, iq, this);
        }

    }

    public boolean addChild(Human child) {
        if (child != null) {
            children = Arrays.copyOf(children, ++childCount);
            children[childCount-1] = child;
            child.setFamily(this);
            return true;
        }
        else {
            System.out.println("Couldn't add the child.");
            return false;
        }
    }

    public boolean deleteChild(Human child) {
        for(int i = 0; i < childCount; i++) {
           if(child.equals(children[i])) {
               return deleteChild(i);
           }
        }
        return false;
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= childCount) {
            return false;
        }
        children[index].setFamily(null);

        for(int j = index; j < childCount-1; j++) {
            children[j] = children[j+1];
        }
        children[--childCount] = null;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) && Objects.equals(father, family.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father);
    }

    public int countFamily() {
        return 2 + childCount;
    }

    //Helper Methods
    private String[] printChildrenNames(){
        if (childCount == 0) return new String[0];

        String[] names = new String[childCount];
        for(int i = 0; i < childCount; i++) {
            names[i] = children[i].getName()+" "+children[i].getSurname();
        }
        return names;
    }

    private String printParentName(Human parent){
        return parent.getName()+" "+parent.getSurname();
    }

    public void checkArguments(Human mother, Human father) {
        if (mother == null || father == null) {
            throw new IllegalArgumentException("Any one of the arguments is null");
        }
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + printParentName(mother) +
                "| father=" + printParentName(father) +
                "| children=" + Arrays.toString(printChildrenNames()) +
                "| pet=" + (pet != null && pet.getNickname() != null ? pet.getNickname() : "None") +
                "| childCount=" + childCount +
                '}';
    }

    @Override
    public void finalize() throws Throwable {
        System.out.printf("[GC] -> Family object of %s and %s is being deleted.%n",father.getName(),mother.getName());
        super.finalize();
    }
}