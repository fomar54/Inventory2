///materials.java
/* 
 * 
 * Title: Materials
 * Author: Fatima Omar 
 * Date: March 14, 2024 
 */


package Inventoryproject;



	public class Materials {
	 private String materialName;

	 	// Constructor  // all materials have names
	 	public Materials(String name) {
	 		this.materialName = name;
	 	}
	 
		public static void main(String[] args) {
			Materials supplies = new Materials("hi");
			
		}
		public String toString() {
			// prints variable as itemName
			return this.materialName	;
		}

	}
	


