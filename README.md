[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/SMGOspQD)
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=19480448)
## AP Computer Science A
### 2D Array Game - Final Project

Pretty simple, come up with a game project that shows me an implementation of 2D arrays. In the past, students have worked on versions of Wordle, Tic Tac Toe, Battleship, and Connect Four, but you can choose to work on anything that involves a 2D Array (Chutes and Ladders? Monopoly? Chess/Checkers?). Since we have done nothing with graphics, remember that everything will need to be text-based, so please make sure to include clear instructions on how your program will work!

## A couple of examples:

### Connect Four
- Figure out dimensions of “board”
- Determine the details of piece placement
    - columns?
    - closest to bottom?
- Algorithm to determine four in a row

### Battleship
- Figure out dimensions of “board”
- Determine system for placing boats
- Determine how to take in coordinates
- Determine how to show hit/miss
- How will game end?

## Some extra code stuff…

### CLEAR THE CONSOLE  
Let’s say you’re creating something and don’t want to print gameboard after gameboard after gameboard… you can wipe the console screen in between turns, which will act as if it’s a single gameboard that’s being updated turn by turn. How do you do it?
```
System.out.print("\033[H\033[2J");  
System.out.flush();
```
### COLORS!
Colors are fun! Or maybe you actually need it for functionality (Wordle / Connect Four)? Here are a few specific examples of code you can use to implement color (the following are for Wordle, but you can use the link above to help with whatever you need):
```
//clears all formatting (black text, normal background)  
public static final String ANSI_RESET = "\u001B[30m\u001B[0m";
```
```
//BLACK text, GREEN background  
public static final String ANSI_GREEN = "\u001B[30m\u001B[42m";
```
```
//BLACK text, YELLOW background  
public static final String ANSI_YELLOW = "\u001B[30m\u001B[43m";
```
If you look at the Strings, they’re led by a \ which means these are really just crazy looking escape characters. We can CONCATENATE these String “variables” to displayed text that will allow you to change the color within print statements.

### Example:  
`System.out.print(ANSI_GREEN + “Hey!” + ANSI_RESET);` prints a green “Hey!”  
Note, it’s important to have the ANSI_RESET… if you don’t reset after the desired text, future text will stay in whatever color you called (even though you may not want it).

## Some final notes (more to be added later?):
- You are required to add multiple Class files to this repository. An easy way to organize this would be to have one Class for the gameboard, game functions, etc. and then a separate Class (main) to actually run the game.
- To COMPILE your runner file, use `javac main.java` in the terminal (NOTE: You will need to recompile after every change!)
- To RUN your compiled code, use `java main` in the terminal
- To COMMIT your changes to the repository, use `git commit -a -m '<your comment about the commit here>'` in the terminal
- To PUSH your changes to me, use `git push` in the terminal
