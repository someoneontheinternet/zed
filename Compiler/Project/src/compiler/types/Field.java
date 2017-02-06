package compiler.types;

abstract public class Field {
	int type;
	int size;
	int offset;
	public abstract int getType();
	public abstract int getSize();
	public abstract int getOffset();
}
