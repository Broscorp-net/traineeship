`Throwable` is a base class for all exceptions.
Subclasses of the `Error` class represents low-level exceptions in JVM.
Subclasses of the `Exception` class deal with exceptional events inside applications.

The `RuntimeException` class is rather a special subclass of `Exception`. It represents so-called unchecked exceptions
If a method throws a checked exception, this must be marked in the declaration using the special `throws` keyword.
Otherwise, the program will not compile.