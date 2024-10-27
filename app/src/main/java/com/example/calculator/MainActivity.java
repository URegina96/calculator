package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView; // Переменная для отображения результата
    private CalculatorViewModel viewModel; // Переменная для ViewModel калькулятора

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Вызов метода родительского класса
        setContentView(R.layout.activity_main); // Устанавливаем макет для активности
        viewModel = new ViewModelProvider(this).get(CalculatorViewModel.class); // Инициализируем ViewModel для работы с данными
        resultTextView = findViewById(R.id.resultTextView); // Находим элемент TextView для отображения результата
        viewModel.getDisplay().observe(this, result -> resultTextView.setText(result));  // Подписываемся на изменения в LiveData и обновляем результат в TextView
        setupButtons();// Настраиваем кнопки калькулятора

        findViewById(R.id.buttonDelete).setOnClickListener(view -> viewModel.deleteLastCharacter());

    }

    private void setupButtons() {
        // Создаем массив кнопок для чисел от 0 до 9
        Button[] numberButtons = new Button[]{
                findViewById(R.id.button0), findViewById(R.id.button1),
                findViewById(R.id.button2), findViewById(R.id.button3),
                findViewById(R.id.button4), findViewById(R.id.button5),
                findViewById(R.id.button6), findViewById(R.id.button7),
                findViewById(R.id.button8), findViewById(R.id.button9)
        };

        // Настраиваем обработчик нажатия для каждой кнопки с числом
        for (int i = 0; i < numberButtons.length; i++) {
            final String value = String.valueOf(i); // Преобразуем индекс в строку
            // Устанавливаем слушатель нажатий, который передает число в ViewModel
            numberButtons[i].setOnClickListener(view -> viewModel.appendToInput(value));
        }

        // Устанавливаем обработчики нажатий для кнопок операций
        findViewById(R.id.buttonPlus).setOnClickListener(view -> viewModel.setOperator("+")); // Сложение
        findViewById(R.id.buttonMinus).setOnClickListener(view -> viewModel.setOperator("-")); // Вычитание
        findViewById(R.id.buttonMultiply).setOnClickListener(view -> viewModel.setOperator("*")); // Умножение
        findViewById(R.id.buttonDivide).setOnClickListener(view -> viewModel.setOperator("/")); // Деление

        // Устанавливаем слушатель для кнопки равно, который вычисляет результат
        findViewById(R.id.buttonEqual).setOnClickListener(view -> viewModel.calculateResult());
        // Устанавливаем слушатель для кнопки очистки, который очищает ввод
        findViewById(R.id.buttonClear).setOnClickListener(view -> viewModel.clearInput());

        // Устанавливаем слушатель для кнопки точки, которая добавляет точку к вводу
        findViewById(R.id.buttonDot).setOnClickListener(view -> viewModel.appendToInput("."));
    }
}
