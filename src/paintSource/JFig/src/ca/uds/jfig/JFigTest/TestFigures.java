package ca.uds.jfig.JFigTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.uds.jfig.jfigInterface.FigureInterface;


public class TestFigures extends JFigTestCase implements FigureInterface {
	//private final int TPS = 100;
	
	
	@Test
	// This is just to know that tests can run
	public void simpleTest() {
		assertEquals("simpleTest", 1, 1);
	}
	
//	@Test
//	public void selectRect() {
//		JFigIU.clickOnRectangle();
//		try {
//			Thread.sleep(TPS);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		JFigIU.createFigure(Application.acontroller);
//		assertEquals("TestRectangle", RECTANGLE, Application.fmodel.getFigureList()
//				.getChild(0).getType());
//		assertEquals("TestNbFigure", 1, Application.fmodel.getFigureList()
//				.countElement());
//	}

//	@Test
//	public void selectOval() {
//		JFigIU.clickOnOval();
//		try {
//			Thread.sleep(TPS);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		JFigIU.createFigure(Application.acontroller);
//		assertEquals("TestApplicationType", OVAL, Application.amodel.getType());
//		assertEquals("TestOval", OVAL, Application.fmodel.getFigureList()
//				.getChild(0).getType());
//		assertEquals("TestNbFigure", 1, Application.fmodel.getFigureList()
//				.countElement());
//	}
//	
//	@Test
//	public void selectCircle() {
//		JFigIU.clickOnCircle();
//		try {
//			Thread.sleep(TPS);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		JFigIU.createFigure(Application.acontroller);
//		assertEquals("TestCircle", "circle", Application.fmodel.getFigureList()
//				.getChild(0).getType());
//		assertEquals("TestNbFigure", 1, Application.fmodel.getFigureList()
//				.countElement());
//	}
//
//	@Test
//	public void selectRoundRectangle() {
//		JFigIU.clickOnRoundRectangle();
//		try {
//			Thread.sleep(TPS);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		JFigIU.createFigure(Application.acontroller);
//		assertEquals("TestRectangle", "roundRectangle", Application.acontroller.getType());
//		assertEquals("TestNbFigure", 1, Application.fmodel.getFigureList()
//				.countElement());
//		assertEquals("TestOval", "roundRectangle", Application.fmodel.getFigureList()
//				.getChild(0).getType());
//	}
//
//	@Test
//	public void selectLine() {
//		JFigIU.clickOnLine();
//		try {
//			Thread.sleep(TPS);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		JFigIU.createFigure(Application.acontroller);
//		assertEquals("TestRectangle", "line", Application.acontroller.getType());
//		assertEquals("TestNbFigure", 1, Application.fmodel.getFigureList()
//				.countElement());
//		assertEquals("TestOval", "line", Application.fmodel.getFigureList()
//				.getChild(0).getType());
//	}
//
//	@Test
//	public void selectFigs() throws InterruptedException{
//		JFigIU.clickOnRectangle();
//		Thread.sleep(TPS);
//		JFigIU.createFigure(Application.acontroller);
//		assertEquals("TestRectangle", "rectangle", Application.fmodel.getFigureList()
//				.getChild(0).getType());
//		assertEquals("TestNbFigure", 1, Application.fmodel.getFigureList()
//				.countElement());
//		Thread.sleep(TPS);
//		JFigIU.clickOnOval();
//		Thread.sleep(TPS);
//		JFigIU.createFigure(Application.acontroller);
//		assertEquals("TestOval", true, Application.fmodel.getFigureList()
//				.getChild(1).getType().equals("oval"));
//		assertEquals("TestNbFigure", 2, Application.fmodel.getFigureList()
//				.countElement());
//		Thread.sleep(TPS);
//		JFigIU.clickOnCircle();
//		Thread.sleep(TPS);
//		JFigIU.createFigure(Application.acontroller);
//		assertEquals("TestCircle", "circle", Application.fmodel.getFigureList()
//				.getChild(2).getType());
//		assertEquals("TestNbFigure", 3, Application.fmodel.getFigureList()
//				.countElement());
//	}
//	
//	@Test
//	public void SaveFigure() throws IOException {
//		JFigIU.clickOnLine();
//		try {
//			Thread.sleep(TPS);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		JFigIU.createFigure(Application.acontroller);
//
//		JFigIU.clickOnRoundRectangle();
//		try {
//			Thread.sleep(TPS);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		JFigIU.createFigure(Application.acontroller);
//
//		File saveFile = new File("./data4Tests/JUnit.jfig");
//		Application.amodel.setCurrentFile(saveFile);
//		Application.acontroller.saveFile();
//		int nbLigne = 0;
//		BufferedReader readwithBuffer = new BufferedReader(new FileReader(
//				saveFile));
//		while ((readwithBuffer.readLine()) != null) {
//			nbLigne++;
//		}
//		readwithBuffer.close();
//		saveFile.delete();
//		assertEquals("TestNbFigureSave", 2, nbLigne);
//	}
//
//	@Test
//	public void OpenFigure() throws IOException {
//		File openFile = new File("./data4Tests/JUnit.jfig");
//		FileWriter fw = new FileWriter(openFile, true);
//		BufferedWriter output = new BufferedWriter(fw);
//		output.write("line 10 10 100 100 0 0 0 255 255 255 255 255 5");
//		output.write("\r\n");
//		output.write("oval 463 -26 615 211 0 0 0 255 255 255 255 255 5");
//		output.flush();
//		output.close();
//		Application.fcontroller.open(openFile.getAbsolutePath());
//		openFile.delete();
//		assertEquals("TestNbFigureOpen", 2, Application.fmodel.getFigureList()
//				.countElement());
//	}
//
//	@Test
//	public void NbFigure() {
//		JFigIU.clickOnLine();
//		try {
//			Thread.sleep(TPS);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		JFigIU.createFigure(Application.acontroller);
//
//		JFigIU.clickOnRoundRectangle();
//		try {
//			Thread.sleep(TPS);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		JFigIU.createFigure(Application.acontroller);
//
//		JFigIU.clickOnCircle();
//		try {
//			Thread.sleep(TPS);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		JFigIU.createFigure(Application.acontroller);
//
//		JFigIU.clickOnOval();
//		try {
//			Thread.sleep(TPS);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		JFigIU.createFigure(Application.acontroller);
//
//		JFigIU.clickOnRectangle();
//		try {
//			Thread.sleep(TPS);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		JFigIU.createFigure(Application.acontroller);
//		
//		assertEquals("TestOval", "line", Application.fmodel.getFigureList()
//				.getChild(0).getType());
//		
//		assertEquals("TestOval", "roundRectangle", Application.fmodel.getFigureList()
//				.getChild(1).getType());
//		
//		assertEquals("TestOval", "circle", Application.fmodel.getFigureList()
//				.getChild(2).getType());
//		
//		assertEquals("TestOval", "oval", Application.fmodel.getFigureList()
//				.getChild(3).getType());
//		
//		assertEquals("TestOval", "rectangle", Application.fmodel.getFigureList()
//				.getChild(4).getType());
//
//		assertEquals("TestNbFigure", 5, Application.fmodel.getFigureList()
//				.countElement());
//	}
}
