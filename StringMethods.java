import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
public class StringMethods {
    public static void main(String[] args) {

        String welcomeString = "Welcome to Upgrad Campus";
        int  len = welcomeString.length(); // Get length of string (welcomeString.length() gives 24)
        System.out.println(len); // Prints 24

        System.out.println("\n\nThe isEmpty(), isBlank() method :");
        System.out.println(welcomeString.isEmpty()); // Returns false (because length is NOT 0)
        System.out.println("      ".isEmpty()); // Returns false because length is NOT 0
        System.out.println("    \t  ".isBlank()); // Returns true because String only has WhiteSpace characters

        System.out.println("\n\nThe toUpperCase(), toLowerCase() method :");
        System.out.println(welcomeString.toUpperCase()); // Prints "WELCOME TO UPGRAD CAMPUS"
        System.out.println(welcomeString.toLowerCase()); // Prints "welcome to upgrad campus"

        System.out.println("\n\nThe String.valueOf() method :");
        char[] characters = {'H','e','l','l','o'};
        String helloFromCharArray = String.valueOf(characters);
        System.out.println(helloFromCharArray); // Prints "Hello" (the string formed from char array)

        System.out.println("\n\nThe charAt() method :");
        System.out.println(welcomeString.charAt(0)); // Prints 'W'
        System.out.println(welcomeString.charAt(23)); // Prints 's'
        System.out.println(welcomeString.charAt(len-1)); // Prints 's'


        char thirdCharacter  = welcomeString.charAt(2);
        System.out.println(thirdCharacter); // Prints 'l'

        int firstCharCodePoint = welcomeString.charAt(0); // Getting unicode codepoint of first character

        System.out.println("\n\nThe indexOf() method: ");
        System.out.println(welcomeString.indexOf(25)); // Prints -1
        System.out.println(welcomeString.indexOf(87)); // Prints 0 (87 is UNICODE for 'W' which occurs at index 0)

        System.out.println(welcomeString.indexOf(87,3)); // Prints -1 ('W' doesn't occur at or after index 3)
        // You can have negative values or values greater than equal to length of the string for fromIndex
        // It doesn't throw exception for invalid fromIndex values

        System.out.println(welcomeString.indexOf('a',3,10)); // Prints -1 ('a' doesn't occur at index 0-9)
        System.out.println(welcomeString.indexOf('a',3,17)); // Prints 15 ('a' occurs at index 15)

        String stringWithSupplementaryCharacter = "something here, \uD861\uDC02 abc";
        System.out.println(stringWithSupplementaryCharacter.indexOf(164866)); // Prints 16
        // 164866 is outside of the BMP characters (Unicode code points) and is integer representation
        // of surrogate pair (\uD861\uDC02) [which is a Unicode supplementary character]
        // This code-point first occurs at index 16 [and takes index 16 and 17]

        System.out.println(welcomeString.indexOf("come to Upgrad"));
        System.out.println(welcomeString.indexOf("come to Upgrad",10)); // Prints -1
        // Given string doesn't occur on or after 10
        System.out.println(welcomeString.indexOf("come to Upgrad",1,15)); // Prints -1
        // (given string doesn't occur in [0-14]

        System.out.println("\n\nThe lastIndexOf() method: ");
        System.out.println(welcomeString.lastIndexOf('a')); // Prints 19 (Last index of 'a' is 19)
        System.out.println(welcomeString.lastIndexOf('x')); // Prints -1
        System.out.println(welcomeString.lastIndexOf('a',19)); // Prints 19
        System.out.println(welcomeString.lastIndexOf('a',18)); // Prints 15 (Last index of 'a' from 0 to 18)
        // (searches backwards)
        // Following are also available:
        //   lastIndexOf(String)
        //   lastIndexOf(String,int beginIndex)
        //   lastIndexOf(String,int beginIndex,int endIndex)


        System.out.println("\n\nThe subString() method :");
        System.out.println(welcomeString.substring(4)); // Prints "ome to Upgrad Campus" (from index 4)
        System.out.println(welcomeString.substring(11,17)); // Prints "Upgrad" (index 11 to 16)


        System.out.println("\n\nThe concat() method :");
        System.out.println(welcomeString.concat(" and LPU")); // Prints "Welcome to Upgrad Campus and LPU"
        // Note: Concat returns a new String (doesn't modify existing String)
        //       Thus, welcomeString is still same. (welcomeString = "Welcome to Upgrad Campus")

        System.out.println("\n\nThe + operator :"); // concatenation using + operator
        System.out.println(welcomeString +" and LPU"); // Prints "Welcome to Upgrad Campus and LPU"


        System.out.println("\n\nThe replace() method :");
        System.out.println(welcomeString.replace('a','#')); // Prints "Welcome to Upgr#d C#mpus"
        // replace() replaces all occurrences of oldChar with newChar and returns NEW string
        // If the character doesn't occur, it returns reference to the original string (doesn't create new one)

        System.out.println("\n\nThe replaceFirst(regex,replacement) method :");
        System.out.println(welcomeString.replaceFirst("Welc","C")); // Prints "Come to Upgrad Campus"
        System.out.println(welcomeString.replaceFirst("u|a","###")); // Prints "Welcome to Upgr###d Campus"
        System.out.println(welcomeString.replaceFirst("o|u|a","###")); // Prints "Welc###me to Upgrad Campus"
        String maxValueOfIntString = "Maximum value of INT_MAX is maximum value that int data-type can contain";
        System.out.println(maxValueOfIntString.replaceAll("Max|max|MAX","MIN"));
        // Above code Prints "MINimum value of INT_MIN is MINimum value that int data-type can contain"
        // It replaces all occurrences of Max or max or MAX
        // Read regex for using this properly

        System.out.println("\n\nThe split() method");
        String sentence = "This is a sentence that contains punctuation marks. " +
                "Thus, one should parse it carefully.";
        String[] words = sentence.split("[\\W]+",0); // limit = 0, apply delimiter
        // as many times as possible
        // and discard TRAILING EMPTY STRINGS
        // The above split() takes delimiter as one or more NON-WORD CHARACTERS (anything except A-Z,a-z,0-9 and _ )
        //  Regex Metacharacters for regex X
        //  X? - Zero or one appearance of X
        //  X* - Zero or more appearance of X
        //  X+ - One or more appearance of X
        //  X{n} - n appearances of X
        //  X{n,} - n or more appearances of X
        //  X{n,m} - n or more but less than m appearances of X
        // Regex finder
        // .    = Any character
        // \d   = Any digits = [0-9]  ( Note that you have to write "\\d" when using in a string
        // \D   = Any NON-DIGIT = [^0-9]
        // \s   = Whitespace character [\t\n\x0B\f\r]
        // \S   = NON-WHITESPACE CHARACTER [^\s]
        // \w   = Any word character [a-zA-Z_0-9]
        // \W   = Non-word character [^\w]
        // \b   = Word boundary
        // \B   = Non-word boundary

        for(String word:words){
            System.out.println(word); // Display each word from array of words
        }

        String sentence2 = "A sentence with 4 spaces";
        String[] str_arr1 = sentence2.split("\\s",2); // Apply delimiter 1 or limit-1 times only
        System.out.println(Arrays.toString(str_arr1)); // Prints [A, sentence with 4 spaces]
        String sentence3WithHyphens = "I-am-thinking---";

        str_arr1 = sentence3WithHyphens.split("-",3); // Apply delimiter 2 times or (limit-1) times
        System.out.println(Arrays.toString(str_arr1)); // Prints [I, am, thinking---]

        str_arr1 = sentence3WithHyphens.split("-",-2); // Apply delimiter as many times as possible
        // And keep the trailing empty strings

        System.out.println(Arrays.toString(str_arr1)); // Prints [I, am, thinking, , , ] (3 empty strings at the end)

        str_arr1 = sentence3WithHyphens.split("-",0); // Apply delimiter as many times as possible
        // And DISCARD the trailing empty strings

        System.out.println(Arrays.toString(str_arr1)); // Prints [I, am, thinking]

        str_arr1 = sentence3WithHyphens.splitWithDelimiters("-",0); // Returns array of strings and the delimiters
        System.out.println(Arrays.toString(str_arr1)); // Prints [I, -, am, -, thinking, -, , -, , -]
        str_arr1 = sentence3WithHyphens.splitWithDelimiters("-",-1); // Returns array of strings and the delimiters
        System.out.println(Arrays.toString(str_arr1)); // Prints [I, -, am, -, thinking, -, , -, , -, ]

        System.out.println("\n\nThe lines() method :");
        String multiline = "This is first line.\n" +
                "This is second line.\n" +
                "This is third line.\n";
        // lines() separates lines using line separators which are '\n', '\r' (Carriage return), "\r\n"
        Stream<String> lines = multiline.lines(); // Get a Stream<String> of lines
        lines.forEach(System.out::println); // Print each line in the stream


        System.out.println("\n\nThe join() method :");
        List<String> wordList = List.of("My","name","is","Barry","Allen");
        String sentenceFromWordList = String.join(" ",wordList); // Takes a delimiter and Iterable
        System.out.println(sentenceFromWordList); // Prints "My name is Barry Allen"
        String sentenceFromWords = String.join(" ","This","is","list","of","words"); // Can take CharSequence
        // to join directly
        System.out.println(sentenceFromWords); // Prints "This is list of words"
        String sentenceFromStringArray = String.join(" ",words); // Can take delimiter and an array of CharSequence
        System.out.println(sentenceFromStringArray);
        // Above statement prints "This is a sentence that contains punctuation marks Thus one should parse it carefully"

        System.out.println("\n\nThe getChars() method :");
        char[] charArray = new char[25];
        welcomeString.getChars(0, welcomeString.length(),charArray,0);
        System.out.println(Arrays.toString(charArray));
        // The above statement prints:
        //  [W, e, l, c, o, m, e,  , t, o,  , U, p, g, r, a, d,  , C, a, m, p, u, s,\u0000 ]
        // \u0000 is null character (default values for char array elements) [output will show this with a symbol]

        System.out.println("\n\nThe toCharArray() method :");
        // toCharArray() converts String to character array
        char[] arrayFromString = welcomeString.toCharArray();



        char[] charArray2 = new char[30];
        welcomeString.getChars(0, welcomeString.length(),charArray2,6); // Starts filling the array up from index 6
        System.out.println(Arrays.toString(charArray2));

        System.out.println("\n\nThe trim() and strip() method :");
        System.out.println("\nNote: Space is defined any character whose value is less than or equal to \\u+0020");
        System.out.println("\nNote: \\u+0020 is Unicode for space");
        String stringWithLeadingSpaces = "     A String with leading spaces.";
        String stringWithTrailingSpaces = "A String with trailing spaces.      ";
        String stringWithSpacesOnBothSides = "     A String with leading and trailing spaces.      ";
        System.out.println(stringWithLeadingSpaces.trim()); // Prints "A String with leading spaces."
        System.out.println(stringWithTrailingSpaces.trim()); // Prints "A String with trailing spaces."
        System.out.println(stringWithSpacesOnBothSides.trim()); // Prints "A String with leading and trailing spaces."

        System.out.println(stringWithLeadingSpaces.strip()); // strip() removes leading/trailing WhiteSpace Characters
        // It checks for whiteSpace using Character.isWhitespace(int codePoint)
        System.out.println(stringWithSpacesOnBothSides.stripLeading()); // "A String with leading and trailing spaces.      "
        System.out.println(stringWithSpacesOnBothSides.stripTrailing()); // "     A String with leading and trailing spaces."

        System.out.println("\n\nThe equals() and equalsIgnoreCase() method :");
        String welcomeString2 = "Welcome to Upgrad Campus";
        String welcomeString3 = "Welcome to Upgrad campus"; // c is lowercase in Campus
        System.out.println(welcomeString.equals(welcomeString3)); // Prints false
        System.out.println(welcomeString.equalsIgnoreCase(welcomeString3)); // Prints true
        System.out.println(welcomeString.equals(welcomeString2)); // Prints true


        System.out.println("\n\nThe contentEquals() method :");
        StringBuffer sb = new StringBuffer("Welcome to Upgrad Campus");
        System.out.println(welcomeString.contentEquals(sb)); // Prints true

        System.out.println("\n\nThe compareTo() method :");
        String word1 = "Helium";
        String word2 = "Helicopter";
        String word3 = "Helipad";
        String word4 = "Hello";
        String word5 = "Hello";
        System.out.println(word1.compareTo(word2)); // Prints 18 (positive because word1 > word2 LEXICOGRAPHICALLY)
        System.out.println(word2.compareTo(word3)); // Prints -13 (negative because word2 < word3 LEXICOGRAPHICALLY)
        System.out.println(word3.compareTo(word4)); // Prints -3 (negative because word3 < word4 LEXICOGRAPHICALLY)
        System.out.println(word4.compareTo(word5)); // Prints 0 (because word4 = word5)
        System.out.println(word5.compareTo(word1)); // Prints 3 (because word5 > word1 LEXICOGRAPHICALLY)

        // word1 > word2 lexicographically means in a dictionary word1 will come AFTER word2
        // word1 and word2 have same first 4 letters (H,e,l,i)
        // They only differ in 5th characters
        System.out.println('u'-'c'); // We can use characters as integers. This prints 18
        // That is 'u' comes after 18 characters starting from 'c' (c+18 = u)
        System.out.println((char)('c'+18)); // Prints 'u'

        // Similarly, word2 and word3 have equal first 4 letters
        System.out.println('c'-'p'); // This prints -13

        String word6 = "Summer";
        String word7 = "Summer Vacation";
        System.out.println(word6.compareTo(word7)); // Prints -9 which means word7 > word6
        // Lexicographically, these two strings don't differ at any index
        // so compareTo returns the difference in length of word6 and word7
        // So, in such a case, longer string is lexicographically GREATER (comes after a dictionary)

        System.out.println(word6.length()-word7.length()); // Prints -9

        System.out.println("\n\nThe startsWith() and endsWith() methods");
        System.out.println(welcomeString.startsWith("Welc")); // Prints true
        System.out.println(welcomeString.startsWith("welc")); // Prints false (Case sensitive)
        System.out.println(welcomeString.startsWith("Camp")); // Prints false
        System.out.println(welcomeString.startsWith("Camp",17)); // Prints false
        System.out.println(welcomeString.startsWith("Camp",18)); // true (welcomeString starts with "Camp" from index 18)

        System.out.println(welcomeString.endsWith("us")); // Prints true
        System.out.println(welcomeString.endsWith("Us")); // Prints false (case sensitivity)



        System.out.println("\n\nThe methods to deal with Unicode Code points :");
        System.out.println(firstCharCodePoint); // Prints 87

        System.out.println(welcomeString.codePointAt(0)); // Prints 87

        String highSurrogateValue = "\uD861";
        System.out.println(highSurrogateValue.codePointAt(0)); // Prints 55393
        // Because \uD861 is HIGH SURROGATE value
        // It needs a value in low surrogate range at next index
        // Next index is out of bounds
        // So, it returns 55393 (decimal for D861 which is hex)
        System.out.println(highSurrogateValue); // Prints ? (question mark) because there is no character here

        String surrogatePair = "\uD861\uDC02";
        System.out.println(surrogatePair.length()); // Prints 2 [2 characters but they
        // represent a single character together]

        System.out.println(surrogatePair.codePointAt(0)); // Prints 164866
        // Now that we have added a LOW SURROGATE value after HIGH SURROGATE VALUE
        // This has become a CODE UNIT (surrogate pair)
        // This represents a supplementary character in Unicode
        System.out.println(surrogatePair); // Prints this character => 𨐂

        System.out.println(welcomeString.codePointBefore(1)); // Prints 87 (code point of W)


        System.out.println(welcomeString.codePointCount(0,5)); // Prints 5
        // There are 5 code points from 0 to 4 (W,e,l,c,o)

        System.out.println(welcomeString.offsetByCodePoints(0,5)); // Prints 5
        // Gives index after counting given number of code points. . .
        // Here we are counting 5 code points from index 0
        // We have code points at 0, 1, 2, 3, 4 (5 code points)
        // So, method returns the next index after 5 code points starting from 0


        String stringWithSurrogatePairs = "\uD861\uDC02abc";
        System.out.println(stringWithSurrogatePairs.offsetByCodePoints(0,2)); // Prints 3
        // Note that first two char values form a surrogate pair
        // That means these two are a single Unicode code point (supplementary character)
        // Thus, to count 2 code points we have code-points at 0,1 (𨐂 or \uD861\uDC02) and 2 (a)
        // Next index after counting 2 code points is 3

        String stringWithOnlyHighSurrogate = "\uD861\u0020abc"; // \u0020 is Unicode for space
        System.out.println(stringWithOnlyHighSurrogate.offsetByCodePoints(0,2)); // Prints 2
        // Note that \uD861 is an UNPAIRED HIGH SURROGATE and will be counted as 1 code point
        // Then we have another code point \u0020 at index 1
        // So, after counting two code points (at index 0 and index 1), the next index is 2


        System.out.println("ABC_".repeat(5)); // Create string by repeating "ABC_" 5 times: ABC_ABC_ABC_ABC_ABC_


    }/**/
}
