package de.chess383;

import java.util.ArrayList;
import java.util.List;

public class OperationTree {

    private List<Double> input;

    private String description;

    public OperationTree( List<Double> numbers, String description ) {
        this.input = numbers;
        this.description = description;
    }

    public void operate() {
        if( input.size() == 1 ) {
            if( input.get(0) < 100.001 && input.get(0) > 99.999 ) {
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
                operateDIV(cursor);
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
                operator.toString(), this.input.get(operatorCursor), this.input.get(operatorCursor+1), operationValue ));

        int numberOfNumbers = this.input.size();
        for( int cursor=operatorCursor+2; cursor<numberOfNumbers; cursor++) {
            list.add(this.input.get(cursor));
            builder.append( this.input.get(cursor) ).append( " " );
        }
        builder.append( "]  " );
        builder.append(this.description);

        new OperationTree( list, builder.toString()).operate();
    }

    private void operateADD(int operatorCursor) {
        operateOP(operatorCursor, Operator.ADD );
    }

    private void operateSUB(int operatorCursor) {
        operateOP(operatorCursor, Operator.SUB );
    }

    private void operateMUL(int operatorCursor) {
        operateOP(operatorCursor, Operator.MUL );
    }

    private void operateDIV(int operatorCursor) {
        operateOP(operatorCursor, Operator.DIV );
    }
    private void operatePOW(int operatorCursor) {
        operateOP(operatorCursor, Operator.POW );
    }
}
