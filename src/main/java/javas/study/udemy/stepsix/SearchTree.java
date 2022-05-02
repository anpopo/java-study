package javas.study.udemy.stepsix;

public class SearchTree implements NodeList{
    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if (this.root == null) {
            root = item;
            return true;
        }

        ListItem currentItem = root;

        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);

            if (comparison < 0) {
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    currentItem.setNext(item);
                    return true;
                }
            } else if (comparison > 0) {
                if (currentItem.previous() != null) {
                    currentItem = currentItem.previous();
                } else {
                    currentItem.setPrevious(item);
                    return true;
                }
            } else {
                System.out.println(item.getValue() + " is already present");
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison < 0) {
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if (comparison > 0) {
                parentItem = currentItem;
                currentItem = currentItem.previous();
            } else {
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }

    private void performRemoval(ListItem item, ListItem parent) {
        if (item.next() == null) {
            if (parent.next() == item) {
                parent.setNext(item.previous());
            } else if (parent.previous() == item) {
                parent.setPrevious(item.previous());
            } else root = item.previous();
        } else if (item.previous() == null) {
            if (parent.next() == item) parent.setNext(item.next());
            else if (parent.previous() == item) parent.setPrevious(item.next());
            else root = item.next();
        } else {
            ListItem current = item.next();
            ListItem leftmostParent = item;

            while (current.previous() != null) {
                leftmostParent = current;
                current = current.previous();
            }

            item.setValue(current.getValue());

            if (leftmostParent == item) item.setNext(current.next());
            else leftmostParent.setPrevious(current.next());
        }
    }

    @Override
    public void traverse(ListItem root) {
        if (root != null) {
            traverse(root.previous());
            traverse(root.next());
        }
    }
}
