package hashTables;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.omg.SendingContext.RunTimeOperations;

public class HashTable {
    // provide a size for your hash table which your hash function will depend on
    int size;

    // hash function will calculate the indices for the following array using the
    // keys provided by user
    HashTableEntry[] hashtable;
    // ArrayList<HashTableEntry> hashtable;

    public HashTable(int size) {
        hashtable = new HashTableEntry[size];
    }

    // HashTableEntry has the key which will decide the index in HashTable array
    // value will be stored in an arraylist that is created for each HashTable entry
    /*
     * Ex: [
     * 0: [value1, value2, value3] <-this is an array list
     * 1: [......]
     * .
     * .
     * .
     * ]
     */
    public static class HashTableEntry {

        public String key;
        public String value;

        // Using a linked list to accept next entry at the same index when there is a
        // collision
        public HashTableEntry next;

        public HashTableEntry(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public int put(String key, String value) {
        int index = hash(key);

        // just to check the length of linked list after each operation
        int listLength = 0;

        if (key != null && value != null) {
            HashTableEntry entry = new HashTableEntry(key, value);

            // check if the hashtable already has any entry at the current hash index
            // returned
            if (this.hashtable[index] == null) {
                this.hashtable[index] = entry;
                listLength++;
            } else {
                // if the hashtable has an entry at the current index, just add the new entry to
                // the linked list that already exists at that index
                HashTableEntry tempEntry = this.hashtable[index];
                // there exists atleast one entry, hence setting the intital length to 1
                listLength = 1;
                while (tempEntry.next != null) {
                    tempEntry = tempEntry.next;
                    listLength++;
                }
                tempEntry.next = entry;
                listLength++;
            }
        }
        System.out.println("number of elements after adding the current value pair is " + listLength);

        return index;
    }

    public String get(String key) {
        if (key != null) {
            int index = hash(key);
            if (this.hashtable[index] != null) {
                HashTableEntry tempEntry = this.hashtable[index];
                while (tempEntry != null) {
                    if (tempEntry.key.equals(key)) {
                        return tempEntry.value;
                    } else {
                        tempEntry = tempEntry.next;
                    }
                }
            }
        }
        return null;
    }

    public String remove(String key){
        if (key != null) {
            int index = hash(key);
            if (this.hashtable[index] != null) {
                //make the length as 1 if there is even 1 entry at the index
                HashTableEntry tempEntry = this.hashtable[index];
                if(tempEntry.key.equals(key)){
                    tempEntry=null;
                    //since we are removing the entry, make the length 0
                }else{
                    while (tempEntry.next != null) {
                        if (tempEntry.next.key.equals(key)) {
                            String removedValue = tempEntry.next.value;
                            tempEntry.next = tempEntry.next.next;
                            return removedValue;
                        } else {
                            tempEntry = tempEntry.next;
                        }
                    }
                }
              
            }
        }
        return null;
    }
 
    /*
     * Takes data of different size but returns data of same size everytime
     * this hash algorithm is not constant time
     */
    public int hash(String key) {
        int hash = charCodeSum(key);
        return hash % this.hashtable.length;
    }

    public int charCodeSum(String str) {
        String[] strArr = str.split("");
        int sum = 0;
        for (String ch : strArr) {
            sum += Character.codePointAt(ch, 0);
        }
        return sum;
    }

    public static void main(String args[]) {
        HashTable ht = new HashTable(10);
        System.out.println("adding 1 at " + ht.put("one", "1"));
        System.out.println("adding 2 at " + ht.put("two", "2"));
        System.out.println("adding 3 at " + ht.put("three", "3"));
        System.out.println("adding 4 at " + ht.put("four", "4"));
        System.out.println("adding 5 at " + ht.put("five", "5"));

        System.out.println(ht.get(null));
        System.out.println("removing 3 " + ht.remove("three"));
    }
}
