
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.Component;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.dialog.ActionListDialog;
import com.googlecode.lanterna.gui.dialog.DialogResult;

public class MainWindow extends Window {
	boolean hidemain = false;
	
	QuitMenu quitmenu;
	final Panel main = new Panel(new Border.Bevel(true), Panel.Orientation.VERTICAL);

	
	public MainWindow(final GUIScreen gui){
		 super("Main Menu");
		 quitmenu = new QuitMenu(gui);
		Helper hlp = new Helper();
		 
		main.addComponent(new Label(hlp.date()));
		
		main.addComponent(new Button("Shutdown Hobble", new Action(){
			@Override
			public void doAction(){
				//addyesno();
				quitmenu.setVisable(true);
					
					if (!quitmenu.isVisable){}
						
					else {gui.showWindow(quitmenu);}
				//gui.showWindow(null);
				//System.exit(0);
			}
		}));
	    addComponent(main);

	}
}
