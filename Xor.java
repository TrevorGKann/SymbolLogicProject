///////////////////////////////////////////////////////
//CSE 205: Class #: 17566 / Miller: M W 4:35-5:50    //
//Assignment: #06									 //
//Author(s): Trevor Kann - ID:1210780334			 //
//Description: XOR node module  			         //
///////////////////////////////////////////////////////

import java.util.Hashtable;

public class Xor extends Node {
    private Node subNode1 = null, subNode2 = null;

    private static Parser parser = new Parser();
    public Xor(String toParse1, String toParse2){//makes a new XOR node and parses subnodes
        subNode1 = parser.parse(toParse1);
        subNode2 = parser.parse(toParse2);
    }
    @Override
    public Boolean evaluate(Hashtable<String, Boolean> tValues) {//returns true if only one is true, checks sub nodes recursively
        return ( (subNode1.evaluate(tValues)&!subNode2.evaluate(tValues)) || (!subNode1.evaluate(tValues)&subNode2.evaluate(tValues)) );
    }

    @Override
    public Boolean isAtomic() {
        return false;
    }
}
