package compiler;

import java.util.ArrayList;

public class Compiler {

	private String file;
	private String Error = null;
	
	public Compiler(String file) {
		this.file = file;
	}
	
	public void compile() {
		String out = "";
		String file = this.file;
		ArrayList<Integer> depth = genLevelDepth(file);
		ArrayList<Integer> functionIndexes = findFunctionIndex(file);
		
		System.out.println(functionIndexes);
		System.out.println(depth);
		
		
		
		this.file = file;
	}

	private ArrayList<Integer> genLevelDepth(String file) {
		ArrayList<Integer> depth = new ArrayList<>();
		
		int level = 100;
		
		for (int i = 0; i < file.length(); i++) {
			char c = file.charAt(i);
			
			if (c == '{') {
				depth.add(level);
				level = level - 1;
			} 
			
			if (c == '}') {
				level = level + 1;
				depth.add(level);
			}
		}
		
		return depth;
	}
	
	private ArrayList<Integer> findFunctionIndex(String file) {
		ArrayList<Integer> list = new ArrayList<>();
		int index = file.indexOf("function");
		
		while (index != -1) {
			list.add(index);
			index = file.indexOf("function", index + 15);
		}
		
		return list;
	}
	
	public String getFile() {
		return file;
	}

	public String getError() {
		return Error;
	}
}
