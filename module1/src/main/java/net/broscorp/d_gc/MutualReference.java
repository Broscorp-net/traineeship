import java.util.logging.Logger;

public class MutualReference {

  private static final Logger LOGGER = Logger.getLogger(MutualReference.class.getName());
  
    public static void main(String[] args) throws InterruptedException {
        
      for (int i = 0; i<2; i++) {
            MutualReference mR1 = new MutualReference();
            LOGGER.info("mR1: " + mR1.hashCode());
            MutualReference mR2 = new MutualReference();
            LOGGER.info("mR2: " + mR2.hashCode());
            mR2 = mR1;
            mR1 = mR2;
            
      }
            System.gc();
        Thread.sleep(500);
    }

    @Override
    protected void finalize() throws Throwable {
        LOGGER.info("finalize: " + this.hashCode());
    }
}