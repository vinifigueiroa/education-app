public class Helpers {

    public static boolean positiveIntegerCheck(String s) {

        //Evaluates if a string input is a valid positive integer and returns a boolean value.
        int i;

        try {

            i = Integer.parseInt(s);

        } catch (NumberFormatException e) {

            return false;
        }

        if (i  < 0) {
            return false;

        }

        return true;
    }
}
