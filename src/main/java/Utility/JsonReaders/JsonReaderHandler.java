package Utility.JsonReaders;

import Interfaces.Serializer;

public class JsonReaderHandler {

    Serializer serializer;

    public JsonReaderHandler(Serializer serializer){
        this.serializer=serializer;
    }

    public void serialize(){
        serializer.serialize();
    }



}
