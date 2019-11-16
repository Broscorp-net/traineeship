
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Garbage {

  private static Logger LOGGER = Logger.getLogger(Garbage.class.getName());
  static final List RESURRECTED = new ArrayList<>();

  public static void main(String[] var0) {

    for (int i = 0; i < 10000; i++) {
      CreateObject createdObject = new CreateObject(new NewObject());
      LOGGER.info("object created");
      createdObject.finalize();
    }
    System.out.println(RESURRECTED);
  }

  static class NewObject {

  }

  public static class CreateObject {

    private NewObject object;

    public CreateObject(NewObject object) {
      this.object = object;
    }

    @Override
    protected void finalize() {
      LOGGER.info("object deleted");
      RESURRECTED.add(this);
      LOGGER.info("object resurrected");
    }
  }
}


