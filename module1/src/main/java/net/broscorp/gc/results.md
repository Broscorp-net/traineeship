##Results


1.	In the case when we create an object in a loop and then assign null to it, the finalize method is called.
Eden memory will be filled and cleared	
2.	To resurrect an object in the finalize method, we can add that object to the static collection, so it will be gc marked but not removed.
If a resurrected object is later de-referenced, it is again eligible for Garbage Collection. However, this time the finalize() method will not be invoked again, 
since Java only invokes the finalizer at most one time.
3.	If objects refer to each other but there is no external reference to them, then they are removed by the garbage collector.
