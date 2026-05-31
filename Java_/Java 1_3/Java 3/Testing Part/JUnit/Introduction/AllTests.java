
/*  
    * JUnit - EsempioStringa exercise testing it 

    ? Creation the JUnit to check if all the giving classes work properly

    ! 1. Recall the testJava class 
    ! 2. testJava -> link to -> EsempioStringa 
*/

package testEsempioStringa;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import eserciziLezione14.EsempioStringa;

@Suite
@SelectClasses({ test.class, EsempioStringa.class })
public class AllTests {

}
