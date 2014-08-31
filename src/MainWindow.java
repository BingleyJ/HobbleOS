
import java.awt.image.ComponentSampleModel;
import java.io.Console;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.Component;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Interactable.FocusChangeDirection;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.TextBox;
import com.googlecode.lanterna.gui.dialog.DialogButtons;
import com.googlecode.lanterna.gui.dialog.DialogResult;
import com.googlecode.lanterna.gui.dialog.MessageBox;

public class MainWindow extends Window {
	boolean hidemain = false;
	String textIn = "";
	TextBox consoleInput = new TextBox();

	
	DialogButtons d1 = DialogButtons.YES_NO;

	
	public MainWindow(final GUIScreen gui){
		 super("Hobble V.00001");
		 final Panel main = new Panel(new Border.Bevel(true), Panel.Orientation.VERTICAL);
		final Helper hlp = new Helper();
		 
		main.addComponent(new Button("Current Date", new Action(){
			@Override
			public void doAction(){
				MessageBox.showMessageBox(getOwner(), "Current Date :", hlp.date());
			}
		}));		
		
		
		main.addComponent(new Button("Directory Listing", new Action(){
			@Override
			public void doAction(){
				
				MessageBox.showMessageBox(getOwner(), getDirectoryPath(), getFileListing());
			}
		}));
		
		main.addComponent(new Button("Print command text", new Action(){
			@Override
			public void doAction(){
				textIn = consoleInput.getText();
				MessageBox.showMessageBox(getOwner(), textIn, textIn);
			}
		}));
		
		main.addComponent(new Button("Console", new Action(){
			@Override
			public void doAction(){
				Panel console = new Panel(new Border.Invisible(), Panel.Orientation.VERTICAL);
				console.addComponent(new Label(getDirectoryPath()));
				console.addComponent(consoleInput);
				setFocus(consoleInput);
				addComponent(console);
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

	private String getDirectoryPath(){
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		return s;
	}
	
	private String getFileListing() {
		// Dir
		String path = ".";

		String files = null;
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isFile()) {
				files = files + listOfFiles[i].getName() + "\n";
				// System.out.println(files);
			}
		}
		return files;
	}
}
