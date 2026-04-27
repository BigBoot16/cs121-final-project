Game.class: Game.java
	javac Game.java

Character.class: Character.java
	javac Character.java

run: Game.class Character.class
	java Game

clean:
	rm *.class
