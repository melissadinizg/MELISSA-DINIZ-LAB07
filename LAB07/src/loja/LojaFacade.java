/**
 * 
 */
package loja;

import java.util.Set;

import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;
import jogo.Jogabilidade;

/**
 * @author Melissa
 *
 */
public class LojaFacade {
	private LojaController lojaController;
	
	public LojaFacade(){
		this.lojaController = new LojaController();
	}
	
	public void criaUsuario(String nome, String login) throws StringInvalidaException{
		lojaController.criaUsuario(nome, login);
	}
	
	public void criaJogo(String nome, double preco, String tipo, Set<Jogabilidade> jogabilidade) throws StringInvalidaException, PrecoInvalidoException{
		lojaController.criaJogo(nome, preco, tipo, jogabilidade);
	}
	
	public void adicionaUsuario(String nome, String login){
		lojaController.adicionaUsuario(nome, login);
	}
	
	public void vendeJogo(String jogoNome, double preco, String jogabilidades, String estiloJogo, String loginUser){
		lojaController.vendeJogo(jogoNome, preco, jogabilidades, estiloJogo, loginUser);
	}
	
	/**
	public void registraJogada(String login, String nomeJogo, int score, boolean venceu){
		lojaController.registraJogada(login, nomeJogo, score, venceu);
	}
	**/
	public void adicionaCredito(String login, double credito){
		lojaController.adicionaCredito(login, credito);
	}

	public void buscaUsuario(String login){
		lojaController.buscaUsuario(login);
	}
	
	public void upgrade(String login) throws Exception{
		lojaController.upgrade(login);
	}
	
	public void confereCredito(String login){
		lojaController.confereCredito(login);
	}
	
	public void getX2p(String login){
		lojaController.getX2p(login);
	}
}
