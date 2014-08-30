
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

public class QuitMenu extends Window {
	GUIScreen screen;
	final Panel quitPanel = new Panel(new Border.Invisible(), Panel.Orientation.VERTICAL);
	
	final Button yesButton = new Button("yes", new Action(){
		@Override
		public void doAction(){
			System.exit(0);
		}
	});
	final Button noButton = new Button("no", new Action(){
		@Override
		public void doAction(){
			setVisable(false);
			//removeComponent(QuitMenu);
		}
	});
	protected boolean isVisable = false;
	
	public void removeyesno(){
		quitPanel.removeComponent(yesButton);
		quitPanel.removeComponent(noButton);
	}
	
	public void addyesno(){
		quitPanel.addComponent(yesButton);
		quitPanel.addComponent(noButton);
	}
	
	public QuitMenu(final GUIScreen gui){
		 super("Quit Menu");
		// Label label1 = new Label("Yew");		 
		screen = gui;
		
				addyesno();
				
				//System.exit(0);
			
	    addComponent(quitPanel);
	}

	public boolean isVisable() {
		return isVisable;
	}

	public void setVisable(boolean isVisable) {
		this.isVisable = isVisable;
	}
}