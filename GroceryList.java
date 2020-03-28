import java.util.ArrayList;

public class GroceryList
{
    // creating our first array list in java
    private ArrayList<String> groceryList = new ArrayList<String>();

    public void addGroceryItem(String item)
    {
        groceryList.add(item);
    }

    public void printList()
    {
        System.out.println("you have " + groceryList.size() + " number of items");
        for (int i = 0; i < groceryList.size(); i++)
        {
            System.out.println(groceryList.get(i));
        }
    }

    public void modifyGroceryItem(String newItem)
    {
        int position = findItem(newItem);
        if (position >= 0)
        {
            modifyGroceryItem(position, newItem);
        }
    }

    public void modifyGroceryItem(int position, String newItem)
    {
        groceryList.set(position, newItem);
        System.out.println("grocery item has been updated");
    }

    public void removeGroceryItem(int position)
    {
        String theItem = groceryList.get(position);
        groceryList.remove(position);

    }

    public int findItem(String searchItem)
    {
        return groceryList.indexOf(searchItem);
    }
}
