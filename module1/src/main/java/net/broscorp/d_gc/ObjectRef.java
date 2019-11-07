
public class ObjectRef {
 static ObjectRef ref1;

    public static void main(String[] args) {
       ObjectRef ref = new ObjectRef();
       ref1 = ref;
       ref = null;
       System.gc();
       System.out.println(ref1.hashCode());
       System.out.println(ref.hashCode());


    }
    @Override
    protected void finalize() {
        System.out.println("Call for finalize");
    }
}
