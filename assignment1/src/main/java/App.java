import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class App {

    //A class that deals with user inputs making sure that they are the correct type and not null
    public static class Input {
        String String() {
            String input;
            while (true) {
                Scanner user_input = new Scanner(System.in);
                input = user_input.nextLine();
                if(input == null || input.isEmpty()) System.out.println("You did not enter anything!"); else break;
                    // User hit enter without any data. Display error message then back to top of loop
            };
            return input;
        }
        int Int() {
            int input;
            while (true) {  
                try{
                    Scanner user_input = new Scanner(System.in);
                    input = user_input.nextInt();
                }   
                //Checks that the input is an integer
                catch(Exception e){
                    System.out.println("That was not a whole number!");
                    continue;
                }
                    break;
                };
            return input;
        }
        double Double() {
            double input;
            while (true) {
                try{
                    System.out.println("Enter a number: ");
                    Scanner user_input = new Scanner(System.in);
                    input = user_input.nextDouble();
                    System.out.println("");
                }
                //Checks that the input is a double
                catch(Exception e){
                    System.out.println("That was not a number!");
                    continue;
                }
                break;
                };
            return input;
        }
    }

    //a method that takes an array of integers and add them all together
    //returning the total value
    public static int sum(int[] list){
        int total = 0;
        int index = 0;

        while(index < list.length){
            total += list[index];
            index++;
        }
        return total;
    }

/////////////////////////////
/////// Main Program ////////
/////////////////////////////

    public static void main( String[] args )
    {
        Random random = new Random();
        Input user_input = new Input();

        System.out.println("Use a number to select which program you want");
        System.out.println("1) Rock, Paper, Scissors");
        System.out.println("2) Dog Genetics");
        System.out.println("3) Healthy Hearts");
        System.out.println("4) Summative Sums");

        int program = user_input.Int();
        System.out.println("");

        //Each case is a different program.
        switch(program){
            //Rock, Paper, Scissors
            case 1:
                String play = "Yes";
                String[] select = {"Rock","Paper","Scissor"};

                //keeps running the program until the user inputs something other than y or yes.
                while(play.toLowerCase().equals("yes") || play.toLowerCase().equals("y")){
                    int maxRounds = 0;
                    int round = 1;
                    int userWin = 0;
                    int computerWin = 0;
                    int tie = 0;
                    int user = 0;

                    //Keeps trying until the user only inputs a number between 1 and 10
                    while(maxRounds < 1 || maxRounds > 10){
                        System.out.println("\nHow many rounds, between 1 and 10 would the user like to play? ");
                        maxRounds = user_input.Int();
                        System.out.println("");
                        if(maxRounds < 1 || maxRounds > 10) System.out.println(maxRounds+" is not between 1 and 10");
                    }
                    while(round <= maxRounds){
                        System.out.println("Select a number: Rock=1, Paper=2, Scissors=3 ");

                        //keep trying until the user inputs either 1,2, or3
                        do{
                            System.out.println("Make sure the number is 1, 2, or 3");
                            user = user_input.Int();
                            System.out.println("");
                        }while(user < 1 || user > 3);

                        //the computer's input to the game
                        int computer = random.nextInt(3)+1;
                        
                        //determines who wins the round 
                        if(user == computer){
                            System.out.println(select[user-1]+" vs "+select[computer-1]+". It's a tie, no one wins!\n");
                            tie++;
                        }else if((user==1 && computer==3) || (user==2 && computer==1) || (user==3 && computer==2)){
                            System.out.println(select[user-1]+" vs "+select[computer-1]+". User wins!\n");
                            userWin++;
                        }else{
                            System.out.println(select[user-1]+" vs "+select[computer-1]+". Computer wins!\n");
                            computerWin++;
                        }
                        round++;
                    }

                    //outputs the results
                    System.out.println("\nThe number of ties were: "+tie);
                    System.out.println("The number of user wins were: "+userWin);
                    System.out.println("The number of computer wins were: "+computerWin);
                    
                    //determines the overall winner
                    if(userWin==computerWin){
                        System.out.println("\nNobody wins; it is a tie");
                    }else if(userWin>computerWin){
                        System.out.println("\nThe User Wins! Congratulations");
                    }else{
                        System.out.println("\nThe Computer Wins! Congratulations");
                    }

                    //checks if the user wants to play again
                    System.out.println("\nWould you like to play again? ");
                    play = user_input.String();
                }
                System.out.println("\nThanks for playing!");
                break;

            //Dog Genetics
            case 2:
                int PercentTotal = 0;
                int percent = 0;
                int index = 0;
                boolean maxPercent = false;
                String[] dogBreeds = {"St. Bernard","Chihuahua","Dramatic RedNosed Asian Pug","Common Cur","King Doberman"};

                System.out.print("What is your dog's name? ");
                String dogName = user_input.String();
                System.out.println("Well then, I have this highly reliable report on "+ dogName + "'s prestigious background right here. \n");
                System.out.println(dogName + " is:\n");

                //generates the percentages for the first 4 dog breeds
                while(index < dogBreeds.length){
                    percent = random.nextInt(101);

                    //compares the current percentage generate to all to the total percentage already produced
                    if(((PercentTotal + percent) < 100) && (index < dogBreeds.length-1)){
                        System.out.println(percent+"% "+dogBreeds[index]);
                        PercentTotal += percent;
                    }else if(maxPercent){ //if the total percentage has reached 100%
                        System.out.println("0% "+dogBreeds[index]);
                    }else{ //the first time you have just gone over 100%
                        percent = 100-PercentTotal;
                        System.out.println(percent+"% "+dogBreeds[index]);
                        maxPercent = true;
                        PercentTotal += percent;
                    }
                    index++;
                }
                break;
            
            //Healthy Hearts
            case 3:
                System.out.print("What is your current age? ");
                int age = user_input.Int();
                int maxHeartRate = 220-age;
                //calculates and rounds the target heart rate zone is the 50 - 85% of the maximum.
                int lowerHR = (int) Math.round(maxHeartRate*0.5);
                int upperHR = (int) Math.round(maxHeartRate*0.85);
                System.out.println("Your maximum heart rate should be "+ (maxHeartRate) + " beats per minute");
                System.out.println("Your target HR Zone is "  + lowerHR + " - " + upperHR + " beats per minute" );

                break;
            
            //Summative Sums
            case 4:
                int[] array1 = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
                int[] array2 = { 999, -60, -77, 14, 160, 301 };
                int[] array3 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 
                    140, 150, 160, 170, 180, 190, 200, -99 };
                
                //takes the arrays of integers and uses the method sum() to add them all together
                System.out.println("#1 Array Sum: " + sum(array1));
                System.out.println("#2 Array Sum: " + sum(array2));
                System.out.println("#3 Array Sum: " + sum(array3));

                break;
            default:
                System.out.println("\nGoodbye");

        }
    }
}
