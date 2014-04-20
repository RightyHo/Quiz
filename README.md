Quiz
====

PIJ Assignment 3 by Andrew Ho Student ID:  12943058

Instructions for running the Quiz System:
-----------------------------------------

***PLEASE ONLY USE THE mach2 PACKAGE TO RUN AND TEST THIS PROJECT***

1.	Compile the following classes from the Quiz/src/mach2 folder using normal Java compilation (eg; javac QuizServerImpl.java):

InputOutput.java
InputOutputImpl.java	
PlayerAttempt.java	
PlayerAttemptImpl.java	
PlayerClient.java	
Question.java	
QuestionImpl.java
Quiz.java	
QuizImpl.java	
QuizServer.java	
QuizServerImpl.java	
QuizServerLauncher.java	
QuizStore.java
QuizStoreImpl.java
SetUpClient.java

This will produce *.class files.  

2.  To create the stub, use the RMI compiler rmic on the class file (eg.QuizServerImpl.class):

rmic QuizServerImpl

This will produce an QuizServerImpl_stub.class file.

3.	Launch the Quiz Server by specifying the security policy:

java -Djava.security.policy=server.policy QuizServerLauncher

4.	Launch the Set-Up Client like the server, specifying the security policy:

java -Djava.security.policy=client.policy SetUpClient

5.	Launch the Player Client like the server, specifying the security policy:

java -Djava.security.policy=client.policy PlayerClient

6.	Interact with the project by using the UI on the PlayerClient & SetUpClient terminals.

7.	Run tests on the underlying code using the junit test classes provided in the Quiz/Test/mach2 folder:

InputOutputImplTest.java	
PlayerAttemptImplTest.java	
QuestionTest.java	
QuizServerImplTest.java	
QuizStoreImplTest.java	
QuizTest.java

8.	Enjoy the game