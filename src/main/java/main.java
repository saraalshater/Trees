public class main {
    public static void main(String[] args) {
        insertSimulator();
    }

    private static void insertSimulator(){
        BST bst = new BST();
        bst.insert(10);
        bst.insert(16);
        bst.insert(11);
        bst.insert(8);
        bst.insert(7);
        bst.insert(9);
        bst.insert(20);
        bst.insert(17);
        bst.insert(29);
//        bst.insert(35);
        bst.insert(28);


        System.out.println("\n======================================================================================");
        System.out.println("Maximum BST test => "+ bst.maxBST());
        bst.SecMaxBstt();
        System.out.println("Second maximum BST test => "+bst.SecMaxBstt());

    }
}



