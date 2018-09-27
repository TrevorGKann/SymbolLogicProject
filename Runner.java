///////////////////////////////////////////////////////
//CSE 205: Class #: 17566 / Miller: M W 4:35-5:50    //
//Assignment: #06									 //
//Author(s): Trevor Kann - ID:1210780334			 //
//Description: a demonstratice main method to impliment the tree
///////////////////////////////////////////////////////
import java.util.Scanner;

public class Runner {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String input = null;
        Boolean running = true;
        instructions();
        LogicTree tree = null;
        while (running) {
            System.out.print(">");
            input = in.nextLine();
            switch (input) {//takes a string input and parses it to either exit, help, or make a logical tree.
                case "?":
                    help();
                    break;
                case "exit":
                    running = false;
                    break;
                case "!":
                    examples();
                    break;
                case "":
                    System.out.println("Please input a non-empty string");
                default:
                    try {
                        tree = new LogicTree(input);
                        tree.evaluate();
                    } catch (StringIndexOutOfBoundsException e) {//catches a few possible exceptions
                        System.out.println("Error: StringIndexOutOfBoundsException\nparenthesis mismatch/empty?");
                    } catch (Error e) {
                        System.out.println("Error: Bad Logical Expression");
                        System.out.println("Check your connectives and parenthesis?");
                    }
                    break;
            }

        }
    }

    static void instructions() {//a start menu
        System.out.println("Java Truth Table Parser:");
        System.out.println("please enter a logical expression below for a Truth Table.");
        System.out.println("enter a ? for help, ! for examples, or \"exit\" to exit");
    }

    static void examples(){//gives a few examples if the user is unfamiliar with logical expressions
        System.out.println("try these for a few well formed sentences:\n" +
            "a\n" +
            "a&b\n" +
            "a&(b|c)\n" +
            "(~a)|(b>c)\n" +
            "((a>b)&(~c))=(a>B)");
    }

    static void help() {//a help menu
        System.out.println("You will enter a logical expression using atomic sentence letters and logical connectives.");
        System.out.println("All logical operators are a two operand operator except for the not(~) operator.");
        System.out.println("Sentences should be formed with operators between sentence letters to signify that \nthe operand is acting on both sides of the operator.");
        System.out.println("");
        System.out.println("Logical connectives are the following: ");
        System.out.println("~ : is the not operator and negates whatever follows it. It is the only single\n" +
                "    input operator");
        System.out.println("& : is the and operator and will only be true when both of the operands are true.");
        System.out.println("| : is the or operator and is true when either operand is true.");
        System.out.println("> : is the then operator and is only false when the first operand is true and the\n" +
                "    second false.");
        System.out.println("< : is the if operator and is a backwards then.");
        System.out.println("= : is the if and only if operator and is only true if the truth values of both\n" +
                "    operands have the same truth value.");
        System.out.println("+ : is the exclusive or operator and is true if the truth values of the operands\n" +
                "    are not the same.");
        System.out.println("a : A setence letter is anything that is not an operator, upper and lower case letters\n" +
                           "are considered different letters. A sentence letter is a True or false variable that\n" +
                           "represents some sort of true or false condition, ie \"it is raining outside\" or \n" +
                           "\"the defendant is guilty\".");
        System.out.println("Ideally logic can be used to express true or false statements and see when/where they're true,\n" +
                           "for example \"I will only attend the party if Suzy or Marry go, but not both\", we could \n" +
                           "express this with S for if suzy goes and M for if marry goes, to yield \"S+M\", or S exclusive-or M.");
        System.out.println("");
        System.out.println("A few examples of well formed sentences: \"a\", \"a&(c|d)\", \"(a>(B+c))|(A&B)\".");
        System.out.println("");
        System.out.println("The sentence parser will read from left to right and treat the left most side of an \noperator as one operand and the right as the other operand.");
        System.out.println("i.e. a&b|c+d will be interpreted as a&(b|(c+d))); so for best results,");
        System.out.println("use parenthesis to make sure the sentence is parsed as desired.");
        System.out.println("Improperly formed logical expressions could cause the program to crash and will result");
        System.out.println("in a bad logical expression error. Additionally the use of \"()\" will cause the\n" +
                "program to crash, try to make sure that all parenthesis are filled in");
    }
}
