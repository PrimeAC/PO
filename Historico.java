public class Historico {

	List <JogosGalo> _jogos = new ArrayList<JogosGalo>();

	public void adicionar(JogoGalo j) {
		_jogos add (j);
	}

	public void mostrarJogos() {
		for(JogoGalo j: _jogos){
			System.out.println(j.obtemEstadoJogo());
		}
	}

	public JogoGalo obterJogo(int i){
		System.out.println(_jogos[i].obtemEstadoJogo());
	}
}