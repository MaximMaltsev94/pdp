package pdp.annotations.objects;

import pdp.annotations.custom.NoMoreThanFourFields;

@NoMoreThanFourFields
public class WrongCompileClass {
    private int field1;
    private int field2;
    private int field3;
    private int field4;
    private int field5;
//    private int field6;
}
