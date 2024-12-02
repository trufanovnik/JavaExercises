package UndoableStringBuilder;

import java.util.Stack;

public class UndoableStringBuilder {
    //делегат
    private StringBuilder stringBuilder;

    //сюда будут падать все вызываемые методы в прямом порядке (стек же)
    private Stack<Command> history;

    private interface Command{
        void undo();
    }

    UndoableStringBuilder(){
        stringBuilder = new StringBuilder();
        history = new Stack<>();
    }

    public UndoableStringBuilder reverse(){
        //при вызове reverse у нашего sb под капотом будет работать обычный sb с известным ему методом reverse
        stringBuilder.reverse();

        /*внутрь метода reverse запихиваем не только его реализацию через делегата
        но реализацию метода undo, чтобы потом, когда мы достали из стека последнюю команду - тут reverse
        мы смогл сразу сделать .undo к ней и реализовать обратное действие
        ==================================================================
        по сути ниже мы могли создать абстрактный метод, заимплементить ему интерфейс Command
        а потом реализовать @Override для метода undo в нем через анонимный класс
        но текущая реализация сразу создает анонимный класс с @Override нашего метода
        далее см. на history.add*/

        Command command = new Command() {
            @Override
            public void undo() {
                stringBuilder.reverse();
            }
        };
        //так как чуть выше мы якобы создали класс (анонимный)
        //в стек мы кладем этот анонимный класс у которого есть метод undo
        //который конкретно для этого анонимного, уникального класса делает снова reverse
        //то есть обратное тому методу, в котором этот класс создан
        //после того как мы скажем стеку: извлеки последнюю записаь у себя
        //он вернет нам класс, который может реализовать undo именно методом reverse
        history.add(command);

        return this;
    }
    public UndoableStringBuilder delete(int start, int end){
        String deletedStr = stringBuilder.substring(start, end);
        stringBuilder.delete(start, end);
        Command command = new Command() {
            @Override
            public void undo() {
                stringBuilder.insert(start, deletedStr);
            }
        };
        history.add(command);
        return this;
    }
    public UndoableStringBuilder append(Object obj){
        stringBuilder.append(obj);
        Command command = new Command() {
            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - obj.toString().length(), stringBuilder.length());
            }
        };
        history.add(command);
        return this;
    }

    public void undo(){
        if (!history.isEmpty()){
            Command command = history.pop();
            command.undo();
        }
    }
    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}

class MainApp{
    public static void main(String[] args) {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("Hello");
        System.out.println(usb); // Hello
        usb.append(" World");
        System.out.println(usb); // Hello World
        usb.delete(5, 11);
        System.out.println(usb); // Hello
        usb.undo();
        System.out.println(usb); // Hello World
        usb.reverse();
        System.out.println(usb); // dlroW olleH
        usb.undo();
        System.out.println(usb); // Hello World
    }
}
