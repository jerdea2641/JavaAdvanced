/*Jeremy Dean
08.14.2026
Week 3 Pet Adoption System
Abstract class for all pets
 */

public abstract class Pet 
{
    //protect inherited classes to use these values
   private String name;
   private int age; 

   public Pet()
   {
    this.name = "Unknown";
    this.age = 0;
   }

   public Pet(String name, int age)
   {
    this.name = name;
    this.age = age;
   }

   public String getName()
   {
    return name;
   }

   public int getAge()
   {
    return age;
   }

   public abstract void displayInfo();


}
