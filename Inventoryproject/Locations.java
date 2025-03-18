	//locations.java
/* 
 * Title: Material Location 
 * Author:Fatima Omar 
 * Date: March 14 2024 
 */
	package Inventoryproject;
	import java.io.*;
	import java.util.ArrayList;

	public class Locations {
	  // --- INPUTS--
	  // loads file into program as ArrayList / every line of the file being a item in the list
	private ArrayList<Materials> storage = new ArrayList<Materials>();  
	public static ArrayList<String> fileImport = new ArrayList<String>();
	  
	public static ArrayList<String> loadStingList(String filename){
	ArrayList<String> temp = new ArrayList<String>();
	  
	  try {
	    BufferedReader file = new BufferedReader(new FileReader(filename));
	    while (file.ready()){
	      temp.add(file.readLine());
	    }
	    file.close();
	  } catch (IOException e){
	    System.out.println(e);
	  }
	  return temp;
	}

	  
		public void Addmaterials(Materials supplies) {
			// add an material  to arraylist
			this.storage.add(supplies);
		
			
			}
			
		public void Viewlocation() {
	    // looping through the ArrayList and printing each item and there index size number
		for(Materials locations: this.storage) {
			System.out.println(   locations.toString() + " \n Index #: "  + this.storage.indexOf(locations)  );
			
		}	 

			
		}
		
		public void RemoveMaterials(int index) {
	    // removing material from storage ArrayList using index of item
			this.storage.remove(index);
			
		}
		
	// --OUTPUT--
	  //Saves an ArrayList to a text file 
	public void SaveStringList(String filename){
	  try{
	    PrintWriter file = new PrintWriter(new FileWriter(filename));
	    for (int i = 0; i < this.storage.size(); i++){
	      file.println(this.storage.get(i));
	    }
	    file.close();
	  }catch(IOException ex ){
	    System.out.println(ex.toString());

	  }
	}


		public static void main(String[] args) {
	fileImport= loadStingList("Storage.txt");
	    System.out.println(fileImport);
		}

	}


