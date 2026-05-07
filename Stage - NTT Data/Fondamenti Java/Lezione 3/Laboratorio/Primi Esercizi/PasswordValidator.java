package Lezione_03;

public class PasswordValidator {
    
    public static void main(String[] args) {
        
        String testPassword = "password";

        
        boolean risultato = isPasswordValida(testPassword);
        
        
        System.out.println("La password '" + testPassword + "' è valida? " + risultato);
        
        
        System.out.println("La password 'ciao' è valida? " + isPasswordValida("ciao"));
    }

    
    
    
    
    public static boolean haLunghezzaValida(String pwd) {
        return pwd != null && pwd.length() >= 8;
    }

    public static boolean contieneNumero(String pwd) {
        if (pwd == null) return false;
        for (char c : pwd.toCharArray()) {
            if (Character.isDigit(c)) return true;
        }
        return false;
    }

    public static boolean contieneMaiuscola(String pwd) {
        if (pwd == null) return false;
        for (char c : pwd.toCharArray()) {
            if (Character.isUpperCase(c)) return true;
        }
        return false;
    }

    public static boolean isPasswordValida(String pwd) {
        return haLunghezzaValida(pwd) &&
               contieneNumero(pwd) && 
               contieneMaiuscola(pwd);
    }
}
