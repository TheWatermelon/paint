package versionZero.modele;

import versionZero.vue.Dessin;

public class CommandFactory {
	
	private static CommandFactory INSTANCE = null;
	private Dessin dessin = null;
	private CommandFactory(){
		
	}
	
	public static synchronized CommandFactory getInstance(){
		if(INSTANCE == null){
			INSTANCE = new CommandFactory();
		}
		return INSTANCE;
	}
	
	public static Command createLoadCommand(){
		return new LoadCommand(getInstance().dessin);
	}
	
	public static Command createNewCommand(){
		return new NewCommand(getInstance().dessin);
	}
	
	public static Command createSaveCommand(){
		return new SaveCommand(getInstance().dessin);
	}
	
	public static void setDessin(Dessin dessin){
		getInstance().dessin = dessin;
	}
	
	public static Dessin getDessin(){
		return getInstance().dessin;
	}

	

}
