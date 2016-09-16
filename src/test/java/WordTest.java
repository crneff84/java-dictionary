import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class WordTest{
  @After
  public void teardown() {
    Word.clear();
  }

  @Test
  public void instanciation_testForCorrectInstanciation_Object() {
    Word testObj = new Word("Word 1");
    assertTrue(testObj instanceof Word);
  }

  @Test
  public void getWord_testForWordReturningWord_string() {
    Word testObj = new Word("Word 1");
    assertEquals("Word 1", testObj.getWord());
  }

  @Test
  public void getId_testForWordGettingId_int() {
    Word testObj = new Word("Word 1");
    assertEquals(1, testObj.getId());
  }

  @Test
  public void getDefinitionCount_testForWordGettingDefinitionCount_int() {
    Word testObj = new Word("Word 1");
    assertEquals(0, testObj.getDefinitionCount());
  }

  @Test
  public void all_testForWordReturningAllInstances_List() {
    Word testObj = new Word("Word 1");
    Word testObj2 = new Word("Word 2");
    assertEquals(testObj, Word.all().get(0));
    assertTrue(Word.all().contains(testObj2));
  }

  @Test
  public void find_testForWordReturningWordInstancesById_Object() {
    Word testObj = new Word("Word 1");
    Word testObj2 = new Word("Word 2");
    assertEquals(testObj, Word.find(testObj.getId()));
    assertEquals(testObj2, Word.find(2));
  }

  @Test public void addDefinition_testForWordAddingDefinitions_String() {
    Word testObj = new Word("Word 1");
    Definition defined = new Definition("Definition 1");
    Definition defined2 = new Definition("Definition 2");
    testObj.addDefinition(defined);
    testObj.addDefinition(defined2);
    assertEquals("Definition 2", testObj.findDefinition(2).getDefinition());
  }

  @Test
  public void findDefinition_testForWordFindingDefinitionById_Object() {
    Word testObj = new Word("Word 1");
    Definition defined = new Definition("Definition 1");
    Definition defined2 = new Definition("Definition 2");
    testObj.addDefinition(defined);
    testObj.addDefinition(defined2);
    assertEquals(defined, testObj.findDefinition(1));
    assertEquals(defined2, testObj.findDefinition(2));
  }
}
