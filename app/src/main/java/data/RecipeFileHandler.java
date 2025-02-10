package data;

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class RecipeFileHandler {
    private String filePath;

    public RecipeFileHandler() {
        filePath = "app/src/main/resources/recipes.txt";
    }

    public RecipeFileHandler(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 設問1: 一覧表示機能
     * recipes.txtからレシピデータを読み込み、それをリスト形式で返します。 <br> 
     * IOExceptionが発生したときは<i>Error reading file: 例外のメッセージ</i>とコンソールに表示します。
     *
     * @return レシピデータ
     */
    public ArrayList<String> readRecipes() {
        /*
         * recipes.txtからレシピデータを読み込むため例外処理を行う
         * recipes.txtから１行ごとにデータを読み込み配列に追加
         * 追加した配列を呼び出し元に戻す
         * テキストデータ読み込みの際に例外が発生した場合は例外メッセージを出力
         */
        try (BufferedReader reader = new BufferedReader(new FileReader(this.filePath))) {
            String line = "";
            ArrayList<String> lines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                // System.out.println(line);
                lines.add(line);
            }
            return lines;
                
                
                
            } catch (IOException e) {
                System.out.println("Error reading file:" + e.getMessage());
            }
            return null;
        }

    /**
     * 設問2: 新規登録機能
     * 新しいレシピをrecipes.txtに追加します。<br>
     * レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
     *
     * @param recipeName レシピ名
     * @param ingredients 材料名
     */
     // 
    public void addRecipe(String recipeName, String ingredients) {
        /*
         * レシピ名、材料名を引数で受け取る
         * 受け取った値をrecipes.txtに追記する
         * 例外が発生した場合はメッセージを出力
         */
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.filePath, true))) {
            writer.write(recipeName + "," + ingredients);
            writer.newLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
