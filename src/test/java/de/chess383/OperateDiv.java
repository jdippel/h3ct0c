
/*
 *  OperateDiv.java
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
 * The class OperateDiv implements an upper tester
 * </p>
 */
@DisplayName("the public method operateDIV() for class OperationTree is tested")
public class OperateDiv {

    @ParameterizedTest( name = "given an input list of double values: {0} there will be the direct derivation: {1}" )
    @MethodSource("listAndStringProvider")
    void testWithMultiArgMethodSource( List<Double> list, String derivation ) {

    	OperationTree tree = new OperationTree(list, "initial");
    	tree.operateDIV(0);
    	assertThat( derivation ).as( "combinations should match" ).isEqualTo(tree.toString());
    }

    static Stream<Arguments> listAndStringProvider() {
        return Stream.of(
            
            Arguments.of( Arrays.asList( 6.0, 0.0 ), "[ ( DIV 6,000 0,000 = Infinity ) ]  initial" )
          , Arguments.of( Arrays.asList( 6.0, 1.0 ), "[ ( DIV 6,000 1,000 = 6,000 ) ]  initial" )
        );
    }
   
}

