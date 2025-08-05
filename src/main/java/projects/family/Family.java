package projects.family;


import projects.human.Human;
import projects.pet.Pet;

import java.util.Arrays;

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
    public boolean deleteChild(String childName) {
        for(int i = 0; i < children.length; i++) {
            if (childName.equalsIgnoreCase(children[i].getName())){
                for (int j = i; i < childCount - 1; i++) {
                    children[j] = children[j + 1];
                }
                children[--childCount] = null;
                return true;

            }
        }
        return false;
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