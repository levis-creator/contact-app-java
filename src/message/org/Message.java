package message.org;

public class Message {
    private String text;
    private String recipient;
    private int id;

    public Message(String text, String recipient, int id) {
        this.text = text;
        this.recipient = recipient;
        this.id = id;
    }

    public void  messageDetails(){
        System.out.println("Contact name: "+recipient+"\nmessage: "+text+"\nid: "+id);

    }
}
