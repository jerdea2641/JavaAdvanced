/*Jeremy Dean
08.27.2026
Week 5 Pet Adoption System
represents dog up for adoption
 */

public class Dog extends Pet implements Adoptable
{
    private String breed;
    private String traits;
    private String size;
    private String energyLevel;
    private boolean adopted;

    public Dog(String name, int age, String breed, String traits) 
    {
        super(name, age);
        this.breed = breed;
        this.traits = traits;
        this.size = "Unknown";
        this.energyLevel = "Unknown";
        this.adopted = false;
    }

    public Dog(String name, int age)
    {
        super(name, age);
        this.breed = "Unknown";
        this.traits = "Unknown";
        this.size = "Unknown";
        this.energyLevel = "Unknown";
        this.adopted = false;
    }

    //Getter for breed
    public String getBreed()
    {
        return breed;
    }
    //Getter for traits
    public String getTraits()
    {
        return traits;
    }
    //Getter for size
    public String getSize()
    {
        return size;
    }
    //Getter for energy level
    public String getEnergyLevel()
    {
        return energyLevel;
    }
    //Getter for adopted status
    public boolean isAdopted()
    {
        return adopted;
    }
    //Setter for breed
    public void setBreed(String breed)
    {
        this.breed = breed;
    }
    //Setter for traits
    public void setTraits(String traits)
    {
        this.traits = traits;
    }
    //Setter for size
    public void setSize(String size)
    {
        this.size = size;
    }
    //Setter for energy level
    public void setEnergyLevel(String energyLevel)
    {
        this.energyLevel = energyLevel;
    }   
    //Setter for adopted status
    public void setAdopted(boolean adopted)
    {
        this.adopted = adopted;
    }

    @Override
    public void adopt()
    {
        adopted = true;
    }

    @Override
    public void displayInfo()
    {
        System.out.println("\nDog Name: " + getName());
        System.out.println("Age: " + getAge() + " years");
        System.out.println("Breed: " + breed);
        System.out.println("Traits: " + traits);
        System.out.println("Size: " + size);
        System.out.println("Energy Level: " + energyLevel);
        System.out.println("Available: " + !adopted);
    }

}