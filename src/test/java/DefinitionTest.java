import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class DefinitionTest{

  @Test
  public void instanciation_testForDefinitionInstanciatingCorrectly_instance() {
    Definition testObj = new Definition("Defined Here");
    assertTrue(testObj instanceof Definition);
  }

  @Test
  public void getDefinition_testForDefinitionGettingName_String() {
    Definition testObj = new Definition("Defined Here");
    assertEquals("Defined Here", testObj.getDefinition());
  }
}
