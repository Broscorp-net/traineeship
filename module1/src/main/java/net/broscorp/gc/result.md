Through testing of Garbage collector in java we partly familiarised with main methods of GC.
The first level of garbage collection is Reference counting, the work was demonstrated in the first
test case. Every object has a reference counter, so object is a garbage when reference counter = 0.
The second level of garbage collection is a tracing - the main purpose of this level to remove
non-reachable object (from GC root). This case is reproduced in the second test case.


