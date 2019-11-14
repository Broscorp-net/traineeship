public class SomeOtherObject extends SomeObject {
    public SomeObject other;

    public SomeOtherObject(String id) {
        super(id);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        super.id += "_copy";
        SomeObject someCopiedObj = this;
    }
}
