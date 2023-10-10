/*
 *  GetNumbers.java
 */

package de.chess383;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


/**
 * <p>
 * The class GetNumbers implements an upper tester
 * </p>
 */
@DisplayName("the public method getNumbers() for class Hectoc is tested")
public class GetNumbers {

    @ParameterizedTest( name = "given an input string of digits: {0} there will be combinations of numbers to be calculated: {1}" )
    @MethodSource("stringAndListProvider")
    void testWithMultiArgMethodSource( String puzzle, int expectedResultListSize ) {
    	assertThat( expectedResultListSize ).as( "combinations should match" ).isEqualTo(new Hectoc().getNumbers(puzzle).getNumbers().size());
    }

    static Stream<Arguments> stringAndListProvider() {
        return Stream.of(
            
            Arguments.of( "987654", 31 )
        );
    }
   
}

