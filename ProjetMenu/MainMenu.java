package ProjetMenu;

import Projet.Jeu;
import nonActiveClasses.Scroll;
import nonActiveClasses.ScrollInterface;

public class MainMenu implements ScrollInterface{
	
	private Jeu jeu;
	private  int selection = 0;
	private DisplayMainMenu display;
	
	public MainMenu(Jeu jeu) {
		this.jeu = jeu;
		this.display = new DisplayMainMenu();
		display.showMenu();
	}
	
	public void resetMainMenu() {
		selection = 0;
		display.setSelection(this.selection);
	}
	
	public void scroll (Scroll scroll) {
		switch (scroll) {
			case UP :
				if (selection != 0) {
					selection--;
				}
				display.setSelection(this.selection);
				break;
			case DOWN :
				if (selection != 2) {
					selection++;
				}
				display.setSelection(this.selection);
				break;
			case CONFIRM :
				switch (selection) {
					case (0) :
						jeu.startNewGame();
						break;
					case (1) :
						jeu.loadGame();
						break;
					case (2) :
						jeu.quitGame();
						break;
				}
				break;
		}
	}
	
}