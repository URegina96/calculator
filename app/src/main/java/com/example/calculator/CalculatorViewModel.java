package com.example.calculator; // Указываем пакет, к которому принадлежит данный класс

import androidx.lifecycle.ViewModel; // Импортируем класс ViewModel из библиотеки Android Architecture Components

// Определяем класс CalculatorViewModel, который наследует функциональность от ViewModel
public class CalculatorViewModel extends ViewModel {
    private String currentInput = ""; // Хранит текущий ввод пользователя (например, цифры, которые вводит пользователь)
    private String previousInput = ""; // Хранит предыдущий ввод пользователя (например, число перед операцией)
    private String operator = ""; // Хранит оператор, который выбран пользователем (например, +, -, *, /)
    private String result = ""; // Хранит результат вычислений
    // Метод для получения текущего ввода
    public String getCurrentInput() {
        return currentInput; // Возвращаем текущее значение currentInput
    }

    // Метод для установки значения текущего ввода
    public void setCurrentInput(String currentInput) {
        this.currentInput = currentInput; // Устанавливаем новое значение для currentInput
    }

    // Метод для получения предыдущего ввода
    public String getPreviousInput() {
        return previousInput; // Возвращаем текущее значение previousInput
    }

    // Метод для установки значения предыдущего ввода
    public void setPreviousInput(String previousInput) {
        this.previousInput = previousInput; // Устанавливаем новое значение для previousInput
    }

    // Метод для получения оператора
    public String getOperator() {
        return operator; // Возвращаем текущее значение operator
    }

    // Метод для установки значения оператора
    public void setOperator(String operator) {
        this.operator = operator; // Устанавливаем новое значение для operator
    }

    public String getResult() {
        return result; // Метод для получения результата
    }

    public void setResult(String result) {
        this.result = result; // Устанавливаем новое значение для результата
    }
}

