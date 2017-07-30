package fr.AuroreJeremie.Service;

/**
 * 
 * @author ajeremie
 *
 */
public class ConsolePrinter implements Printer{

	@Override
	public void printLn(String operations) {
		System.out.println(operations);
		
	}

	
}
