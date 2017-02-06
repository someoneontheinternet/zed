package compiler;

public class Compiler {

	private String file;
	private String Error = null;
	
	public Compiler(String file) {
		this.file = file;
	}
	
	public void compile() {
		String out = "";
		String file = this.file;
		
		for (int i = 0; i < file.length(); i++) {
			
		}
		
		
		this.file = file;
	}

	public String getFile() {
		return file;
	}

	public String getError() {
		return Error;
	}
}
