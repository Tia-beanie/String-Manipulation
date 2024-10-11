/**
 * This program asks user to enter a sentence and display a menu. User can select the options and display some data about the sentence. 
 */

import java.util.Scanner;

/**
 * The main method reads user input, display a menu, ask user to input selections and display the result.
 */
public class StringManipulation {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a sentence: ");
        String sentence = scan.nextLine();

        int option;

        //Repeat the menu, until user enters 6 to terminate program
        do{
            //Invoke menu method to display menu
            menu();

            //Read user's selection
            option = scan.nextInt();
           
            //Invoke the method according to user selection
            switch (option) {
                case 1:
                    numberOfWords(sentence);
                    break;
                case 2:
                    numberOfVowels(sentence);
                    break;
                case 3:
                    longestWord(sentence);
                    break;
                case 4:
                    mostVowels(sentence);
                    break;
                case 5:
                    sentence = newStatement();
                    break;
                case 6:
                    System.out.println("Program terminates.");
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }while(option != 6); //Terminate program when user enters '6'
    }

    //The method displays the menu
    public static void menu(){

        System.out.println("\nPlease enter: ");
        System.out.println("1. To display the number of words in the sentence.");
        System.out.println("2. To display the number of vowel characters in the sentence.");
        System.out.println("3. To display the word with the most number of characters.");
        System.out.println("4. To display the word with the most vowels.");
        System.out.println("5. To enter a new statement.");
        System.out.println("6. To terminate the program.");
    }

    //This moethod decides how many words in total, and display
    public static void numberOfWords(String sent){
        int count=0, index=0;
        sent = sent.trim(); //Trim the extra spaces

        while(index < sent.length()){
            //charAt() returns the character which use ' '
            if((sent.charAt(index) == ' ') && (sent.charAt(index+1) != ' ')){
                count++; 
            }
            index++;
        }
        count++;
        System.out.println("There are " + count + " words in " + "\"" + sent + "\"");
    }

    //This method decides the total quantity of each vowels and display
    public static void numberOfVowels(String sent){
        int count_A = 0, count_E = 0, count_I = 0, count_O = 0, count_U = 0, index = 0;
        String upperSent = sent.toUpperCase();
        while(index < sent.length()){

            if(upperSent.charAt(index) == 'A')
                count_A++;
            if(upperSent.charAt(index) == 'E')
                count_E++;
            if(upperSent.charAt(index) == 'I')
                count_I++;
            if(upperSent.charAt(index) == 'O')
                count_O++;
            if(upperSent.charAt(index) == 'U')
                count_U++;
            index++;
        }  
        System.out.println("There are:\n" + count_A + " a's\n" + count_E + " e's\n" + count_I + " i's\n" + count_O + " o's\n" + count_U + " u's\n" + "in " + "\"" + sent + "\"");
    }

    //This method decides the longest word in the sentence, and display
    public static void longestWord(String sent){
        int index = 0;
        String word = "", longestWord = "";
        sent = sent.trim(); //Trim the extra spaces
        sent += " "; //Add one space at end of sentence
   
        //Iterate through each character
        while(index < sent.length()){
    
            word += sent.charAt(index);

            if(sent.charAt(index) == ' '){
                if(word.length() > longestWord.length()){
                    longestWord = word;
                }
                word = "";
            }   
            index++;
        }  
  
        System.out.println("The longest word is: " + longestWord);
    }

    //This method decides the word with the most vowels and display
    public static void mostVowels(String sent){

        int index = 0;
        int currentVowelCount = 0;
        int mostVowelCount = 0;
        String currentWord = "", mostVowelWord = "";
        sent = sent.trim();
        sent += " ";
        sent = sent.toLowerCase();
   
        //Iterate through each character
        while(index < sent.length()){

            currentWord += sent.charAt(index);

            if(sent.charAt(index) == 'a'
             ||sent.charAt(index) == 'e'
             ||sent.charAt(index) == 'i'
             ||sent.charAt(index) == 'o'
             ||sent.charAt(index) == 'u'){ 

                currentVowelCount++;
            }
            
            //When it encounters a space, compare with previous count, set the new word
            if(sent.charAt(index) == ' '){
                if(currentVowelCount > mostVowelCount){
                    mostVowelCount = currentVowelCount;
                    mostVowelWord = currentWord;
                }
                //Set current count to 0, set current word to empty
                currentVowelCount = 0;
                currentWord = "";
            }   
            index++;
        }
        System.out.println("The word with the most vowels is: " + mostVowelWord);
    }

    //This method ask user to enter a new sentence, return the String back to main()
    public static String newStatement(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a new statement: ");
        String newSent = scan.nextLine();
        return newSent;
    }

}