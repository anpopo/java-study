package javas.study.udemy.stepnine;

public class StockMain {

    private static StockList stockList = new StockList();
    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("char", 52.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.5, 200);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 7);
        stockList.addStock(temp);


        System.out.println(stockList);


        for (String s : stockList.items().keySet()) {
            System.out.println(s);
        }

        Basket seBasket = new Basket("se");
        sellItem(seBasket, "car", 2);
        System.out.println(seBasket);

        sellItem(seBasket, "cup", 5);
        System.out.println(seBasket);

        sellItem(seBasket, "car", 2);
        sellItem(seBasket, "book", 5);
        System.out.println(seBasket);

        sellItem(seBasket, "juice", 5);
        System.out.println(seBasket);


        temp = new StockItem("pen", 1.12);
        stockList.items().put(temp.getName(), temp);

    }

    public static int sellItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);

        if (stockItem == null) {
            System.out.println("We dont sell " + item);
            return 0;
        }

        if (stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }

        return 0;
    }
}
