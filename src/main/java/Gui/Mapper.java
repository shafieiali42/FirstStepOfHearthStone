package Gui;

import Interfaces.Request;

import java.util.ArrayList;
import java.util.Iterator;

public class Mapper {

    private static Mapper mapper = new Mapper();

    public static Mapper getInstance() {
        return mapper;
    }

    private ArrayList<Request> requests;


    private Mapper() {
        requests = new ArrayList<Request>();


    }

    public void executeRequests() {
        for (Iterator<Request> requestIterator = requests.iterator(); requestIterator.hasNext(); ) {
            Request request = requestIterator.next();
            request.execute();
            requestIterator.remove();
        }
    }

    public enum RequestTypes implements Request {

        PLAY_CARDS {
            @Override
            public void execute() {

            }
        },
        END_TURN {
            @Override
            public void execute() {
                endTurn();
            }
        };

         void endTurn() {

        }
    }
}
