package menus;

public class Loading {

    static void typeWriter(String text, int delay) throws Exception {
        for (char ch : text.toCharArray()) {
            System.out.print(ch);
            Thread.sleep(delay);
        }
        System.out.println();
    }

    public void loading(int timeInMiliSecond) throws Exception {

        System.out.print("Loading:-");
        for (int i = 0; i < timeInMiliSecond; i++) {
            System.out.print("█");
            Thread.sleep(80);
        }
        System.out.println();

    }

}
