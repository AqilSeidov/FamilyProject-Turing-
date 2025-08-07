package projects.human;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projects.family.Family;
import projects.pet.Pet;
import projects.pet.Species;
import projects.pet.sub_classes.DomesticCat;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    private Human human;
    private Human mother;
    private Human father;
    private Family family;
    private Pet pet;

    @BeforeEach
    void setUp() {
        mother = new Human("Jane", "Doe", 1980);
        father = new Human("John", "Doe", 1975);
        family = new Family(mother, father);
        human = new Human("Roxy", "Doe", 2000);
        pet = new DomesticCat("Felix");
    }


    @Test
    public void feedPet_returnsTrueIfAllConditionsMet(){
        family.addChild(human);
        family.setPet(pet);

        assertNotNull(human.getFamily());
        assertNotNull(family.getPet());
        assertTrue(human.feedPet(true));

    }

    @Test
    public void feedPet_returnsFalseWhenNoFamily(){
        family.setPet(pet);

        assertNull(human.getFamily());
        assertFalse(human.feedPet(false));
    }

    @Test
    public void feedPet_ReturnsFalseWhenNoPet(){
        family.addChild(human);

        assertNotNull(human.getFamily());
        assertNull(family.getPet());
        assertFalse(human.feedPet(false));
    }

    @Test
    void testIqAndActivities() {
        String[][] activities = {{"Monday", "Swimming"}, {"Tuesday", "Reading"}};
        Human human2 = new Human("Alice", "Smith", 1990, 120, family, activities);

        assertEquals(120, human2.getIq());
        assertArrayEquals(activities, human2.getActivities());
    }

    @Test
    void testNullActivities() {
        Human human = new Human("Bob", "Johnson", 1985);
        assertNull(human.getActivities());
    }

    @Test
    void testEquality() {
        Human human1 = new Human("Alice", "Smith", 1990);
        Human human2 = new Human("Alice", "Smith", 1990);

        assertEquals(human1, human2);
        assertEquals(human1.hashCode(), human2.hashCode());
    }

    @Test
    void testActivitiesSetterGetter() {
        String[][] initialActivities = {{"Monday", "Swimming"}, {"Tuesday", "Reading"}};
        Human human = new Human();


        human.setActivities(initialActivities);
        assertArrayEquals(initialActivities, human.getActivities());

        human.setActivities(null);
        assertNull(human.getActivities());

        String[][] newActivities = {{"Wednesday", "Running"}};
        human.setActivities(newActivities);
        newActivities[0][1] = "Modified";
        assertEquals("Running", human.getActivities()[0][1]);
    }

}