package edu.oregonstate.cs361.battleship;

import com.google.gson.Gson;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spark.Spark;
import spark.utils.IOUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static spark.Spark.awaitInitialization;


/**
 * Created by michaelhilton on 1/26/17.
 */
class MainTest {

    @BeforeAll
    public static void beforeClass() {
        Main.main(null);
        awaitInitialization();
    }

    @AfterAll
    public static void afterClass() {
        Spark.stop();
    }

    @Test
    public void testGetModel() {
        String newModel = "{\"AllShipsPlaced\":0,\"aircraftCarrier\":{\"name\":\"AircraftCarrier\",\"length\":5,\"start\":{\"Across\":0,\"Down\":0},\"end\":{\"Across\":0,\"Down\":0}},\"battleship\":{\"name\":\"Battleship\",\"length\":4,\"start\":{\"Across\":0,\"Down\":0},\"end\":{\"Across\":0,\"Down\":0}},\"clipper\":{\"name\":\"Clipper\",\"length\":3,\"start\":{\"Across\":0,\"Down\":0},\"end\":{\"Across\":0,\"Down\":0}},\"dinghy\":{\"name\":\"Dinghy\",\"length\":1,\"start\":{\"Across\":0,\"Down\":0},\"end\":{\"Across\":0,\"Down\":0}},\"submarine\":{\"name\":\"Submarine\",\"length\":2,\"start\":{\"Across\":0,\"Down\":0},\"end\":{\"Across\":0,\"Down\":0}},\"computer_aircraftCarrier\":{\"name\":\"Computer_AircraftCarrier\",\"length\":5,\"start\":{\"Across\":2,\"Down\":2},\"end\":{\"Across\":2,\"Down\":6}},\"computer_battleship\":{\"name\":\"Computer_Battleship\",\"length\":4,\"start\":{\"Across\":2,\"Down\":8},\"end\":{\"Across\":5,\"Down\":8}},\"computer_clipper\":{\"name\":\"Clipper\",\"length\":3,\"start\":{\"Across\":4,\"Down\":1},\"end\":{\"Across\":4,\"Down\":3}},\"computer_dinghy\":{\"name\":\"Dinghy\",\"length\":1,\"start\":{\"Across\":7,\"Down\":3},\"end\":{\"Across\":7,\"Down\":3}},\"computer_submarine\":{\"name\":\"Computer_Submarine\",\"length\":2,\"start\":{\"Across\":9,\"Down\":6},\"end\":{\"Across\":9,\"Down\":7}},\"playerHits\":[],\"playerMisses\":[],\"computerHits\":[],\"computerMisses\":[],\"scanResult\":2,\"isGameOver\":0,\"validPlace\":0,\"repeatFire\":0,\"shipsHit\":2,\"shoots\":0,\"hitSearch\":0,\"direction\":1,\"inc\":0,\"hardAI\":0,\"originalHit\":{\"Across\":0,\"Down\":0},\"searchHit\":{\"Across\":0,\"Down\":0}}";
        TestResponse res = request("GET", "/model");
        assertEquals(200, res.status);
        assertEquals(newModel,res.body);
    }

