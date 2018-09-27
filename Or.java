///////////////////////////////////////////////////////
//CSE 205: Class #: 17566 / Miller: M W 4:35-5:50    //
//Assignment: #06									 //
//Author(s): Trevor Kann - ID:1210780334			 //
//Description: or node          			         //
///////////////////////////////////////////////////////
import java.util.Hashtable;

public class Or extends Node{
    private Node subNode1 = null, subNode2 = null;
    private static Parser parser = new Parser();
    public Or(String toParse1, String toParse2){//makes a new or node
        subNode1 = parser.parse(toParse1);
        subNode2 = parser.parse(toParse2);
    }

    @Override
    public Boolean evaluate(Hashtable<String, Boolean> tValues) {//returns true if either sub node is correct, like the others asks its sub nodes to recursively check
        return (subNode1.evaluate(tValues) || subNode2.evaluate(tValues));
    }

    @Override
    public Boolean isAtomic() {
        return false;
    }
}
