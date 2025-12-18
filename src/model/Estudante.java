package model;

public class Estudante implements Comparable<Estudante> {

	private int matricula;
	private String nome;
	private int nota;
	
		
	public Estudante(int matricula, String nome, int nota) {
		this.matricula = matricula;
		this.nome = nome;
		this.nota = nota;
	}

	
												// getters gerados para algoritmos que usaram dados
	public int getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public int getNota() {
		return nota;
	}

							// não há setters pelo motivo de não precisar modificar
	
	@Override
	public int compareTo(Estudante outro) {		// no compareTo podemos ter: negativo, zero ou positivo

		if(this.nota != outro.nota){			// nota decrescente
			return outro.nota - this.nota;		// se for 0 vai para o próximo critério, se for positivo o java entende que o outro passa a frente, caso negativo mantem
		}
		
		int compNome = this.nome.compareTo(outro.nome);	// caso 2 - o compareTo da string já retorna positivo/negativo informando se vem antes ou depois
		if (compNome != 0) {					// se o resultado não for 0 significa que os nomes são diferentes
			return compNome;					// retorna o valor para definir a ordem
		}
		
		
		return this.matricula - outro.matricula;	// matrícula (nome e nota empatados)
												// compara x com y, e retorna negativo, 0 ou positivo para o método
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Mat: %d |", matricula));
		sb.append(String.format(" Nome: %-15s |", nome));
		sb.append(String.format(" Nota: %d |", nota));
		return sb.toString();
	}
	
}
