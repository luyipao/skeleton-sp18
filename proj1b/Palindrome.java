public class Palindrome {
    /** I use ArrayDeque to instanlize*/
    static private Deque<Character> privatewordToDeque(String word) {
        Deque<Character> deque = new ArrayDeque<Character>();
        char[] charword = word.toCharArray();
        for(int i = 0; i < charword.length; i++) {
            deque.addLast(charword[i]);
        }
        return deque;
    }

    /** convert a String to char in deque*/
    public Deque<Character> wordToDeque(String word) {
        return privatewordToDeque(word);
    }

    /** judge a String is Palindrome or not*/
    public boolean isPalindrome(String word) {
        Deque<Character> deque = Palindrome.privatewordToDeque(word);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }


    /**overload isPalindrome using the `CharacterComparator`*/
    public boolean isPalindrome(String word, CharacterComparator cc) {
        cc = new OffByOne();
        Deque<Character> deque = Palindrome.privatewordToDeque(word);
        while (deque.size() > 1) {
            if (! cc.equalChars(deque.removeFirst(), deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}
