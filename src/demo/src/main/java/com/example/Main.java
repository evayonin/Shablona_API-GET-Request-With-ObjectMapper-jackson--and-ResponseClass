package com.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String apiUrl = ""; // הלינק לשרת שנקבל

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body()); // we have to check if it's an array or
        // just object parameters

        ObjectMapper mapper = new ObjectMapper(); // של ספריית ג׳קסון
        ResponseBodyClass rbc = mapper.readValue(response.body(), ResponseBodyClass.class);
        // המאפר ממפה את המחרוזת גייסון של הגוף - את הפרמטרים משייך לשדות (מחרוזות)
        // במחלקה שיצרנו בהתאמה למפתחות ויוצר את אובייקט המחלקה.

        System.out.println(rbc); // בדיקת הדפסה (לפי טו סטרינג) של מה שקיבלנו

        // עכשיו ניתן לגשת לשדות של המחלקה (עם גטרים) שמהווים את הפרמטרים בשרת ולהשתמש
        // בהם.

        // לדוגמה:
        if (rbc.getParam1() == "Param1-value") {
            System.out.println(rbc.getParam1());
        }

        // דוגמה ממשית מתגבור 3+4 בגיטהאב:
        if (joke.type == "single") {
            System.out.println(joke.joke); // ידפיס את הערך שחזר בשדה הזה ע״י ריד וליו
        } else {
            System.out.println(joke.setup + "\n" + joke.delivery);// twhopart
        }
        // פה זה בלי גטרים כי אביה לא יצרה אותם אז היא רק ניגשה לשדות

        // הערה חשובה:

        // לפני שאביה יצרה את האובייקט עם האובג׳קט מאפר היא הוסיפה לריסולט (גוף) ששלחה
        // לו את המחרוזת קטגוריה כדי שיהיה מסוג אחד של קטגוריה(שהיוזר בחר בהתחלה)
        // String result = getJokeByUrl("https://v2.jokeapi.dev/joke/" + joke.category);

    }
}