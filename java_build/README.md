1. Build file JAR
	+ jar cfv ./jars/User.jar lib/User.java

2. Build CLASS file
	+ javac -cp ".;./jars/User.jar" Encapsulation.java

3. Run with JAR file
	+ java -cp ".;./jars/User.jar" Encapsulation