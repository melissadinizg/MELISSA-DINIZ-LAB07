/**
 * 
 */
package loja;

import java.util.Set;

import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;
import jogo.Jogabilidade;
import jogo.Jogo;
import jogo.Luta;
import jogo.Plataforma;
import jogo.Rpg;

/**
 * @author melissadg
 *
 */
public class FactoryDeJogo {

	public Jogo criaJogo(String nome, double preco, String tipo, Set<Jogabilidade> jogabilidade)
			throws StringInvalidaException, PrecoInvalidoException {
		switch (tipo) {

		case "Plataforma":
			return criarJogoPlataforma(nome, preco);
		case "Luta":
			return criaJogoLuta(nome, preco);
		case "Rpg":
			return criaJogoRPG(nome, preco);
		default:
			return null;
		}
		
	}

	/**
	 * Cria um jogo tipo Plataforma
	 * 
	 * @param nome
	 * @param preco
	 * @return jogo criado
	 * @throws PrecoInvalidoException
	 * @throws StringInvalidaException
	 * @throws AtributoInvalidoRuntimeException
	 */
	public Plataforma criarJogoPlataforma(String nome, double preco)
			throws StringInvalidaException, PrecoInvalidoException {
		return new Plataforma(nome, preco);
	}

	/**
	 * Cria um jogo tipo RPG
	 * 
	 * @param nome
	 * @param preco
	 * @return obj
	 * @throws PrecoInvalidoException
	 * @throws StringInvalidaException
	 * @throws AtributoInvalidoRuntimeException
	 */
	public Rpg criaJogoRPG(String nome, double preco) throws StringInvalidaException, PrecoInvalidoException {
		return new Rpg(nome, preco);
	}

	/**
	 * Cria jogo tipo luta
	 * 
	 * @param nome
	 * @param preco
	 * @return
	 * @throws PrecoInvalidoException
	 * @throws StringInvalidaException
	 * @throws AtributoInvalidoRuntimeException
	 */
	public Luta criaJogoLuta(String nome, double preco) throws StringInvalidaException, PrecoInvalidoException {
		return new Luta(nome, preco);
	}
}
