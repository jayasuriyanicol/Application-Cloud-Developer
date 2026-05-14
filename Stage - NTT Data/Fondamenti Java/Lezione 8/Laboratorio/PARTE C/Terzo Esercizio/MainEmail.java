package Lezione_07;

import java.util.HashSet;
import java.util.Set;

public class MainEmail {

	
	public static void main(String[] args) {
		
		
		EmailUniche m = new EmailUniche ("jayasuriyanicol28@gmail.com");
		EmailUniche m2 = new EmailUniche("jayasuriyanicol28@gmail.com");
		
		System.out.println(m.equals(m2));
		System.out.println(m.hashCode() == m2.hashCode());
		
		
		Set<EmailUniche> emailConvalidate = new HashSet<>();
		
		emailConvalidate.add(m);
		emailConvalidate.add(m2);
		
		System.out.println(emailConvalidate.size());
	}
}
