import IO.Reader;
import compiler.Compiler;

public class Main {

	public static void main(String[] args) {
	
		Reader r = new Reader();
		
		String file = r.read("/Users/Admin/Documents/D/Compiler/Project/Syntax/", "test.d");
		
		Compiler c = new Compiler(file);
		
		c.compile();
		
		System.out.println(c.getError());
		System.out.println(c.getFile());
		
	}
}
