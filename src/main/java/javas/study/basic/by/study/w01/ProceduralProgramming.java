package javas.study.basic.by.study.w01;

public class ProceduralProgramming {

//    public static void main(String[] args) {
//        Human human = new Human();
//        List<Object> cart = new ArrayList<>();
//
//        cart.add(getBook("톨스토이 단편선"));
//        cart.add(getToy("로봇"));
//
//        int totalPrice = 0;
//        for (Object product : cart) {
//            totalPrice += getPrice(product);
//        }
//
//        pay(human, totalPrice);
//
//
//    }

    private static Toy getToy(String toyName) {
        Toy toy = new Toy();
        if ("로봇".equals(toyName)) {
            toy.price = 11000;
            toy.toyName = toyName;
            toy.possibleAge = 4;
        } else if ("인형".equals(toyName)) {
            toy.price = 13000;
            toy.toyName = toyName;
            toy.possibleAge = 4;
        } else if ("레고".equals(toyName)) {
            toy.price = 40000;
            toy.toyName = toyName;
            toy.possibleAge = 8;
        }
        return toy;
    }

    private static Book getBook(String bookName) {
        Book book = new Book();
        if ("톨스토이 단편선".equals(bookName)) {
            book.price = 13000;
            book.bookName = bookName;
            book.totalPage = 120;
        } else if ("셰익스피어 4대 비극".equals(bookName)) {
            book.price = 15000;
            book.bookName = bookName;
            book.totalPage = 200;
        }
        return book;
    }

    private static void pay(Human human, int totalPrice) {
        int result = human.money - totalPrice;

        if (result < 0) throw new RuntimeException("돈이 모자랍니다.");
        human.money = result;
    }


    public static int getPrice (Object product) {
        if (product instanceof Book) {
            Book book = (Book) product;
            return book.price;
        } else if (product instanceof Cloth) {
            Cloth cloth = (Cloth) product;
            return cloth.price;
        } else {
            Toy toy = (Toy) product;
            return toy.price;
        }
    }
}
