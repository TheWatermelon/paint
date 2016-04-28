package versionZero.modele;

import versionZero.vue.Dessin;

public class NewCommand extends Command {
	private Dessin dessin;
	
	public NewCommand(Dessin d) {
		dessin = d;
	}

	@Override
	public void execute() {
		dessin.clear();
		
	}
}
