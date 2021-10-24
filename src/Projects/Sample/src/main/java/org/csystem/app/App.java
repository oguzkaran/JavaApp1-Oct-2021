/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte metot kandisini hep 1(bir) eksik değerle çağırmaktadır. Parametre değişkeni olan n sıfır değerine
    geldiğinde artık kendini çağırma işlemi sonlanmış ve çıkış süreci başlamıştır. Dikkat edilirse aşağıdaki ömrnekte bir
    tek foo(0) çağrısı return deyiminden dolayı sonlanır. Diğerleri ilgili çağrılar sonlandığından dolayı akışın *** ile
    belirtilen deyime gelmesi ve bu deyimin çalıştırılması sonrasında sonlanır.Örnekte foo(0) çağrısı için "Çıkış:0"
    yazısının ekrana basılmadığına dikkat ediniz. Örneğin ekran çıktısı:
    Giriş:3
    Giriş:2
    Giriş:1
    Giriş:0
    Çıkış:1
    Çıkış:2
    Çıkış:3
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.recursion.test.RecursiveFibonacciNumberTest;

class App {
    public static void main(String[] args)
    {
        RecursiveFibonacciNumberTest.run();
    }
}

