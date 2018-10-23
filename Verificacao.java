package dicionario;

public class Verificacao {
	String[] nomes, convencao;
	String linguagem;
	public Verificacao(String[] nomes, String[] convencao, String linguagem) {
		this.nomes = nomes;
		this.convencao = convencao;
		this.linguagem = linguagem;
	}
	public boolean verifica() {
		int i = 0;
		for (i=0;i<convencao.length;i++) {
			Dicionario dicionario = new Dicionario(nomes[i], linguagem);
			if (convencao[i].equals("verb")) {
				if (!dicionario.isVerb(dicionario.consultaRadical())) {
					return false;
				}
			} else if  (convencao[i].equals("noun")){
				if (!dicionario.isNoun(dicionario.consultaRadical())) {
					return false;
				}
			} else if (convencao[i].equals("adjective")){
				if (!dicionario.isAdjective(dicionario.consultaRadical())) {
					return false;
				}	
			} else if (convencao[i].equals("adverb")){
				if (!dicionario.isAdverb(dicionario.consultaRadical())) {
					return false;
				}	
			} else if (convencao[i].equals("pronoun")){
				if (!dicionario.isPronoun(dicionario.consultaRadical())) {
					return false;
				}	
			} else if (convencao[i].equals("preposition")){
				if (!dicionario.isPreposition(dicionario.consultaRadical())) {
					return false;
				}	
			}
		}
		if (nomes.length > convencao.length) {
			for (int j=i;j<nomes.length;j++) {
				Dicionario dicionario = new Dicionario(nomes[i], linguagem);
				if (convencao[i-1].equals("verb")) {
					if (!dicionario.isVerb(dicionario.consultaRadical())) {
						return false;
					}
				} else if  (convencao[i-1].equals("noun")){
					if (!dicionario.isNoun(dicionario.consultaRadical())) {
						return false;
					}
				} else if (convencao[i-1].equals("adjective")){
					if (!dicionario.isAdjective(dicionario.consultaRadical())) {
						return false;
					}	
				} else if (convencao[i-1].equals("adverb")){
					if (!dicionario.isAdverb(dicionario.consultaRadical())) {
						return false;
					}	
				} else if (convencao[i-1].equals("pronoun")){
					if (!dicionario.isPronoun(dicionario.consultaRadical())) {
						return false;
					}	
				} else if (convencao[i-1].equals("preposition")){
					if (!dicionario.isPreposition(dicionario.consultaRadical())) {
						return false;
					}	
				}
			}
		}
		return true;
	}
}
