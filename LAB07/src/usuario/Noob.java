package usuario;

import java.util.Iterator;
import java.util.Set;

import excecoes.StringInvalidaException;
import excecoes.ValorInvalidoException;
import jogo.Jogabilidade;
import jogo.Jogo;

public class Noob extends Usuario {
	public static final double DESCONTO_NOOB = 0.9;

	public Noob(String nome, String login) throws StringInvalidaException {
		super(nome, login);
		setXp2(0);
	}

	@Override
	public void compraJogo(Jogo jogo) throws Exception {
		double custo = jogo.getPreco() * DESCONTO_NOOB;
		if (custo > this.getCredito()) {
			throw new ValorInvalidoException("Credito insuficiente para realizar a compra.");
		} else {
			int parteInteira = (int) (jogo.getPreco() - (jogo.getPreco() % 1));
			int bonusXp = parteInteira * 10;
			setXp2(getXp2() + bonusXp);
			setCredito(getCredito() - custo);
			this.cadastraJogo(jogo);

		}

	}

	@Override
	public int recompensar(String nomeJogo, int scoreObtido, boolean zerou) {
		
		// busca o jogo pelo nome
		Jogo jogo = super.buscaJogo(nomeJogo);
		// pega o set de jogabilidade do jogo
		Set<Jogabilidade> lista = jogo.getJogabilidades();

		for (Jogabilidade j : lista) {
			if (j == Jogabilidade.ONLINE) {
				super.setXp2(super.getXp2() - 10);
			}
			if (j == Jogabilidade.COMPETITIVO) {
				super.setXp2(super.getXp2() - 20);
			}
			if (j == Jogabilidade.COOPERATIVO) {
				super.setXp2(super.getXp2() - 50);
			}
		}
		setXp2(getXp2() + jogo.registraJogada(scoreObtido, zerou));

		return getXp2();

	}

	@Override
	public int punir(String nomeJogo, int scoreObtido, boolean zerou) {
		// busca o jogo pelo nome
		Jogo jogo = super.buscaJogo(nomeJogo);
		// pega o set de jogabilidade do jogo
		Set<Jogabilidade> lista = jogo.getJogabilidades();

		for (Jogabilidade j : lista) {
			if (j == Jogabilidade.OFFLINE) {
				super.setXp2(super.getXp2() + 30);

			}
			if (j == Jogabilidade.MULTIPLAYER) {
				super.setXp2(super.getXp2() + 10);
			}
		}
		return super.getXp2();


	}

	@Override
	public String toString() {
		String myString = this.getLogin() + FIM_DE_LINHA;
		myString += this.getNome() + " - Jogador Noob" + FIM_DE_LINHA;
		myString += "Lista de Jogos:" + FIM_DE_LINHA;

		Iterator itr = getMeusJogos().iterator();
		while (itr.hasNext()) {
			Jogo j = (Jogo) itr.next();
			myString += j.toString();
		}
		myString += FIM_DE_LINHA;
		myString += "Total de pre�o dos jogos: R$ " + this.calculaPrecoTotal() + FIM_DE_LINHA;
		myString += "--------------------------------------------";
		return myString;
	}

}