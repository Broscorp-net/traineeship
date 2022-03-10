## spamObjectsTest()
During the first test there was a huge increase of memory usage with clear view in JConsole graph.
After some undefined amount of time automatic garbage collection was invoked and all unreferenced objects was collected.

Logs example:
`Hamster #41982 is gone
 Hamster #41981 is gone
 Hamster #41980 is gone
 Hamster #41979 is gone
 Hamster #41978 is gone
 Hamster #41976 is gone
 Hamster #41975 is gone
 Hamster #41974 is gone
 Hamster #41973 is gone
 Hamster #41972 is gone
 Hamster #41971 is gone`

## referencedObjectsTest()
During tests there were made two gc() calls. First call cleared only 1 object, because I intentionally didn't cleared the referencing object, thus creating a situation where Object A is no longer accessible outside of Object B field.
Second call of gc() was made without these precautions and this time garbage collector cleared all three objects.

Logs example:
`Peter is gone
 Fred is gone
 Gavrila is gone
`

## selfReferencingDuringFinalizeTest()
Object was garbage collected only once. Making it reachable didn't stop finalize().

Logs example:
`Test Subject is gone
`