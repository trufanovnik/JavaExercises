import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class FillTable extends DBconnection{
    private static int id;
    private static String nickname;
    private static String game;

    private static void getFieldsFromClass() throws NoSuchMethodException {
        try {
            Class<?> gamersClass = Gamers.class;
            Object gamer = gamersClass.getConstructor(int.class, String.class, String.class)
                    .newInstance(5, "Bob", "Pubg");

            Field idField = gamersClass.getDeclaredField("id");
            Field nicknameField = gamersClass.getDeclaredField("nickname");
            Field gameField = gamersClass.getDeclaredField("game");

            idField.setAccessible(true);
            nicknameField.setAccessible(true);
            gameField.setAccessible(true);

            id = idField.getInt(gamer);
            nickname = (String) nicknameField.get(gamer);
            game = (String) gameField.get(gamer);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
//    private static void fillTableWithFields(){
//
//    }

//    public static void main(String[] args) throws NoSuchMethodException {
//        getFieldsFromClass();
//        System.out.println(id + " " + nickname + " " + game);
//    }
}
