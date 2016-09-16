import java.util.List;
import java.util.ArrayList;

public class Word {
  private String mWord;
  private int mId;
  private int mDefinitionCount;
  private Definition[] mDefinitionList;
  private static List<Word> instances = new ArrayList<Word>();

  public Word (String word) {
    mWord = word;
    mDefinitionCount = 0;
    instances.add(this);
    mId = instances.size();
    mDefinitionList = new Definition[5];
    for (int i=0; i < 5; i++) {
      mDefinitionList[i] = new Definition("");
    }
  }

  public String getWord() {
    return mWord;
  }

  public int getId() {
    return mId;
  }

  public Definition[] getDefinitions() {
    return mDefinitionList;
  }

  public int getDefinitionCount() {
    return mDefinitionCount;
  }

  public static List<Word> all() {
    return instances;
  }

  public static Word find(int _id) {
    return instances.get(_id - 1);
  }

  public boolean addDefinition(Definition _definition) {
    if (mDefinitionCount < 5 && _definition.getDefinition() != "") {
      mDefinitionList[mDefinitionCount] = _definition;
      mDefinitionCount++;
      return true;
    } else {
      return false;
    }
  }

  public Definition findDefinition(int _definitionIndex) {
    try {
      return mDefinitionList[_definitionIndex - 1];
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

  public static void clear() {
    instances.clear();
  }
}
