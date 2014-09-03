import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.screen.Screen;


	public class Main {
	    static boolean running = true;

	
		@SuppressWarnings("deprecation")
		public static void main(String[] args) throws InterruptedException {
			  GUIScreen textGUI = TerminalFacade.createGUIScreen();
			    MainWindow main = new MainWindow(textGUI);
			    main.setSoloWindow(true);
			    
			    
			    if(textGUI == null) {
			        System.err.println("Couldn't allocate a terminal!");
			        return;
			    }
			    textGUI.getScreen().startScreen();
			    textGUI.setTitle("Hobble OS");
			   
			    
			   
				//GUI Stuff
			    while (running){
			  
			    	textGUI.showWindow(main, GUIScreen.Position.OVERLAPPING.CENTER);
			    	textGUI.showWindow(null);
			    	
			    	
			    }
		   

		    textGUI.getScreen().stopScreen();    	 
    }
}
