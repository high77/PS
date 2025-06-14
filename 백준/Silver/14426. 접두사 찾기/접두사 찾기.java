import java.io.*;

public class Main {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null) node.children[index] = new TrieNode();
                node = node.children[index];
            }
        }

        boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (node.children[index] == null) return false;
                node = node.children[index];
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Trie trie = new Trie();

        for (int i = 0; i < N; i++) {
            trie.insert(br.readLine());
        }

        int ans = 0;
        for (int i = 0; i < M; i++) {
            if (trie.startsWith(br.readLine())) ans++;
        }

        System.out.println(ans);
    }
}
