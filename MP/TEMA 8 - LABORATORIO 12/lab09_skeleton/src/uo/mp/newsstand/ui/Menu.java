package uo.mp.newsstand.ui;

import uo.mp.util.console.Console;

/**
 * Shows the user a menu of options. Each option will be identified 
 * by a sequential number.
 *  @version 2023
 */
public class Menu {
	private String[] options = {
			"Load information from a file",
			"Show actual publications",
			"Add a new publication",
			"Remove a publication publication",
			"Create orders",
			"",
			"Save orders to file",
			"Import stock from zip",
			"Export orders to zip",
		};
		


	public void show() {
		int i = 1;
		for(String line: options) {
			if ( "".equals(line) ) {
				Console.print(String.format("\t%s\n", "----------------------") );
				Console.print(String.format("\t%s\n", "Input / Output options") );
				Console.print(String.format( "\t%s\n", "----------------------") );
				continue;
			}
			
			Console.print(String.format( "\t%2d- %s\n", i++, line) );
		}
		Console.print( String.format("\n\t%2d- %s\n", 0, "Exit"));
	}

}
