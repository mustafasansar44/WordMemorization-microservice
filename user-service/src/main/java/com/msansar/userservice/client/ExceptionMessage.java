package com.msansar.userservice.client;

public record ExceptionMessage(
        String timestamp, // Hata ne zaman alındı
        int status, // hatanın status kodu
        String error, // feign tarafından alınan hata mesajı
        String message, // benim kendi mikroservisimde kullanıcıya döneceğim mesaj
        String path // Bu hatayı feignClient'in hangi path'ini çağırırken aldım
) {
}
