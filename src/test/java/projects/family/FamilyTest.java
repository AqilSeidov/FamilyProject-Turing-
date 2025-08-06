package projects.family;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projects.human.Human;
import projects.pet.Pet;
import projects.pet.Species;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {
    private Family family;
    private Human mother;
    private Human father;
    private Human child1;
    private Human child2;
    private Pet pet;


    @BeforeEach
    void setUp() {
        mother = new Human("Jane", "Doe", 1980);
        father = new Human("John", "Doe", 1975);
        family = new Family(mother, father);
        child1 = new Human("Alice", "Doe", 2010);
        child2 = new Human("Bob", "Doe", 2012);
        pet = new Pet(Species.DOG, "Freddy");
        family.setPet(pet);
    }

    @Test
    void addChild_AddsChildAndUpdatesReference() {
        Human child = new Human("Bred","Summer",2000);
        int initialCount = family.getChildCount();

        assertTrue(family.addChild(child));
        assertEquals(initialCount+1,family.getChildCount());
        assertSame(family,child.getFamily());
    }

    @Test
    void addChild_RejectsNullChild() {
        assertFalse(family.addChild(null));
    }

    @Test
    void deleteChildByObject_RemovesChild(){
        family.addChild(child1);
        family.addChild(child2);
        int initialCount = family.getChildCount();

        assertTrue(family.deleteChild(child1));
        assertEquals(initialCount-1,family.getChildCount());
        assertNull(child1.getFamily());
    }

    @Test
    void deleteChildByObject_KeepArraySameWhenChildNotFound() {
        family.addChild(child1);
        Human unknown = new Human("Unknown", "Doe", 2005);
        int initialCount = family.getChildCount();

        assertFalse(family.deleteChild(unknown));
        assertNotEquals(initialCount-1,family.getChildCount());
    }

    @Test
    void deleteChildByIndex_RemovesChildAtIndex() {
        family.addChild(child1);
        family.addChild(child2);
        int initialCount = family.getChildCount();

        assertTrue(family.deleteChild(0));
        assertEquals(initialCount-1,family.getChildCount());
        assertNull(child1.getFamily());
    }

    @Test
    void deleteChildByIndex_ReturnsFalseForInvalidIndex() {
        family.addChild(child1);
        family.addChild(child2);
        int initialCount = family.getChildCount();

        assertFalse(family.deleteChild(15));
        assertFalse(family.deleteChild(-1));
        assertFalse(family.deleteChild(initialCount));
        assertNotEquals(initialCount-1, family.getChildCount());

    }

    @Test
    void countFamily_ReturnsCorrectCount() {
        assertEquals(2, family.countFamily());

        family.addChild(child1);
        assertEquals(3, family.countFamily());

        family.addChild(child2);
        assertEquals(4, family.countFamily());

        family.deleteChild(0);
        assertEquals(3, family.countFamily());
    }


}