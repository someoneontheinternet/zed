package compiler;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

public class Compiler {

	private String file;
	private String Error = null;
	
	public Compiler(String file) {
		this.file = file;
	}
	
	public void compile() {
		String file = this.file;
		//    index    depth
		ArrayList<Point> depth = genLevelDepth(file);
		ArrayList<Integer> functionIndexes = findFunctionIndex(file);
		
		System.out.println(functionIndexes);
		System.out.println(depth);
		
		
		
		this.file = file;
	}

	private ArrayList<Point> genLevelDepth(String file) {
		
		ArrayList<Point> depth = new ArrayList<>();
		
		int level = 100;
	
		for (int i = 0; i < file.length(); i++) {
			
			if (file.charAt(i) == '{') {
				depth.add(new Point(i, level));
				level = level - 1;
			}
			
			if (file.charAt(i) == '}') {
				level = level - 1;
				depth.add(new Point(i, level));
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
