///////////////////////////////////////////////////////
//CSE 205: Class #: 17566 / Miller: M W 4:35-5:50    //
//Assignment: #06									 //
//Author(s): Trevor Kann - ID:1210780334			 //
//Description: Atomic node module			         //
///////////////////////////////////////////////////////

import java.util.Hashtable;

public class Atomic extends Node{
    private String atomic = null;
    public Atomic(String toParse){//makes a new atomic node
        this.atomic=toParse;
    }
    @Override
    public Boolean evaluate(Hashtable<String, Boolean> tValues) { // checks to see if the atomic is true in this instance
        return tValues.get(atomic);
    }

    @Override
    public Boolean isAtomic() {
        return true;
    }
}
