import java.util.List;
import java.util.ArrayList;

public class Definition {
  private String mDefinition;
  private int mId;
  private static List<Definition> instances = new ArrayList<Definition>();


  public Definition(String _definition) {
    mDefinition = _definition;
    instances.add(this);
    mId = instances.size();
  }

  public String getDefinition() {
    return mDefinition;
  }

  public int getId() {
    return mId;
  }

  public static List<Definition> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public static Definition find(int _id) {
    return instances.get(_id - 1);
  }
}
