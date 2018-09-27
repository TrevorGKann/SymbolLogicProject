///////////////////////////////////////////////////////
//CSE 205: Class #: 17566 / Miller: M W 4:35-5:50    //
//Assignment: #06									 //
//Author(s): Trevor Kann - ID:1210780334			 //
//Description: Then node module			             //
///////////////////////////////////////////////////////

import java.util.Hashtable;

public class Then extends Node{
    private Node subNode1 = null, subNode2 = null;

    private static Parser parser = new Parser();
    public Then(String toParse1, String toParse2){//makes a new then node
        subNode1 = parser.parse(toParse1);
        subNode2 = parser.parse(toParse2);
    }

    @Override
    public Boolean evaluate(Hashtable<String, Boolean> tValues) {//returns true if either the first is false or the second is true, checks the subnodes recursively
        return (!(subNode1.evaluate(tValues)) || subNode2.evaluate(tValues));
    }

    @Override
    public Boolean isAtomic() {
        return false;
    }
}
