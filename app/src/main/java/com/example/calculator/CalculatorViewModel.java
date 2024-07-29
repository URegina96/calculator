package com.example.calculator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalculatorViewModel extends ViewModel {
    private String currentInput = ""; // Хранит текущий ввод пользователя
    private String previousInput = ""; // Хранит предыдущее значение ввода
    private String operator = ""; // Хранит оператор (например, "+", "-", "*", "/")
    private MutableLiveData<String> display = new MutableLiveData<>("0"); // MutableLiveData для отображения значения калькулятора

    public LiveData<String> getDisplay() {
        return display; // Возвращает LiveData для вывода на экран
    }

    public void appendToInput(String value) {
        if (value.equals(".") && currentInput.contains(".")) {
            return; // Предотвращаем добавление нескольких точек в одно число
        }

        // Если текущий ввод "0", заменяем его на новое значение (если это не "0"), чтобы избежать ввода вида "00"
        if (currentInput.equals("0") && !value.equals(".")) {
            currentInput = value; // Устанавливаем новое значение как текущее
        } else {
            currentInput += value; // В противном случае добавляем новое значение к текущему
        }
        display.setValue(currentInput); // Обновляем отображаемое значение
    }

    public void setOperator(String op) {
        if (!currentInput.isEmpty()) {
            if (!previousInput.isEmpty()) {
                calculateResult(); // Вычисляем предыдущий результат, если он существует
            }
            operator = op; // Устанавливаем новый оператор
            previousInput = currentInput; // Обновляем previousInput на текущее значение
            currentInput = ""; // Сбрасываем currentInput для нового ввода
        } else if (!previousInput.isEmpty()) {
            operator = op; // Устанавливаем оператор, если предыдущий результат доступен
        }
    }

    public void calculateResult() {
        if (!previousInput.isEmpty() && !currentInput.isEmpty() && !operator.isEmpty()) {
            try {
                double num1 = Double.parseDouble(previousInput); // Преобразуем предыдущий ввод в число
                double num2 = Double.parseDouble(currentInput); // Преобразуем текущий ввод в число
                double result = 0; // Переменная для хранения результата вычислений
                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            display.setValue("Error"); // Ошибка деления на 0
                            return; // Прерываем выполнение, чтобы избежать дальнейших вычислений
                        } else {
                            result = num1 / num2; // Деление
                        }
                        break;
                }

                operator = ""; // Сбрасываем оператор после вычисления
                display.setValue(formatResult(result)); // Форматируем результат и обновляем отображаемое значение
                previousInput = String.valueOf(result); // Сохраняем результат в previousInput для дальнейших операций
                currentInput = ""; // Очищаем currentInput, чтобы начать новый ввод
            } catch (NumberFormatException e) {
                display.setValue("Invalid input"); // Обрабатываем ошибку неверного формата ввода
            }
        }
    }

    private String formatResult(double value) {
        if (value % 1 == 0) {
            return String.format("%.0f", value); // Форматируем результат как целое число
        } else {
            return String.format("%.2f", value); // Форматируем результат с двумя знаками после запятой
        }
    }

    public void clearInput() {
        currentInput = ""; // Очищаем текущий ввод
        previousInput = ""; // Очищаем предыдущее значение
        operator = ""; // Очищаем оператор
        display.setValue("0"); // Устанавливаем отображаемое значение в "0"
    }
}
