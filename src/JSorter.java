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
    int quickSort(Comparable[] array) {
        myquick(array, 0, array.length);
        return z;
    }

    /**
     * Eigentliches Quick-Sort nach Script
     *
     * @param array zu sortierendes Array
     * @param l     Anfangsindex des Teilintervalls
     * @param r     Endindex des Teilintervalls
     */
    private void myquick(Comparable[] array, int l, int r) {
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
        //Rekursion
        int l1, l2, r1, r2;
        if ((pivin - l) < (r - pivin)) {
            l1 = l;
            r1 = pivin;
            l2 = pivin + 1;
            r2 = r;
        } else {
            l1 = pivin + 1;
            r1 = r;
            l2 = l;
            r2 = pivin;
        }
        myquick(array, l1, r1);
        myquick(array, l2, r2);

    }
}
