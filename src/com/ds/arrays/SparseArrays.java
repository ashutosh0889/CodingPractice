package com.ds.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 *  input::
 *      4
        aba
        baba
        aba
        xzxb
        3
        aba
        xzxb
        ab
    output::
    *   2
        1
        0
 * @author ashutosh
 */
public class SparseArrays {
    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] values, String[] queries) {
        Map<String, Integer> occurrences = new HashMap<>();

        for ( String value : values ) {
            if ( occurrences.containsKey( value ) ) {
                int count = occurrences.get( value );
                occurrences.put( value, count + 1 );
            } else {
                occurrences.put( value, 1 );
            }
        }
        int[] counts = new int[ queries.length ];

        for ( int i = 0; i < queries.length; i++ ) {
            String query = queries[ i ];
            counts[i] = occurrences.containsKey( query ) ? occurrences.get( query ) : 0;
        }
        return counts;
    }
    
    public static void main(String[] args) {
        String values[] = {"aba","baba","aba","xzxb"};
        String query[] = {"aba","xzxb","ab"};
        int count[] = matchingStrings(values,query);
        for(int i=0; i<count.length; i++){
            System.out.println(count[i]);
        }
    }
}
