import javafx.scene.Scene;

public class Test {
    public static void main(String[] args) {
        int n = 0;
        if (args.length == 1)
            n = Integer.parseInt(args[0]);
        else {
            System.out.println("Bitte geben sie nur einen Wert ein");
            System.exit(1);
        }

        //Aufsteigendes und Absteigendes Array initalisieren
        Integer[] aufsteigendarray = new Integer[n];
        Integer[] absteigendArray = new Integer[n];
        for (int i = 0; i < n; i++) {
            aufsteigendarray[i] = i;
            absteigendArray[i] = n-1-i;
        }

        //Arrays initalsieren um Vorher und nachher zu zeigen
        Integer[] randomArray = aufsteigendarray.clone();
        Permutation.fisher_yates_shuffle(randomArray); //Randomisiertes Array
        Integer quickSortArray0[] = absteigendArray.clone();
        Integer quickSortArray1[] = randomArray.clone();
        Integer quickSortArray2[] = randomArray.clone();
        Permutation.fisher_yates_shuffle(quickSortArray2);
        Integer insertionSortArray0[] = absteigendArray.clone();
        Integer insertionSortArray1[] = randomArray.clone();
        Integer insertionSortArray2[] = quickSortArray2.clone();
        Integer quickSortRandomArray0[] = absteigendArray.clone();
        Integer quickSortRandomArray1[] = Permutation.fisher_yates_shuffle(randomArray);


        Sorter<Integer> sorter = new Sorter<Integer>();
        System.out.println();
        //---------
        System.out.println("====Quicksort====");
        System.out.println("Aufsteigenedes Array");
        showArray(aufsteigendarray);
        System.out.println("Quicksort Aufsteigend Schlüsselvergleiche: "+sorter.quicksort(aufsteigendarray.clone()));
        showArray(aufsteigendarray);
        sorter.reset();
        System.out.println();
        System.out.println("Absteigendes Array");
        showArray(quickSortArray0);
        System.out.println("Quicksort Absteigend Schlüsselvergleiche: "+sorter.quicksort(quickSortArray0));
        showArray(quickSortArray0);
        sorter.reset();
        System.out.println();
        System.out.println("Random 1");
        showArray(quickSortArray1);
        System.out.println("Quicksort Random 1 Schlüsselvergleiche: "+sorter.quicksort(quickSortArray1));
        showArray(quickSortArray1);
        sorter.reset();
        System.out.println();
        System.out.println("Random 2");
        showArray(quickSortArray2);
        System.out.println("Quicksort Random 2 Schlüsselvergleiche: "+sorter.quicksort(quickSortArray2));
        showArray(quickSortArray2);
        sorter.reset();
        System.out.println();
        System.out.println();
        //---------
        System.out.println("====Insertionsort====");
        System.out.println("Aufsteigenedes Array");
        showArray(aufsteigendarray);
        System.out.println("InsertionsSort Aufsteigend Schlüsselvergleiche: "+sorter.insertionsort(aufsteigendarray));
        showArray(aufsteigendarray);
        System.out.println();
        System.out.println("Absteigendes Array");
        showArray(insertionSortArray0);
        System.out.println("InsertionSort Absteigend Schlüsselvergleiche: "+sorter.insertionsort(insertionSortArray0));
        showArray(insertionSortArray0);
        System.out.println();
        System.out.println("Random 1");
        showArray(insertionSortArray1);
        System.out.println("Insertionsort Random 1 Schlüsselvergleiche: "+sorter.insertionsort(insertionSortArray1));
        showArray(insertionSortArray1);
        System.out.println();
        System.out.println("Random 2");
        showArray(insertionSortArray2);
        System.out.println("Insertionsort Random 2 Schlüsselvergleiche: "+sorter.insertionsort(insertionSortArray2));
        showArray(insertionSortArray2);
        System.out.println();
        System.out.println();
        //-------------
        System.out.println("====QuickSortRandom=====");
        System.out.println("Aufsteigendes Array");
        showArray(aufsteigendarray);
        System.out.println("QuickSortRandom Aufsteigend Schlüsselvergleiche: "+sorter.quicksortRandom(aufsteigendarray));
        showArray(aufsteigendarray);
        sorter.reset();
        System.out.println();
        System.out.println("Absteigendes Array");
        showArray(quickSortRandomArray0);
        System.out.println("QuickSortRandom Absteigend Schlüsselvergleiche: "+sorter.quicksortRandom(quickSortRandomArray0));
        showArray(quickSortRandomArray0);
        System.out.println();
        System.out.println("Random");
        int zz=0;
        showArray(quickSortRandomArray1);
        Integer test[] = quickSortRandomArray1.clone();
        for (int i=0; i<100000; i++){
            test = quickSortRandomArray1.clone();
            zz+=sorter.quicksortRandom(test);
            sorter.reset();
        }
        showArray(test);
        System.out.println("Durchschnittlich "+zz/100000+" Schlüsselvergleiche");

        System.out.println();
        System.out.println("====Generics Test mit Char[] und String[]====");
        Sorter<Character> charSorter = new Sorter<Character>();
        String mytest = "acbdxkj";
        Character[] characters = new Character[mytest.length()];
        char[] charaarray = mytest.toCharArray();
        for (int i=0; i<mytest.length(); i++){
            characters[i]= charaarray[i];
        }
        showArray(characters);
        System.out.println("Character[] Quicksort Schlüsselvergleiche: "+charSorter.quicksort(characters));
        showArray(characters);

        System.out.println();
        Sorter<String> stringSorter = new Sorter<String>();
        String[] strings = {"Hi","abcd","a","xzsk","b","c"};
        showArray(strings);
        System.out.println("String[] Quicksort Schlüsselvergleiche: "+stringSorter.quicksort(strings));
        showArray(strings);
        System.out.println();
        System.out.println("=====Heapsort=====");
        Comparable[] A = {0,1,0,0,1,1,1,0,0,1};
        showArray(A);
        sorter.reset();
        System.out.println(sorter.heapsort(A));
        showArray(A);
        System.out.println();
        System.out.println("====Simple und Extendedkeys====");

        SimpleKey[] simpleKeys = {new SimpleKey(0,5), new SimpleKey(1,7),
                new SimpleKey(0,0),new SimpleKey(0,3),new SimpleKey(1,1),
                new SimpleKey(1,9),new SimpleKey(1,6),new SimpleKey(0,4),
                new SimpleKey(0,2),new SimpleKey(1,8)};
        SimpleKey[] simpleKeys1 = simpleKeys.clone();
        ExtendedKey[] extendedKeys = new ExtendedKey[10];

        Sorter<SimpleKey> simpleKeySorter = new Sorter<>();

        showArray(simpleKeys);
        System.out.println("Quicksort: "+simpleKeySorter.quicksort(simpleKeys));
        showArray(simpleKeys);
        System.out.println();
        showArray(simpleKeys1);
        System.out.println("Heapsort: "+simpleKeySorter.heapsort(simpleKeys1));
        showArray(simpleKeys1);
    }

    /**
     * Methode zur Ausgabe des Arrays
     * @param array anzuzeigendes Array
     */
    private static void showArray(Comparable[] array){
        for (int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
