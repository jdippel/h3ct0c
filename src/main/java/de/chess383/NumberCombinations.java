
package de.chess383;

import static java.util.Collections.EMPTY_LIST;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NumberCombinations {
    
    private final int HECTOC_LIMIT = 6;

    private String digits;
    private Integer[] numbers = new Integer[HECTOC_LIMIT];
    private List<List<Integer>> combinations;

    public NumberCombinations( String input ) {
        this.digits = input;
        this.combinations = new ArrayList<>();
    }

    public NumberCombinations createNumbers() {
        for( int cursor=0; cursor<HECTOC_LIMIT; cursor++) {
            this.numbers[cursor] = Character.digit(this.digits.charAt(cursor), 10 );
        }
        this.combinations.add( createNumberList(numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5] ));
        // one pair
        this.combinations.add( createNumberList(pair(numbers[0], numbers[1]), numbers[2], numbers[3], numbers[4], numbers[5] ));
        this.combinations.add( createNumberList(numbers[0], pair(numbers[1], numbers[2]), numbers[3], numbers[4], numbers[5] ));
        this.combinations.add( createNumberList(numbers[0], numbers[1], pair(numbers[2], numbers[3]), numbers[4], numbers[5] ));
        this.combinations.add( createNumberList(numbers[0], numbers[1], numbers[2], pair(numbers[3], numbers[4]), numbers[5] ));
        this.combinations.add( createNumberList(numbers[0], numbers[1], numbers[2], numbers[3], pair(numbers[4], numbers[5]) ));
        // two pairs
        this.combinations.add( createNumberList(pair(numbers[0], numbers[1]), pair(numbers[2], numbers[3]), numbers[4], numbers[5] ));
        this.combinations.add( createNumberList(pair(numbers[0], numbers[1]), numbers[2], pair(numbers[3], numbers[4]), numbers[5] ));
        this.combinations.add( createNumberList(pair(numbers[0], numbers[1]), numbers[2], numbers[3], pair(numbers[4], numbers[5]) ));
        this.combinations.add( createNumberList(numbers[0], pair(numbers[1], numbers[2]), pair(numbers[3], numbers[4]), numbers[5] ));
        this.combinations.add( createNumberList(numbers[0], pair(numbers[1], numbers[2]), numbers[3], pair(numbers[4], numbers[5]) ));
        this.combinations.add( createNumberList(numbers[0], numbers[1], pair(numbers[2], numbers[3]), pair(numbers[4], numbers[5]) ));
        // three pairs
        this.combinations.add( createNumberList(pair(numbers[0], numbers[1]), pair(numbers[2], numbers[3]), pair(numbers[4], numbers[5]) ));
        // one triple
        this.combinations.add( createNumberList(triple(numbers[0], numbers[1], numbers[2]), numbers[3], numbers[4], numbers[5] ));
        this.combinations.add( createNumberList(numbers[0], triple(numbers[1], numbers[2], numbers[3]), numbers[4], numbers[5] ));
        this.combinations.add( createNumberList(numbers[0], numbers[1], triple(numbers[2], numbers[3], numbers[4]), numbers[5] ));
        this.combinations.add( createNumberList(numbers[0], numbers[1], numbers[2], triple(numbers[3], numbers[4], numbers[5]) ));
        // two triples
        this.combinations.add( createNumberList(triple(numbers[0], numbers[1], numbers[2]), triple(numbers[3], numbers[4], numbers[5]) ));
        // one triple, one pair
        this.combinations.add( createNumberList(triple(numbers[0], numbers[1], numbers[2]), pair(numbers[3], numbers[4]), numbers[5] ));
        this.combinations.add( createNumberList(triple(numbers[0], numbers[1], numbers[2]), numbers[3], pair(numbers[4], numbers[5]) ));
        this.combinations.add( createNumberList(numbers[0], triple(numbers[1], numbers[2], numbers[3]), pair(numbers[4], numbers[5]) ));
        this.combinations.add( createNumberList(pair(numbers[0], numbers[1]), triple(numbers[2], numbers[3], numbers[4]), numbers[5] ));
        this.combinations.add( createNumberList(pair(numbers[0], numbers[1]), numbers[2], triple(numbers[3], numbers[4], numbers[5]) ));
        this.combinations.add( createNumberList(numbers[0], pair(numbers[1], numbers[2]), triple(numbers[3], numbers[4], numbers[5]) ));
        // one quadruple
        this.combinations.add( createNumberList(quadruple(numbers[0], numbers[1], numbers[2], numbers[3]), numbers[4], numbers[5] ));
        this.combinations.add( createNumberList(numbers[0], quadruple(numbers[1], numbers[2], numbers[3], numbers[4]), numbers[5] ));
        this.combinations.add( createNumberList(numbers[0], numbers[1], quadruple(numbers[2], numbers[3], numbers[4], numbers[5]) ));
        // one quadruple, one pair
        this.combinations.add( createNumberList(quadruple(numbers[0], numbers[1], numbers[2], numbers[3]), pair(numbers[4], numbers[5]) ));
        this.combinations.add( createNumberList(pair(numbers[0], numbers[1]), quadruple(numbers[2], numbers[3], numbers[4], numbers[5]) ));
        // one quintuple
        this.combinations.add( createNumberList(quintuple(numbers[0], numbers[1], numbers[2], numbers[3], numbers[4]), numbers[5] ));
        this.combinations.add( createNumberList(numbers[0], quintuple(numbers[1], numbers[2], numbers[3], numbers[4], numbers[5]) ));

        return this;
    }

    public List<List<Integer>> getNumbers() {
        return this.combinations;
    }

    private Integer pair(Integer number1, Integer number2) {
        return 10 * number1 + number2;
    }

    private Integer triple(Integer number1, Integer number2, Integer number3) { return( pair(pair(number1, number2), number3)); }

    private Integer quadruple(Integer number1, Integer number2, Integer number3, Integer number4) { return( pair(triple(number1, number2, number3), number4)); }

    private Integer quintuple(Integer number1, Integer number2, Integer number3, Integer number4, Integer number5) { return( pair(quadruple(number1, number2, number3, number4), number5)); }

    private List<Integer> createNumberList(Integer numbers1, Integer numbers2, Integer numbers3, Integer numbers4, Integer numbers5, Integer numbers6) {

        List<Integer> list = new ArrayList<>(HECTOC_LIMIT);
        list.add(numbers1);
        list.add(numbers2);
        list.add(numbers3);
        list.add(numbers4);
        list.add(numbers5);
        list.add(numbers6);
        return list;
    }

    private List<Integer> createNumberList(Integer numbers1, Integer numbers2, Integer numbers3, Integer numbers4, Integer numbers5) {

        List<Integer> list = new ArrayList<>(HECTOC_LIMIT);
        list.add(numbers1);
        list.add(numbers2);
        list.add(numbers3);
        list.add(numbers4);
        list.add(numbers5);
        return list;
    }

    private List<Integer> createNumberList(Integer numbers1, Integer numbers2, Integer numbers3, Integer numbers4) {

        List<Integer> list = new ArrayList<>(HECTOC_LIMIT);
        list.add(numbers1);
        list.add(numbers2);
        list.add(numbers3);
        list.add(numbers4);
        return list;
    }

    private List<Integer> createNumberList(Integer numbers1, Integer numbers2, Integer numbers3) {

        List<Integer> list = new ArrayList<>(HECTOC_LIMIT);
        list.add(numbers1);
        list.add(numbers2);
        list.add(numbers3);
        return list;
    }

    private List<Integer> createNumberList(Integer numbers1, Integer numbers2) {

        List<Integer> list = new ArrayList<>(HECTOC_LIMIT);
        list.add(numbers1);
        list.add(numbers2);
        return list;
    }

    @Override
    public String toString() {
        final Iterator iterator = this.combinations.iterator();
        if( iterator.hasNext()) {
            StringBuffer builder = new StringBuffer("");
            builder.append(iterator.next());
            while( iterator.hasNext()) {
                builder.append(iterator.next());
            }
            return builder.toString();
        }
        else return singleCombinationString( EMPTY_LIST );
    }

    private String singleCombinationString( List<Integer> combination ) {
        StringBuffer builder = new StringBuffer("[ ");
        for( Integer number : combination ) {
            builder.append( number ).append(" ");
        }
        builder.append("]\n");
        return builder.toString();
    }
}
