//Person.java
/* 
 * Title: Preson Inventory
 * Author:Fatima Omar 
 * Date: March 14 2024 
 */



package Inventoryproject;
import java.util.Scanner;
public class Person {
 public Scanner choice =  new Scanner(System.in);
 public Scanner wantedMaterial = new Scanner(System.in);
 public Scanner moveMaterial = new Scanner(System.in);
 public Scanner removeMaterial = new Scanner (System.in);
  public Scanner  locationRemove = new Scanner(System.in);
  public Scanner  locationAdd = new Scanner(System.in);


  
 // differentiate between areas that are all are locations 
 private Locations locker = new Locations();
 private Locations backpack = new Locations();
 private Locations pencilcase = new Locations();
 
	
	public Person (){
		
	}
  // ----- INPUTS---- 
	// prints menu for user to choose from 
  // gets user input and returns it in to run method 
	public String setup() {
		 String choiceMade ;
		System.out.println(" Welcmome to Inventory");
		 System.out.println("  Options: "
		 		+ "[1] Add item"
		 		+ "[2] Move item"
		 		+ " [3] Remove item" 
		 		+ " [4] View storage"
        + " [5] Save/ Load storage ");	
		 //getting user input 
		 choiceMade = choice.nextLine();	 
		//GETTER  
    // user input return vairable assgined to scanner to use in run() method 
		 return choiceMade;
	}
  
	// ------PROCESSING --------
  // takes scanner input assgins a string variable to be compared to the options avaible 
	public void run() {
		
		//compares the input to options 
		String choiceMade = setup(); 
		
	
		
		if(choiceMade.equals("1")) {
			String materialAdded;
			 System.out.println("Enter material you would like to add ");
			 
	 materialAdded = wantedMaterial.nextLine();
	 //creates an new object of material class and adds it to storage ArrayList fo location Backpack
	this.backpack.Addmaterials(new Materials(materialAdded));
	
	System.out.println("Material added sucessfully ");	 

		}
		
		if (choiceMade.equals("2")) {
			int materialRemoved ;
      String materialMoved;
			String location1 ;
        String location2;
      
      System.out.println("Where would you like to remove the material?");
      System.out.println("Options: Backpack, Locker, Pencilcase");
      location1 = locationRemove.nextLine();
      //taking in user input(String) location 1 used to remove material from storage 

      //Printing out all storage  
      System.out.println("Locker Storage:");
      this.locker.Viewlocation();
      System.out.println("Backpack Storage: ");
      this.backpack.Viewlocation();
      System.out.println("Pencil Case Storage");
      this.pencilcase.Viewlocation();
     
System.out.println("What material would you like to move? (input the number index of item)");
			
			materialRemoved = moveMaterial.nextInt();
	// takes user input(int) to match index int of item to remove from ArrayList
      
      System.out.println("Name the item ");
      
      materialMoved = moveMaterial.nextLine();
      // takes user input(String) will be used to add material to location2 
			System.out.println("Where do you want to place it ");
      
		  location2 = locationAdd.nextLine();
			// second location used in method to add material in 

      //comparing user input to optional scenarios
    // if  location1 user iput matches Backpack then material is being removed from backpack storage 
      if (location1.equals ("Backpack")){
        this.backpack.RemoveMaterials(materialRemoved);
        // if location2 user input matches locker then material is being added to locker storage 
        if (location2.equals ("Locker")){
          this.locker.Addmaterials(new Materials(materialMoved));
        }
        // if location2 user input matches pencilcase  then material is being added to pencilcase storage
        if (location2.equals ("Pencilcase")){
          this.pencilcase.Addmaterials(new Materials(materialMoved));
        }
       
      }
    
        if (location1.equals ("Locker")){
          
          this.locker.RemoveMaterials(materialRemoved);
          
          if (location2.equals ("Backpack")){
            this.backpack.Addmaterials(new Materials(materialMoved));
          }
          if (location2.equals ("Pencilcase")){
            this.pencilcase.Addmaterials(new Materials(materialMoved));
          }

        }
      
      if (location1.equals ("Pencilcase")){

        this.pencilcase.RemoveMaterials(materialRemoved);

        if (location2.equals ("Backpack")){
          this.backpack.Addmaterials(new Materials(materialMoved));
        }
        if (location2.equals ("Locker")){
          this.locker.Addmaterials(new Materials(materialMoved));
        }

      }

        // sucess message for user to see when material is moved
         System.out.println("Sucesfully moved material ");
            
      }
    
		if(choiceMade.equals("3") ) {
			int materialRemoved ;
      String location ; 
			System.out.println("Where would you like to remove ");

      location = removeMaterial.nextLine();
      
			System.out.println("What would you like to remove?");
			
			materialRemoved = removeMaterial.nextInt();
       
     
      // comparing user input to optional scenarios of different locations 
      
       // userinput materialRemoved as int to match index of item to remove from ArrayList
		if(location.equals("Locker")){
		this.locker.RemoveMaterials((materialRemoved));
    }
      if(location.equals("Backpack")){
      this.backpack.RemoveMaterials((materialRemoved));
      }
      
      if(location.equals("Pencilcase")){
      this.pencilcase.RemoveMaterials((materialRemoved));
      }
      // calling removeMaterials method from Locations class to remove material from storage ArrayList from location
		}

    
    // -- OUTPUT-- 
    // Displays all storage from each location's method Viewlocation that printa the  ArrayList and size index of each item
		if(choiceMade.equals("4") ) {
			System.out.println("Locker Storage:");
			
			  this.locker.Viewlocation();
			  
			  System.out.println("Backpack Storage: ");
			  
			  this.backpack.Viewlocation();
			  
			  System.out.println("Pencil Case Storage");
			  this.pencilcase.Viewlocation();
		}
		
	
    // Saving storage in text file and loading storage from text file 
    if (choiceMade.equals("4") ){
       String option;
 System.out.println("Save or Load");
    option  = choice.nextLine();
      if (option.equals("Save")){
        this.backpack.SaveStringList("Storage.txt");
          this.locker.SaveStringList("Storage.txt" );
          this.pencilcase.SaveStringList("Storage.txt");

        System.out.println("Sucessfuly saved ");
      }
      else {
        
        this.backpack.loadStingList("backpack.txt");
        this.locker.loadStingList("locker.txt");
        this.pencilcase.loadStingList("pencilcase.txt");
        
         System.out.println("Sucessfuly Loaded  ");
      
    }
      
  
    }//end of choiceMade if statement
    
	}

	public static void main(String[] args) {
		Person person = new Person();
		person.run();
		person.setup();
	}

}
