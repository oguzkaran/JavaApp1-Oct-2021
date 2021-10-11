package org.csystem.application.product;

import org.csystem.application.product.data.entity.Product;
import org.csystem.application.product.data.repository.ProductRepository;
import org.csystem.util.Console;

public class SimpleProductConsoleAppMenu {
    private final ProductRepository m_productRepository;

    private static void displayMenu()
    {
        Console.writeLine("1.Ürün ekle");
        Console.writeLine("2.En pahalı ürün");
        Console.writeLine("3.En ucuz ürün");
        Console.writeLine("4.Kar-zarar");
        Console.writeLine("5.Çıkış");
        Console.write("Seçenek:");
    }

    private void doWorkForInsert()
    {
        if (!m_productRepository.isAvailable()) {
            Console.writeLine("Artık ürün ekleyemezsiniz");
            return;
        }
        var name = Console.read("Ürün adını giriniz");
        var code = Console.read("Ürün kodunu giriniz:");
        var stock = Console.readDouble("Stok miktarını giriniz:");
        var cost = Console.readBigDecimal("Alış fiyatını giriniz:");
        var unitPrice = Console.readBigDecimal("Satış fiyatını giriniz");

        m_productRepository.save(new Product(0, code, name, stock, cost, unitPrice));
        Console.writeLine("Ürün başarıyla eklendi");
    }

    private void doWorkForExpensiveProduct()
    {
        var product = m_productRepository.findExpensive();

        if (product != null)
            Console.writeLine("En pahalı ürün:%s", product.getName());
        else
            Console.writeLine("Hiç ürün eklenmedi");
    }

    private void doWorkForCheapProduct()
    {
        var product = m_productRepository.findCheap();

        if (product != null)
            Console.writeLine("En ucuz ürün:%s", product.getName());
        else
            Console.writeLine("Hiç ürün eklenmedi");
    }

    private void doWorkForStatus()
    {
        var result = m_productRepository.findTotal();

        Console.writeLine("Kar-zarar durumu:%s", result);
    }

    private void doWorkForExit()
    {
        Console.writeLine("C ve Sistem Programcıları derneği");
        Console.writeLine("Tekrar yapıyor musunuz?");
        System.exit(0);
    }

    private void doWorkForOption(int option) // Menu işlemleri fonksiyonel programlama ile daha farklı yapılacaktır
    {
        switch (option) {
            case 1:
                doWorkForInsert();
                break;
            case 2:
                doWorkForExpensiveProduct();
                break;
            case 3:
                doWorkForCheapProduct();
                break;
            case 4:
                doWorkForStatus();
                break;
            case 5:
                doWorkForExit();
                break;
            default:
                Console.writeLine("Geçersiz seçenek");
        }
    }

    public SimpleProductConsoleAppMenu()
    {
        Console.writeLine("C ve Sistem Programcıları derneği");
        var n = Console.readUInt("Kaç tane ürün olsun?");
        m_productRepository = new ProductRepository(n);
    }

    public void run()
    {
        for (;;) {
            displayMenu();
            doWorkForOption(Console.readUInt());
        }
    }
}
