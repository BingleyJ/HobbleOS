
public class PCB {
	private String processName = "";
	private char processClass = ' ';
	private int processPrority = -127;
	
	private boolean processRunning = false;
	private boolean processReady = false;
	private boolean processBlocked = false;
	
	private boolean processSuspended = false;
	
	private int processMemory = 0;
	
	
	
	
	
	//processIdent is either A for application or S for System Type
	public PCB (char processIdent, int inPriority ) {
		
	}
}
