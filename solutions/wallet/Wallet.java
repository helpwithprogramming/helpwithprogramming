public class Wallet {

    // max possible # of banknotes in a wallet
    private static final int MAX = 10;
    private int contents[];
    private int count; // count # of banknotes stored in contents[]

    /**
     * Constructor
     */
    public Wallet() {
        // your code goes here
        contents = new int[MAX];
        count = 0;
    }

    /**
     * Adds a bank note if there is room only
     * @param banknoteType
     */
    public void addBanknote(int banknoteType) {
        if(count < MAX) {
            contents[count++] = banknoteType;
        }
    }

    /**
     * String representation of the wallet
     * @return
     */
    public String toString() {
        // your code goes here
        StringBuffer buffer = new StringBuffer("Wallet[");
        for(int i=0; i<count; i++) {
            buffer.append(Integer.toString(contents[i]));
            if(i<count-1) {
                buffer.append(", ");
            }
        }
        buffer.append("]");
        return buffer.toString();
    }

    /**
     * Gets the total value in the wallet
     * @return
     */
    public int value() {
        // your code goes here
        int total = 0;
        for(int i=0; i<count; i++) {
            total += contents[i];
        }
        return total;
    }

    /**
     * Reverses the wallet contents
     */
    public void reverse() {
        // your code goes here
        int[] temp = new int[MAX];

        int index = 0;
        for(int i=count-1; i>=0; i--) {
            temp[index++] = contents[i];
        }

        // re-assigns the reversed value to contents
        contents = temp;
    }

    /**
     * Transfers the contents from donor into this wallet
     * @param donor
     */
    public void transfer(Wallet donor) {
        // your code goes here
        for(int i=0; i<donor.count; i++) {
            addBanknote(donor.contents[i]);
        }
    }

    /**
     * Checks if both wallets have the exact same contents
     * @param other
     * @return
     */
    public boolean sameBanknotesSameOrder(Wallet other) {
        if(count != other.count)
            return false;

        for(int i=0; i<count; i++) {
            if(contents[i] != other.contents[i])
                return false;
        }

        return true;
    }

    /**
     * EXTRA CREDIT methods follow...
     *
     * Prints the pairs of notes in the two wallters
     * @param other
     */
    public String printBanknotePairs(Wallet other) {
        // your code goes here
        String output = "";
        boolean[] selected = new boolean[other.count];
        for(int i=0; i<count; i++) {
            int note = contents[i];
            int index = findInOtherWallet(other, selected, note);
            if(index >= 0) {
                selected[index] = true;
                output += note + " ";
            }
        }
        if(output.length() == 0) {
            return "No pairs found";
        }
        else {
            return output;
        }
    }

    /**
     * Helper method to see if a note exists in the other wallet
     * It also makes sure it has not already been selected for
     * another pair
     * @param other
     * @param selected
     * @param note
     * @return
     */
    private int findInOtherWallet(Wallet other, boolean[] selected, int note) {
        for(int i=0; i<other.count; i++) {
            if(other.contents[i] == note && !selected[i]) {
                return i;
            }
        }
        return -1;
    }

}