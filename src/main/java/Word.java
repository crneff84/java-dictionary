import java.util.List;
import java.util.ArrayList;

public class Word {
  private String mWordName;
  private static List<Word> instances = new ArrayList<Word>();
  private int mId;
  private List<Definition> mDefinitions;

  public Word(String _wordName) {
    mWordName = _wordName;
    instances.add(this);
    mId = instances.size();
    mDefinitions = new ArrayList<Definition>();
  }

  public String getWordName() {
    return mWordName;
  }

  public static List<Word> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static Word find(int _id) {
    try{
      return instances.get(_id - 1);
    } catch(IndexOutOfBoundsException exception){
      return null;
    }
  }

  public List<Definition> getDefinitions() {
    return mDefinitions;
  }

  public void addDefinition(Definition _definition) {
    mDefinitions.add(_definition);
  }
}
