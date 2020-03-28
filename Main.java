import java.util.Scanner;

public class Main
{
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("123 456 7890");

    public static void main (String [] args)
    {
        boolean quit = false;
        startPhone();
        printActions();
        while(!quit)
        {
            System.out.println("\nenter action");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action)
            {
                case 0:
                    System.out.println("shutting down now...goodbye");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContact();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }

        }
    }

    private static void addNewContact()
    {
        System.out.println("enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("enter new phone number: ");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if(mobilePhone.addNewContact(newContact))
        {
            System.out.println("new contact added");
        }
    }

    private static void updateContact()
    {
        System.out.println("enter existing contact name");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null)
        {
            System.out.println("contact not found");
            return;
        }
        System.out.println("enter new contact name");
        String newName = scanner.nextLine();
        System.out.println("enter new contact phone number");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName,newNumber);
        if (mobilePhone.updateContact(existingContactRecord, newContact))
        {
            System.out.println("contacts updated successfully");
        }
    }

    private static void removeContact() {
        System.out.println("enter existing contact name");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("contact not found");
            return;
        }
        if(mobilePhone.removeContact(existingContactRecord))
        {
            System.out.println("removed contact successfully");
        }
    }

    private static void queryContact() {
        System.out.println("enter existing contact name");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("contact not found");
            return;
        }
        System.out.println("name " + existingContactRecord.getName() + " phone number " + existingContactRecord.getPhoneNumber());
    }

    private static void startPhone()
    {
        System.out.println("starting phone...");
    }

    private static void printActions()
    {
        System.out.println("Available actions...");
        System.out.println("0 - to shut down");
        System.out.println("1 - to print contacts");
        System.out.println("2 - to add a new contact");
        System.out.println("3 - to update an existing contact");
        System.out.println("4 - to remove an existing contact");
        System.out.println("5 - to query an existing contact");
        System.out.println("6 - to print available actions");
    }
}
