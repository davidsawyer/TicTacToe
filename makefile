compile:
	@javac -d build src/*.java
run:
	@java -cp build TicTacToe human cutthroat
jar:
	@cd build; jar cmf MainClass.txt TicTacToe.jar *.class; mv TicTacToe.jar ../releases; cd ..
clean:
	@rm build/*.class; rm .DS_Store; rm src/.DS_Store; rm build/.DS_Store; rm releases/.DS_Store;
