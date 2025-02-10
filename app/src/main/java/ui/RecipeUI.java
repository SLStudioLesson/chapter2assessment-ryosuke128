package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

import data.RecipeFileHandler;

public class RecipeUI {
    private BufferedReader reader;
    private RecipeFileHandler fileHandler;

    public RecipeUI() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        fileHandler = new RecipeFileHandler();
    }

    public RecipeUI(BufferedReader reader, RecipeFileHandler fileHandler) {
        this.reader = reader;
        this.fileHandler = fileHandler;
    }

    public void displayMenu() {
        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        // 設問1: 一覧表示機能
                        displayRecipes();
                        break;
                    case "2":
                        // 設問2: 新規登録機能
                        break;
                    case "3":
                        // 設問3: 検索機能
                        break;
                    case "4":
                        System.out.println("Exit the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    /**
     * 設問1: 一覧表示機能
     * RecipeFileHandlerから読み込んだレシピデータを整形してコンソールに表示します。
     */
    private void displayRecipes() {
    /*
     * RecipeFileHandlerのreadRecipesメソッドの呼び出し
     * RecipeFileHandlerから読み込むための例外処理
     * RecipeFileHandlerから読み込んだデータから初めて出現する「,」で区切った前後のデータを
     * recipeNames,Ingredients配列へそれぞれ入れ成形する
     * 読み込んだデータが空の場合はエラーメッセージを出力
     */
        RecipeFileHandler reader = new RecipeFileHandler("app/src/main/resources/recipes.txt");
        ArrayList<String> recipes = reader.readRecipes();
        ArrayList<String> recipeNames = new ArrayList<>();
        ArrayList<String> ingredients = new ArrayList<>();
        if (recipes != null) {
            for (int i = 0; i < recipes.length; i++) {
                String[] recipe = recipes.get(i).split(",", 2);
                recipeNames.add(recipe[0]);
                ingredients.add(recipe[1]);
            }
            System.out.println("Recipes:");
            System.out.println("-----------------------------------");
            for (int i = 0; i < recipeNames.size();i++) {
                System.out.println("Recipe Name: " + recipeNames.get(0));
                System.out.println("Main Ingredients: " + ingredients.get(0));
                System.out.println("-----------------------------------");
            }
        } else {
            System.out.println("No recipes available.");
        }


    }

    /**
     * 設問2: 新規登録機能
     * ユーザーからレシピ名と主な材料を入力させ、RecipeFileHandlerを使用してrecipes.txtに新しいレシピを追加します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void addNewRecipe() throws IOException {

    }

    /**
     * 設問3: 検索機能
     * ユーザーから検索クエリを入力させ、そのクエリに基づいてレシピを検索し、一致するレシピをコンソールに表示します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void searchRecipe() throws IOException {

    }

}

