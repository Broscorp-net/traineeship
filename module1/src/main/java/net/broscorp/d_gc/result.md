# Results of classes execution
* In the first case in the class GBClass we can see that we create 1_000_000 null objects 
of the GBClass. The method finalize() was override. We call the finalize() which has in it 
realization the initialization for the GBClass objects. But the objects will not deleted because
of new initialization of objects in finalize method.

```java
public class GBClass {
    private static GBClass gbClass = new GBClass();

    @Override
    protected void finalize() throws Throwable {
        gbClass = this;
        System.out.println("Finalize method");
        super.finalize();
    }


    public static void main(String[] args) {
        for (int i = 0; i < 1_000_000; i++) {
            gbClass = new GBClass();
            gbClass = null;
        }
        System.gc();
    }
} 
```

* In the second case we can see example of cross references. Cross references - it is the case
when objects are point on each other. But objects was deleted because they did  not have external
references.

```
 public static void main(String[] args) {
        for (int i = 0; i < 1_000_000; i++) {
            FirstGCClass first = new FirstGCClass();
            SecondGCClass second = new SecondGCClass();
            first.secondGCClass = second;
            second.firstGCClass = first;
        }
    }

```