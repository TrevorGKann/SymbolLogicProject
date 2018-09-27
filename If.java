///////////////////////////////////////////////////////
//CSE 205: Class #: 17566 / Miller: M W 4:35-5:50    //
//Assignment: #06									 //
//Author(s): Trevor Kann - ID:1210780334			 //
//Description: If node module   			         //
///////////////////////////////////////////////////////

import java.util.Hashtable;

public class If extends Node{
    private Node subNode1 = null, subNode2 = null;

    private static Parser parser = new Parser();
    public If(String toParse1, String toParse2){//makes a new if node
        subNode1 = parser.parse(toParse1);
        subNode2 = parser.parse(toParse2);
    }

    @Override
    public Boolean evaluate(Hashtable<String, Boolean> tValues) {//either the left statement is true or the right one is false for if to be correct, recursively checks
        return (subNode1.evaluate(tValues) || !(subNode2.evaluate(tValues)));
    }

    @Override
    public Boolean isAtomic() {
        return false;
    }
}
