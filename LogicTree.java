///////////////////////////////////////////////////////
//CSE 205: Class #: 17566 / Miller: M W 4:35-5:50    //
//Assignment: #06									 //
//Author(s): Trevor Kann - ID:1210780334			 //
//Description: Logic Tree Holder			         //
///////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.Hashtable;


public class LogicTree {//i chose the logic tree to be a different class than the head node because it needs to create a truth table and i wanted the nodes to be as simple as possible, so i left the complex stuff to the tree
    private Hashtable<String, Boolean> tValues = new Hashtable<String, Boolean>();//the hastable just acts as a dictionary to make it easy to parse Tvalues for the atomics
    private String header;
    private String separator = ": ";
    private static Parser parser = new Parser();
    private ArrayList<String> atomics = new ArrayList<String>();
    private Node head = null;//the head is just the biggest logical opperator, could be a not or an attomic or something else

    public LogicTree(String toParse){//starts a new logic tree and parses the head node
        header = toParse;
        getAtomics(toParse);//checks for all atomics in the string before parsing it
        this.head = parser.parse(toParse);//parsing the head node then recursively parses every other sequence to a node in the declaration of each node and therefore recursively defines the tree
    }

    public void evaluate(){//creates a truth table and evaluates the tree for each permutation
        printHeader();
        for(int i = 0; i < ((int) Math.pow(2,atomics.size())); i++){//there are 2^n tvalue permutations
            for(int j = 0; j < atomics.size(); j++){//go through all atomics
                if(((int) Math.pow(2,j) & i) == ((int) Math.pow(2,j)) ){//this was a fast way i created to permute Tvalues that relies of the bitwise and opperator
                    tValues.put(atomics.get(j),true);
                    System.out.print("1 ");
                } else {
                    tValues.put(atomics.get(j),false);
                    System.out.print("0 ");
                }
            }
            System.out.print(separator);
            if(head.evaluate(tValues))//the evaluate method runs recursively throughout the nodes with a base case of an atomic to get the T value of the current tf permutation
                System.out.println("1");
            else
                System.out.println("0");
        }
    }

    private void getAtomics(String toParse){//parses the initial string to obtain all the atomic sentence letters and adds them to an array list
        for(int i = 0; i < toParse.length(); i++){
            if (isAtomic(toParse.charAt(i))){
                if (atomics.contains(""+toParse.charAt(i)) == false){
                    atomics.add(""+ toParse.charAt(i));
                }
            }
        }
    }

    private Boolean isAtomic(char check){//basically a dictionary of forbidden characters, since it's a switch new opperators can be easily added
        switch(check) {
            case '~':   return false;
            case '&':   return false;
            case '|':   return false;
            case '<':   return false;
            case '>':   return false;
            case '(':   return false;
            case ')':   return false;
            case '+':   return false;
            case '=':   return false;
            default:    return true;
        }
    }

    private void printHeader(){//just makes the top readable and look nice
        for(int i = 0; i < atomics.size(); i++){
            System.out.print(atomics.get(i)+" ");
        }
        System.out.println(separator+header);
        int under = 2 * atomics.size() + separator.length() + header.length();//+2*atomics size is because each is followed by a space and the rest is to accomodate the length of the reast of the header
        for(int i = 0; i < under; i++)//this just underlines the header so it looks nice
            System.out.print("-");
        System.out.println();
    }

    @Override
    public String toString(){//just prints the inputted value if someone needs it later
        return header;
    }
}
