package compiler;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Compiler {
	
	public HashMap<String, Integer> typeSize = new HashMap<>();
	
	private String file;
	private String Error = "";
	
	public Compiler(String file) {
		this.file = file;
	}
	
	public void compile() {
		
		typeSize.put("void", 0);
		typeSize.put("int", 4);
		typeSize.put("long", 8);
		typeSize.put("short", 2);
		typeSize.put("char", 2);
		typeSize.put("float", 4);
		typeSize.put("double", 8);
		
		String file = this.file;
		//    index, depth
		ArrayList<Point> depth = genLevelDepth(file);
		ArrayList<Integer> functionIndexes = findFunctionIndex(file);
		
		//System.out.println(depth.toString().replaceAll("java.awt.Point", ""));
		//System.out.println(functionIndexes);
		
		for (int num : functionIndexes) {
			int end = findEndIndex(file, depth, num);
			compileFunction(num, end);
		}
		
		this.file = "";
	}
	
	private void compileFunction(int fStartIndex, int fEndIndex) {
		
		if (fEndIndex == -1) {
			Error += "\n";
			Error += "Cannot parse Function at " + fStartIndex;
		}
		
		String function = file.substring(fStartIndex + 9, fEndIndex);
		
		System.out.println(function);
		
		int firstSpaceIndex = function.indexOf(' ');
		int secondSpaceIndex = function.indexOf('(', firstSpaceIndex + 1);
		int thirdSpaceIndex = function.indexOf(')', secondSpaceIndex);
		
		int retSize = typeSize.get(function.substring(0, firstSpaceIndex));
		
		String name = function.substring(firstSpaceIndex + 1, secondSpaceIndex);
		ArrayList<String> arguments = new ArrayList<>();
		
		String[] args = function.substring(secondSpaceIndex + 1, thirdSpaceIndex).split(", ");
		
		for (String s : args) {
			if (s != "") {
				arguments.add(s);
			}
		}
		
		String content = function.substring(thirdSpaceIndex + 3, function.length() - 1);
		
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
				level = level + 1;
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
	
	private int findEndIndex(String file, ArrayList<Point> depth, int start) {
		
		for (int i = depth.size() - 1; i > 0; i--) {
			if (depth.get(i).getY() != 100) {
				depth.remove(i);
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (Point p : depth) {
			list.add(p.x);
		}
		
		list.add(start);
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == start) {
				return list.get(i + 2) + 1;
			}
		}
		
		return -1;
	}
	
	public String getFile() {
		return file;
	}

	public String getError() {
		return Error;
	}
}
