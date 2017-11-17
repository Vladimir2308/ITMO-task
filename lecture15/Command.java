package lecture15;

import java.io.*;

public class Command implements Externalizable {
    private String text;
    private Object obj;

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Command() {
        this("");
    }

    public Command(String text) {
        this.text = text;
        this.obj = obj;

    }

    public String getText() {
        return text;
    }

    public Object getObj() {
        return obj;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(text);
        out.writeObject(obj);
    }

    @Override
    public String toString() {
        return "Command{" +
                "text='" + text + '\'' +
                ", obj=" + obj +
                '}';
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        text = (String) in.readObject();
        obj = in.readObject();
    }
}
