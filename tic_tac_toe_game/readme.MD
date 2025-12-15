This is designed to help me get back into the swing of Java

The premise of this is to get me back into the *swing* of things, haha. 

So, I will be designing a front-end in swing and the backend in regular java,
with maybe some JUnit if I am feeling spunky.

First things first, we learn how to write and compile Java again.

Compilation has two steps, first compile the initial program and then run that program. This happens like this:

1. javac program_name.java
2. java program_name

the program will compile and then the class that was used will then become a program_name.class, which we then run using java program_name

Now, let's continue reading and see how we can acutally develop the tic tac toe app

I think we should start on the front-end, which will involve event listeners and the such, I dont think much backend will be necessary, or if any at all
    - if anything, we will have to have the game start in X and then continue in O, so if even, the placement is an O and if odd, the placement is X



Designing the game tiles:
    - I want it to look something like this:

     |              |
_____|______________|__________
     |              |
     |              |
_____|______________|__________
     |              |
     |              |

Again, if we start, we are O and after that, we are X, which should mean that the logic should appear something like this:

    start = 0;

    if (start % 2 == 0) {
        place O;
        start++;
    } else {
        place X;
        start++;
    }

    
    return "Player %d turn" //where %d is the player number 

Designing the Grid:
    - Need to be buttons that are dynamic based on the start of the game
How do we make a grid with buttons as the tiles?

honestly, calling the program confuses me, as you don't call the .java file, but instead you call the .class file? I don't really understand it 

Grid is done, now we need to get into the design of the game and attaching those said aspects to one another, which I don't know how to do



Switched to creating a Maven environment:
    1. Always compile with mvn compile
        this is done so that maven can deal with it, not so much running a terminal command for javac and then java
