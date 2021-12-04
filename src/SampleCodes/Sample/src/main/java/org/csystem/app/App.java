/*----------------------------------------------------------------------------------------------------------------------
    "this expression"'ın genel biçimi:
        <sınıf ismi>.this
    şeklindedir. Bu durumda this expression ile kullanılan sınıf türünden referans elde edilmiş olur. Aşağıdaki
    örnekte A.this diyerek B'nin içerisinde gizlice tutulan A referansına erişilmiş olur. Bu A referansı B nesnesinin
    yaratılmasında kullanılan referanstır. Örneği inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

class App {
    public static void main(String[] args)
    {
        var x = new A();
        A.B y = x.new B();

        y.foo();
    }
}

class A {
    //...
    public void foo()
    {
        Console.writeLine("A.foo");
    }

    public class B {
        public void foo()
        {
            A.this.foo();
        }
    }
    //...
}