    @Test
    public void testPlaceShip() {
        BattleshipModel test = new BattleshipModel();
        Gson gson = new Gson();
        String model = gson.toJson(test);
        String testShipPlacement = "{\"AllShipsPlaced\":0,\"aircraftCarrier\":{\"name\":\"AircraftCarrier\",\"length\":5,\"start\":{\"Across\":0,\"Down\":0},\"end\":{\"Across\":0,\"Down\":0}},\"battleship\":{\"name\":\"Battleship\",\"length\":4,\"start\":{\"Across\":0,\"Down\":0},\"end\":{\"Across\":0,\"Down\":0}},\"clipper\":{\"name\":\"Clipper\",\"length\":3,\"start\":{\"Across\":0,\"Down\":0},\"end\":{\"Across\":0,\"Down\":0}},\"dinghy\":{\"name\":\"Dinghy\",\"length\":1,\"start\":{\"Across\":0,\"Down\":0},\"end\":{\"Across\":0,\"Down\":0}},\"submarine\":{\"name\":\"Submarine\",\"length\":2,\"start\":{\"Across\":0,\"Down\":0},\"end\":{\"Across\":0,\"Down\":0}},\"computer_aircraftCarrier\":{\"name\":\"Computer_AircraftCarrier\",\"length\":5,\"start\":{\"Across\":2,\"Down\":2},\"end\":{\"Across\":2,\"Down\":6}},\"computer_battleship\":{\"name\":\"Computer_Battleship\",\"length\":4,\"start\":{\"Across\":2,\"Down\":8},\"end\":{\"Across\":5,\"Down\":8}},\"computer_clipper\":{\"name\":\"Clipper\",\"length\":3,\"start\":{\"Across\":4,\"Down\":1},\"end\":{\"Across\":4,\"Down\":3}},\"computer_dinghy\":{\"name\":\"Dinghy\",\"length\":1,\"start\":{\"Across\":7,\"Down\":3},\"end\":{\"Across\":7,\"Down\":3}},\"computer_submarine\":{\"name\":\"Computer_Submarine\",\"length\":2,\"start\":{\"Across\":9,\"Down\":6},\"end\":{\"Across\":9,\"Down\":7}},\"playerHits\":[],\"playerMisses\":[],\"computerHits\":[],\"computerMisses\":[],\"scanResult\":2,\"isGameOver\":0,\"validPlace\":0,\"repeatFire\":0,\"shipsHit\":2,\"shoots\":0,\"hitSearch\":0,\"direction\":1,\"inc\":0,\"hardAI\":0,\"originalHit\":{\"Across\":0,\"Down\":0},\"searchHit\":{\"Across\":0,\"Down\":0}}";
        TestResponse res = request_post("POST", "/placeShip/aircraftCarrier/1/1/horizontal",model);
        assertEquals(200, res.status);
        assertEquals(testShipPlacement,res.body);
    }

    @Test
    public void testRandShips() {
        BattleshipModel test = new BattleshipModel();
        Gson gson = new Gson();
        String model = gson.toJson(test);
        String testRandShipPlacement = "{\"AllShipsPlaced\":0,\"aircraftCarrier\":{\"name\":\"AircraftCarrier\",\"length\":5,\"start\":{\"Across\":0,\"Down\":0},\"end\":{\"Across\":0,\"Down\":0}},\"battleship\":{\"name\":\"Battleship\",\"length\":4,\"start\":{\"Across\":0,\"Down\":0},\"end\":{\"Across\":0,\"Down\":0}},\"clipper\":{\"name\":\"Clipper\",\"length\":3,\"start\":{\"Across\":0,\"Down\":0},\"end\":{\"Across\":0,\"Down\":0}},\"dinghy\":{\"name\":\"Dinghy\",\"length\":1,\"start\":{\"Across\":0,\"Down\":0},\"end\":{\"Across\":0,\"Down\":0}},\"submarine\":{\"name\":\"Submarine\",\"length\":2,\"start\":{\"Across\":0,\"Down\":0},\"end\":{\"Across\":0,\"Down\":0}},\"computer_aircraftCarrier\":{\"name\":\"Computer_AircraftCarrier\",\"length\":5,\"start\":{\"Across\":2,\"Down\":2},\"end\":{\"Across\":2,\"Down\":6}},\"computer_battleship\":{\"name\":\"Computer_Battleship\",\"length\":4,\"start\":{\"Across\":2,\"Down\":8},\"end\":{\"Across\":5,\"Down\":8}},\"computer_clipper\":{\"name\":\"Clipper\",\"length\":3,\"start\":{\"Across\":4,\"Down\":1},\"end\":{\"Across\":4,\"Down\":3}},\"computer_dinghy\":{\"name\":\"Dinghy\",\"length\":1,\"start\":{\"Across\":7,\"Down\":3},\"end\":{\"Across\":7,\"Down\":3}},\"computer_submarine\":{\"name\":\"Computer_Submarine\",\"length\":2,\"start\":{\"Across\":9,\"Down\":6},\"end\":{\"Across\":9,\"Down\":7}},\"playerHits\":[],\"playerMisses\":[],\"computerHits\":[],\"computerMisses\":[],\"scanResult\":2,\"isGameOver\":0,\"validPlace\":0,\"repeatFire\":0,\"shipsHit\":2,\"shoots\":0,\"hitSearch\":0,\"direction\":1,\"inc\":0,\"hardAI\":0,\"originalHit\":{\"Across\":0,\"Down\":0},\"searchHit\":{\"Across\":0,\"Down\":0}}";
        TestResponse res = request_post("POST", "/placeShip/random/1/1/horizontal",model);
        assertEquals(200, res.status);
        assertEquals(testRandShipPlacement,res.body);
    }


