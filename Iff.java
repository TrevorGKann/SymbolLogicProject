///////////////////////////////////////////////////////
//CSE 205: Class #: 17566 / Miller: M W 4:35-5:50    //
//Assignment: #06									 //
//Author(s): Trevor Kann - ID:1210780334			 //
//Description: Iff node module  			         //
///////////////////////////////////////////////////////

import java.util.Hashtable;

public class Iff extends Node {
    private Node subNode1 = null, subNode2 = null;

    private static Parser parser = new Parser();
    public Iff(String toParse1, String toParse2){//makes a new iff node
        subNode1 = parser.parse(toParse1);
        subNode2 = parser.parse(toParse2);
    }
    @Override
    public Boolean evaluate(Hashtable<String, Boolean> tValues) {//returns true if either both are true or both are false, recursively checks
        return ( (subNode1.evaluate(tValues) & subNode2.evaluate(tValues)) || (!subNode1.evaluate(tValues) & !subNode2.evaluate(tValues)) );
    }

    @Override
    public Boolean isAtomic() {
        return false;
    }
}
