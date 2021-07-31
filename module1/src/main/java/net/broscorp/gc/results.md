##Test #1 - Creating a lot of objects.
          
   During the loop, the heap memory curve looked like an increasing stepped graph.
   But at some point in time, the GC triggered and the memory curve dropped to its original value.  
   
   logs:
    ====== Creating a lot of objects ======
    
    finalize() has been called for Object 191118
    finalize() has been called for Object 23087
    finalize() has been called for Object 49181
    ...
     
##Test #2 - Saving a reference to an object during finalization.
    
   A list is used to store objects. In the finalize() method, the current object saved into the external list.
   According to the heap memory graph, the memory was full and not force cleared ('Perform GC' button).
   
   logs:
   ====== Creating a lot of objects with an external list ====== 
   
    finalize() has been called for Object 23173
    finalize() has been called for Object 20401
    ...
    finalize() has been called for Object 49208
    LIST SIZE = 200000
   
##Test #3 - Creating a lot of objects with referencing to each other.

   The result is the same as in test #1.
   
   logs:
   ====== Creating a lot of objects with referencing to each other ======
   
    finalize() has been called for Object 13617
    finalize() has been called for Object 11367
    finalize() has been called for Object 11367
    ...
   
##Summary
   - There is no guarantee at what time the finalize() method will be called.
   - Objects with references to each other will be collected
     because they do not have external references.
   - An object can be brought back to life (not collected) if its reference will be stored somewhere during 
     the execution of finalize().
    