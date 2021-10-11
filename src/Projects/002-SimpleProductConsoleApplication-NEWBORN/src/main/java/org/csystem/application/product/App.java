/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Aşağıda açıklanan Product isimli sınıfı yazınız:
	Açıklama: Product sınıfı aşağıdaki elemanlara sahip olacaktır:
	- Ürün id'si (int türden olabilir)
	- Ürün kodu
	- Ürün adı
	- Ürün stoktaki miktarı
	- Ürün alış fiyatı
	- Ürün satış fiyatı

	Yukarıdaki sınıfa göre aşağıdaki işlemleri yapabilen basit bir menu uygulamasını yazınız:
	- Program içerisinde önce toplam kaç ürün eklenebileceği sorulacaktır
	- En fazla, belirlenen sayı kadar ürün eklenebilecektir
	- Ekle menüsünde ürün eklenecektir
	- En pahalı ürün menüsünde en pahalı ürün gösterilecektir
	- En ucuz ürün menüsünde en ucuz ürün gösterilecektir
	- Kar-zarar menüsünde tüm ürünler satıldığındaki kar-zarar durumu gösterilecektir. Bu menüde stokta bulunmayan
	ürünler dikkate alınmayacaktır
	- Programda exception durumları ele alınmayacaktır
	- Program şu ana kadar gördüklerimiz gözönünen alınarak yazılacaktır
	- İleride arada servis katmanı da eklenecektir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.application.product;

public class App {
    public static void main(String[] args)
    {
        SimpleProductConsoleApp.run();
    }
}
