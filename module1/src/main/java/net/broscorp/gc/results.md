## 1. Creating test checkReferencingObjectsTest

When executing this test, the garbage collector
was triggered in 1 million iterations. 
Jconsole showed an increasing graph, 
after the picker was triggered, the graph went down sharply.



Current object 395455 has bean deleted from finalize
List is full
Current object 412782 has bean deleted from finalize
List is full
Current object 412821 has bean deleted from finalize
List is full
Current object 412884 has bean deleted from finalize
List is full
Current object 412934 has bean deleted from finalize
...

## 2. Creating test createObjectsSaveReferenceTest

For this example,
I decided to use an array of data 
to show that the garbage collector
will work the same way as in the previous example.


Current object 482522 has bean deleted from finalize
List is full
Current object 482843 has bean deleted from finalize
List is full
Current object 482902 has bean deleted from finalize
List is full
Current object 482973 has bean deleted from finalize
List is full
Current object 483025 has bean deleted from finalize
...

## 3. Creating test checkReferencingObjectsTest

In this test, the collector 
works in the same way as in the previous examples.

Current object 223468 has bean deleted from finalize
List is full
Current object 223468 has bean deleted from finalize
List is full
Current object 223467 has bean deleted from finalize
List is full
Current object 223467 has bean deleted from finalize
List is full
Current object 223466 has bean deleted from finalize
List is full