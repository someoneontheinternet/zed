package compiler.types;

public class Int extends Variable{

	String name;

	public Int(String name, int offset) {
		this.name = name;
		this.offset = offset;
	}
	
	public String getName() {
		return this.name;
	}

	public int getType() {
		return 1;
	}

	public int getSize() {
		return 4;
	}

	public int getOffset() {
		return this.offset;
	}

}
