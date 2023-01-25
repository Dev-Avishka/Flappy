import static com.raylib.Raylib.*;
import static com.raylib.Jaylib.*;
import com.raylib.*;
import java.util.Random;


public class Main  {

    public static void main(String[] args) {


        int message_x = 55;
        Thread t = new Thread();

        int Gravity = 1;

        InitWindow(300, 500, "Flappy");

        int x = 10;
        int y = 10;

        int pipe_x =400;
        int pipe_y = 250;

        int pipe_y2 = pipe_y - 600;

        boolean won = false;
        Image image = LoadImage("icon.png");
        Texture texture = LoadTextureFromImage(image);

        String message = "";
        String message2 = "";

        int score = 0;


        while (!WindowShouldClose()) {

            Random rand = new Random();
            BeginDrawing();
            ClearBackground(RAYWHITE);


            String score2 = "Score"+ " "+ new String(String.valueOf(score));

            //draw textures
            DrawRectangle(x,y,40,40,RED);
            DrawRectangle(pipe_x,pipe_y,50,450,BLUE);
            DrawRectangle(pipe_x,pipe_y2,50,450,BLUE);
            DrawTexture(texture, 10, 10, WHITE);
            DrawText(message,message_x,155,70,VIOLET);
            DrawText(message2,10,215,20,VIOLET);
            DrawText(score2,100,30,30,VIOLET);


            EndDrawing();

            pipe_x  -= 1;

            y += Gravity;

            if (IsKeyPressed(KEY_SPACE)){
                y -= 70;
            }
            if (x <= pipe_x){
                
            }
            if (pipe_x < -5){
                pipe_x = 400;
                int n = rand.nextInt(500);
                int l = rand.nextInt(n);

                if (n < 100) {
                    n+=200;
                }
                if (n>300){
                    n -= 100;
                }
                pipe_y = n;
                pipe_y2 = pipe_y - 600;

                score += 1;

                if (score == 999){
                    pipe_x  =  1000000;
                    message_x = 15;
                    message = "You won";
                    message2 = "Close The Game To restart";
                    won = true;
                }
            }

            if (y>450) {
                Gravity = 0;

                if (!won) {
                    message_x = 55;
                    message = "Dead";
                    message2 = "Close The Game To restart";
                }
            } else if (y<450) {
                Gravity = 1;
            }

            try {
                t.sleep(7);

            }catch (Exception e){
                e.printStackTrace();

            }

        }

        CloseWindow();

    }


}