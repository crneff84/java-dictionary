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
  public void instanciation_WordinstantiatesCorrectly_true() {
    Word testObj = new Word("Word 1");
    assertEquals(true, testObj instanceof Word);
  }

  @Test
  public void getWordName_testWordForGettingWordName_string() {
    Word testObj = new Word("Word 1");
    assertEquals("Word 1", testObj.getWordName());
  }

  @Test
  public void all_returnsAllInstancesOfWord_true() {
    Word testObj = new Word("Word 1");
    Word testObj2 = new Word("Word 2");
    assertEquals(true, Word.all().contains(testObj));
    assertEquals(true, Word.all().contains(testObj2));
  }

  @Test
  public void clear_emptiesAllWordsFromlist_int() {
    Word testObj = new Word("Word 1");
    Word.clear();
    assertEquals(0, Word.all().size());
  }

  @Test
  public void getId_testForWordGettingId_int() {
    Word testObj = new Word("Word 1");
    assertEquals(1, testObj.getId());
  }

  @Test
  public void find_returnsWordWithSameId_Object(){
    Word testObj = new Word("Word 1");
    Word testObj2 = new Word("Word 2");
    assertEquals(testObj2, Word.find(testObj2.getId()));
  }

  @Test
  public void find_returnsNullWhenNoDefinitionFound_True() {
    assertTrue(Word.find(999) == null);
  }

  @Test
  public void getDefinitions_intiallyReturnsEmptyList_0() {
    Word testObj = new Word("Word 1");
    assertEquals(0, testObj.getDefinitions().size());
  }

  @Test
  public void addDefinition_addsDefinitionToList_true() {
    Word testWord = new Word("Word 1");
    Definition testDefinition = new Definition("defined");
    testWord.addDefinition(testDefinition);
    assertTrue(testWord.getDefinitions().contains(testDefinition));
  }

}
