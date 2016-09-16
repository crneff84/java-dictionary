import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class DefinitionTest{

  @After
  public void teardown() {
    Definition.clear();
  }

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

  @Test
  public void getId_testForDefinitionGettingId_int() {
    Definition testObj = new Definition("Defined Here");
    Definition testObj2 = new Definition("Defined 2 Here");
    assertEquals(1, testObj.getId());
    assertEquals(2, testObj2.getId());
  }

  @Test
  public void all_testForDefinitionReturningInstance_List () {
    Definition testObj = new Definition("Defined Here");
    Definition testObj2 = new Definition("Defined 2 Here");
    assertTrue(Definition.all().contains(testObj));
    assertTrue(Definition.all().contains(testObj2));
  }

  @Test
  public void find_testForDefinitionFindingInstancesById_Object() {
    Definition testObj = new Definition("Defined Here");
    Definition testObj2 = new Definition("Defined 2 Here");
    assertEquals(testObj, Definition.find(1));
    assertEquals(testObj2, Definition.find(2));
  }
}