    @Test
    public void testScan() {
        BattleshipModel test = new BattleshipModel();
        Gson gson = new Gson();
        String model = "{\"AllShipsPlaced\":1,\"aircraftCarrier\":{\"name\":\"AircraftCarrier\",\"length\":5,\"start\":{\"Across\":8,\"Down\":2},\"end\":{\"Across\":8,\"Down\":6},\"stealth\":false,\"armorless\":false},\"battleship\":{\"name\":\"Battleship\",\"length\":4,\"start\":{\"Across\":2,\"Down\":8},\"end\":{\"Across\":5,\"Down\":8},\"stealth\":true,\"armorless\":false},\"clipper\":{\"name\":\"Clipper\",\"length\":3,\"start\":{\"Across\":5,\"Down\":6},\"end\":{\"Across\":7,\"Down\":6},\"stealth\":false,\"armorless\":true},\"dinghy\":{\"name\":\"Dinghy\",\"length\":1,\"start\":{\"Across\":7,\"Down\":9},\"end\":{\"Across\":7,\"Down\":9},\"stealth\":false,\"armorless\":true},\"submarine\":{\"name\":\"Submarine\",\"length\":2,\"start\":{\"Across\":2,\"Down\":2},\"end\":{\"Across\":3,\"Down\":2},\"stealth\":true,\"armorless\":false},\"computer_aircraftCarrier\":{\"name\":\"Computer_AircraftCarrier\",\"length\":5,\"start\":{\"Across\":2,\"Down\":2},\"end\":{\"Across\":2,\"Down\":6},\"stealth\":false,\"armorless\":false},\"computer_battleship\":{\"name\":\"Computer_Battleship\",\"length\":4,\"start\":{\"Across\":2,\"Down\":8},\"end\":{\"Across\":5,\"Down\":8},\"stealth\":true,\"armorless\":false},\"computer_clipper\":{\"name\":\"Clipper\",\"length\":3,\"start\":{\"Across\":4,\"Down\":1},\"end\":{\"Across\":4,\"Down\":3},\"stealth\":false,\"armorless\":true},\"computer_dinghy\":{\"name\":\"Dinghy\",\"length\":1,\"start\":{\"Across\":7,\"Down\":3},\"end\":{\"Across\":7,\"Down\":3},\"stealth\":false,\"armorless\":true},\"computer_submarine\":{\"name\":\"Computer_Submarine\",\"length\":2,\"start\":{\"Across\":9,\"Down\":6},\"end\":{\"Across\":9,\"Down\":7},\"stealth\":true,\"armorless\":false},\"playerHits\":[],\"playerMisses\":[],\"computerHits\":[],\"computerMisses\":[],\"scanResult\":2,\"isGameOver\":0,\"validPlace\":0}";
        String scanTest = "{\"AllShipsPlaced\":1,\"aircraftCarrier\":{\"name\":\"AircraftCarrier\",\"length\":5,\"start\":{\"Across\":8,\"Down\":2},\"end\":{\"Across\":8,\"Down\":6},\"stealth\":false,\"armorless\":false},\"battleship\":{\"name\":\"Battleship\",\"length\":4,\"start\":{\"Across\":2,\"Down\":8},\"end\":{\"Across\":5,\"Down\":8},\"stealth\":true,\"armorless\":false},\"clipper\":{\"name\":\"Clipper\",\"length\":3,\"start\":{\"Across\":5,\"Down\":6},\"end\":{\"Across\":7,\"Down\":6},\"stealth\":false,\"armorless\":true},\"dinghy\":{\"name\":\"Dinghy\",\"length\":1,\"start\":{\"Across\":7,\"Down\":9},\"end\":{\"Across\":7,\"Down\":9},\"stealth\":false,\"armorless\":true},\"submarine\":{\"name\":\"Submarine\",\"length\":2,\"start\":{\"Across\":2,\"Down\":2},\"end\":{\"Across\":3,\"Down\":2},\"stealth\":true,\"armorless\":false},\"computer_aircraftCarrier\":{\"name\":\"Computer_AircraftCarrier\",\"length\":5,\"start\":{\"Across\":2,\"Down\":2},\"end\":{\"Across\":2,\"Down\":6},\"stealth\":false,\"armorless\":false},\"computer_battleship\":{\"name\":\"Computer_Battleship\",\"length\":4,\"start\":{\"Across\":2,\"Down\":8},\"end\":{\"Across\":5,\"Down\":8},\"stealth\":true,\"armorless\":false},\"computer_clipper\":{\"name\":\"Clipper\",\"length\":3,\"start\":{\"Across\":4,\"Down\":1},\"end\":{\"Across\":4,\"Down\":3},\"stealth\":false,\"armorless\":true},\"computer_dinghy\":{\"name\":\"Dinghy\",\"length\":1,\"start\":{\"Across\":7,\"Down\":3},\"end\":{\"Across\":7,\"Down\":3},\"stealth\":false,\"armorless\":true},\"computer_submarine\":{\"name\":\"Computer_Submarine\",\"length\":2,\"start\":{\"Across\":9,\"Down\":6},\"end\":{\"Across\":9,\"Down\":7},\"stealth\":true,\"armorless\":false},\"playerHits\":[],\"playerMisses\":[],\"computerHits\":[],\"computerMisses\":[],\"scanResult\":2,\"isGameOver\":0,\"validPlace\":0}";
        TestResponse res = request_post("POST", "/scan/6/6",model);
        assertEquals(200, res.status);
        assertEquals(scanTest, res.body);
    }


