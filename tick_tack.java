import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.lang.*;
class tick{

    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("\n\n\n\nWellcome to a small tick tack toe game.\nYou all know the rules except, since I'm lazy to learn graphics and web git does not work with it, here are some premade rules:\n to place your sybmol, yoy need to give me 2 integers: one for row and one for column.\n(for all programmers, input numbers normal, I adjusted array indexification)");
        
        System.out.print("\n\nHow many people playing (1 or 2. if 1 - against computer)\n\n> ");
        int num=input.nextInt();
        int[][] field = {{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
        
        String[] game_field= {"_","|","_","|","_","\n","_","|","_","|","_","\n"," ","|"," ","|"," "};
        int counter=0;
        String team="";int turn1 =-1;int turn2=-1;   // declaring variables. Team for what sybols player places
        System.out.println(String.join("", game_field));
        if (num==2){
            while (counter<9 && !winning_scen(field)){
                System.out.print("Where do you want to put your mark?\n> ");
                turn1=input.nextInt()-1;
                System.out.print("> ");
                turn2=input.nextInt()-1;
                if (turn1>2 || turn1<0 || turn2>2 || turn2<0){
                    System.out.println("Retry, your numbers aint working");
                    continue;
                }
                if (field[turn1][turn2]==-1){
                    if (counter%2==0){
                        field[turn1][turn2]=1;
                        if (turn1<2){
                            game_field[turn1*6+turn2*2]="\u001B[34m"+"X̲"+"\u001B[0m";                //"\u001B[0m" - reset    "\u001B[31m" - red   "\u001B[34m" - blue
                        } else {
                            game_field[turn1*6+turn2*2]="\u001B[34m"+"X"+"\u001B[0m";
                        }
                    } else {
                        field[turn1][turn2]=0;
                        if (turn1<2){
                            game_field[turn1*6+turn2*2]="\u001B[31m"+"O̲"+"\u001B[0m";
                        } else {
                            game_field[turn1*6+turn2*2]="\u001B[31m"+"O"+"\u001B[0m";
                        }
                    }
                    counter++;
                } else {
                    System.out.println("Choose an empty spot.");
                }

                System.out.println(String.join("", game_field));
            }
        } else if (num==1){
            System.out.print("Choose your team (\'X\' or \'O\'). Remember the \'X\' goes first\n> ");
            input.nextLine();
            
            team = input.nextLine().toLowerCase();
            while (!(team.equals("x") || team.equals("o"))){
                System.out.println("Your input went wrong. Try again, please.");
                team = input.nextLine().toLowerCase();
            }
            if (team.equals("x")){
                while (counter<9 && !winning_scen(field)){
                    if (counter%2==0){
                        System.out.print("Where do you want to put your mark?\n> ");
                        turn1=input.nextInt()-1;
                        System.out.print("> ");
                        turn2=input.nextInt()-1;
                        if (turn1>2 || turn1<0 || turn2>2 || turn2<0){
                            System.out.println("Retry, your numbers aint working");
                            continue;
                        }
                        if (field[turn1][turn2]==-1){
                            field[turn1][turn2]=1;
                            if (turn1<2){
                                game_field[turn1*6+turn2*2]="\u001B[34m"+"X̲"+"\u001B[0m";                //"\u001B[0m" - reset    "\u001B[31m" - red   "\u001B[34m" - blue
                            } else {
                                game_field[turn1*6+turn2*2]="\u001B[34m"+"X"+"\u001B[0m";
                            }
                            counter++;
                        }else {
                            System.out.println("Choose an empty spot.");
                        }
                    }else{
                        int[] turns=bot_turn(field, counter);
                        turn1=turns[0];
                        turn2=turns[1];
                        if (field[turn1][turn2]==-1)
                            field[turn1][turn2]=0;
                        if (turn1==2){
                            game_field[turn1*6+turn2*2]="\u001B[31m"+"O"+"\u001B[0m";
                        } else {
                            game_field[turn1*6+turn2*2]="\u001B[31m"+"O̲"+"\u001B[0m";
                        }
                        counter++;
                    }
                    System.out.println(String.join("", game_field));
                }
            } else if (team.equals("o")){
                while (counter<9 && !winning_scen(field)){
                    if (counter%2==1){
                        System.out.print("Where do you want to put your mark?\n> ");
                        turn1=input.nextInt()-1;
                        System.out.print("> ");
                        turn2=input.nextInt()-1;
                        if (turn1>2 || turn1<0 || turn2>2 || turn2<0){
                            System.out.println("Retry, your numbers aint working");
                            continue;
                        }
                        if (field[turn1][turn2]==-1){
                            field[turn1][turn2]=1;
                            if (turn1<2){
                                game_field[turn1*6+turn2*2]="\u001B[34m"+"O̲"+"\u001B[0m";                //"\u001B[0m" - reset    "\u001B[31m" - red   "\u001B[34m" - blue
                            } else {
                                game_field[turn1*6+turn2*2]="\u001B[34m"+"O"+"\u001B[0m";
                            }
                            counter++;
                        }else {
                            System.out.println("Choose an empty spot.");
                        }
                    }else{
                        int[] turns=bot_turn(field, counter);
                        turn1=turns[0];
                        turn2=turns[1];
                        if (field[turn1][turn2]==-1)
                            field[turn1][turn2]=0;
                        if (turn1==2){
                            game_field[turn1*6+turn2*2]="\u001B[31m"+"X"+"\u001B[0m";
                        } else {
                            game_field[turn1*6+turn2*2]="\u001B[31m"+"X̲"+"\u001B[0m";
                        }
                        counter++;
                    }
                    System.out.println(String.join("", game_field));
                }
            }
        }
        if (num==2 && counter%2==1 && winning_scen(field)){
            System.out.println("\'X\' won, congrats");
        } else if(num==2 && counter%2==0 && winning_scen(field)){
            System.out.println("\'O\' won, congrats");
        } else if (counter==9 && !winning_scen(field)){
            System.out.println("Tie is the most common ending of the tick tack game");
        }else if (num==1 && ((team=="x" && counter%2==1) || (team=="o" && counter%2==0)) && winning_scen(field)){
            System.out.println("You won!");
        }else if (num==1 && ((team=="o" && counter%2==1) || (team=="x" && counter%2==0)) && winning_scen(field)){
            System.out.println("Well, you tried.");
        }
        again();
        
    }
    static boolean winning_scen(int[][] matrix) {
        boolean away=false;
        for (int i=0;i<=2;i++){
            if ((matrix[i][0]==1 && matrix[i][1]==1 && matrix[i][2]==1) || (matrix[i][0]==0 && matrix[i][1]==0 && matrix[i][2]==0))
                away = true;
            else if ((matrix[0][i]==1 && matrix[1][i]==1 && matrix[2][i]==1) || (matrix[0][i]==0 && matrix[1][i]==0 && matrix[2][i]==0))
                away = true;
            else if ((matrix[0][0]==1 && matrix[1][1]==1 && matrix[2][2]==1) || (matrix[0][2]==1 && matrix[1][1]==1 && matrix[2][0]==1) || (matrix[0][0]==0 && matrix[1][1]==0 && matrix[2][2]==0) || (matrix[0][2]==0 && matrix[1][1]==0 && matrix[2][0]==0))
                away = true;
        }
        return away;
    }
    static int[] bot_turn(int[][]field,int counter){
        int turn1=-1;int turn2=-1;
        Random rand=new Random();
        for (int i=0; i<3;i++) {
            if (field[i][0]==field[i][1] && field[i][0]!=-1 && field[i][2]==-1){
                turn1=i;
                turn2=2;
                counter++;
                break;
            } else if (field[i][1]==field[i][2] && field[i][1]!=-1 && field[i][0]==-1){
                turn1=i;
                turn2=0;
                counter++;
                break;
            } else if (field[i][0]==field[i][2] && field[i][0]!=-1 && field[i][1]==-1){
                turn1=i;
                turn2=1;
                counter++;
                break;
            } else if (field[0][i]==field[1][i] && field[0][i]!=-1 && field[2][i]==-1){
                turn1=2;
                turn2=i;
                counter++;
                break;
            } else if (field[0][i]==field[2][i] && field[0][i]!=-1 && field[1][i]==-1){
                turn1=1;
                turn2=i;
                counter++;
                break;
            } else if (field[2][i]==field[1][i] && field[2][i]!=-1 && field[0][i]==-1){
                turn1=0;
                turn2=i;
                counter++;
                break;
            } else if (field[0][0]==field[1][1] && field[0][0]!=-1 && field[2][2]==-1){
                turn1=2;
                turn2=2;
                counter++;
                break;
            } else if (field[0][0]==field[2][2] && field[0][0]!=-1 && field[1][1]==-1){
                turn1=1;
                turn2=1;
                counter++;
                break;
            } else if (field[1][1]==field[2][2] && field[1][1]!=-1 && field[0][0]==-1){
                turn1=0;
                turn2=0;
                counter++;
                break;
            } else if (field[0][2]==field[1][1] && field[0][2]!=-1 && field[2][0]==-1){
                turn1=2;
                turn2=0;
                counter++;
                break;
            } else if (field[0][2]==field[2][0] && field[0][2]!=-1 && field[1][1]==-1){
                turn1=1;
                turn2=1;
                counter++;
                break;
            } else if (field[2][0]==field[1][1] && field[1][1]!=-1 && field[0][2]==-1){
                turn1=1;
                turn2=1;
                counter++;
                break;
            }
        }
        if (turn1==-1 || turn2==-1){
            turn1=rand.nextInt(2);
            turn2=rand.nextInt(2);
            while (field[turn1][turn2]!=-1){
                turn1=rand.nextInt(2);
                turn2=rand.nextInt(2);
            }
        }
        int[] for_return={turn1, turn2};
        return for_return;
    }
    static void again(){
        System.out.print("\nWant to play again?(yes/no)\n> ");
        input.nextLine();
        String ans=input.nextLine().toLowerCase();
        if (ans.equals("yes") || ans.equals("y")){
            main(null);
        }else{
            System.out.println("Thanks for playing");
        }
    }       
}
