package de.chess383;

import java.util.ArrayList;
import java.util.List;

public class Hectoc {
    
    public NumberCombinations getNumbers( String digits ) {
        return new NumberCombinations(digits).createNumbers();
    }

    public void getMatches( NumberCombinations puzzle) {
        for( List<Integer> combination : puzzle.getNumbers() ) {
            new OperationTree( wrap(combination), "initial" ).operate();
        }
    }

    private List<Double> wrap( List<Integer> combination ) {
        List<Double> result = new ArrayList<>( combination.size() );
        for( Integer element : combination ) {
            result.add( Double.valueOf( element ));
        }
        return result;
    }

    public static void create( String digits ) {
        Hectoc hectoc = new Hectoc();
        NumberCombinations puzzle = hectoc.getNumbers( digits );
        hectoc.getMatches(puzzle);
    }
}
