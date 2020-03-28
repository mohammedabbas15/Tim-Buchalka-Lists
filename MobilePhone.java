import java.util.ArrayList;

public class MobilePhone
{
    private String myNumber;
    private ArrayList<Contact> contacts;

    // usually when you use a ArrayList you want to initialize it in the constructor
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.contacts = new ArrayList<Contact>();
    }

    public void printContact()
    {
        System.out.println("you have " + contacts.size() + " number of contacts");
        for (int i = 0; i < this.contacts.size(); i++)
        {
            System.out.println((i+1) + "." + this.contacts.get(i).getName() + " + " + this.contacts.get(i).getPhoneNumber());
        }
    }

    public boolean addNewContact(Contact contact)
    {
        if(findContact(contact.getName()) >= 0)
        {
            System.out.println("that contact is already in the system");
            return false;
        }
        contacts.add(contact);
        return true;
    }

    private int findContact(Contact contact)
    {
        return this.contacts.indexOf(contact);
    }

    private int findContact(String contactName)
    {
        for (int i = 0; i < this.contacts.size(); i++)
        {
            Contact contact = this.contacts.get(i);
            if (contact.getName().equals(contactName))
            {
                return i;
            }
        }
        return -1;
    }

    public boolean updateContact(Contact oldContact, Contact newContact)
    {
        int foundPosition = findContact(oldContact);
        // meaning if findContact returned a -1
        if(foundPosition < 0)
        {
            System.out.println( oldContact.getName() + " was not found");
            return false;
        }
        contacts.set(foundPosition, newContact);
        System.out.println("contact was updated with new contact");
        return true;
    }

    public String queryContact(Contact contact)
    {
        if (findContact(contact) >= 0)
        {
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact(String name)
    {
        int position = findContact(name);
        if(position >= 0)
        {
            return this.contacts.get(position);
        }
        return null;
    }

    public boolean removeContact(Contact contact)
    {
        int foundPosition = findContact(contact);
        // meaning if findContact returned a -1
        if(foundPosition < 0)
        {
            System.out.println(contact.getName() + " was not found");
            return false;
        }
        this.contacts.remove(foundPosition);
        System.out.println(contact.getName() + " was removed");
        return true;
    }
}
