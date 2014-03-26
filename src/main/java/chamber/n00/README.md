Chamber 00: Hello World
=======================
Like any Hello World, it's main propose is show the basic structure and some utilities.

Structure
---------
Each chamber contains the main class with the main method, Guice package with its own module and the package that corresponds to the business logic of the problem with their test.

Utilities
---------
###ChamberXX
Use the utilities `Program` and `ProgramFactory` to facilitate the use of Guice,
the main method structure should remain the same.

###ProgramFactory
Initializes the dependency injection and serves as entry point.

###Terminal
It's a facade for `java.io.Console` when it's used through an IDE.
