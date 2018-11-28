class Sorter<T extends Comparable<T>> {
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
    int quicksort(T[] array) {
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
    private void myquick(T[] array, int l, int r) {
        //Großschritt 1.Basisfall
        if (r - l <= 1) {
            return;
        }
        //Großschritt 2
        //Pivoindex genau in der Mitte des Teilintervalls
        int pivin = (int) (l + r) / 2;
        T piv = (T) array[pivin];
        int lamda = l, roh = r - 1;
        int lamdalamda, rohroh;

        while (roh - lamda != 0) {
            int i = lamda - 1;
            int j = roh + 1;
            do {
                i++;
                z++;
            } while (array[i].compareTo(piv) < 0);
            lamdalamda = i;
            do {
                j--;
                z++;
            } while (array[j].compareTo(piv) > 0);
            rohroh = j;

            //Großschritt 2.2
            T temp = array[lamdalamda];
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
            } else if (lamdalamda == pivin && pivin < rohroh) {
                lamda = lamdalamda;
                roh = rohroh - 1;
            } else if (lamdalamda < pivin && pivin == rohroh) {
                lamda = lamdalamda + 1;
                roh = rohroh;
            } else if (lamdalamda == pivin && pivin == rohroh) {
                lamda = lamdalamda;
                roh = rohroh;
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

    /**
     * Insertion-Sort
     *
     * @param array zu sortierendes Array
     * @return int-Wert Schlüsselvergleiche
     */
    int insertionsort(T[] array) {
        int z = 0;
        for (int i = 1; i < array.length; i++) {
            T sort = array[i];
            int j = i;
            z++;
            while (j > 0 && array[j - 1].compareTo(sort) > 0) {
                array[j] = array[j - 1];
                j -= 1;
                z++;
            }
            array[j] = sort;
        }
        return z;
    }

    /**
     * Methode zur Sortierung eines Arrays mit randomisierten Quicksort - Rekursiv
     *
     * @param array zu sortierendes Array
     * @return int Schulüsselvergleiche
     */
    int quicksortRandom(T[] array) {
        myquickrandom(array, 0, array.length);
        return z;
    }

    /**
     * Eigentliches randomisertes Quick-Sort nach Script
     *
     * @param array zu sortierendes Array
     * @param l     Anfangsindex des Teilintervalls
     * @param r     Endindex des Teilintervalls
     */
    private void myquickrandom(T[] array, int l, int r) {
        if (r - l <= 1) {
            return;
        }
        int pivin = (int) (l + ((r - l) * Math.random()));
        T piv = (T) array[pivin];
        int lamda = l, roh = r - 1;
        int lamdalamda, rohroh;

        while (roh - lamda != 0) {
            int i = lamda - 1;
            int j = roh + 1;
            do {
                i++;
                z++;
            } while (array[i].compareTo(piv) < 0);
            lamdalamda = i;
            do {
                j--;
                z++;
            } while (array[j].compareTo(piv) > 0);
            rohroh = j;

            //Großschritt 2.2
            T temp = array[lamdalamda];
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
            } if (lamdalamda == pivin && pivin < rohroh) {
                lamda = lamdalamda;
                roh = rohroh - 1;
            } if (lamdalamda < pivin && pivin == rohroh) {
                lamda = lamdalamda + 1;
                roh = rohroh;
            } if (lamdalamda == pivin && pivin == rohroh) {
                lamda = lamdalamda;
                roh = rohroh;
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
            myquickrandom(array, l1, r1);
            myquickrandom(array, l2, r2);

        }
    }

    int heapsort(Comparable[] A) {
        //Großschritt 0
        if (A.length <= 1)
            return z;
        //Buildheap
        reheap(A, 0, A.length);
        //Großschritt 2
        int heapsize = A.length;
        while (heapsize >= 2) {
            Comparable temp = A[0];
            A[0] = A[heapsize - 1];
            A[heapsize - 1] = temp;
            heapsize -= 1;
            reheap(A, 0, heapsize);
        }
        return z;

    }

    void reheap(Comparable[] A, int from, int to) {
        //Großschritt 1 Basis
        if (2 * from + 1 >= to) {
            return;
        }
        //1.2 Berechnng des maximalen Sohns
        int maxson;
        z++;
        if (2 * from + 1 == to - 1) {
            maxson = 2 * from + 1;
        } else if (A[(2 * from) + 1].compareTo(A[2 * from + 2]) > 0) {
            maxson = 2 * from + 1;
        } else
            maxson = 2 * from + 2;
        //1.3
        z++;
        if (A[from].compareTo(A[maxson]) >= 0) {
            return;
        }
        //2. Rekursion
        Comparable temp = A[from];
        A[from] = A[maxson];
        A[maxson] = temp;
        reheap(A, maxson, to);
    }


    /**
     * Methode zum Resetten des Zählers
     */
    void reset() {
        z = 0;
    }
}

