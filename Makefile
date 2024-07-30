all:
	@find * -name "*.java" > sources.txt
	@javac -d . @sources.txt
	@java -cp . com.tliangso.Simulator ./scenario.txt
	@cat -e ./simulation.txt
	
clean:
	rm -rf com
	rm ./simulation.txt
	rm ./sources.txt