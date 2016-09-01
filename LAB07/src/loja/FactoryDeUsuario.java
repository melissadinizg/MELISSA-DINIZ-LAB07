/**
 * 
 */
package loja;

import excecoes.StringInvalidaException;
import usuario.Noob;
import usuario.Usuario;

/**
 * @author Melissa Diniz - 115211394
 *
 */
public class FactoryDeUsuario{


	public Usuario criaUsuario(String nome, String login) throws StringInvalidaException{
		return new Noob(nome, login);
	}


}
