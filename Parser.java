public class Parser {//this parser is used by all nodes and the logicTree

    public Node parse(String toParse){
        if(toParse.length()==0){//check to see if string is empty
            throw new Error("Empty String handed, was () present?");
        }else if(toParse.startsWith("~")){//checks to see if it is a not node
            return new Not(toParse.substring(1));
        }else if(toParse.startsWith("(")){//otherwise checks if it is an atomic on the left or a parenthesis item
            int parenEnd = countParen(toParse);//finds the end of the parenthesis
            if (parenEnd == toParse.length()-1) {//checks to see if it was just passed a parenthesis and then strips them
                return parse(toParse.substring(1, parenEnd));
            }else{
                switch(toParse.charAt(parenEnd+1)){//sees what the largest logical is, if not the largest then the left most
                    case '&':   return new And(toParse.substring(1,parenEnd),toParse.substring(parenEnd+2));
                    case '|':   return new Or(toParse.substring(1,parenEnd),toParse.substring(parenEnd+2));
                    case '<':   return new If(toParse.substring(1,parenEnd),toParse.substring(parenEnd+2));
                    case '>':   return new Then(toParse.substring(1,parenEnd),toParse.substring(parenEnd+2));
                    case '+':   return new Xor(toParse.substring(1,parenEnd),toParse.substring(parenEnd+2));
                    case '=':   return new Iff(toParse.substring(1,parenEnd),toParse.substring(parenEnd+2));
                    default:    throw new Error("Error Bad Logical Exception");//if something like "abc" is entered, instead of just breaking an error is thrown which should be caught
                }
            }
        }else if(toParse.length()==1){//if it doesnt start with a (, check to see if it's an atomic sentence
            return new Atomic(toParse);//atomics should be the only time that a single charachter is passed
        }else {
            switch(toParse.charAt(1)){//assuming that the first sentence was an atomic and not a paren, check to see the opperator
                case '&':   return new And(toParse.substring(0,1),toParse.substring(2));
                case '|':   return new Or(toParse.substring(0,1),toParse.substring(2));
                case '<':   return new If(toParse.substring(0,1),toParse.substring(2));
                case '>':   return new Then(toParse.substring(0,1),toParse.substring(2));
                case '+':   return new Xor(toParse.substring(0,1),toParse.substring(2));
                case '=':   return new Iff(toParse.substring(0,1),toParse.substring(2));
                default:    throw new Error("Error Bad Logical Exception");
            }
        }
    }

    private int countParen(String toParse){//a little method to see how long a parenthesis chain is and return the overarching parenthesis end point, ie (()) would return 3
        int parenCount = 0;
        int endLocation = 0;
        do{
            if (toParse.charAt(endLocation) == ')'){//every time an end parenthesis occurs, decriment
                parenCount--;
            }else if (toParse.charAt(endLocation) == '('){//every time an open parenthesis occurs, incriment
                parenCount++;
            }
            if(parenCount != 0)//if the count is non zero, incriment the pointer
                endLocation++;
        }while(parenCount > 0);
        return endLocation;//return the pointer of the last end paren
    }
}
