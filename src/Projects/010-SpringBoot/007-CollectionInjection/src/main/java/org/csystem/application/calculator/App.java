/*
Açıklamalar
	Örnek sadece konuyu anlatmak amaçlıdır
	Bazı sınıfların tasarımı daha genel yapılabilir. Ancak gözardı edilebilir
	Birçok sınıfın bir jar dosyasından geldiği fikriyle düşününüz
	Senaryonun detayından çok tasarımına odaklanınız
 */

package org.csystem.application.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
	public static void main(String[] args)
	{
		SpringApplication.run(App.class, args);
	}
}
