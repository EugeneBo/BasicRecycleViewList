package eugenebo.com.github.basicrecycleviewlist;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private List<RecycledItemView> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = contactListGenerator();
        for (RecycledItemView item : items) {
            setContactAvatarLetters(item);
            colorGenerator(item);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        ItemAdapter itemAdapter = new ItemAdapter(items);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(itemAdapter);

    }

    private List<RecycledItemView> contactListGenerator() {

        List<RecycledItemView> items = new ArrayList<>();
        String description = getResources().getString(R.string.description);

        items.add(new Divider("Friends"));

        items.add(new Contact("Ryan Gosling", description));
        items.add(new Contact("Ryan Gosling", description));
        items.add(new Contact("Winona Ryder", description));
        items.add(new Contact("Winona Ryder", description));

        items.add(new Divider("Colleges"));

        items.add(new Contact("Wanana Vader", description));
        items.add(new Contact("Wanana Vader", description));
        items.add(new Contact("Ryan Gosling", description));
        items.add(new Contact("Keith", description));
        items.add(new Contact("Thomas Alan Waits", description));
        items.add(new Contact("Natalie Portman", description));
        items.add(new Contact("Mick Jagger", description));
        items.add(new Contact("Jim Morrison", description));
        items.add(new Contact("Charlie Sheen", description));
        items.add(new Contact("Tom Hanks", description));
        items.add(new Contact("Emma Stone", description));
        items.add(new Contact("Sergey Stilov", description));

        items.add(new Divider("Relatives"));

        items.add(new Contact("Roger Waters", description));
        items.add(new Contact("Billie Armstrong", description));
        items.add(new Contact("Miles Davis", description));
        items.add(new Contact("Chet Baker", description));
        items.add(new Contact("Michael", description));
        items.add(new Contact("Mike Shinoda", description));
        items.add(new Contact("Jean Reno", description));
        items.add(new Contact("Lawrence Ellison", description));
        items.add(new Contact("Ilon Mask", description));
        items.add(new Contact("Winona Ryder", description));

        items.add(new Divider("Service"));

        items.add(new Contact("Winona Ryder", description));
        items.add(new Contact("Ryan Gosling", description));
        items.add(new Contact("Ryan Gosling", description));
        items.add(new Contact("Keith", description));
        items.add(new Contact("Thomas Alan Waits", description));
        items.add(new Contact("Natalie Portman", description));
        items.add(new Contact("Mick Jagger", description));
        items.add(new Contact("Jim Morrison", description));
        items.add(new Contact("Charlie Sheen", description));
        items.add(new Contact("Tom Hanks", description));
        items.add(new Contact("Emma Stone", description));

        items.add(new Divider("Favorite"));

        items.add(new Contact("Sergey Stilov", description));
        items.add(new Contact("Roger Waters", description));
        items.add(new Contact("Billie Armstrong", description));
        items.add(new Contact("Miles Davis", description));
        items.add(new Contact("Chet Baker", description));
        items.add(new Contact("Michael", description));
        items.add(new Contact("Mike Shinoda", description));
        items.add(new Contact("Jean Reno", description));
        items.add(new Contact("Lawrence Ellison", description));
        items.add(new Contact("zilon zask", description));

        return items;
    }

    private void colorGenerator(RecycledItemView item) {

        if (item instanceof Contact) {
            Contact contactItem = (Contact) item;

            int red =2 * (Math.abs((byte) contactItem.hashCode()));
            int green;
            int blue;

            if (red % 5 == 0) {
                green = 95;
                blue = 75;
            } else if (red % 3 == 0) {
                green = 20;
                blue = 60;
            } else if (red % 2 == 0) {
                green = 125;
                blue = 40;
            } else {
                green = 30;
                blue = 90;
            }
           // Log.i(TAG, "COLOR: " + Color.rgb(red, green, blue));
            contactItem.setAvatarColor(Color.rgb(red, green, blue));
        }
    }

    private void setContactAvatarLetters(RecycledItemView item) {

        if (item instanceof Contact) {
            Contact contactItem = (Contact) item;

            String[] strings = contactItem.getName().trim().split("\\s+");

            if (strings.length >= 2) {
                contactItem.setAvatarLetters(strings[0].substring(0, 1) + strings[1].substring(0, 1));
            } else if (strings.length == 1) {
                contactItem.setAvatarLetters(strings[0].substring(0, 1));
            } else contactItem.setAvatarLetters("N/A");
        }

    }



}
