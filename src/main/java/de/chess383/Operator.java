package de.chess383;

public enum Operator {

    ADD,

    SUB         { @Override public String toString() { return "SUB"; }
                  @Override public Double operate( Double left, Double right ) { return( left - right ); } },

    MUL         { @Override public String toString() { return "MUL"; }
                  @Override public Double operate( Double left, Double right ) { return( left * right ); } },

    DIV         { @Override public String toString() { return "DIV"; }
                  @Override public Double operate( Double left, Double right ) { return( left / right ); } },

    POW         { @Override public String toString() { return "POW"; }
                  @Override public Double operate( Double left, Double right ) { return( (left == 1.0) ? 1.0 : Math.pow(left, right )); } };


    public String toString() { return "ADD"; }
    public Double operate( Double left, Double right ) { return( left + right ); }
}
