package Tries;

public class TriesClient {

	public static void main(String[] args) {
		Tries trie = new Tries();
		trie.addString("abcd");
		trie.addString("abcde");
		trie.addString("pqrs");
		System.out.println(trie.Searchword("abcd"));
		System.out.println(trie.Searchword("lmn"));
		System.out.println("-----------------");
		trie.display();
		trie.delete("abcd");
		System.out.println("-----------------");
		trie.display();
		System.out.println(trie.startswith("pq"));
	}
}
//OUTPUT
//true
//false
//-----------------
//pqrs
//abcd
//abcde
//-----------------
//pqrs
//abcde
//true
