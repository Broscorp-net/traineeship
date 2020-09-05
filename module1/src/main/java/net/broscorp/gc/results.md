### Dead objects
In this experiment I tried creating a lot of new objects and instantly dropping (assigning new reference to variable) their references.
While running this test I noticed that objects were being collected almost immediately after the test started. Garbage Collector doesn't
have problems marking those objects because they're unreachable from the roots (stack, etc.). Objects are being collected quickly because of the Generational Hypothesis (most objects die young).

### Object resurrection
In this experiment I tried `resurrecting` an object by assigning a reference to it when garbage collector called `finalize`.
I did it by assigning a reference to a static field. Because garbage collector had already called `finalize` on this object once, it didn't call it again.
There also weren't any opportunities for the garbage collector to collect this object since it was referenced from a static field.  

### Circular references
In this experiment I tried creating two objects that referenced each other from the inside, and weren't referenced from the outside.
Because these objects were unreachable from the roots, garbage collector successfully removed them.

#### Example of logs:  
`net.broscorp.gc.B 2020-09-05T22:26:14.415Z`  
`net.broscorp.gc.A 2020-09-05T22:26:14.415Z`  
`net.broscorp.gc.B 2020-09-05T22:26:14.416Z`  
`net.broscorp.gc.A 2020-09-05T22:26:14.417Z`  
`net.broscorp.gc.B 2020-09-05T22:26:14.417Z`  
`net.broscorp.gc.A 2020-09-05T22:26:14.419Z`  
`net.broscorp.gc.B 2020-09-05T22:26:14.419Z`  
`net.broscorp.gc.A 2020-09-05T22:26:14.420Z`  
`net.broscorp.gc.B 2020-09-05T22:26:14.420Z`  