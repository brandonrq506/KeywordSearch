package Conversations;

public class Message {
    
    private String text;
    private int sender;
    private boolean passedFilter;

    public Message(String text){
        this.text = text;
    }
    public Message(String text, int sender){
        this.text = text;
        this.sender = sender;
    }
    
    public String getText(){
        return this.text;
    }
    
    public int getSender(){
        return this.sender;
    }

    public void setPassedFilter(){
        this.passedFilter = true;
    }
    
    public boolean hasPassedFilter(){
        return this.passedFilter;
    }
}
