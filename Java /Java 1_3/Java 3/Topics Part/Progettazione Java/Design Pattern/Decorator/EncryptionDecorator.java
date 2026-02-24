package eserciziLezione13;

public class EncryptionDecorator {
	
	
	public String encrypt(String text, int offset) {
	    
	    int shift = (offset % 26 + 26) % 26;
	    StringBuilder result = new StringBuilder();

	    for (char c : text.toCharArray()) {
	        if (Character.isLetter(c)) {
	            char base = Character.isUpperCase(c) ? 'A' : 'a';
	           
	            char shifted = (char) ((c - base + shift) % 26 + base);
	            result.append(shifted);
	        } else {
	            result.append(c); 
	        }
	    }
	    return result.toString();
	}


}


