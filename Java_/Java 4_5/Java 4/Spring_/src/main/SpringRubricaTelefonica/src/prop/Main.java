package prop;

import java.util.ResourceBundle;

/* * Main - Internationalization (i18n) Resource Loader
    ? Demonstrates the usage of `ResourceBundle` to manage external configuration and localization. It separates hardcoded strings from the source code, allowing the application to adapt to different languages or settings without recompilation.

    ! 1. ResourceBundle.getBundle(...), the factory method that locates and loads the specific `.properties` file (e.g., `config.properties`) from the classpath. It uses a naming convention to find the correct file based on the default Locale.
    ! 2. Key-Value Retrieval, usage of `.getString("saluto")` fetches the externalized string. This is the core mechanism for localization, where "saluto" could return "Ciao" in Italian or "Hello" in English depending on the active bundle.
    ! 3. Locale Sensitivity, the commented code hints at `Locale.US`, showcasing the ability to explicitly force a specific cultural context (e.g., loading `config_en_US.properties`), which is essential for multi-language support.
*/

public static void main(String[] args {
     
    //Aggancio il properties, another type. 
    ResourceBundle boundle = ResourceBundle.getBundle("prop.config");
//  ResourceBundle bonble = ResourcerBundle.getBundle("prop.config", Locale.US)

    System.out.println(boundle.getString("saluto"));
    System.out.println(boundle.getDefault());
}