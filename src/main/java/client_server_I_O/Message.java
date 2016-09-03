package client_server_I_O;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

public class Message implements Serializable {
    private Queue<Object> parcel = new LinkedList<>();

    public Message(Object ... units){
        for(int i = 0; i < units.length; i++){
            parcel.add(units[i]);
        }
    }

    public void addUnit(Object ... units) {
        for(int i = 0; i < units.length; i++){
            parcel.add(units[i]);
        }
    }

    public Object getUnit() {
        return parcel.poll();
    }
}