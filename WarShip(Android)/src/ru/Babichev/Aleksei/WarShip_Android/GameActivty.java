package ru.Babichev.Aleksei.WarShip_Android;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;
import ru.Babichev.Aleksei.WarShip_Android.game.ConstParam;
import ru.Babichev.Aleksei.WarShip_Android.game.WarShipMain;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 13.11.13
 * Time: 4:11
 * To change this template use File | Settings | File Templates.
 */
public class GameActivty extends Activity {

    int shotResult;
    TextView logs;

    private Button[][] arrCells = new Button[ConstParam.GRID_LENGTH][ConstParam.GRID_LENGTH];
    WarShipMain game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
        TableLayout warField = (TableLayout) findViewById(R.id.warField);
        warField.setShrinkAllColumns(true);
        warField.setStretchAllColumns(true);
        TableRow[] rows = new TableRow[ConstParam.GRID_LENGTH];
        
        game = new WarShipMain();
        game.setUpGame();
        
        for (int i = 0; i < ConstParam.GRID_LENGTH; i++) {
            rows[i] = new TableRow(this);
            warField.addView(rows[i]);
            for (int j = 0; j < ConstParam.GRID_LENGTH; j++) {
                Button cell = new Button(this);
                cell.setMinimumHeight(cell.getWidth());
                cell.setHeight(cell.getWidth());
                arrCells[i][j] = cell;
                cell.setText(game.getAi().getField().getField()[i][j]);
                cell.setOnTouchListener(cellListener);
                rows[i].addView(cell);

            }
        }

        Button changeViewButton = (Button) findViewById(R.id.changeViewField);
        changeViewButton.setOnClickListener(changeViewFieldListener);

        logs = (TextView) findViewById(R.id.logs);
    }



    View.OnTouchListener cellListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                chekTouchCell(view);
            }
            return false;
        }
    };

    private void chekTouchCell(View view){
        for (int i = 0; i < ConstParam.GRID_LENGTH; i++) {
            for (int j = 0; j < ConstParam.GRID_LENGTH; j++) {
                if (view.equals(arrCells[i][j])){
                    System.out.println("координаты: " + i + " " + j);
                    if(game.isBelongsToTheUserMove()) userStep(i, j);
                    while(!game.isBelongsToTheUserMove()) aiStep();//game.aiShot();
                }
            }
        }
    }

    private void aiStep() {
        int asGuess;
        do {
            asGuess = (int) (Math.random()* ConstParam.GRID_SIZE);
        } while(game.getAi().getGrid()[asGuess] != 0);
        int row = asGuess / ConstParam.GRID_LENGTH;
        int column = asGuess % ConstParam.GRID_LENGTH;
        game.aiShot(row, column);
        showUserFiled();

    }

    private void userStep(int i, int j) {
        shotResult = game.startUserStep(i, j);
        showUserFiled();
        switch (shotResult){
            case 0 : Toast.makeText(this, "мимо", Toast.LENGTH_SHORT).show();
                break;
            case 1 : Toast.makeText(this, "попал", Toast.LENGTH_SHORT).show();
                break;
            case 2 : Toast.makeText(this, "потопил", Toast.LENGTH_SHORT).show();
                break;
            default: Toast.makeText(this, "неизвестная ошибка", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isAiField = true;
    View.OnClickListener changeViewFieldListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (isAiField) {
                showUserFiled();
                isAiField = false;
            } else {
                showAiField();
                isAiField = true;
            }
        }
    };

    private void showAiField() {
        for (int k = 0; k < ConstParam.GRID_LENGTH; k++) {
            for (int l = 0; l < ConstParam.GRID_LENGTH; l++) {
                int asGuess = (k*10)+l;
                if (game.getUser().getField().getField()[k][l].equals("#")) {
                    arrCells[k][l].setEnabled(false);
                    arrCells[k][l].setText("*");
                }
                if (game.getUser().getField().getField()[k][l].equals(".")) arrCells[k][l].setEnabled(false);
                if (game.getUser().getGrid()[asGuess] == 0) arrCells[k][l].setText(" ");
            }
        }
    }

    private void showUserFiled() {
        for (int k = 0; k < ConstParam.GRID_LENGTH; k++) {
            for (int l = 0; l < ConstParam.GRID_LENGTH; l++) {
                int asGuess = (k*10)+l;
                if (game.getAi().getGrid()[asGuess] == 1) {
                    arrCells[k][l].setEnabled(false);
                    arrCells[k][l].setText("*");
                }
                if (game.getAi().getGrid()[asGuess] == 2) arrCells[k][l].setEnabled(false);
                if (game.getAi().getGrid()[asGuess] == 0) {
                    arrCells[k][l].setText(" ");
                    arrCells[k][l].setEnabled(true);
                }
            }
        }
    }
}
