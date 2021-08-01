1. GC does not maintain the order in which the reference to the object is set to null
Logs:
Finalization: called on Room Object 0
Finalization: called on Room Object 1
Finalization: called on Room Object 4
Finalization: called on Room Object 3
Finalization: called on Room Object 2
Finalization: called on Room Object 5
Finalization: called on Room Object 6
...

2. If objects reference each other upon deleting one object another one is deleted too.
Two referencing objects are not cleaned strictly one after another but one of them may be 
cleaned up with a gap in time

Logs:
Finalization: called on Apartment Object Room object0
Finalization: called on Room Object 0
Finalization: called on Apartment Object Room object2
Finalization: called on Room Object 3
Finalization: called on Apartment Object Room object3
Finalization: called on Apartment Object Room object1
Finalization: called on Room Object 1
Finalization: called on Room Object 2
Finalization: called on Apartment Object Room object4
Finalization: called on Room Object 4
Finalization: called on Apartment Object Room object5
Finalization: called on Room Object 5
Finalization: called on Apartment Object Room object6
Finalization: called on Room Object 6
...

3. Making object accessible in finalization block has no effect. The object the reference to which 
was set to null (lost) is cleaned up by garbage collector. 
Finalization: called on AvailableAgain Object 0
AvailableAgain object is cleaned up
AvailableAgain object is cleaned up
Finalization: called on AvailableAgain Object 1
AvailableAgain object is cleaned up
Finalization: called on AvailableAgain Object 2
AvailableAgain object is cleaned up
AvailableAgain object is cleaned up
AvailableAgain object is cleaned up
Finalization: called on AvailableAgain Object 3
Finalization: called on AvailableAgain Object 6
Finalization: called on AvailableAgain Object 4
Finalization: called on AvailableAgain Object 5
AvailableAgain object is cleaned up
Finalization: called on AvailableAgain Object 7
AvailableAgain object is cleaned up
Finalization: called on AvailableAgain Object 8
AvailableAgain object is cleaned up
AvailableAgain object is cleaned up
...
