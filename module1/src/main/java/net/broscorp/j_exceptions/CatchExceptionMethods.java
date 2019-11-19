import java.io.FileReader;
import java.io.IOException;

public class CatchExceptionMethods {

    public void readFile_catchesIOException(String fileName) {
        try (FileReader file = new FileReader(fileName)) {
            throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Catches IOException.");
        }
    }

    public void readFile_catchesException(String fileName) {
        try (FileReader file = new FileReader(fileName)) {
            throw new IOException();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Catches Exception.");
        }
    }

    public void readFile_catchesThrowable(String fileName) {
        try (FileReader file = new FileReader(fileName)) {
            throw new IOException();
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            System.out.println("Catches Throwable.");
        }
    }

}
