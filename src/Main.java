import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.screen.Screen;


	public class Main {
	
		@SuppressWarnings("deprecation")
		public static void main(String[] args) throws InterruptedException {
			  GUIScreen textGUI = TerminalFacade.createGUIScreen();
			    MainWindow main = new MainWindow(textGUI);
			    if(textGUI == null) {
			        System.err.println("Couldn't allocate a terminal!");
			        return;
			    }
			    textGUI.getScreen().startScreen();
			    textGUI.setTitle("Hobble OS");
			   
			    
			   
			    //Do GUI logic here
			    textGUI.showWindow(main, GUIScreen.Position.OVERLAPPING.CENTER);
			 
		   

		    textGUI.getScreen().stopScreen();    	 
    }
}
