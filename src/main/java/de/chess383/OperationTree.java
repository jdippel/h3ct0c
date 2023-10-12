package de.chess383;

import java.util.ArrayList;
import java.util.List;

public class OperationTree {

    static private String lastDescription = "";    // only for testing

    private final List<Double> input;

    private final String description;

    public OperationTree( List<Double> numbers, String description) {
        this.input = numbers;
        this.description = description;
    }

    private boolean deltaDouble( Double value ) {
        return value > -0.005 && value < 0.005;
    }

    public void operate() {
        if( input.size() == 1 ) {
            if( deltaDouble(input.get(0) - 100.0 )) {
                System.out.println("Match: 100 - " + description);
            }
        }
        else {
            int numberOfNumbers = input.size();
            int cursor = 0;
            while( cursor + 1 < numberOfNumbers ) {
                operateADD(cursor);
                operateSUB(cursor);
                operateMUL(cursor);
                if( ! deltaDouble(this.input.get(cursor+1))) operateDIV(cursor);
                operatePOW(cursor);
                cursor++;
            }
        }
    }

    private void operateOP(int operatorCursor, Operator operator) {
        List<Double> list = new ArrayList<>();
        StringBuffer builder = new StringBuffer( "[ ");
        for( int cursor=0; cursor<operatorCursor; cursor++) {
            list.add(this.input.get(cursor));
            builder.append(this.input.get(cursor) ).append( " " );
        }
        Double operationValue = operator.operate(this.input.get(operatorCursor), this.input.get(operatorCursor+1) );
        list.add( operationValue );
        builder.append( String.format( "( %s %-5.3f %-5.3f = %-5.3f ) ",
                operator, this.input.get(operatorCursor), this.input.get(operatorCursor+1), operationValue ));

        int numberOfNumbers = this.input.size();
        for( int cursor=operatorCursor+2; cursor<numberOfNumbers; cursor++) {
            list.add(this.input.get(cursor));
            builder.append( this.input.get(cursor) ).append( " " );
        }
        builder.append( "]  " );
        builder.append(this.description);
        lastDescription = builder.toString();;

        new OperationTree( list, builder.toString()).operate();
    }

    public void operateADD(int operatorCursor) {
        operateOP(operatorCursor, Operator.ADD );
    }

    public void operateSUB(int operatorCursor) {
        operateOP(operatorCursor, Operator.SUB );
    }

    public void operateMUL(int operatorCursor) {
        operateOP(operatorCursor, Operator.MUL );
    }

    public void operateDIV(int operatorCursor) { operateOP(operatorCursor, Operator.DIV );
    }

    public void operatePOW(int operatorCursor) {
        operateOP(operatorCursor, Operator.POW );
    }

    @Override
    public String toString() {
        return lastDescription;
    }
}
