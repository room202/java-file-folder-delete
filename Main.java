import java.io.File;

public class Main {

    // フォルダ削除のメインメソッド
    public static void main(String[] args) {

        String folderPath = "target_folder"; // 削除したいフォルダのパスを指定
        File folder = new File(folderPath);

        // フォルダが存在するか確認
        if (deleteFolder(folder)) {
            System.out.println("フォルダを削除しました: " + folderPath);
        } else {
            System.out.println("フォルダの削除に失敗しました: " + folderPath);
        }
    }

    // 再帰的にフォルダと中身を削除するメソッド
    public static boolean deleteFolder(File folder) {
        // フォルダが存在しない場合はfalseを返す
        if (!folder.exists()) {
            return false;
        }

        // フォルダ内のファイルやサブフォルダをすべて削除
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteFolder(file); // 再帰呼び出し
                } else {
                    file.delete();
                }
            }
        }

        // 最後にフォルダ自身を削除
        return folder.delete();
    }
}
