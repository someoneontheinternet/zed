package compiler;

import java.util.ArrayList;

public class Body {

	public String compileContent(String body) {

		ArrayList<Var> reference = new ArrayList<>();

		String[] temp = body.split(";");
		;
		ArrayList<String> var = new ArrayList<>();

		for (String s : temp) {
			if (s.startsWith("@") || s.startsWith("$"))
				var.add(s);
		}

		int offsetCounter = 0;

		for (String s : var) {
			if (s.startsWith("@")) {
				Var v;

				// Parse size
				String type = s.substring(1, s.indexOf(" "));
				int size = Compiler.typeSize.get(type);

				offsetCounter += size;

				// name

				int index = s.indexOf(" ") + 1;
				int endIndex = s.indexOf(" ", index);

				if (endIndex == -1)
					endIndex = s.length();

				String name = s.substring(index, endIndex);

				v = new Var(name, type, offsetCounter, size);

				System.out.println(v.compile());

			}
		}

		return "TODO: compile to asm";
	}
}

class Var {
	public String name;
	public String type;
	public int offset;
	public int size;
	public String val;

	public Var(String name, String type, int offset, int size) {
		this.name = name;
		this.type = type;
		this.offset = offset;
		this.size = size;
	}

	public Var() {
	}

	public String compile() {
		String end = "\n";
		String operationSize = "";
		if (size == 8)
			operationSize = "qword";
		if (size == 4)
			operationSize = "dword";
		if (size == 2)
			operationSize = "word";
		if (size == 1)
			operationSize = "byte";
		String out = "";
		out += "sub esp, " + size + end;
		out += "mov " + operationSize + " [ebp - " + offset + "]";
		return out;
	}
	
	public String getReference() {		
		return "[ebp - " + offset + "]";
	}

}