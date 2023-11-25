package message.org;

import java.util.ArrayList;

public class Contact {
    private  String name;
    private  String number;
    private  String email;
    private ArrayList<Message> messages;

    public Contact(String name, String number, String email, ArrayList<Message> messages) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.messages = messages;
    }

    public Contact(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.messages=new ArrayList<>();
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public void  getContactDetails(){
        System.out.println("Name: "+this.name+"\nNumber: "+this.number+"\nEmail: "+this.email);
    }
}
