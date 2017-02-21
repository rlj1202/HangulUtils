package redlaboratory.koreancore;

public class Result {
	
	public String str;
	public int cursor;
	public int selection;
	
	public Result(String str, int cursorPos, int selecPos) {
		this.str = str;
		this.cursor = cursorPos;
		this.selection = selecPos;
	}
	
}
