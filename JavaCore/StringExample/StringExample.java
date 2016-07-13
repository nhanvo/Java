public class StringExample {
    public static void main(String[] args) {
        StringExample strEx = new StringExample();

        // Compare String
        strEx.StringCompareEmp();

        // Search last string
        strEx.SearchLastString();

        // Remove char at any position
        strEx.RemoveCharAt();
    }
    
    void StringCompareEmp() {
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
}
