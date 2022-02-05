/*----------------------------------------------------------------------------------------------------------------------
    Class sınıfının getXXXs ve getDeclaredXXXs metotlarının sonunda "s" olmayan versiyonları spwsific bir elemana
    yönelik bilgileri elde etmek için kullanılır. Constructor sınıfının newInstance metodu ile ilgili sınıf türünden
    nesne yaratılabilir. Elemanlara yönelik sınıfların (Method, Field, Constructor vs) setAccessible isimli metotları
    ile eleman erişilebilir duruma getirilebilir. Yani private bir elemana da çalışma zamanı sırasında erişilebilir.
    Method sınıfının invoke isimli metotları ile Method nesnesine ilişkin metot çağrılabilir. Metot çaprıları uygun
    argümanlar ile yapılmalıdır. Aksi durumda exception oluşur. Reflection konusuna ilişkin metotlar genel olarak
    "checked exception" sınıflar türünden nesneler fırlatır. invoke metodunun birinci parametresi metodu çağrıolacak
    sınıfa ilişkin referanstır. static metotlar için bu parametre null geçilir
    ~/Projects/009-CallNonStaticMethodViaReflection örneğini inceleyiniz

    Örnek tamamen durumu anlatmak için yazılmıştır. Detaylar gözardı edilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

class App {
    public static void main(String[] args)
    {
        var cls = Sample.class;

        Console.writeLine("--------------------------------");
        for (var method : cls.getDeclaredMethods())
            Console.writeLine(method.getName());
        Console.writeLine("--------------------------------");

        Console.writeLine("--------------------------------");
        for (var method : cls.getMethods())
            Console.writeLine(method.getName());
        Console.writeLine("--------------------------------");

    }
}


class Sample {
    private void foo(int a)
    {

    }

    public void bar()
    {
    }

    void tar(int a)
    {

    }

    protected void zar(int a)
    {

    }

}


