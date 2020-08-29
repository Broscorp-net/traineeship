If we pass boxed Integer and primitive int to method,
our code will not compile. Cause we will get ambiguous method call.
Compiler cannot understand which method it should use to invoke method.
```
    int x = 4;
    Integer y = 2;

    double result = new SumMathOperation().calculate(x, y);
```

Actually, we need to implement this method calculate(int x, Integer y) 


@Override annotation actually means that compiler should check 
that method with that signature is exists and that extended class
or implemented interface has this method.

We can override method without @Override annotation. 
Sometimes we can make mistake in method signature,
and we will get a new independent method. 
So this annotation is extremely useful.

@Override annotation increases readability cause
 other developers can see it and guess what you have done.
 They will understand that method have been overridden
 from basic class or interface.