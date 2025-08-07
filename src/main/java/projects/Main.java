package projects;

import projects.family.Family;
import projects.human.Human;
import projects.human.Man;
import projects.human.Woman;
import projects.pet.Fouls;
import projects.pet.Pet;
import projects.pet.sub_classes.*;

public class Main {
    public static void main(String[] args) {
        // ========== 1. TEST PET CLASSES ==========
        System.out.println("===== Testing Pet Classes =====");

        // Test Dog (implements Fouls)
        Dog dog = new Dog("Buddy", 3, 75, new String[]{"barking", "fetching"});
        testPet(dog);

        // Test Fish (doesn't implement Fouls)
        Fish fish = new Fish("Nemo", 1, 30, new String[]{"swimming"});
        testPet(fish);

        // Test DomesticCat (implements Fouls)
        DomesticCat cat = new DomesticCat("Whiskers", 2, 60, new String[]{"purring", "scratching"});
        testPet(cat);

        // Test RoboCat (implements Fouls)
        RoboCat roboCat = new RoboCat("Byte", 1, 95, new String[]{"charging", "beeping"});
        testPet(roboCat);

        // Test GenericPet (UNKNOWN species)
        GenericPet unknownPet = new GenericPet("Mystery", 2, 50, new String[]{"hiding"});
        testPet(unknownPet);

        // Edge Case: Pet with null habits
        Dog dogWithNullHabits = new Dog("Rex", 4, 80, null);
        System.out.println("\nDog with null habits: " + dogWithNullHabits);

        // ========== 2. TEST HUMAN CLASSES ==========
        System.out.println("\n\n===== Testing Human Classes =====");

        // Create parents
        Man father = new Man("John", "Doe", 1975);
        father.setIq(90);
        Woman mother = new Woman("Jane", "Doe", 1980);
        mother.setIq(110);

        // Test human methods without family
        System.out.println("\nTesting human without family:");
        testHuman(new Man("Lonely", "Man", 1990));

        // ========== 3. TEST FAMILY OPERATIONS ==========
        System.out.println("\n\n===== Testing Family Operations =====");
        Family doeFamily = new Family(mother, father);

        // Test empty family
        System.out.println("\nEmpty family:");
        System.out.println(doeFamily);
        System.out.println("Family count: " + doeFamily.countFamily());

        // Add pets
        doeFamily.setPet(dog);
        System.out.println("\nFamily with dog:");
        testFamilyPetInteractions(doeFamily);

        // Test child management
        System.out.println("\n--- Testing Child Management ---");

        // Add children
        System.out.println("\nAdding children:");
        doeFamily.bornChild();
        doeFamily.bornChild();
        System.out.println(doeFamily);

        // Test child-specific features
        for (Human child : doeFamily.getChildren()) {
            if (child instanceof Man) {
                ((Man) child).repairCar();
            } else if (child instanceof Woman) {
                ((Woman) child).makeup();
            }
        }

        // Test deleting children
        System.out.println("\nDeleting first child:");
        Human firstChild = doeFamily.getChildren()[0];
        doeFamily.deleteChild(firstChild);
        System.out.println(doeFamily);

        // Test deleting non-existent child
        System.out.println("\nAttempting to delete non-existent child:");
        Human stranger = new Man("Stranger", "Danger", 2000);
        boolean deleted = doeFamily.deleteChild(stranger);
        System.out.println("Deletion successful? " + deleted);

        // Test invalid index deletion
        System.out.println("\nAttempting invalid index deletion:");
        deleted = doeFamily.deleteChild(5);
        System.out.println("Deletion successful? " + deleted);

        // ========== 4. TEST EDGE CASES ==========
        System.out.println("\n\n===== Testing Edge Cases =====");

        // Test null pet
        System.out.println("\nTesting null pet:");
        doeFamily.setPet(null);
        father.greetPet();
        father.describePet();
        father.feedPet(true);

        // Test family with single parent (should fail)
        System.out.println("\nAttempting to create family with single parent:");
        try {
            Family brokenFamily = new Family(mother, null);
            System.out.println("Successfully created");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test pet with invalid trickLevel
        System.out.println("\nTesting pet with invalid trickLevel (150):");
        Dog invalidDog = new Dog("BadBoy", 5, 150, new String[]{"misbehaving"});
        System.out.println("Actual trickLevel: " + invalidDog.getTrickLevel()); // Should clamp to 100

        // ========== 5. FINAL STATE ==========
        System.out.println("\n\n===== Final Family State =====");
        System.out.println(doeFamily);
    }

    private static void testPet(Pet pet) {
        System.out.println("\nTesting " + pet.getClass().getSimpleName() + ": " + pet);
        pet.eat();
        pet.respond();

        // Only try foul() if pet implements Fouls
        if (pet instanceof Fouls) {
            ((Fouls)pet).foul();
        } else {
            System.out.println(pet.getNickname() + " cannot foul (correct behavior)");
        }
    }

    private static void testHuman(Human human) {
        human.greetPet();
        human.describePet();
        human.feedPet(true);
    }

    private static void testFamilyPetInteractions(Family family) {
        family.getFather().greetPet();
        family.getMother().describePet();
        family.getFather().feedPet(false);
    }
}