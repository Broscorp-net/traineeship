import java.text.SimpleDateFormat;
import java.util.Date;

public class SomeObject {

    protected String id;

    public SomeObject(String id) {
        this.id = "#" + id;
    }

    @Override
    protected void finalize() throws Throwable {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
        String dateTime = formatter.format(date);
        System.out.println(dateTime + " " + id);

        super.finalize();
    }
}