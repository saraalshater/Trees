public class main {
    public static void main(String[] args) {
        insertSimulator();
//        mergeSimulator();
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



        BST bt = new BST();


        System.out.print("inorder   => ");
        bst.inorder();
        System.out.println("\n======================================================================================");
        System.out.print("preorder  => ");
        bst.preorder();
        System.out.println("\n======================================================================================");
        System.out.print("postorder => ");
        bst.postorder();
        System.out.println("\n======================================================================================");
        System.out.print("Traversing => ");
        bst.traversing();

//        System.out.println("\n======================================================================================");
//        System.out.println("Contains test");
//        System.out.println(bst.contains(5));
//        System.out.println(bst.contains(0));
//        System.out.println(bst.contains(10));
//        System.out.println(bst.contains(4));
//        System.out.println(bst.contains(7));
//        System.out.println(bt.contains(70));
//        System.out.println(bst.contains(-5));
        System.out.println("\n======================================================================================");
        System.out.println("Maximum BST test => "+ bst.maxBST());
        bst.SecMaxBstt();
        System.out.println("Second maximum BST test => "+bst.SecMaxBstt());

    }
}



