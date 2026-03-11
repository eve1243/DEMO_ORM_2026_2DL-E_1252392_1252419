/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isep.eapli.demo_orm.presentation;

import isep.eapli.demo_orm.util.Console;

/**
 *
 * @author mcn
 */
public class MainMenu {
	private static final GroupCarUI groupCarUI = new GroupCarUI();
	private static final CarUI carUI = new CarUI();

	public static void mainLoop() {
		int opcao;
		do {
			opcao = menu();

			switch (opcao) {
				case 0:
					System.out.println("end ...");
					groupCarUI.close();
					carUI.close();
					break;
				case 1:
					groupCarUI.registerCG();
					break;
				case 2:
					groupCarUI.listAllCG();
					break;
			case 3:
				carUI.manageCarsInGroup();
				break;
				case 4:
					carUI.listAllCars();
					break;
				default:
					System.out.println("option not recognized.");
					break;
			}
		} while (opcao != 0);
	}

	private static int menu() {
		int option;
		System.out.println();
		System.out.println("=============================");
		System.out.println(" Rent a Car ");
		System.out.println("=============================\n");
		System.out.println("1. Register a Cargroup");
		System.out.println("2. List of all CarGroups");
		System.out.println("3. Manage Cars in Car Group");
		System.out.println("4. List of all Cars");
		System.out.println("=============================");
		System.out.println("0. Exit\n\n");
		option = Console.readInteger("Please select an option");
		return option;
	}
}
