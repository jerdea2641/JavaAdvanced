public class Cat extends Pet implements Adoptable
{
    private String breed;
    private String traits;
    private boolean indoorOnly;
    private String favoriteToy;
    private boolean adopted;


    public Cat(String name, int age, String breed, String traits) 
    {
        super(name, age);
        this.breed = breed;
        this.traits = traits;
        this.indoorOnly = true;
        this.favoriteToy = "Unknown";
        this.adopted = false;
    }

    public Cat(String name, int age) 
    {
        super(name, age);
        this.breed = "Unknown";
        this.traits = "Unknown";
        this.indoorOnly = true;
        this.favoriteToy = "Unknown";
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
    //Getter for indoorOnly
    public boolean isIndoorOnly()
    {
        return indoorOnly;
    }
    //Getter for favoriteToy
    public String getFavoriteToy()
    {
        return favoriteToy;
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
    //Setter for indoorOnly
    public void setIndoorOnly(boolean indoorOnly)
    {
        this.indoorOnly = indoorOnly;
    }
    //Setter for favoriteToy
    public void setFavoriteToy(String favoriteToy)
    {
        this.favoriteToy = favoriteToy;
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
        System.out.println("\nCat Name: " + getName());
        System.out.println("Age: " + getAge() + " years");
        System.out.println("Breed: " + breed);
        System.out.println("Traits: " + traits);
        System.out.println("Indoor Only: " + indoorOnly);
        System.out.println("Favorite Toy: " + favoriteToy);
        System.out.println("Available: " + !adopted);
    }
}
