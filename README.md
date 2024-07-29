
# 📱 Простое мобильное приложение-калькулятор

## ✨ Описание
Это простое мобильное приложение-калькулятор, разработанное на языке Java с использованием Android Studio и архитектурного компонента ViewModel. Приложение предназначено как учебное пособие для начинающих разработчиков, которые хотят изучить основы Android-разработки.

Калькулятор предоставляет базовые функции, такие как сложение, вычитание, умножение и деление. Код приложения снабжен подробными комментариями, что делает его идеальным отправной точкой для дальнейшего изучения и доработки.

![Скриншот калькулятора](app/src/main/res/drawable/calculator.png) <!-- Замените URL_для_вашей_картинки на ссылку на изображение вашего калькулятора -->

## 🎨 Дизайн
Приложение имеет минималистичный интерфейс с простым дизайном. Вот код разметки основного интерфейса:

```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp">

    <TextView
        android:id="@+id/resultTextView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_marginBottom="24dp"
        android:textSize="32sp"
        android:background="#E7E7E7"
        android:padding="16dp"
        android:gravity="end"
        android:text="0" />

    <GridLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/resultTextView"
        android:columnCount="4"
        android:rowCount="5"
        android:layout_marginTop="16dp">
        <!-- Кнопки калькулятора -->
        ...
    </GridLayout>
</RelativeLayout>
```

## ⚙️ Функциональность
Калькулятор поддерживает следующие операции:
- ➕ Сложение (+)
- ➖ Вычитание (−)
- ✖️ Умножение (×)
- ➗ Деление (÷)
- ❌ Очистка (C)
- ✔️ Результат (=)

## 🚀 Установка и запуск
1. Клонируйте репозиторий:
   ```
   git clone https://github.com/URegina96/calculator.git
   ```
2. Откройте проект в Android Studio.
3. Запустите приложение на эмуляторе или реальном устройстве.

## 🛠️ Как использовать
Приложение интуитивно понятно. Просто нажмите на кнопки с числами и операциями, чтобы выполнять математические расчеты. Результат будет отображаться в верхней части экрана.

## 📝 Заключение
Вы можете использовать данный проект как основу для дальнейших разработок и улучшений. Добавляйте новые функции, улучшайте интерфейс и делитесь своими изменениями!

