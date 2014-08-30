
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
import com.googlecode.lanterna.gui.dialog.DialogButtons;
import com.googlecode.lanterna.gui.dialog.DialogResult;
import com.googlecode.lanterna.gui.dialog.MessageBox;

public class MainWindow extends Window {
	boolean hidemain = false;
	

	DialogButtons d1 = DialogButtons.YES_NO;

	
	public MainWindow(final GUIScreen gui){
		 super("Main Menu");
		 Panel main = new Panel(new Border.Bevel(true), Panel.Orientation.VERTICAL);
		final Helper hlp = new Helper();
		 
		//main.addComponent(new Label(hlp.date()));
		main.addComponent(new Button("Current Date", new Action(){
			@Override
			public void doAction(){
				MessageBox.showMessageBox(getOwner(), "Current Date", hlp.date());
				
			}
		}));		
		
		main.addComponent(new Button("Shutdown Hobble", new Action(){
			@Override
			public void doAction(){
				//removeAllComponents();
				DialogResult dr ;
				dr = MessageBox.showMessageBox(getOwner(), "Quit", "Are you sure?", d1);
				if (dr == DialogResult.YES)
					System.exit(0);
			}
		}));
	    addComponent(main);

	}
}
