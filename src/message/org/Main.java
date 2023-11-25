package message.org;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private  static ArrayList<Contact> contacts;
    private  static Scanner scanner;
    private  static  int id=0;
    public static void main(String[] args) {
        contacts=new ArrayList<>();
        System.out.println("Welcome to a contact app");
        showInitialOptions();

    }
    private static  void showInitialOptions(){
        System.out.println("""
                        Please select one:\s
                        \t1. Manage contacts
                        \t2. Messages
                        \t3. Quit"""
                );
        scanner=new Scanner(System.in);
        int choice=scanner.nextInt();
        switch (choice){
            case 1:
               manageContact();
                break;
            case 2:
               manageMessages();
                break;
            case 3:
                System.out.println("Quiting");
                break;
            default:
                showInitialOptions();
                break;

        }
    }

    private static void manageMessages() {
        System.out.println("""
                Please Select one
                \t1. Show all messages
                \t2. Send a new message
                \t3. Go back""");
        int choice=scanner.nextInt();
        switch (choice){
            case 1:
                showAllMessages();
                break;
            case 2:
                sendMessage();
                break;
            default:
                showInitialOptions();
                break;
        }
        
    }

    private static void sendMessage() {
        System.out.println("Who do you want to send the message to? ");
        String name =scanner.next();
        if(name.isEmpty()){
            sendMessage();
        }else {
            boolean exists=  false;
            for (Contact contact: contacts){
                if (contact.getName().equals(name)) {
                    exists = true;
                    break;
                }
            }
            if (exists){
                System.out.println("Type your message");
                String message=scanner.next();
                if (message.isEmpty()){
                    System.out.println(" please Enter your message");
                    sendMessage();
                }else {
                    id++;
                    Message newMessage= new Message(message, name, id);
                    for (Contact contact:  contacts){
                        if (contact.getName().equals(name)){
                            ArrayList<Message> messageNew= contact.getMessages();
                            messageNew.add(newMessage);
                            contact.setMessages(messageNew);
                        }
                    }

                }

            }
        }
        showInitialOptions();

    }

    private static void showAllMessages() {
        ArrayList<Message> allMessages= new ArrayList<>();
        for(Contact contact: contacts){
            allMessages.addAll(contact.getMessages());
        }
        if(!allMessages.isEmpty()){
            for (Message message: allMessages){
                message.messageDetails();
                System.out.println("***************");
            }
        }else {
            System.out.println(" You do not have any messages");
        }
        showInitialOptions();
        
    }

    //this contains manage contacts and methods related to managing contacts
    private static void  manageContact(){

        System.out.println(
                """
                        Please select one:\s
                        \t1. Show all contacts
                        \t2. Add a new contact\s
                        \t3. Search for a contact
                        \t4. Delete a contact
                        \t5. Go back"""
        );
        int choice=scanner.nextInt();
        switch (choice){
            case 1:
                showAllContacts();
                break;
            case 2:
                addNewContacts();
                break;
            case 3:
                searchContact();
                break;
            case 4:
                deleteContact();
                break;
            default:
                showInitialOptions();
                break;
        }

    }

    private static void deleteContact() {
        System.out.println(" Please enter the contact's name");
        String name= scanner.next();
        if (name.isEmpty()){
            deleteContact();
        }else {
            boolean exists=false;
            for (Contact contact: contacts){
                if (contact.getName().equals(name)){
                    exists=true;
                    contacts.remove(contact);
                }
            }
            if (!exists){
                System.out.println("No search contact...");
            }
        }
        showInitialOptions();
    }

    private static void searchContact() {
        System.out.println(" Please enter the contact's name");
        String name= scanner.next();
        if (name.isEmpty()){
            searchContact();
        }else {
            boolean exists=false;
            for (Contact contact: contacts){
                if (contact.getName().equals(name)){
                    exists=true;
                    contact.getContactDetails();
                }
            }
            if (!exists){
                System.out.println(" No contact by that name");
            }
        }
        showInitialOptions();
    }

    private static void addNewContacts() {
        System.out.println("Adding a new contact..." +
                "\n\tPlease enter the contact's name: ");
        String name=scanner.next();
        System.out.println("Please enter the contacts number: ");
        String number=scanner.next();
        System.out.println("Please enter the contacts Email: ");
        String email=scanner.next();

        if (name.isEmpty() || number.isEmpty() || email.isEmpty()){
            System.out.println("please enter all of the required information");
            addNewContacts();
        }else {
            boolean exists=false;
            for (Contact contact: contacts){
                if (contact.getName().equals(name)) {
                    exists = true;

                    break;
                }
            }
            if(exists){
                System.out.println(" contact already exists");
            }else {
                Contact newContact= new Contact(name, number, email);
                contacts.add(newContact);
                System.out.println("name added successfully");
            }


        }
        showInitialOptions();
    }

    private static void showAllContacts() {
        for (Contact contact:contacts ){
            contact.getContactDetails();
            System.out.println("****************************");
        }
        showInitialOptions();
    }

}