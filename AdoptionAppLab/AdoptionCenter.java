/*Jeremy Dean
08.27.2026
Week 5 Pet Adoption System
 */

import java.util.ArrayList;

public class AdoptionCenter 
{
     private ArrayList<Pet> pets;

    public AdoptionCenter()
    {
        pets = new ArrayList<>();
    }

    public void addPet(Pet pet)
    {
        pets.add(pet);
    }

    public void displayPets()
    {
        if (pets.isEmpty())
        {
            System.out.println("There are currently no pets available.");
            return;
        }

        int number = 1;

        for (Pet pet : pets)
        {
            System.out.println("\nPet #" + number);
            pet.displayInfo();
            number++;
        }
    }

    public ArrayList<Pet> getPets()
    {
        return pets;
    }
}
