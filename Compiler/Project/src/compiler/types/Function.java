package compiler.types;

import java.util.ArrayList;

public class Function {

	public String name;
	public int retSize;
	public ArrayList<String> arguments = new ArrayList<>();
	public String content;
	
	public Function(String name, int retSize, ArrayList<String> arguments, String content) {
		this.name = name;
		this.retSize = retSize;
		this.arguments = arguments;
		this.content = content;
	}
	
	@Override
	public String toString() {
		return name + " " + retSize + " " + arguments + " content: " + content;
	}
	
}
