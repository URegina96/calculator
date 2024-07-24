package com.example.calculator; // Указываем пакет, к которому принадлежит класс

import android.os.Bundle; // Импортируем класс Bundle для передачи данных между Activities
import android.view.View; // Импортируем класс View для работы с элементами интерфейса
import android.widget.Button; // Импортируем класс Button для работы с кнопками
import android.widget.TextView; // Импортируем класс TextView для работы с текстовыми полями
import androidx.appcompat.app.AppCompatActivity; // Импортируем базовый класс для создания Activities с ActionBar

public class MainActivity extends AppCompatActivity { // Основной класс приложения, наследует от AppCompatActivity

    private TextView resultTextView; // Текстовое поле, отображающее результат вычислений
    private String currentInput = ""; // Строка для хранения текущего ввода пользователя
    private String previousInput = ""; // Строка для хранения предыдущего ввода
    private String operator = ""; // Строка для хранения оператора (например, +, -, *, /)

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Метод вызывается при создании активности
        super.onCreate(savedInstanceState); // Вызов метода родителя
        setContentView(R.layout.activity_main); // Устанавливаем макет интерфейса для этой активности

        resultTextView = findViewById(R.id.resultTextView); // Находим элемент TextView по его идентификатору

        // Инициализация кнопок
        Button button1 = findViewById(R.id.button1); // Находим кнопку "1"
        Button button2 = findViewById(R.id.button2); // Находим кнопку "2"
        Button button3 = findViewById(R.id.button3); // Находим кнопку "3"
        Button button4 = findViewById(R.id.button4); // Находим кнопку "4"
        Button button5 = findViewById(R.id.button5); // Находим кнопку "5"
        Button button6 = findViewById(R.id.button6); // Находим кнопку "6"
        Button button7 = findViewById(R.id.button7); // Находим кнопку "7"
        Button button8 = findViewById(R.id.button8); // Находим кнопку "8"
        Button button9 = findViewById(R.id.button9); // Находим кнопку "9"
        Button button0 = findViewById(R.id.button0); // Находим кнопку "0"
        Button buttonPlus = findViewById(R.id.buttonPlus); // Находим кнопку "+"
        Button buttonMinus = findViewById(R.id.buttonMinus); // Находим кнопку "-"
        Button buttonMultiply = findViewById(R.id.buttonMultiply); // Находим кнопку "*"
        Button buttonDivide = findViewById(R.id.buttonDivide); // Находим кнопку "/"
        Button buttonEqual = findViewById(R.id.buttonEqual); // Находим кнопку "="
        Button buttonClear = findViewById(R.id.buttonClear); // Находим кнопку "C"

        // Установка слушателей на кнопки
        button1.setOnClickListener(view -> appendToInput("1")); // При нажатии добавляем "1" к текущему вводу
        button2.setOnClickListener(view -> appendToInput("2")); // При нажатии добавляем "2" к текущему вводу
        button3.setOnClickListener(view -> appendToInput("3")); // При нажатии добавляем "3" к текущему вводу
        button4.setOnClickListener(view -> appendToInput("4")); // При нажатии добавляем "4" к текущему вводу
        button5.setOnClickListener(view -> appendToInput("5")); // При нажатии добавляем "5" к текущему вводу
        button6.setOnClickListener(view -> appendToInput("6")); // При нажатии добавляем "6" к текущему вводу
        button7.setOnClickListener(view -> appendToInput("7")); // При нажатии добавляем "7" к текущему вводу
        button8.setOnClickListener(view -> appendToInput("8")); // При нажатии добавляем "8" к текущему вводу
        button9.setOnClickListener(view -> appendToInput("9")); // При нажатии добавляем "9" к текущему вводу
        button0.setOnClickListener(view -> appendToInput("0")); // При нажатии добавляем "0" к текущему вводу

        buttonPlus.setOnClickListener(view -> setOperator("+")); // Устанавливаем оператор "+" при нажатии
        buttonMinus.setOnClickListener(view -> setOperator("-")); // Устанавливаем оператор "-" при нажатии
        buttonMultiply.setOnClickListener(view -> setOperator("*")); // Устанавливаем оператор "*" при нажатии
        buttonDivide.setOnClickListener(view -> setOperator("/")); // Устанавливаем оператор "/" при нажатии

        buttonEqual.setOnClickListener(view -> calculateResult()); // Вычисляем результат при нажатии "="
        buttonClear.setOnClickListener(view -> clearInput()); // Очищаем ввод при нажатии "C"
    }

    private void appendToInput(String value) { // Метод для добавления значения к текущему вводу
        currentInput += value; // Добавляем значение к текущему вводу
        resultTextView.setText(currentInput); // Обновляем текстовое поле для отображения нового ввода
    }

    private void setOperator(String op) { // Метод для установки оператора
        if (!currentInput.isEmpty()) { // Проверяем, не пустой ли текущий ввод
            previousInput = currentInput; // Сохраняем текущий ввод как предыдущий
            operator = op; // Устанавливаем оператор
            currentInput = ""; // Очищаем текущий ввод для следующего числа
        }
    }

    private void calculateResult() { // Метод для вычисления результата
        if (!previousInput.isEmpty() && !currentInput.isEmpty() && !operator.isEmpty()) { // Проверяем, что все необходимые данные введены
            double num1 = Double.parseDouble(previousInput); // Преобразуем предыдущий ввод в число
            double num2 = Double.parseDouble(currentInput); // Преобразуем текущий ввод в число
            double result = 0; // Переменная для хранения результата

            switch (operator) { // Определяем, какой оператор был выбран
                case "+": // Если оператор "+"
                    result = num1 + num2; // Считаем сумму
                    break; // Выходим из switch
                case "-": // Если оператор "-"
                    result = num1 - num2; // Считаем разность
                    break; // Выходим из switch
                case "*": // Если оператор "*"
                    result = num1 * num2; // Считаем произведение
                    break; // Выходим из switch
                case "/": // Если оператор "/"
                    if (num2 != 0) { // Проверяем, не делим ли мы на ноль
                        result = num1 / num2; // Считаем частное
                    } else { // Если делим на ноль
                        resultTextView.setText("Error"); // Отображаем ошибку
                        return; // Завершаем выполнение метода
                    }
                    break; // Выходим из switch
            }
            resultTextView.setText(String.valueOf(result)); // Отображаем результат в текстовом поле
            currentInput = ""; // Очищаем текущий ввод
            previousInput = ""; // Очищаем предыдущий ввод
            operator = ""; // Очищаем оператор
        }
    }

    private void clearInput() { // Метод для очистки всего ввода и отображения
        currentInput = ""; // Очищаем текущий ввод
        previousInput = ""; // Очищаем предыдущий ввод
        operator = ""; // Очищаем оператор
        resultTextView.setText("0"); // Устанавливаем текстовое поле в значение "0"
    }
}
