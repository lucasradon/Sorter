public class JSorter {
    /**
     * Zähler Varibale - Schlüssevergleiche
     */
    private static int z = 0;

    /**
     * Methode zur Sortierung eines Arrays mit Quicksort - Rekursiv
     *
     * @param array zu sortierendes Array
     * @return int Schulüsselvergleiche
     */
    int quickSort(Comparable[] array, int j) {
        myquick(array, 0, array.length, j);
        System.out.println(array[j]);
        return z;
    }
    private void myquick(Comparable[] array, int l, int r, int k) {
        //Großschritt 1.Basisfall
        if (r - l <= 1) {
            return;
        }
        //Großschritt 2
        //Pivoindex genau in der Mitte des Teilintervalls
        int pivin = (l + r) / 2;
        Comparable piv = array[pivin];
        int lamda = l, roh = r - 1;
        int lamdalamda, rohroh;

        while (roh - lamda != 0) {
            int i = lamda;
            int j = roh;

            z++;
            while (array[i].compareTo(piv) < 0) {
                z++;
                i++;
            }

            z++;
            while (array[j].compareTo(piv) > 0) {
                z++;
                j--;
            }
            lamdalamda = i;
            rohroh = j;

            //Großschritt 2.2
            Comparable temp = array[lamdalamda];
            array[lamdalamda] = array[rohroh];
            array[rohroh] = temp;
            if (pivin == lamdalamda)
                pivin = rohroh;
            else if (pivin == rohroh)
                pivin = lamdalamda;
            //Großschritt 2.3
            if (lamdalamda < pivin && pivin < rohroh) {
                lamda = lamdalamda + 1;
                roh = rohroh - 1;
            }
            if (lamdalamda == pivin && pivin < rohroh) {
                lamda = lamdalamda;
                roh = rohroh - 1;
            }
            if (lamdalamda < pivin && pivin == rohroh) {
                lamda = lamdalamda + 1;
                roh = rohroh;
            }
            if (lamdalamda == pivin && pivin == rohroh) {
                lamda = lamdalamda;
                roh = rohroh;
            }
        }

        int l1, r1;
        if (pivin == k)
            return;
        else if (k<pivin){
            l1 = l;
            r1 = pivin;
        } else {
            l1 = pivin + 1;
            r1 = r;
        }
        //Rekursion

        myquick(array, l1, r1,k);

    }

    private static void showArray(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
