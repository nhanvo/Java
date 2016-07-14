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

        // String split
        strEx.StringSplit();

        // String region Match
        strEx.StringRegionMatch();

        // Compare performance when init strong
        strEx.ComparePerformance();

        // Concatenate two string
        strEx.StringConcatenate();
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

    void StringSplit() {
        String str = "jan-feb-march";
        String[] temp;
        String delimeter = "-";
        temp = str.split(delimeter);
        for(int i = 0; i < temp.length; i++) {
             System.out.println(temp[i] + " ");
        }
    }

    void StringRegionMatch() {
        String first_str = "Welcome to TheWorld";
        String second_str = "I work with TheWorld";
        boolean match = first_str.regionMatches(11, second_str, 12, 8);
        System.out.println("first_str[11-8] == second_str[12-8]: " + match);
    }

    void ComparePerformance() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            String s1 = "Hello";
            String s2 = "Hello";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken for creation" 
        + " of String literals : "+ (endTime - startTime) 
        + " milli seconds" );

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            String s3 = new String("Hello");
            String s4 = new String("Hello");
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken for creation" 
        + " of String objects : "+ (endTime - startTime) 
        + " milli seconds" );
    }

    void StringConcatenate() {
        long startTime = System.currentTimeMillis();
        for(int i=0;i<5000;i++){
            String result = "This is"
            + "testing the"
            + "difference"+ "between"
            + "String"+ "and"+ "StringBuffer";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken for string" 
        + "concatenation using + operator : " 
        + (endTime - startTime)+ " ms");
        long startTime1 = System.currentTimeMillis();
        for(int i=0;i<5000;i++){
            StringBuffer result = new StringBuffer();
            result.append("This is");
            result.append("testing the");
            result.append("difference");
            result.append("between");
            result.append("String");
            result.append("and");
            result.append("StringBuffer");
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("Time taken for String concatenation" 
        + "using StringBuffer : "
        + (endTime1 - startTime1)+ " ms");
    }
}











