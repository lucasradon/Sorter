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
        Integer HeapsortArray[] = randomArray.clone();
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
        System.out.println("Quicksort Aufsteigend Schlüsselvergleiche: "+sorter.quickSort(aufsteigendarray.clone()));
        showArray(aufsteigendarray);
        sorter.reset();
        System.out.println();
        System.out.println("Absteigendes Array");
        showArray(quickSortArray0);
        System.out.println("Quicksort Absteigend Schlüsselvergleiche: "+sorter.quickSort(quickSortArray0));
        showArray(quickSortArray0);
        sorter.reset();
        System.out.println();
        System.out.println("Random 1");
        showArray(quickSortArray1);
        System.out.println("Quicksort Random 1 Schlüsselvergleiche: "+sorter.quickSort(quickSortArray1));
        showArray(quickSortArray1);
        sorter.reset();
        System.out.println();
        System.out.println("Random 2");
        showArray(quickSortArray2);
        System.out.println("Quicksort Random 2 Schlüsselvergleiche: "+sorter.quickSort(quickSortArray2));
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
        System.out.println("QuickSortRandom Aufsteigend Schlüsselvergleiche: "+sorter.quicksortRandomNachScript(aufsteigendarray));
        showArray(aufsteigendarray);
        sorter.reset();
        System.out.println();
        System.out.println("Absteigendes Array");
        showArray(quickSortRandomArray0);
        System.out.println("QuickSortRandom Absteigend Schlüsselvergleiche: "+sorter.quicksortRandomNachScript(quickSortRandomArray0));
        showArray(quickSortRandomArray0);
        System.out.println();
        System.out.println("Random");
        int zz=0;
        showArray(quickSortRandomArray1);
        Integer test[] = quickSortRandomArray1.clone();
        for (int i=0; i<10000; i++){
            test = quickSortRandomArray1.clone();
            zz+=sorter.quicksortRandomNachScript(test);
            sorter.reset();
        }
        showArray(test);
        System.out.println("Durchschnittlich "+zz/10000+" Schlüsselvergleiche");

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
        System.out.println("Character[] Quicksort Schlüsselvergleiche: "+charSorter.quickSort(characters));
        showArray(characters);

        System.out.println();
        Sorter<String> stringSorter = new Sorter<String>();
        String[] strings = {"Hi","abcd","a","xzsk","b","c"};
        showArray(strings);
        System.out.println("String[] Quicksort Schlüsselvergleiche: "+stringSorter.quickSort(strings));
        showArray(strings);
        System.out.println();
        System.out.println("=====Heapsort=====");
        showArray(HeapsortArray);
        sorter.reset();
        System.out.println("Heapsort: "+sorter.heapsort(HeapsortArray));
        showArray(HeapsortArray);
        System.out.println();
        sorter.reset();
        System.out.println("====Simplekeys====");

        Integer[] A = {0,1,2,3,4,5,6,7,8,9};
        Integer[] B = {0,0,0,0,0,1,1,1,1,1};
        A = Permutation.fisher_yates_shuffle(A);
        B = Permutation.fisher_yates_shuffle(B);

        //SimpleKeys Initialisieren
        SimpleKey[] simpleKeys = new SimpleKey[10];
        ExtendedKey[] extendedKeys = new ExtendedKey[10];

        for (int i=0; i<simpleKeys.length; i++){
            simpleKeys[i] = new SimpleKey(B[i],A[i]);
            extendedKeys[i] = new ExtendedKey(B[i],A[i]);
        }

        SimpleKey[] simpleKeys1 = simpleKeys.clone();
        SimpleKey[] simpleKeys2 = simpleKeys.clone();

        Sorter<SimpleKey> simpleKeySorter = new Sorter<>();

        showArray(simpleKeys);
        System.out.println("Quicksort Schlüsselvergleiche: "+simpleKeySorter.quickSort(simpleKeys));
        showArray(simpleKeys);
        System.out.println();
        simpleKeySorter.reset();
        showArray(simpleKeys1);
        System.out.println("Heapsort Schlüsselvergleiche: "+simpleKeySorter.heapsort(simpleKeys1));
        showArray(simpleKeys1);
        System.out.println();
        simpleKeySorter.reset();
        showArray(simpleKeys2);
        System.out.println("InsertionSort Schlüsselvergleiche: "+simpleKeySorter.insertionsort(simpleKeys2));
        showArray(simpleKeys2);
        System.out.println();
        System.out.println("====ExtendedKeys====");

        //ExtendedKeys Initialisieren

        ExtendedKey[] extendedKeys1 = extendedKeys.clone();
        ExtendedKey[] extendedKeys2 = extendedKeys.clone();


        Sorter<ExtendedKey> extendedKeySorter = new Sorter<>();
        showArray(extendedKeys);
        System.out.println("Quicksort Schlüsselvergleiche: "+extendedKeySorter.quickSort(extendedKeys));
        showArray(extendedKeys);
        System.out.println();
        extendedKeySorter.reset();
        showArray(extendedKeys1);
        System.out.println("Heapsort Schlüsselvergleiche: "+extendedKeySorter.heapsort(extendedKeys1));
        showArray(extendedKeys1);
        System.out.println();
        extendedKeySorter.reset();
        showArray(extendedKeys2);
        System.out.println("InsertionSort Schlüsselvergleiche: "+extendedKeySorter.insertionsort(extendedKeys2));
        showArray(extendedKeys2);
        System.out.println();
        System.out.println("Man sieht, dass die Extendedkey eine höhere Anzahl an Schlüsselvergleiche brauchen um richtig Sortiert zu werden, da im Falle eines gleichen Keys, nochmal nach Position sortiert wird." +
                "Nach mehreren Durchgänge sieht man, dass es sehr unterschiedlich ist, welcher der schnellste ist, je nach dem wie Sortiert wird.");
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
