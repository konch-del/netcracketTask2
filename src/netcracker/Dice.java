package netcracker;

import java.util.ArrayList;
import java.util.Scanner;

public class Dice implements Game{
    private int N;
    private int K;
    private int round = 1; //номер раунда
    private int winner; // переменная для хранения номера победителя
    // таблица, содержащая информацию о количестве выигранных раундов и результатах текущего раунда
    private int[][] table;

    Dice(int N, int K){
        this.N = N;
        this.K = K;
    }
    /*
      Вспомогательная функция, сортирующая таблицу по очкам предыдущего раунда
      и обнуляющая его результаты
    */
    private void sortTable(){
        ArrayList<int[]> newTable = new ArrayList();
        newTable.add(table[winner]);
        table[winner][2] = -2;
        int max = 0;
        int numb = 0;
        while(newTable.size() < N) {
            for (int i = 0; i < N; i++) {
                if (max < table[i][2]) {
                    max = table[i][2];
                    numb = i;
                }
            }
            newTable.add(table[numb]);
            table[numb][2] = -2;
            numb = 0;
            max = 0;
        }
        newTable.toArray(table);
        for (int i = 0; i < N; i++) {
            table[i][2] = 0;
        }
    }
    /*
      Функция, которая начинает игру,
      выводит результаты раунда и победителя в игре
    */
    @Override
    public void startGame(){
        table = new int[N][3];

        for(int i = 1; i <= N;  i++){
            table[i - 1][0] = i;
        }
        Scanner scan = new Scanner(System.in);

        while (table[0][1] != 7) {
            int max = 0;
            int numb = -1;
            System.out.println(round + " раунд");

            for (int i = 0; i < N; i++) {
                if(table[i][0] == N){
                    System.out.println("Ход компьютера");
                    for(int j = 0; j < K; j++) {
                        table[i][2] += 1 + Math.random() * 5;
                    }
                    System.out.println("Очки компьютера: " + table[i][2]);
                    if(table[i][2] > max){
                        max = table[i][2];
                        numb = i;
                    }
                }
                else {
                    System.out.println("Ход " + table[i][0] + " игрока\nВведите 1, чтобы бросить кости");
                    if (scan.nextLine().equals("1")) {
                        for (int j = 0; j < K; j++) {
                            table[i][2] += 1 + Math.random() * 5;
                        }
                        System.out.println("Очки " + table[i][0] + " игрока: " + table[i][2]);
                        if (table[i][2] > max) {
                            max = table[i][2];
                            numb = i;
                        }
                    }
                }
            }

            table[numb][1] ++;
            winner = numb;
            sortTable();
            round++;
            if(table[0][0] == N){
                System.out.println("В раунде выиграл компьютер");
            }
            else{
                System.out.println("В раунде выиграл " + table[0][0] + " игрок");
            }
        }

        for(int i = 0; i < N; i++){
            if(table[i][0] == N){
                System.out.println("Победы компьютера: " + table[i][1]);
            }
            else{
                System.out.println("Победы игрока " + + table[i][0] + ": " + + table[i][1]);
            }
        }

    }
}