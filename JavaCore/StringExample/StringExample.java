public class StringExample {
    public static void main(String[] args) {
        // Init StringExample object
        StringExample strEx = new StringExample();

        // Compare String
        strEx.StringCompare();

        // Search last string
        strEx.SearchLastString();

        // Remove char at any position
        strEx.RemoveCharAt();

        // Replace string inside original string by other string
        strEx.StringReplace();

        // Reverse string
        strEx.StringReverse();

        // Search string
        strEx.SearchString();
    }
    
    void StringCompare() {
        String str = "Hello World";
        String anotherString = "Hello world";
        
        Object objStr = str;
        System.out.println(str.compareTo(anotherString));
        System.out.println(str.compareToIgnoreCase(anotherString));
        System.out.println(str.compareTo(objStr.toString()));
    }

    void SearchLastString() {
        String strOrig = "Hello world, Hello Reader";
        int lastIndex = strOrig.lastIndexOf("Hello");
        String result = "";
        if (lastIndex == -1) {
            result = "Hello not found";
        } else {
            result = "Last occurrence of Hello is at index " + lastIndex;
        }

        System.out.println(result);
    }

    void RemoveCharAt() {
        String str = "This is Java";
        System.out.println("Original string: " + str);
        int pos = 3;
        str = str.substring(0, pos) + str.substring(pos + 1);
        System.out.println("Remove character number 3: " + str);
    }

    void StringReplace() {
        String str = "Hello world";
        System.out.println("Original string: " + str);
        System.out.println(str.replace('H', 'W'));
        System.out.println(str.replace("He", "Wa"));
        System.out.println(str.replace("Hello", "Halla"));
    }

    void StringReverse() {
        String str = "Hello world";
        String reverse = new StringBuffer(str).reverse().toString();

        System.out.println("Original:" + str);
        System.out.println("Reverse: " + reverse);
    }

    void SearchString() {
        String str = "Hello world";
        int index = str.indexOf('o');
        System.out.println(index);
    }
}











