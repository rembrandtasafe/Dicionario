package dicionario;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class Dicionario {
	static String language;
	static String word;
	public Dicionario (String word, String language) {
		setLanguage(language);
		setWord(word);
	}
	public String consultaRadical() { // Consulta os dados do dicionario sobre palavras que originaram a palavra que está sendo pesquisada
         final String word_id = word.toLowerCase(); //word id is case sensitive and lowercase is required
         String param = "https://od-api.oxforddictionaries.com:443/api/v1/inflections/" + language + "/" + word_id;
		 final String app_id = "";
         final String app_key = "";
         try {
             URL url = new URL(param);
             HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
             urlConnection.setRequestProperty("Accept","application/json");
             urlConnection.setRequestProperty("app_id",app_id);
             urlConnection.setRequestProperty("app_key",app_key);
             HostnameVerifier hv = new HostnameVerifier() {
            	    public boolean verify(String hostname, SSLSession session) {  
            	        return true;
            	    }
             };
             BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
             StringBuilder stringBuilder = new StringBuilder();
             String line = null;
             while ((line = reader.readLine()) != null) {
                 stringBuilder.append(line + " ");
             }
             return stringBuilder.toString();
         }
         catch (Exception e) {
             //e.printStackTrace();
             return e.toString();
         } 
	}
	public boolean isVerb(String root) { // Retorna verdadeiro quando o redical da palavra pode ser um verbo
		return root.matches("(.*)Verb(.*)");
	}
	public boolean isNoun(String root) { // Retorna verdadeiro quando o redical da palavra pode ser um substantivo
		return root.matches("(.*)Noun(.*)");
	}
	public boolean isAdjective(String root) { 
		return root.matches("(.*)Adjective(.*)");
	}
	public boolean isAdverb(String root) { 
		return root.matches("(.*)Adverb(.*)");
	}
	public boolean isPronoun(String root) {
		return root.matches("(.*)Pronoun(.*)");
	}
	public boolean isPreposition(String root) { 
		return root.matches("(.*)Preposition(.*)");
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		Dicionario.language = language;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		Dicionario.word = word;
	}
}
