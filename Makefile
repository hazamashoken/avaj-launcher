all:
	@find * -name "*.java" > sources.txt
	@javac -d . @sources.txt
	@java -cp . com.tliangso.Simulator ./scenario.txt
	@cat -e ./simulation.txt
	
clean:
	rm $$(find * -name "*.class")
	rm ./simulation.txt
	rm ./sources.txt