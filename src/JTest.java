public class JTest {
    public static void main(String[] args) {
        int n = 0;
        if (args.length == 1)
            n = Integer.parseInt(args[0]);
        else {
            System.out.println("Bitte geben sie nur einen Wert ein");
            System.exit(1);
        }

        Integer[] aufsteigendarray = new Integer[n];
        Integer[] absteigendArray = new Integer[n];
        for (int i = 0; i < n; i++) {
            aufsteigendarray[i] = i;
            absteigendArray[i] = n-1-i;
        }
        Integer[] randomArray = {1,7,5,10,3,11,2};
        Permutation.fisher_yates_shuffle(randomArray);
        Integer[] randomArray2 = randomArray.clone();

        JSorter jSorter = new JSorter();
        Sorter<Integer> sorter = new Sorter<>();

        showArray(randomArray);
        System.out.println(sorter.quickSort(randomArray));
        showArray(randomArray);
        System.out.println();

        showArray(randomArray2);
        System.out.println(jSorter.quickSort(randomArray2, 3));
        showArray(randomArray2);
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
