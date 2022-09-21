public class Grocery {
    
    public static void main (String[] args){
        String[] groceryList = {"Nuts", "Fish", "Lentils", "Whole Grains", "Beans", "Olive Oil", "Eggs", "Yogurt"};
        print(groceryList);
        groceryList = addItem(groceryList, "Bread");
        print(groceryList);
    }

    public static void print(String[] list){
        for (int i = 0; i < list.length; i++){
            System.out.println("Item " + (i+1) + ": " +list[i]);
        }
    }
    public static String[] addItem(String[] array, String addMe){
        String[] newList = new String[array.length + 1];
        for (int i = 0; i < array.length; i++){
            newList[i] = array[i];
        }
        newList[array.length] = addMe;
        return newList;
    }

}
