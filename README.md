# Yo‘lchi — Android ilova

Haydovchilik guvohnomasi imtihoniga tayyorgarlik ilovasi (oflayn ishlaydi).

- `app/src/main/assets/www/` — ilovaning o‘zi (HTML, ovozli darslar, shriftlar).
- `app/src/main/java/.../MainActivity.java` — WebView qobig‘i: orqaga tugmasi, fayl tanlash, tizim panellari.
- `.github/workflows/android.yml` — GitHub Actions har push’da test APK yig‘adi va `dist/yolchi-test.apk` ga saqlaydi.

## Play Market uchun imzolangan AAB
Repozitoriyaning **Settings → Secrets and variables → Actions** bo‘limiga 4 ta secret qo‘shing:

| Secret | Qiymati |
|---|---|
| `YOLCHI_KEYSTORE_BASE64` | upload kalit faylining base64 ko‘rinishi |
| `YOLCHI_KEYSTORE_PASSWORD` | kalit ombori paroli |
| `YOLCHI_KEY_ALIAS` | kalit nomi (alias) |
| `YOLCHI_KEY_PASSWORD` | kalit paroli |

Shundan keyin har bir build `dist/yolchi-release.aab` faylini ham yaratadi — uni Play Console’ga yuklaysiz.
Kalit faylini hech qachon repozitoriyaga qo‘shmang va zaxira nusxasini saqlang.
