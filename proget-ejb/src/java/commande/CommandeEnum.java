/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package commande;

/**
 *
 * @author Treemo
 */
public enum CommandeEnum {

    EN_COUR(1),
    ANULEE(2),
    LIVREE(3);

    private final int value;

	/** Le constructeur qui associe une valeur à l'enum */
	private CommandeEnum(int value) {
		this.value = value;
	}

	/** La méthode accesseur qui renvoit la valeur de l'enum */
	public int getValue() {
		return this.value;
	}
}
