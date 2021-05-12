package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Gameactivity extends AppCompatActivity {

    Button buttonback1;
    private Game game;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        buttonback1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tableLayout = findViewById(R.id.tableLayout);
        buildGameField(); // создание игрового поля
    }
    private TableLayout tableLayout;
    private Button[][] buttons = new Button[3][3];
    private void buildGameField()
    {
        Square[][] field = game.getField();
        for (int i = 0, lenI = field.length; i < lenI; i++ ) {
            TableRow row = new TableRow(this); // создание строки таблицы
            for (int j = 0, lenJ = field[i].length; j < lenJ; j++)
            {
                Button button = new Button(this);
                buttons[i][j] = button;

                row.addView(button, new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT)); // добавление кнопки в строку таблицы
                button.setWidth(160);
                button.setHeight(160);
            }
            tableLayout.addView(row,
                    new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                            TableLayout.LayoutParams.WRAP_CONTENT)); // добавление строки в таблицу
        }
    }
}

