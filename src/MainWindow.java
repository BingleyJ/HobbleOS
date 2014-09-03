
import java.awt.image.ComponentSampleModel;
import java.io.Console;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
import com.googlecode.lanterna.screen.Screen;

public class MainWindow extends Window {
	
    ArrayList<String> history = new ArrayList<String>();
    int nextHistoryLocation = history.size();
   
	String textIn = "";
	TextBox consoleInput = new TextBox();
	boolean openConsole = false;

	DialogButtons d1 = DialogButtons.YES_NO;

	public MainWindow(final GUIScreen gui) {
		super("Hobble V.00001");
		final Panel main = new Panel(new Border.Bevel(true),
				Panel.Orientation.VERTICAL);
		final Helper hlp = new Helper();
		
		main.addComponent(new Button("Current Date", new Action() {
			@Override
			public void doAction() {
				MessageBox.showMessageBox(getOwner(), "Current Date :",
						hlp.getDate());
				history.add(history.size(), " Date Request " + hlp.getDate() + " @ " + hlp.getTime() + "\n");
			}
		}));
		
		main.addComponent(new Button("Current Time", new Action() {
			@Override
			public void doAction() {
				MessageBox.showMessageBox(getOwner(), "Current time :",
						hlp.getTime());
				history.add(history.size(), " Time Request " + hlp.getDate() + " @ " + hlp.getTime() + "\n");
			}
		}));

		main.addComponent(new Button("Directory Listing", new Action() {
			@Override
			public void doAction() {
				history.add(history.size(), " ls Request" + hlp.getDate() + " @ " + hlp.getTime());

				MessageBox.showMessageBox(getOwner(), getDirectoryPath(),
						getFileListing());
			}
		}));
		
		main.addComponent(new Button("Shutdown Hobble", new Action() {
			@Override
			public void doAction() {
				// removeAllComponents();
				DialogResult dr;
				dr = MessageBox.showMessageBox(getOwner(), "Quit",
						"Are you sure?", d1);
				if (dr == DialogResult.YES){
					try {
						smoothLanding();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.exit(0);
				}
			}
		}));
		
		Panel console = new Panel(new Border.Invisible(),Panel.Orientation.HORISONTAL);
		if (!openConsole) {
			console.addComponent(consoleInput);
			setFocus(consoleInput);
			main.addComponent(console);
			openConsole = true;
		}
		else {
			gui.getActiveWindow().removeComponent(consoleInput);
		}
		

		main.addComponent(new Button("Run Console Command", new Action() {
			@Override
			public void doAction() {
				textIn = consoleInput.getText();
				switch (textIn) {
				case "ls":
					history.add(history.size(), " ls Request" + hlp.getDate() + " @ " + hlp.getTime());
					MessageBox.showMessageBox(getOwner(), getDirectoryPath(),
							getFileListing());
					break;
				case "quit":
					history.add(history.size(), " quit Request" + hlp.getDate() + " @ " + hlp.getTime());
					try {
						smoothLanding();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.exit(0);
				case "help":
					MessageBox.showMessageBox(getOwner(),"Help Menu", "ls : List Current Directory\nquit : Shutdown Hobble\nhelp : We cannot provide the type you need.");

					break;
				default : 
					MessageBox.showMessageBox(getOwner(),"Error", "Unkown Command\nYour computer has a virus.\nLike for sure.");
					break;

				}
				//MessageBox.showMessageBox(getOwner(), textIn, textIn);
			}
		}));
		addComponent(main);
	}

	
	//write history to file
	protected void smoothLanding() throws IOException {
		// TODO Auto-generated method stub
		FileWriter write = new FileWriter("Histo.ry");
		for(String str: history) {
			write.write(str);
		}
		write.close();
	}

	private String getDirectoryPath() {
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
