/*Example of classes in Java.
  OOP -> Object Oriented Programming 
*/

package corsoBase;

import java.util.Date;

public class Lezione4_0 {
		
		public static void main(String[] args) {
			
			//For convention we will use pre-build date, not others advanced 
			Date d = new Date();
			
			//We can use also the form -> 'd.toString()' || d  trasform object to a sting
			System.out.println(d);
			
			//Deprecate form,used in 1900 the '2025' for save memory convert it into -> '125'
			System.out.println(d.getYear());
			System.out.println(d.getMonth());
			
			//Set the Moth, it will set other things. For example today Friday 28 Nov 2025 setting the month to 12 -> +2 months to ' Wed 28 Jan 2026'.
			d.setMonth(12);
			System.out.println(d);
			
			
			//Creation the varaible of Christmas, to show the date of Christmas Date
			Date natale = new Date(125,11,25);
			
			System.out.println(natale);
		}
	}

