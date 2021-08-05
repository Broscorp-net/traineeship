Results
===

### 1.gc deletes the object if there is no link

### 2.the finalize method fires when the object is cleaned

|2131845destroy...|
|15164017destroy...|

### 3.the collector needs some time to complete the cleaning
clean gc
sleep 5000 millis
executing gc
i'm here


### 4. heap cleans itself as needed and clean the inner object too
override finalize..
Student4992 says :  bye!
override finalize..
Student5055 says :  bye!
2131845destroy...
15164017destroy...
override finalize..
Student5103 says :  bye!
override finalize..
Student5121 says :  bye!
override finalize..
Student5139 says :  bye!
override finalize..
Student5157 says :  bye!
override finalize..
Student5195 says :  bye!
override finalize..
Student5309 says :  bye!
14216437destroy...


 