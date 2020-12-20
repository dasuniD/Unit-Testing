package ex3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.platform.commons.util.ReflectionUtils;
import ex3.Developer;
import java.util.ArrayList;
import java.util.List;
import java.util.EnumSet;
import java.lang.reflect.Method; 


class openFridgeTest{
    @Test
	@DisplayName("Test openFridge method")
	void verifyOpenFridge() {
		Office ofz = new Office(2);
        List<Developer> dev = new ArrayList<Developer>(EnumSet.allOf(Developer.class));
        ofz.openFridge(dev);
        assertEquals(6,ofz.maxibonsLeft, "maxibonsLeft should be 6");
	}
 
    @Test
	@DisplayName("Test grabMaxibons method")
    void verifyGrabMaxibons() {
		Office ofz = new Office(2);
        Class class1 = ofz.getClass(); 
        Method[] methods = class1.getMethods(); 
        try{
        Method methodcall1 = class1.getDeclaredMethod("grabMaxibons",Developer.class);
        methodcall1.setAccessible(true);  
        methodcall1.invoke(ofz,Developer.PEDRO);
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
        assertEquals(0,ofz.maxibonsLeft, "maxibonsLeft should be 0");
	}

}
