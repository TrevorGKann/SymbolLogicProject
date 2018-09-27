///////////////////////////////////////////////////////
//CSE 205: Class #: 17566 / Miller: M W 4:35-5:50    //
//Assignment: #06									 //
//Author(s): Trevor Kann - ID:1210780334			 //
//Description: not node			                      //
///////////////////////////////////////////////////////

import java.util.Hashtable;

public class Not extends Node{
    private Node subNode = null;
    private static Parser parser = new Parser();
    public Not(String toParse){//makes a new not node and defines it's sub nodes
        this.subNode = parser.parse(toParse);
    }

    @Override
    public Boolean evaluate(Hashtable<String, Boolean> tValues) {//simply negates its one subnode, is also a recursive check at its sub node
        return !( subNode.evaluate(tValues) );
    }

    @Override
    public Boolean isAtomic() {
        return false;
    }

}
