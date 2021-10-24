package Sorting;

import Conversations.Conversation;
import java.util.Comparator;

/**
 * Sorts all the filtered Messages/Conversation by disposition.
 */
public class ByDisposition implements Comparator<Conversation>{

    @Override
    public int compare(Conversation o1, Conversation o2) {
        return o1.getDisposition().compareTo(o2.getDisposition());
    }
}
