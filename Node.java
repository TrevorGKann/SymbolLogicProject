///////////////////////////////////////////////////////
//CSE 205: Class #: 17566 / Miller: M W 4:35-5:50    //
//Assignment: #06									 //
//Author(s): Trevor Kann - ID:1210780334			 //
//Description: abstract node class that everything inherits from
///////////////////////////////////////////////////////

import java.util.Hashtable;

public abstract class Node{//made simple because the atomics and not break the mold a lot

    public abstract Boolean evaluate(Hashtable<String, Boolean> tValues);

    public abstract Boolean isAtomic();//thought this would be usefull but i ended up not using it, i have ideas for more extensive trees that i want to make later so i didn't take it out

}
