package javas.study.udemy.stepfive;

import java.util.ArrayList;
import java.util.Collections;

public class GroceryList {

    private ArrayList<String> groceryList = new ArrayList<>();

    public void addGroceryItem(String item) {
        groceryList.add(item);
    }

    public void printGroceryList() {
        System.out.println(groceryList.size());
        for (String s : groceryList) {
            System.out.println(s);
        }
    }

    private void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
    }

    public void modifyGroceryItem(String currentItem, String newItem) {
        int position = findIndexOfItem(currentItem);
        if (position >= 0) {
            modifyGroceryItem(position, newItem);
        }
    }

    private void removeGroceryItem(int position) {
        groceryList.remove(position-1);
    }

    public void removeGroceryItem(String item) {
        int position = findIndexOfItem(item);
        if (position >= 0) {
            removeGroceryItem(position);
        }
    }
    private int findIndexOfItem(String searchItem) {
        return groceryList.indexOf(searchItem);
    }

    public boolean onFile(String searchItem) {
        int position = findIndexOfItem(searchItem);
        return position >= 0;
    }

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }
}
