public class Main {

    public static void main(String[] args) {/*
        System.out.println(palidrome("atta"));*/
        GameOfLife game = new GameOfLife();
        game.play();;
    }

    public static boolean palidrome(String str1) {
        str1 = str1.replaceAll("\\s+", "").toLowerCase();
        if(str1.isEmpty()) return false;

        for (int i = 0, j = str1.length() - 1; i < j; i++, j--) {
            if (str1.charAt(i) != str1.charAt(j)) return false;
        }
        return true;
    }

}