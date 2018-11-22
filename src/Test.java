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


        Sorter sorter = new Sorter();
        System.out.println();
        //---------
        System.out.println("Quicksort");
        System.out.println("Aufsteigenedes Array");
        showArray(aufsteigendarray);
        System.out.println("Quicksort Aufsteigend "+sorter.quicksort(aufsteigendarray.clone(),0,aufsteigendarray.length));
        showArray(aufsteigendarray);
        sorter.reset();
        System.out.println();
        System.out.println("Absteigendes Array");
        showArray(quickSortArray0);
        System.out.println("Quicksort Absteigend "+sorter.quicksort(quickSortArray0,0,quickSortArray0.length));
        showArray(quickSortArray0);
        sorter.reset();
        System.out.println();
        System.out.println("Random 1");
        showArray(quickSortArray1);
        System.out.println("Quicksort Random 1 "+sorter.quicksort(quickSortArray1,0,quickSortArray1.length));
        showArray(quickSortArray1);
        sorter.reset();
        System.out.println();
        System.out.println("Random 2");
        showArray(quickSortArray2);
        System.out.println("Quicksort Random 2 "+sorter.quicksort(quickSortArray2,0,quickSortArray1.length));
        showArray(quickSortArray2);
        sorter.reset();
        System.out.println();
        System.out.println();
        //---------
        System.out.println("Insertionsort");
        System.out.println("Aufsteigenedes Array");
        showArray(aufsteigendarray);
        System.out.println("InsertionsSort Aufsteigend "+sorter.insertionsort(aufsteigendarray));
        showArray(aufsteigendarray);
        System.out.println();
        System.out.println("Absteigendes Array");
        showArray(insertionSortArray0);
        System.out.println("InsertionSort Absteigend "+sorter.insertionsort(insertionSortArray0));
        showArray(insertionSortArray0);
        System.out.println();
        System.out.println("Random 1");
        showArray(insertionSortArray1);
        System.out.println("Insertionsort Random 1 "+sorter.insertionsort(insertionSortArray1));
        showArray(insertionSortArray1);
        System.out.println();
        System.out.println("Random 2");
        showArray(insertionSortArray2);
        System.out.println("Insertionsort Random 2 "+sorter.insertionsort(insertionSortArray2));
        showArray(insertionSortArray2);
        System.out.println();
        System.out.println();
        //-------------
        System.out.println("QuickSortRandom");
        System.out.println("Aufsteigendes Array");
        showArray(aufsteigendarray);
        System.out.println("QuickSortRandom Aufsteigend "+sorter.quicksortRandom(aufsteigendarray,0,aufsteigendarray.length));
        showArray(aufsteigendarray);
        sorter.reset();
        System.out.println();
        System.out.println("Absteigendes Array");
        showArray(quickSortRandomArray0);
        System.out.println("QuickSortRandom Absteigend "+sorter.quicksortRandom(quickSortRandomArray0,0,quickSortRandomArray0.length));
        showArray(quickSortRandomArray0);
        System.out.println();
        System.out.println("Random");
        int zz=0;
        showArray(quickSortRandomArray1);
        Integer test[] = quickSortRandomArray1.clone();
        for (int i=0; i<100000; i++){
            test = quickSortRandomArray1.clone();
            zz+=sorter.quicksortRandom(test,0,quickSortRandomArray1.length);
            sorter.reset();
        }
        showArray(test);
        System.out.println("Durchschnittlich "+zz/100000+" Schlüsselvergleiche");

    }

    /**
     * Methode zur Ausgabe des Arrays
     * @param array
     */
    private static void showArray(Comparable<Integer>[] array){
        for (int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
