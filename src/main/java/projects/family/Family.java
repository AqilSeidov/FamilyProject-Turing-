package projects.family;


import projects.human.Human;
import projects.pet.Pet;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;
    private int childCount;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[10];
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

    public void addChild(Human child) {
        if (childCount < children.length) {
            this.children[childCount++] = child;
            child.setFamily(this);
        }
        else {
            System.out.println("I couldn't add a child.");
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


    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + Arrays.toString(children) +
                ", pet=" + pet +
                ", childCount=" + childCount +
                '}';
    }
}