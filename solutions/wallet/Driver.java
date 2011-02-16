/**
 * Driver tests the Wallet class.
 *
 * @author Anthony W. Smith
 * @version 6/15/2009
 */

public class Driver {

    public static void main(String args[]) {

        // create an empty Wallet object
        Wallet myWallet = new Wallet();


        // put some banknotes into myWallet
        myWallet.addBanknote(5);
        myWallet.addBanknote(50);
        myWallet.addBanknote(10);
        myWallet.addBanknote(5);


        // show the contents of myWallet
        System.out.println("myWallet contains: " + myWallet.toString());


        // calculate the value of myWallet
        System.out.println("myWallet value: " + myWallet.value()
                + " dollars");

        // reverse the order of banknotes in myWallet
        myWallet.reverse();
        System.out.println("myWallet reversed contains: "
                + myWallet.toString());

        // transfer all the banknotes from myWallet to yourWallet!
        Wallet yourWallet = new Wallet();
        yourWallet.addBanknote(1);
        yourWallet.transfer(myWallet);
        System.out.println("\nnow myWallet contains: "
                + myWallet.toString());
        System.out.println("yourWallet contains: "
                + yourWallet.toString());

        // check whether two wallets have the same banknotes

        // in the same order
        Wallet tom = new Wallet();
        tom.addBanknote(10);
        tom.addBanknote(5);
        tom.addBanknote(10);

        Wallet dick = new Wallet();
        dick.addBanknote(10);
        dick.addBanknote(10);
        dick.addBanknote(5);

        Wallet harry = new Wallet();
        harry.addBanknote(10);
        harry.addBanknote(5);
        harry.addBanknote(10);

        System.out.println(
                "\ntom has same banknotes in same order as dick: "
                        + tom.sameBanknotesSameOrder(dick));

        System.out.println(
                "tom has same banknotes in same order as harry: "
                        + tom.sameBanknotesSameOrder(harry));


        // EXTRA CREDIT – compare two wallets and print banknote pairs
        // you write code here to create wallets w1 and w2 then
        // call your printBanknotePairs() method
        System.out.println(
                "\nmyWallet and yourWallet note pairs: " +
                        myWallet.printBanknotePairs(yourWallet));
    }
}