    @Test
    public void testValidFire(){
        BattleshipModel test = new BattleshipModel();
        Gson gson = new Gson();
        String model = gson.toJson(test);

        TestResponse res = request_post( "POST", "/fire/4/1", model);
        assertEquals( 200, res.status);
    }


    private TestResponse request_post(String method, String path, String body) {
        try {
            URL url = new URL("http://localhost:4567" + path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            connection.setDoOutput(true);
            if(body != null) {
                connection.setDoInput(true);
                byte[] outputInBytes = body.getBytes("UTF-8");
                OutputStream os = connection.getOutputStream();
                os.write(outputInBytes);
            }
            connection.connect();
            return new TestResponse(connection.getResponseCode(), body);
        } catch (IOException e) {
            e.printStackTrace();
            fail("Sending request failed: " + e.getMessage());
            return null;
        }
    }

    private TestResponse request(String method, String path) {
        try {
            URL url = new URL("http://localhost:4567" + path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            connection.setDoOutput(true);
            connection.connect();
            String body = IOUtils.toString(connection.getInputStream());
            return new TestResponse(connection.getResponseCode(), body);
        } catch (IOException e) {
            e.printStackTrace();
            fail("Sending request failed: " + e.getMessage());
            return null;
        }
    }

    private static class TestResponse {

        public final String body;
        public final int status;

        public TestResponse(int status, String body) {
            this.status = status;
            this.body = body;
        }

        public Map<String,String> json() {
            return new Gson().fromJson(body, HashMap.class);
        }
    }
}