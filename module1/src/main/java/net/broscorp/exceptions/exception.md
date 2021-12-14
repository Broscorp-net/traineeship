digraph G {
   Throw [label="Throwable"]
   Exc [label="Exception"]
   Error [label="Error"]
   OMEx [label="OutOfMemoryError"]
   SOEx [label="StackOverflowError"]
   IAEx [label="IllegalArgumentException"]
   NPEx [label="NullPointerException"]
   IOE [label="IOException"]
   CNF [label="ClassNotFoundException"]

   Throw -> Error;
   Error -> OMEx;
   Error -> SOEx;
   Throw -> Exc;
   Exc -> IOE;
   Exc -> CNF;
   Exc -> NPEx;
   Exc -> IAEx;
} 