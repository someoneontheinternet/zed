import IO.Reader;
import compiler.Compiler;

public class Main {

	public static void main(String[] args) {
	
		Reader r = new Reader();
		
		String file = r.read("/Users/Admin/Documents/Github/zed/Compiler/Project/Syntax/", "test.zed");
		
		System.out.println("Input: " + file);
		
		Compiler c = new Compiler(file);
		
		c.compile();
		
		System.out.println("Error: " + c.getError());
		System.out.println("Output: " + c.getFile());
		
	}
}
